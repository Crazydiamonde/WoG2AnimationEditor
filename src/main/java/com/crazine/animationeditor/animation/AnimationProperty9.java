package com.crazine.animationeditor.animation;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Property9")
public class AnimationProperty9 extends AnimationElement {

    @JacksonXmlProperty(isAttribute = true)
    public int group;

    @JacksonXmlProperty(isAttribute = true)
    public int untilFrame;

    @JacksonXmlProperty(isAttribute = true)
    public int attribute1;

    @JacksonXmlProperty (isAttribute = true)
    public float attribute2;

    @JacksonXmlProperty (isAttribute = true)
    public float attribute3;

    @JacksonXmlProperty (isAttribute = true)
    public float attribute4;

    @JacksonXmlProperty (isAttribute = true)
    public float attribute5;

    @JacksonXmlProperty (isAttribute = true)
    public float attribute6;

    @JacksonXmlProperty (isAttribute = true)
    public float attribute7;

}
