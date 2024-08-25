package com.crazine.animationeditor.animation;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Property8")
public class AnimationProperty8 extends AnimationElement {

    @JacksonXmlProperty(isAttribute = true)
    public int untilFrame;

    @JacksonXmlProperty (isAttribute = true)
    public int unknown1;

    @JacksonXmlProperty(isAttribute = true)
    public int unknown2;

}
