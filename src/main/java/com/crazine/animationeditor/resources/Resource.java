package com.crazine.animationeditor.resources;

import com.crazine.animationeditor.animation.AnimationObject;

public class Resource extends AnimationObject {

    public String id;
    public String path;

    @Override
    public String getId() {
        return id;
    }

}
