package com.crazine.animationeditor.animation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javafx.scene.control.TreeItem;

public class AnimationObject {

    @JsonIgnore
    private final TreeItem<AnimationObject> treeItem = new TreeItem<>(this);
    public TreeItem<AnimationObject> getTreeItem() {
        return treeItem;
    }


    @JsonIgnore
    public String getType() {
        return "";
    }

    @JsonIgnore
    public String getId() {
        return "";
    }

    @Override
    public String toString() {
        return null;
    }


    @JsonIgnore
    public void fromString(String s) {

    }

}
