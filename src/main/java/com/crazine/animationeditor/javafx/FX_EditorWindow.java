package com.crazine.animationeditor.javafx;

import com.crazine.animationeditor.SceneManager;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

public class FX_EditorWindow extends AnimationTimer {

    @Override
    public void handle(long now) {
        if (SceneManager.getScene() != null && SceneManager.getScene().getBall() != null) {

            double time = FX_Timeline.getScrollBar().getValue() * 2;

            Renderer.render(FX_Canvas.getCanvas(), SceneManager.getScene(), time);
        }
    }

}
