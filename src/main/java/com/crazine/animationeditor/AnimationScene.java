package com.crazine.animationeditor;

import com.crazine.animationeditor.animation.Animation;
import com.crazine.animationeditor.animation.AnimationObject;
import javafx.scene.control.TreeItem;

import java.util.Stack;

public class AnimationScene {

    private Animation ball;
    public Animation getBall() {
        return ball;
    }
    public void setBall(Animation ball) {
        this.ball = ball;
    }


    private AnimationObject selected;
    public AnimationObject getSelected() {
        return selected;
    }
    public void setSelected(AnimationObject selected) {
        this.selected = selected;
    }


    private double offsetX = 600;
    public double getOffsetX() {
        return offsetX;
    }
    public void setOffsetX(double offsetX) {
        this.offsetX = offsetX;
    }

    private double offsetY = 0;
    public double getOffsetY() {
        return offsetY;
    }
    public void setOffsetY(double offsetY) {
        this.offsetY = offsetY;
    }

    private double zoom = 1;
    public double getZoom() {
        return zoom;
    }
    public void setZoom(double zoom) {
        this.zoom = zoom;
    }


    private final TreeItem<AnimationObject> partManifest = new TreeItem<>();
    public TreeItem<AnimationObject> getPartManifest() {
        return partManifest;
    }

    private TreeItem<AnimationObject> animationManifest = new TreeItem<>();
    public TreeItem<AnimationObject> getAnimationManifest() {
        return animationManifest;
    }
    public void setAnimationManifest(TreeItem<AnimationObject> t) {
        this.animationManifest = t;
    }

    private TreeItem<AnimationObject> resourceManifest = new TreeItem<>();
    public TreeItem<AnimationObject> getResourceManifest() {
        return resourceManifest;
    }
    public void setResourceManifest(TreeItem<AnimationObject> t) {
        this.resourceManifest = t;
    }

    // public final Stack<UserAction[]> redoActions = new Stack<>();
    // public final Stack<UserAction[]> undoActions = new Stack<>();


    private int lastSavedUndoPosition = 0;
    public int getLastSavedUndoPosition() {
        return lastSavedUndoPosition;
    }
    public void setLastSavedUndoPosition(int position) {
        this.lastSavedUndoPosition = position;
    }


    // private FX_SceneSelectPane.SceneTab levelTab;
    // public FX_SceneSelectPane.SceneTab getLevelTab() {
        // return levelTab;
    // }
    // public void setLevelTab(FX_SceneSelectPane.SceneTab levelTab) {
        // this.levelTab = levelTab;
    // }


    private int editingStatus;
    public int getEditingStatus() {
        return editingStatus;
    }
    public void setEditingStatus(int editingStatus, boolean shouldSelect) {
        this.editingStatus = editingStatus;
        // this.levelTab.update(editingStatus, shouldSelect);
    }


    private String currentlySelectedSection;
    public String getCurrentlySelectedSection() {
        return currentlySelectedSection;
    }
    public void setCurrentlySelectedSection(String s) {
        this.currentlySelectedSection = s;
    }

}
