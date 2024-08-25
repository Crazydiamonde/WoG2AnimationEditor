package com.crazine.animationeditor.animation;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class AnimationEvent {

    @JacksonXmlProperty(isAttribute = true)
    public boolean active;

    @JacksonXmlProperty (isAttribute = true)
    public int delay;

    @JacksonXmlProperty (isAttribute = true)
    public int groupId;

}
