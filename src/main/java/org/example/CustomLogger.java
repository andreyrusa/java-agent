package org.example;

import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.helpers.MarkerIgnoringBase;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomLogger extends MarkerIgnoringBase implements Logger {
    private final Logger delegate;
    private static final String LOG_FILE_PATH = "agent-logs.txt";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    private void writeToFile(String message) {
        try (FileWriter fw = new FileWriter(LOG_FILE_PATH, true);
             PrintWriter pw = new PrintWriter(fw)) {
            String timestamp = DATE_FORMAT.format(new Date());
            pw.println(timestamp + " - " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public CustomLogger(Logger delegate) {
        this.delegate = delegate;
    }

    @Override
    public String getName() {
        return delegate.getName();
    }

    @Override
    public boolean isTraceEnabled() {
        return delegate.isTraceEnabled();
    }

    @Override
    public void trace(String msg) {
        delegate.trace(msg);
        writeToFile(msg);
    }

    @Override
    public void trace(String s, Object o) {
        delegate.trace(s);
        writeToFile(s);
    }

    @Override
    public void trace(String s, Object o, Object o1) {
        delegate.trace(s);
        writeToFile(s);
    }

    @Override
    public void trace(String s, Object... objects) {
        delegate.trace(s);
        writeToFile(s);
    }

    @Override
    public void trace(String s, Throwable throwable) {
        delegate.trace(s);
        writeToFile(s);
    }

    @Override
    public boolean isTraceEnabled(Marker marker) {
        return delegate.isTraceEnabled();
    }

    @Override
    public void trace(Marker marker, String s) {
        delegate.trace(s);
        writeToFile(s);
    }

    @Override
    public void trace(Marker marker, String s, Object o) {
        delegate.trace(s);
        writeToFile(s);
    }

    @Override
    public void trace(Marker marker, String s, Object o, Object o1) {
        delegate.trace(s);
        writeToFile(s);
    }

    @Override
    public void trace(Marker marker, String s, Object... objects) {
        delegate.trace(s);
        writeToFile(s);
    }

    @Override
    public void trace(Marker marker, String s, Throwable throwable) {
        delegate.trace(s);
        writeToFile(s);
    }

    @Override
    public boolean isDebugEnabled() {
        return delegate.isDebugEnabled();
    }

    @Override
    public void debug(String s) {
        delegate.debug(s);
        writeToFile(s);
    }

    @Override
    public void debug(String s, Object o) {
        delegate.debug(s);
        writeToFile(s);
    }

    @Override
    public void debug(String s, Object o, Object o1) {
        delegate.debug(s);
        writeToFile(s);
    }

    @Override
    public void debug(String s, Object... objects) {
        delegate.debug(s);
        writeToFile(s);
    }

    @Override
    public void debug(String s, Throwable throwable) {
        delegate.debug(s);
        writeToFile(s);
    }

    @Override
    public boolean isDebugEnabled(Marker marker) {
        return delegate.isDebugEnabled();
    }

    @Override
    public void debug(Marker marker, String s) {
        delegate.debug(s);
        writeToFile(s);
    }

    @Override
    public void debug(Marker marker, String s, Object o) {
        delegate.debug(s);
        writeToFile(s);
    }

    @Override
    public void debug(Marker marker, String s, Object o, Object o1) {
        delegate.debug(s);
        writeToFile(s);
    }

    @Override
    public void debug(Marker marker, String s, Object... objects) {
        delegate.debug(s);
        writeToFile(s);
    }

    @Override
    public void debug(Marker marker, String s, Throwable throwable) {
        delegate.debug(s);
        writeToFile(s);
    }

    @Override
    public boolean isInfoEnabled() {
        return delegate.isInfoEnabled();
    }

    @Override
    public void info(String s) {
        delegate.info(s);
        writeToFile(s);
    }

    @Override
    public void info(String s, Object o) {
        delegate.info(s);
        writeToFile(s);
    }

    @Override
    public void info(String s, Object o, Object o1) {
        delegate.info(s);
        writeToFile(s);
    }

    @Override
    public void info(String s, Object... objects) {
        delegate.info(s);
        writeToFile(s);
    }

    @Override
    public void info(String s, Throwable throwable) {
        delegate.info(s);
        writeToFile(s);
    }

    @Override
    public boolean isInfoEnabled(Marker marker) {
        return delegate.isInfoEnabled();
    }

    @Override
    public void info(Marker marker, String s) {
        delegate.info(s);
        writeToFile(s);
    }

    @Override
    public void info(Marker marker, String s, Object o) {
        delegate.info(s);
        writeToFile(s);
    }

    @Override
    public void info(Marker marker, String s, Object o, Object o1) {
        delegate.info(s);
        writeToFile(s);
    }

    @Override
    public void info(Marker marker, String s, Object... objects) {
        delegate.info(s);
        writeToFile(s);
    }

    @Override
    public void info(Marker marker, String s, Throwable throwable) {
        delegate.info(s);
        writeToFile(s);
    }

    @Override
    public boolean isWarnEnabled() {
        return delegate.isWarnEnabled();
    }

    @Override
    public void warn(String s) {
        delegate.warn(s);
        writeToFile(s);
    }

    @Override
    public void warn(String s, Object o) {
        delegate.warn(s);
        writeToFile(s);
    }

    @Override
    public void warn(String s, Object... objects) {
        delegate.warn(s);
        writeToFile(s);
    }

    @Override
    public void warn(String s, Object o, Object o1) {
        delegate.warn(s);
        writeToFile(s);
    }

    @Override
    public void warn(String s, Throwable throwable) {
        delegate.warn(s);
        writeToFile(s);
    }

    @Override
    public boolean isWarnEnabled(Marker marker) {
        return delegate.isWarnEnabled();
    }

    @Override
    public void warn(Marker marker, String s) {
        delegate.warn(s);
        writeToFile(s);
    }

    @Override
    public void warn(Marker marker, String s, Object o) {
        delegate.warn(s);
        writeToFile(s);
    }

    @Override
    public void warn(Marker marker, String s, Object o, Object o1) {
        delegate.warn(s);
        writeToFile(s);
    }

    @Override
    public void warn(Marker marker, String s, Object... objects) {
        delegate.warn(s);
        writeToFile(s);
    }

    @Override
    public void warn(Marker marker, String s, Throwable throwable) {

    }

    @Override
    public boolean isErrorEnabled() {
        return delegate.isErrorEnabled();
    }

    @Override
    public void error(String s) {
        delegate.error(s);
        writeToFile(s);
    }

    @Override
    public void error(String s, Object o) {
        delegate.error(s);
        writeToFile(s);
    }

    @Override
    public void error(String s, Object o, Object o1) {
        delegate.error(s);
        writeToFile(s);
    }

    @Override
    public void error(String s, Object... objects) {
        delegate.error(s);
        writeToFile(s);
    }

    @Override
    public void error(String s, Throwable throwable) {

    }

    @Override
    public boolean isErrorEnabled(Marker marker) {
        return delegate.isErrorEnabled();
    }

    @Override
    public void error(Marker marker, String s) {
        delegate.error(s);
        writeToFile(s);
    }

    @Override
    public void error(Marker marker, String s, Object o) {
        delegate.error(s);
        writeToFile(s);
    }

    @Override
    public void error(Marker marker, String s, Object o, Object o1) {
        delegate.error(s);
        writeToFile(s);
    }

    @Override
    public void error(Marker marker, String s, Object... objects) {
        delegate.error(s);
        writeToFile(s);
    }

    @Override
    public void error(Marker marker, String s, Throwable throwable) {
        delegate.error(s);
        writeToFile(s);
    }
}
