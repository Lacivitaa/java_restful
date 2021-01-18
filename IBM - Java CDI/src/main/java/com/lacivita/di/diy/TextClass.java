package com.lacivita.di.diy;

public class TextClass {
    private TextService textService;

    public TextClass(TextServiceImpl textService){
        this.textService = textService;
    }
}
