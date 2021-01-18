package com.lacivita.dependencyinjection;

import com.lacivita.di.imagefileeditors.PngFileEditor;
import com.lacivita.di.imagefileprocessor.ImageFileProcessor;
import com.lacivita.di.loggers.TimeLogger;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ImageProcessorUnitTest {

    private static ImageFileProcessor imageFileProcessor;
    private static SimpleDateFormat simpleDateFormat;
    private static Calendar calendar;

    @BeforeClass
    public static void setImageProcessorInstance(){
        Weld weld =new Weld();
        WeldContainer container = weld.initialize();
        imageFileProcessor = container.select(ImageFileProcessor.class).get();
        container.shutdown();
    }

    @BeforeClass
    public static void setSimpleDateFormatInstance(){
        simpleDateFormat = new SimpleDateFormat("HH:mm");
    }

    @BeforeClass
    public static void setCalendarInstance(){
        calendar = Calendar.getInstance();
    }

    @Test
    public void givenImageProcessorInstance_whenInjectedPngFileEditorAndTimeLoggerInstance_thenTwoAssertions(){
        assertThat(imageFileProcessor.getImageFileEditor()).isInstanceOf(PngFileEditor.class);
        assertThat(imageFileProcessor.getTimeLogger()).isInstanceOf(TimeLogger.class);
    }

    @Test
    public void givenImageProcessorInstance_whenCalledOpenFile_thenOneAssertion(){
        String currentTIme = simpleDateFormat.format(calendar.getTime());
        assertThat(imageFileProcessor.editFile("file1.png")).isEqualTo("Opening PNG file file1.png at: " + currentTIme);
    }
}
