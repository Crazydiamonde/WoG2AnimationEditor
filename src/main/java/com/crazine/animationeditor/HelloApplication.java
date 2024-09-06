package com.crazine.animationeditor;

import com.crazine.animationeditor.animation.Animation;
import com.crazine.animationeditor.animation.AnimationPart;
import com.crazine.animationeditor.file.FileTransferManager;
import com.crazine.animationeditor.javafx.FX_EditorWindow;
import com.crazine.animationeditor.javafx.FX_Hierarchy;
import com.crazine.animationeditor.javafx.FX_Scene;
import com.crazine.animationeditor.resources.ResourceManifest;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.File;

public class HelloApplication extends Application {

    public static void onOpenBin(File binFile) {

        FinalBinAnimation binAnimation = FileTransferManager.readBin(binFile);
        assert binAnimation != null;
        Animation animation = new Animation(binAnimation);
        SceneManager.getScene().getPartManifest().getChildren().clear();
        SceneManager.getScene().getResourceManifest().getChildren().clear();
        SceneManager.getScene().setBall(animation);
        try {
            AnimationLoader.recursivelyAdd(animation.getTreeItem());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        FX_Hierarchy.getHierarchy().setRoot(animation.getTreeItem());
        for (AnimationPart animationPart : animation.animationParts) {
            SceneManager.getScene().getPartManifest().getChildren().add(animationPart.getTreeItem());
        }
        SceneManager.getScene().setAnimationManifest(animation.getTreeItem());

        //ResourceManifest resourceManifest = AnimationLoader.openResources(new File(binFile.getParent() + "/manifest.resrc"));
        //try {
            //AnimationLoader.recursivelyAdd(resourceManifest.getTreeItem());
        //} catch (Exception e) {
            //throw new RuntimeException(e);
        //}
        //SceneManager.getScene().setResourceManifest(resourceManifest.getTreeItem());

    }

    @Override
    public void start(Stage stage) {

        FX_Scene.buildScene(stage);

        stage.setTitle("World of Goo 2 Animation Editor");
        stage.setScene(FX_Scene.getScene());
        stage.show();

        //File binFile = new File("D:/World of Goo 2/game/res/anim/Launchers/BallLauncher/BallLauncher.anim.bin");
        //onOpenBin(binFile);

        FinalBinAnimation finalBinAnimation = FileTransferManager.readBin(new File("C:/Users/Crazine/Documents/World of Goo 2/game/res/anim/Launchers/BallLauncher/BallLauncher.anim.bin"));
        FileTransferManager.writeXml(new Animation(finalBinAnimation), finalBinAnimation, new File("C:/Users/Crazine/Documents/BallLauncher.anim.xml"));

        new FX_EditorWindow().start();

    }

    public static void main(String[] args) {
        launch();
    }

}