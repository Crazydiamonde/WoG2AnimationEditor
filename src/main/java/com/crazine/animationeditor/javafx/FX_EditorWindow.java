package com.crazine.animationeditor.javafx;

import com.crazine.animationeditor.SceneManager;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

public class FX_EditorWindow extends AnimationTimer {

    @Override
    public void handle(long now) {
        if (SceneManager.getScene() != null && SceneManager.getScene().getBall() != null) {
            Renderer.render(FX_Canvas.getCanvas(), SceneManager.getScene(), 0);
        }
    }

}
