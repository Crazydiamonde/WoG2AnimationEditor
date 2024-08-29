package com.crazine.animationeditor.resources;

import com.crazine.animationeditor.animation.AnimationObject;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;

public class Resources extends AnimationObject {

    public String id;

    @JacksonXmlElementWrapper(useWrapping = false)
    public Resource[] resources;

    @Override
    public String getType() {
        return "Resources";
    }

}
