package com.crazine.animationeditor.animation;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class AnimationBlank extends AnimationElement {

    @JacksonXmlProperty(isAttribute = true)
    public int untilFrame;

}
