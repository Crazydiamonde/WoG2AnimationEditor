package com.crazine.animationeditor.javafx;

import com.crazine.animationeditor.AnimationScene;
import com.crazine.animationeditor.KTXFileManager;
import com.crazine.animationeditor.SceneManager;
import com.crazine.animationeditor.animation.*;
import com.crazine.animationeditor.resources.Image;
import com.crazine.animationeditor.resources.Resource;
import com.crazine.animationeditor.resources.ResourceManifest;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.transform.Affine;

import java.awt.image.BufferedImage;
import java.nio.file.Path;

public class Renderer {

    public static class RenderTransform {

        public double x = 0;
        public double y = 0;
        public double scaleX = 1;
        public double scaleY = 1;
        public double rotation = 0;

        public RenderTransform copy() {
            RenderTransform renderTransform = new RenderTransform();
            renderTransform.x = x;
            renderTransform.y = y;
            renderTransform.scaleX = scaleX;
            renderTransform.scaleY = scaleY;
            renderTransform.rotation = rotation;
            return renderTransform;
        }

    }

    public static void render(Canvas canvas, AnimationScene scene, double time) {

        if (true) return;

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        graphicsContext.save();

        Affine t = graphicsContext.getTransform();
        t.prependScale(scene.getZoom(), scene.getZoom());
        t.prependTranslation(scene.getOffsetX(), scene.getOffsetY());
        graphicsContext.setTransform(t);

        int i = 0;
        for (AnimationState animationState : scene.getBall().animationStates) {
            for (AnimationSection animationSection : animationState.animationGroup.animationSections) {
                graphicsContext.setGlobalAlpha(0.5);
                RenderTransform renderTransform = new RenderTransform();
                renderTransform.x += i * 400;
                renderSection(graphicsContext, animationSection, renderTransform, time);
            }
            i++;
        }

        graphicsContext.restore();

    }


    private static void renderSection(GraphicsContext graphicsContext, AnimationSection animationSection, RenderTransform renderTransform, double time) {

        for (AnimationElement animationElement : animationSection.animationElements) {

            if (animationElement instanceof AnimationPartReference animationPartReference) {
                AnimationPart animationPart = animationPartReference.animationPart;
                String imageString = animationPart.image;
                for (Resource resource : ((ResourceManifest)SceneManager.getScene().getResourceManifest().getValue()).resources.resources) {
                    if (resource instanceof Image image) {
                        if (image.id.equals(imageString)) {
                            String path = image.path;

                            if (image.image == null) {
                                BufferedImage image1 = KTXFileManager.readKTXImage(Path.of("C:/Users/Crazine/Documents/World of Goo 2/game/" + path + ".image"));
                                image.image = SwingFXUtils.toFXImage(image1, null);
                            }

                            javafx.scene.image.Image image2 = image.image;

                            double imageWidth = image2.getWidth() * renderTransform.scaleX * animationPart.scaleX;
                            double imageHeight = image2.getHeight() * renderTransform.scaleY * animationPart.scaleY;
                            double imageX = renderTransform.x + animationPart.offsetX * renderTransform.scaleX - animationPart.centerX * renderTransform.scaleX * animationPart.scaleX;
                            double imageY = renderTransform.y + animationPart.offsetY * renderTransform.scaleY - animationPart.centerY * renderTransform.scaleY * animationPart.scaleY;

                            graphicsContext.save();
                            Affine t = graphicsContext.getTransform();
                            t.appendRotation(Math.toDegrees(renderTransform.rotation + animationPart.angleTopLeft), imageX + imageWidth / 2, imageY + imageHeight / 2);
                            graphicsContext.setTransform(t);
                            graphicsContext.drawImage(image2, imageX, imageY, imageWidth, imageHeight);
                            graphicsContext.restore();

                        }
                    }
                }
            } else if (animationElement instanceof AnimationKeyframe animationKeyframe) {
                for (AnimationSection animationSection1 : animationKeyframe.animationGroup.animationSections) {
                    RenderTransform renderTransform1 = renderTransform.copy();
                    renderTransform1.x += (animationKeyframe.x2 - animationKeyframe.x1) * renderTransform.scaleX;
                    renderTransform1.y -= (animationKeyframe.y1 - animationKeyframe.y2) * renderTransform.scaleY;
                    renderTransform1.scaleX *= animationKeyframe.scaleX;
                    renderTransform1.scaleY *= animationKeyframe.scaleY;
                    renderTransform1.rotation -= animationKeyframe.angleTopLeft;
                    renderSection(graphicsContext, animationSection1, renderTransform1, time);
                }
            }

        }

    }

}
