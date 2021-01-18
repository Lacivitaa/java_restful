package com.lacivita.di.service;

import com.lacivita.di.interceptor.Audited;

public class ChatService {
    @Audited
    public String deliverMessage(String msg){
        return msg;
    }
}
