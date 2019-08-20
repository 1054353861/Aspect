package com.android.aspectj.log;


import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author lucas
 * @dscription 日志打印收集类
 */

@Aspect
public class LogTraceAspect {

    private static final String TAG = "LOG";

    /**
     * call 方法
     *
     * @param joinPoint
     * @throws Throwable
     */
    @Before("call(* android.app.Activity.on*(..))")
    public void callMethod(JoinPoint joinPoint) throws Throwable {
        String key = joinPoint.getSignature().toString();
        Log.e(TAG, "callMethodBefore" + key);
    }


    /**
     * excution
     *
     * @param joinPoint
     * @throws Throwable
     */
    @Before("execution(* android.app.Activity.on*(..))")
    public void onActivityMethodBefore(JoinPoint joinPoint) throws Throwable {
        String key = joinPoint.getSignature().toString();
        Log.e(TAG, "onActivityMethodBefore:" + key);
    }


    /**
     * 获取到类的构造方法，并且给方法赋值
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("get(com.android.aspectj.TextUser.age)")
    public String onGetAge(ProceedingJoinPoint joinPoint) throws Throwable{
        // 执行原代码
        Object obj = joinPoint.proceed();
        String age = obj.toString();
        Log.e(TAG, "age: " + age);
        return "18";
    }

    @Before("execution(@com.android.aspectj.log.LogTraceAspectInterface.Debug * * (..))")
    public void onActivityDebug(JoinPoint joinPoint) throws Throwable {
        String key = joinPoint.getSignature().toString();
        Log.e(TAG, "Debug:" + key);
    }

    @Before("handler(java.long.Exception)")
    public void handlerMethod() {
        Log.e(TAG, "handlerMethod：Exception!");
    }


}
