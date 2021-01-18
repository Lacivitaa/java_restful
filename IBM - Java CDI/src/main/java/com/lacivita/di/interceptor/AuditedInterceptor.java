package com.lacivita.di.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/*
Everything "audited" is intercepted by this code here because of the
interceptor annotation
 */
@Audited
@Interceptor
public class AuditedInterceptor {
    public static boolean calledBefore = false;
    public static boolean calledAfter = false;

    @AroundInvoke
    public Object auditMethod(InvocationContext ctx) throws Exception{
        calledBefore = true;
        Object result = ctx.proceed(); //Proceed to method where there is a annotation
        System.out.println("intercepted msg: " + result);
        calledAfter = true;
        return result;
    }
}
