package com.lacivita.di.imagefileprocessor;

import com.lacivita.di.imagefileeditors.ImageFileEditor;
import com.lacivita.di.loggers.TimeLogger;
import com.lacivita.di.qualifiers.PngFileEditorQualifier;

import javax.inject.Inject;

public class ImageFileProcessor {

    private final ImageFileEditor imageFileEditor;
    private final TimeLogger timeLogger;

    /*
    Inject annotations - used to say to the program that we will need to use a field
    that have more than one implementation, like ImageFileEditor, the annotations will
    guide to the right direction.
     */
    @Inject
    public ImageFileProcessor(@PngFileEditorQualifier ImageFileEditor imageFileEditor, TimeLogger timeLogger){
        this.imageFileEditor = imageFileEditor;
        this.timeLogger = timeLogger;
    }

    public ImageFileEditor getImageFileEditor(){
        return imageFileEditor;
    }

    public TimeLogger getTimeLogger() {
        return timeLogger;
    }

    public String openFile(String fileName){
        return imageFileEditor.openFile(fileName) + " at: " + timeLogger.getTime();
    }

    public String editFile(String fileName){
        return imageFileEditor.editFile(fileName) + " at: " + timeLogger.getTime();
    }

    public String writeFile(String fileName){
        return imageFileEditor.writeFile(fileName) + " at: " + timeLogger.getTime();
    }

    public String saveFile(String fileName){
        return imageFileEditor.saveFile(fileName) + " at: " + timeLogger.getTime();
    }
}
