package com.lacivita;

import com.lacivita.di.interceptor.AuditedInterceptor;
import com.lacivita.di.service.ChatService;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.After;
import org.junit.Before;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InterceptorIntegrationTest {

    Weld weld;
    WeldContainer weldContainer;

    @Before
    public void init(){
        weld = new Weld();
        weldContainer = weld.initialize();
    }

    @After
    public void shutdown(){
        weld.shutdown();
    }

    @Test
    public void givenTheService_whenMethodAndInterceptorExecuted_thenOK(){
        ChatService chatService = weldContainer.select(ChatService.class).get();
        String code = "123456";
        chatService.deliverMessage(code);

        Assert.assertTrue(AuditedInterceptor.calledBefore);
        Assert.assertTrue(AuditedInterceptor.calledAfter);
    }
}
