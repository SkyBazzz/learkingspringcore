package com.oleksandr.spring.core.myspringcore.apsect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CountableAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountableAspect.class);
    private static final Map<String, Integer> countingMap = new HashMap<>();

    @Pointcut("@annotation(Countable)")
    public void executeCounting() {
    }

    @Before(value = "executeCounting()")
    public void logMethodCall(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getDeclaringType() + "." + joinPoint.getSignature().getName();
        if (countingMap.containsKey(methodName)) {
            int current = countingMap.get(methodName);
            current++;
            countingMap.put(methodName, current);
        } else {
            countingMap.put(methodName, 1);
        }
        StringBuilder message = new StringBuilder("Current counts are: |");
        countingMap.forEach((k,v) -> message.append(k)
                                            .append("::")
                                            .append(v)
                                            .append(" | "));

        LOGGER.info(message.toString());

    }

}
