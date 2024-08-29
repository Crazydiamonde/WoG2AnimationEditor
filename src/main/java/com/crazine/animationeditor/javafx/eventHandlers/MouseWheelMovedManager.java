package com.crazine.animationeditor.javafx.eventHandlers;

import com.crazine.animationeditor.AnimationScene;
import com.crazine.animationeditor.SceneManager;
import com.crazine.animationeditor.javafx.FX_Canvas;
import com.crazine.animationeditor.javafx.Renderer;
import javafx.scene.control.SplitPane;
import javafx.scene.input.ScrollEvent;

public class MouseWheelMovedManager {

    public static void onMouseWheelMoved(ScrollEvent e) {


        AnimationScene level = SceneManager.getScene();
        if (level == null) return;

        // If the mouse was scrolled out the editor window, return
        //SplitPane splitPane = FX_Scene.getHBox();
        //double canvasWidth = splitPane.getDividerPositions()[0] * splitPane.getWidth();
        //if (e.getX() > canvasWidth) return;

        // Calculate the new translation and scale.
        double amt = Math.pow(1.25, (e.getDeltaY() / 40));

        double oldTranslateX = level.getOffsetX();
        double oldTranslateY = level.getOffsetY();

        double oldScaleX = level.getZoom();
        double oldScaleY = level.getZoom();

        double mouseX = e.getX();
        double mouseY = e.getY() - FX_Canvas.getMouseYOffset();

        //if (oldScaleX * amt < 10 || oldScaleX * amt > 1000000 ||
        //        oldScaleY * amt < 10 || oldScaleY * amt > 1000000) return;

        double newScaleX = oldScaleX * amt;
        double newScaleY = oldScaleY * amt;

        double newTranslateX = ((oldTranslateX - mouseX) * amt + mouseX);
        double newTranslateY = ((oldTranslateY - mouseY) * amt + mouseY);

        level.setOffsetX(newTranslateX);
        level.setOffsetY(newTranslateY);
        level.setZoom(newScaleX);

        // Redraw the canvas.
        Renderer.render(FX_Canvas.getCanvas(), level, 0);


    }

}
