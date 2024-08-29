package com.crazine.animationeditor.animation;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public abstract class AnimationElement extends AnimationObject {

    @JacksonXmlProperty(isAttribute = true)
    public int untilFrame;

}
