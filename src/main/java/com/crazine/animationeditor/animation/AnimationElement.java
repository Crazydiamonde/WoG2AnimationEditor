package com.crazine.animationeditor.animation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = AnimationKeyframe.class, name = "Keyframe"),
        @JsonSubTypes.Type(value = AnimationBlank.class, name = "Blank"),
        @JsonSubTypes.Type(value = AnimationProperty8.class, name = "Property8"),
        @JsonSubTypes.Type(value = AnimationProperty9.class, name = "Property9"),
})
public abstract class AnimationElement extends AnimationObject {

    @JacksonXmlProperty(isAttribute = true)
    public String type;

    @JacksonXmlProperty(isAttribute = true)
    public int untilFrame;

}
