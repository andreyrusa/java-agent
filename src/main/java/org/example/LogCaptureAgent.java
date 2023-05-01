package org.example;

import java.lang.instrument.Instrumentation;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.asm.Advice.OnMethodExit;
import net.bytebuddy.asm.Advice.Return;
import net.bytebuddy.implementation.bytecode.assign.Assigner.Typing;
import net.bytebuddy.matcher.ElementMatchers;

public class LogCaptureAgent {
    public LogCaptureAgent() {
    }

    public static void premain(String agentArgs, Instrumentation inst) {
        configureAgent(inst);
    }

    public static void agentmain(String agentArgs, Instrumentation inst) {
        configureAgent(inst);
    }

    private static void configureAgent(Instrumentation inst) {
        (new AgentBuilder.Default()).type(ElementMatchers.named("org.slf4j.LoggerFactory")).transform((builder, typeDescription, classLoader, module) -> {
            return builder.method(ElementMatchers.named("getLogger")).intercept(Advice.to(GetLoggerAdvice.class));
        }).installOn(inst);
    }

    public static class GetLoggerAdvice {
        public GetLoggerAdvice() {
        }

        @OnMethodExit
        public static void exit(@Return(readOnly = false,typing = Typing.DYNAMIC) Object logger) {
            logger = CustomLogger.wrapLogger(logger);
        }
    }
}