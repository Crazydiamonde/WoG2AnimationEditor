package com.crazine.animationeditor.animation;

import com.crazine.animationeditor.AnimationUtil;
import com.crazine.animationeditor.FinalBinAnimation;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class AnimationState extends AnimationObject {

    @JacksonXmlProperty(isAttribute = true)
    public String name;

    @JacksonXmlProperty(isAttribute = true)
    public int globalId;

    @JacksonXmlProperty(isAttribute = true)
    public int localId;

    public AnimationGroup animationGroup;

    @Override
    public String getType() {
        return "State";
    }

    @Override
    public String getId() {
        return name;
    }


    public AnimationState(FinalBinAnimation binAnimation, int animationStateIndex) {

        FinalBinAnimation.AnimationState animationState = binAnimation.animationStates[animationStateIndex];

        int nameStringTableIndex = binAnimation.animationStateNameStringTableIndices[animationStateIndex];
        FinalBinAnimation.AnimationStringDefinition stringDefinition =
                binAnimation.animationStringDefinitions[nameStringTableIndex];
        name = AnimationUtil.getStringFromStringTable(binAnimation.animationStringTable,
                stringDefinition.stringTableIndex);

        globalId = animationState.globalIdHash;

        localId = animationState.localIdHash;

        animationGroup = new AnimationGroup(binAnimation, animationState.groupIndex);

    }

}
