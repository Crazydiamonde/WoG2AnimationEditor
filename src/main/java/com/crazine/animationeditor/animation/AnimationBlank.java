package com.crazine.animationeditor.animation;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class AnimationBlank extends AnimationElement {

    @Override
    public String getType() {
        return "Blank";
    }

}
