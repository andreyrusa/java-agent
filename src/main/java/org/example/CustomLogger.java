package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class CustomLogger implements InvocationHandler {
    private final Object originalLogger;
    private static final String LOG_FILE_PATH = "agent-logs.txt";
    private static final Set<String> uniqueLogMessages = new HashSet();

    private CustomLogger(Object originalLogger) {
        this.originalLogger = originalLogger;
    }

    public static Object wrapLogger(Object logger) {
        return Proxy.newProxyInstance(logger.getClass().getClassLoader(), logger.getClass().getInterfaces(), new CustomLogger(logger));
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (("info".equals(method.getName()) || "debug".equals(method.getName()) || "warn".equals(method.getName()) || "error".equals(method.getName())) && args != null && args.length > 0) {
            String logMessage = String.valueOf(args[0]);
            Object[] logArgs = args.length > 1 ? (Object[])((Object[])args[1]) : null;
            Method getLoggerNameMethod = this.originalLogger.getClass().getMethod("getName");
            String loggerName = (String)getLoggerNameMethod.invoke(this.originalLogger);
            Instant currentTime = Instant.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS").withZone(ZoneId.systemDefault());
            String timestamp = formatter.format(currentTime);
            String threadName = Thread.currentThread().getName();
            String formattedLogMessage;
            if (logArgs != null) {
                formattedLogMessage = String.format(logMessage, logArgs);
            } else {
                formattedLogMessage = logMessage;
            }

            formattedLogMessage = String.format("%s [%s] %s %s - %s", timestamp, threadName, method.getName().toUpperCase(), loggerName, formattedLogMessage);
            if (uniqueLogMessages.add(formattedLogMessage)) {
                this.writeLogToFile(formattedLogMessage);
            }
        }

        return method.invoke(this.originalLogger, args);
    }

    private void writeLogToFile(String logMessage) {
        try {
            FileWriter fileWriter = new FileWriter("agent-logs.txt", true);
            Throwable var3 = null;

            try {
                fileWriter.write(logMessage + System.lineSeparator());
            } catch (Throwable var13) {
                var3 = var13;
                throw var13;
            } finally {
                if (fileWriter != null) {
                    if (var3 != null) {
                        try {
                            fileWriter.close();
                        } catch (Throwable var12) {
                            var3.addSuppressed(var12);
                        }
                    } else {
                        fileWriter.close();
                    }
                }

            }
        } catch (IOException var15) {
            System.err.println("Error writing log to file: " + var15.getMessage());
        }

    }
}

