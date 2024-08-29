package com.crazine.animationeditor.animation;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class AnimationKeyframe extends AnimationElement {

    @JacksonXmlProperty(isAttribute = true)
    public int durationFrames;

    @JacksonXmlProperty(isAttribute = true)
    public int unknown1;

    @JacksonXmlElementWrapper(localName = "elements", useWrapping = false)
    public AnimationSection[] animationSections;

    @JacksonXmlElementWrapper(localName = "events", useWrapping = false)
    public AnimationEvent[] animationEvents;

    @JacksonXmlProperty(isAttribute = true)
    public int unknown2;

    @JacksonXmlProperty(isAttribute = true)
    public float angleTopLeft;

    @JacksonXmlProperty(isAttribute = true)
    public float angleBottomRight;

    @JacksonXmlProperty(isAttribute = true)
    public float x1;

    @JacksonXmlProperty(isAttribute = true)
    public float y1;

    @JacksonXmlProperty(isAttribute = true)
    public float x2;

    @JacksonXmlProperty(isAttribute = true)
    public float y2;

    @JacksonXmlProperty(isAttribute = true)
    public float scaleX;

    @JacksonXmlProperty(isAttribute = true)
    public float scaleY;

    @JacksonXmlProperty(isAttribute = true)
    public int colorize;

    // always 0.0
    @JacksonXmlProperty(isAttribute = true)
    public float unknown3;

    @Override
    public String getType() {
        return "Keyframe";
    }

}
