package com.crazine.animationeditor;

public class SceneManager {

    private static AnimationScene scene;
    public static AnimationScene getScene() {
        return scene;
    }
    public static void setScene(AnimationScene scene) {
        SceneManager.scene = scene;
    }

}
