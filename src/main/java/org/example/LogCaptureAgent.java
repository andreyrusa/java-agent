package org.example;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import org.slf4j.Logger;

import java.lang.instrument.Instrumentation;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class LogCaptureAgent {
    public static void premain(String agentArgs, Instrumentation inst) {
        configureAgent(inst);
    }

    public static void agentmain(String agentArgs, Instrumentation inst) {
        configureAgent(inst);
    }

    private static void configureAgent(Instrumentation inst) {
        new AgentBuilder.Default()
                .type(named("org.slf4j.LoggerFactory"))
                .transform((builder, typeDescription, classLoader, module) -> builder
                        .method(named("getLogger"))
                        .intercept(Advice.to(GetLoggerAdvice.class))
                ).installOn(inst);
    }

    public static class GetLoggerAdvice {
        @Advice.OnMethodExit
        public static void exit(@Advice.Return(readOnly = false, typing = Assigner.Typing.DYNAMIC) Logger logger) {
            logger = new CustomLogger(logger);
        }
    }
}