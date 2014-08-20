package com.kaiinui.potatoannotation;

import android.app.Activity;
import android.widget.Toast;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PotatoAspect {
    @Pointcut("execution(@com.kaiinui.potatoannotation.PotatoTip * *(..))")
    public void method() {}

    @Around("method()")
    public Object executePotato(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = joinPoint.proceed();

        final Activity activity = (Activity) joinPoint.getThis();
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(activity, "POTATOTIP!", Toast.LENGTH_SHORT).show();
            }
        });

        return result;
    }
}
