package com.lacivita.di.app;

import com.lacivita.di.imagefileprocessor.ImageFileProcessor;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class ChatApplication {
    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        ImageFileProcessor imageFileProcessor = container.select(ImageFileProcessor.class).get();
        System.out.println(imageFileProcessor.openFile("file1.png"));
        System.out.println(imageFileProcessor.writeFile("file1.png"));
        System.out.println(imageFileProcessor.saveFile("file1.png"));
    }
}
