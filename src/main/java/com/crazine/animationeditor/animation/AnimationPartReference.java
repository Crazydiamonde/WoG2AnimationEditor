package com.crazine.animationeditor.animation;

public class AnimationPartReference extends AnimationElement {

    @HideTreeItem
    public AnimationPart animationPart;

    @Override
    public String getType() {
        return "Part";
    }

    @Override
    public String getId() {
        return animationPart.image;
    }

}
