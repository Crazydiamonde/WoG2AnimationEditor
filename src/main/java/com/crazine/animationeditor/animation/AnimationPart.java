package com.crazine.animationeditor.animation;

import com.crazine.animationeditor.AnimationUtil;
import com.crazine.animationeditor.FinalBinAnimation;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Part")
public class AnimationPart extends AnimationObject {

    @JacksonXmlProperty(isAttribute = true)
    public String image;

    @JacksonXmlProperty (isAttribute = true)
    public float angleTopLeft;

    @JacksonXmlProperty (isAttribute = true)
    public float angleBottomRight;

    @JacksonXmlProperty (isAttribute = true)
    public float centerX;

    @JacksonXmlProperty (isAttribute = true)
    public float centerY;

    @JacksonXmlProperty (isAttribute = true)
    public float offsetX;

    @JacksonXmlProperty (isAttribute = true)
    public float offsetY;

    @JacksonXmlProperty (isAttribute = true)
    public float scaleX;

    @JacksonXmlProperty (isAttribute = true)
    public float scaleY;

    @JacksonXmlProperty (isAttribute = true)
    public int colorize;

    @JacksonXmlProperty (isAttribute = true)
    public int unknown1;

    @Override
    public String getType() {
        return "Part";
    }

    @Override
    public String getId() {
        return image;
    }


    public AnimationPart(FinalBinAnimation binAnimation, int animationPartIndex) {

        FinalBinAnimation.AnimationPart animationPart = binAnimation.animationParts[animationPartIndex];

        int imageStringTableIndex = binAnimation.animationImageStringTableIndices[animationPart.imageIndex];
        FinalBinAnimation.AnimationStringDefinition stringDefinition =
                binAnimation.animationStringDefinitions[imageStringTableIndex];
        image = AnimationUtil.getStringFromStringTable(binAnimation.animationStringTable,
                stringDefinition.stringTableIndex);

        angleTopLeft = animationPart.angleTopLeft;

        angleBottomRight = animationPart.angleBottomRight;

        centerX = animationPart.centerX;

        centerY = animationPart.centerY;

        offsetX = animationPart.offsetX;

        offsetY = animationPart.offsetY;

        scaleX = animationPart.scaleX;

        scaleY = animationPart.scaleY;

        colorize = animationPart.colorize;

        unknown1 = animationPart.attribute11;

    }

}
