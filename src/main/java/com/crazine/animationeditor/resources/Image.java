package com.crazine.animationeditor.resources;

import com.crazine.animationeditor.animation.AnimationObject;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Image extends Resource {

    @JsonIgnore
    public javafx.scene.image.Image image;


    @Override
    public String getType() {
        return "Image";
    }

}
