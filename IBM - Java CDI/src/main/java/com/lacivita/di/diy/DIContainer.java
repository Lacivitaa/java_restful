package com.lacivita.di.diy;

public class DIContainer {
    public TextClass getTextClass(){
        return new TextClass(new TextServiceImpl());
    }
}
