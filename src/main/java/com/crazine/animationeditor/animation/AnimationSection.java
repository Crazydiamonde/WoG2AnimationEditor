package com.crazine.animationeditor.animation;

import com.crazine.animationeditor.FinalBinAnimation;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class AnimationSection extends AnimationObject {

    @JacksonXmlProperty(isAttribute = true, localName = "type")
    public FinalBinAnimation.AnimationSectionType type;

    @JacksonXmlElementWrapper(localName = "elements", useWrapping = false)
    public AnimationElement[] animationElements;

    @Override
    public String getType() {
        return "Section";
    }

    @Override
    public String getId() {
        return type.toString();
    }


    public AnimationSection(FinalBinAnimation binAnimation, int animationSectionIndex) {

        FinalBinAnimation.AnimationSection animationSection = binAnimation.animationSections[animationSectionIndex];

        type = animationSection.type;

        animationElements = new AnimationElement[animationSection.elementLength];
        for (int elementIndex = 0; elementIndex < animationSection.elementLength; elementIndex++) {
            int animationElementIndex = elementIndex + animationSection.elementOffset;
            FinalBinAnimation.AnimationElement animationElement = binAnimation.animationElements[animationElementIndex];
            animationElements[elementIndex] = switch (animationElement.type) {
                case TYPE_0 -> new AnimationBlank();
                case TYPE_1 -> new AnimationKeyframe();
                case TYPE_2 -> new AnimationPartReference();
                case TYPE_3 -> new AnimationProperty8();
                case TYPE_4 -> new AnimationProperty9();
            };
        }

    }

}
