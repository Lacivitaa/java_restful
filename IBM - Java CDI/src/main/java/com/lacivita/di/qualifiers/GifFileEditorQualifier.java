package com.lacivita.di.qualifiers;

import javax.inject.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/*
Retention - Checked on the runtime

Target - where this annotation can be used
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER})
public @interface GifFileEditorQualifier { }
