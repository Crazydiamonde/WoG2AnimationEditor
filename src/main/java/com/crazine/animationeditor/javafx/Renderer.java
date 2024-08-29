package com.crazine.animationeditor.javafx;

import com.crazine.animationeditor.AnimationScene;
import com.crazine.animationeditor.KTXFileManager;
import com.crazine.animationeditor.SceneManager;
import com.crazine.animationeditor.animation.*;
import com.crazine.animationeditor.resources.Image;
import com.crazine.animationeditor.resources.Resource;
import com.crazine.animationeditor.resources.ResourceManifest;
import javafx.animation.Animation;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;

import java.awt.image.BufferedImage;
import java.nio.file.Path;

public class Renderer {

    public static void render(Canvas canvas, AnimationScene scene, double time) {

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        graphicsContext.save();

        Affine t = graphicsContext.getTransform();
        t.prependScale(scene.getZoom(), scene.getZoom());
        t.prependTranslation(scene.getOffsetX(), scene.getOffsetY());
        graphicsContext.setTransform(t);

        int i = 0;
        for (AnimationState animationState : scene.getBall().animationStates) {
            //if (!animationState.name.equals("idle")) continue;
            for (AnimationSection animationSection : animationState.animationSections) {
                graphicsContext.setGlobalAlpha(0.5);
                renderSection(graphicsContext, animationSection, i * 400, 0, 1, 1, 0);
            }
            i++;
        }

        graphicsContext.restore();

    }


    private static void renderSection(GraphicsContext graphicsContext, AnimationSection animationSection, double x, double y, double scaleX, double scaleY, double rotation) {

        for (AnimationElement animationElement : animationSection.animationElements) {

            if (animationElement instanceof AnimationPartReference animationPartReference) {
                AnimationPart animationPart = animationPartReference.animationPart;
                String imageString = animationPart.image;
                for (Resource resource : ((ResourceManifest)SceneManager.getScene().getResourceManifest().getValue()).resources.resources) {
                    if (resource instanceof Image image) {
                        if (image.id.equals(imageString)) {
                            String path = image.path;

                            if (image.image == null) {
                                BufferedImage image1 = KTXFileManager.readKTXImage(Path.of("D:/World of Goo 2/game/" + path + ".image"));
                                image.image = SwingFXUtils.toFXImage(image1, null);
                            }

                            javafx.scene.image.Image image2 = image.image;

                            double imageWidth = image2.getWidth();
                            double imageHeight = image2.getHeight();
                            double imageX = x + animationPart.offsetX - animationPart.centerX;
                            double imageY = y + animationPart.offsetY - animationPart.centerY;

                            graphicsContext.save();
                            Affine t = graphicsContext.getTransform();
                            t.appendRotation(Math.toDegrees(rotation + animationPart.angleTopLeft), imageX + imageWidth / 2, imageY + imageHeight / 2);
                            graphicsContext.setTransform(t);
                            graphicsContext.drawImage(image2, imageX, imageY, imageWidth, imageHeight);
                            graphicsContext.restore();

                        }
                    }
                }
            } else if (animationElement instanceof AnimationKeyframe animationKeyframe) {
                for (AnimationSection animationSection1 : animationKeyframe.animationSections) {
                    renderSection(graphicsContext, animationSection1, x + (animationKeyframe.x2 - animationKeyframe.x1) * scaleX, y - (animationKeyframe.y1 - animationKeyframe.y2) * scaleY, scaleX * animationKeyframe.scaleX, scaleY * animationKeyframe.scaleY, rotation - animationKeyframe.angleTopLeft);
                }
            }

        }

    }

}
