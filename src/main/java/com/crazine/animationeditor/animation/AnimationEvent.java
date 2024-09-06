package com.crazine.animationeditor.animation;

import com.crazine.animationeditor.FinalBinAnimation;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class AnimationEvent extends AnimationObject {

    @JacksonXmlProperty (isAttribute = true, localName = "type")
    public FinalBinAnimation.AnimationEventType type;

    @JacksonXmlProperty (isAttribute = true, localName = "frame")
    public int frame;

    @JacksonXmlProperty (isAttribute = true, localName = "unknown1")
    public int unknown1;

    @Override
    public String getType() {
        return "Event";
    }


    public AnimationEvent(FinalBinAnimation binAnimation, int animationEventIndex) {

        FinalBinAnimation.AnimationEvent animationEvent = binAnimation.animationEvents[animationEventIndex];

        type = animationEvent.type;

        frame = animationEvent.frame;

        unknown1 = animationEvent.unknown1;

    }

}
