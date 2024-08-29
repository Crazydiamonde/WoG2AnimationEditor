package com.crazine.animationeditor.resources;

import com.crazine.animationeditor.animation.AnimationObject;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ResourceManifest extends AnimationObject {

    @JacksonXmlProperty(localName = "Resources")
    public Resources resources;

}
