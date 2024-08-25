package com.crazine.animationeditor.animation;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class AnimationSection {

    @JacksonXmlProperty(isAttribute = true)
    public int group;

    @JacksonXmlElementWrapper(localName = "elements", useWrapping = false)
    public AnimationElement[] animationElements;

}
