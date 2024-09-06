package com.crazine.animationeditor.animation;

import com.crazine.animationeditor.FinalBinAnimation;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Animation extends AnimationObject {

    @JacksonXmlProperty(isAttribute = true)
    public int fps;

    @JacksonXmlElementWrapper(localName = "states", useWrapping = false)
    @JacksonXmlProperty(localName = "state")
    public AnimationState[] animationStates;

    @JacksonXmlElementWrapper(localName = "parts", useWrapping = false)
    @JacksonXmlProperty(localName = "part")
    public AnimationPart[] animationParts;


    public Animation(FinalBinAnimation binAnimation) {

        fps = binAnimation.animationFPS;

        animationParts = new AnimationPart[binAnimation.animationParts.length];
        for (int animationPartIndex = 0; animationPartIndex < animationParts.length; animationPartIndex++) {
            animationParts[animationPartIndex] = new AnimationPart(binAnimation, animationPartIndex);
        }

        animationStates = new AnimationState[binAnimation.animationStates.length];
        for (int animationStateIndex = 0; animationStateIndex < animationStates.length; animationStateIndex++) {
            animationStates[animationStateIndex] = new AnimationState(binAnimation, animationStateIndex);
        }

    }

    @Override
    public String getType() {
        return "Animation";
    }

}
