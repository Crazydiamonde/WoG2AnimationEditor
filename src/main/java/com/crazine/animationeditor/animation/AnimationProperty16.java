package com.crazine.animationeditor.animation;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class AnimationProperty16 extends AnimationObject {

    @JacksonXmlProperty(isAttribute = true)
    public int attribute1;

    @JacksonXmlProperty (isAttribute = true)
    public int attribute2;

    @Override
    public String getType() {
        return "Property 16";
    }

    @Override
    public String getId() {
        return attribute1 + "," + attribute2;
    }

}
