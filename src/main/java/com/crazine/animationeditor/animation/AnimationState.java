package com.crazine.animationeditor.animation;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class AnimationState {

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
    @JacksonXmlProperty(localName = "element")
    public AnimationSection[] animationSections;

    @JacksonXmlElementWrapper(localName = "events", useWrapping = false)
    @JacksonXmlProperty(localName = "event")
    public AnimationEvent[] animationEvents;

}
