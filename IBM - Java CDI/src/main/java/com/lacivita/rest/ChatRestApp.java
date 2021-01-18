package com.lacivita.rest;

import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("api")
public class ChatRestApp extends Application {

    @Override
    public Set<Class<?>> getClasses(){
        HashSet<Class<?>> classes = new HashSet<>();
        classes.add(ChatController.class);
        return classes;
    }

    public static void main(String[] args) {
        UndertowJaxrsServer server = new UndertowJaxrsServer().start();
        server.deploy(ChatRestApp.class);
    }
}
