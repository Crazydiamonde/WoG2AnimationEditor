package com.crazine.animationeditor.animation;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Part")
public class AnimationPart extends AnimationElement {

    @JacksonXmlProperty(isAttribute = true)
    public int untilFrame;

    @JacksonXmlProperty(isAttribute = true)
    public String image;

    @JacksonXmlProperty (isAttribute = true)
    public float angleTopLeft;

    @JacksonXmlProperty (isAttribute = true)
    public float angleBottomRight;

    @JacksonXmlProperty (isAttribute = true)
    public float centerX;

    @JacksonXmlProperty (isAttribute = true)
    public float centerY;

    @JacksonXmlProperty (isAttribute = true)
    public float offsetX;

    @JacksonXmlProperty (isAttribute = true)
    public float offsetY;

    @JacksonXmlProperty (isAttribute = true)
    public float scaleX;

    @JacksonXmlProperty (isAttribute = true)
    public float scaleY;

    @JacksonXmlProperty (isAttribute = true)
    public int colorize;

    @JacksonXmlProperty (isAttribute = true)
    public int unknown1;

}
