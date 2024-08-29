package com.crazine.animationeditor.animation;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class AnimationState extends AnimationObject {

    @JacksonXmlProperty(isAttribute = true)
    public String name;

    @JacksonXmlProperty(isAttribute = true)
    public int globalId;

    @JacksonXmlProperty(isAttribute = true)
    public int localId;

    @JacksonXmlProperty(isAttribute = true)
    public int durationFrames;

    @JacksonXmlProperty(isAttribute = true)
    public int unknown1;

    @JacksonXmlElementWrapper(localName = "elements", useWrapping = false)
    public AnimationSection[] animationSections;

    @JacksonXmlElementWrapper(localName = "events", useWrapping = false)
    public AnimationEvent[] animationEvents;

    @Override
    public String getType() {
        return "State";
    }

    @Override
    public String getId() {
        return name;
    }

}
