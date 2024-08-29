package com.crazine.animationeditor.javafx;

import com.crazine.animationeditor.AnimationScene;
import com.crazine.animationeditor.HelloApplication;
import com.crazine.animationeditor.SceneManager;
import com.crazine.animationeditor.animation.FX_PropertiesView;
import com.crazine.animationeditor.file.FileTransferManager;
import com.crazine.animationeditor.javafx.eventHandlers.MouseWheelMovedManager;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class FX_Scene {

    private static Scene scene = null;
    public static Scene getScene() {
        return scene;
    }


    public static void buildScene(Stage stage) {

        MenuBar menuBar = new MenuBar();

        Menu fileMenu = new Menu("File");

        MenuItem binToXml = new MenuItem("Translate .anim.bin to .anim.xml...");
        binToXml.setOnAction(event -> {
            File binFile = FileTransferManager.promptOpenBin(stage);
            HelloApplication.onOpenBin(binFile);
            FileTransferManager.writeXml(FileTransferManager.readBin(binFile), FileTransferManager.promptSaveXml(binFile, stage));
        });

        MenuItem xmlToBin = new MenuItem("Translate .anim.xml to .anim.bin...");
        xmlToBin.setOnAction(event -> {
            File xmlFile = FileTransferManager.promptOpenXml(stage);
            FileTransferManager.writeBin(FileTransferManager.readXml(xmlFile), FileTransferManager.promptSaveBin(xmlFile, stage));
        });

        MenuItem repeat = new MenuItem("Repeat last operation");
        repeat.setOnAction(event -> {
            if (FileTransferManager.getTransferMode() == FileTransferManager.FileTransferMode.BIN_TO_XML) {
                FileTransferManager.writeXml(FileTransferManager.readBin(FileTransferManager.getLastOpenedBin()), FileTransferManager.getLastSavedXml());
            } else {
                FileTransferManager.writeBin(FileTransferManager.readXml(FileTransferManager.getLastOpenedXml()), FileTransferManager.getLastSavedBin());
            }
        });

        fileMenu.getItems().addAll(binToXml, xmlToBin, repeat);

        menuBar.getMenus().add(fileMenu);

        VBox dragTarget = new VBox();
        dragTarget.setOnDragOver(event -> {
            if (event.getGestureSource() != dragTarget && event.getDragboard().hasFiles()) {
                /* allow for both copying and moving, whatever user chooses */
                event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
            }
            event.consume();
        });

        dragTarget.setOnDragDropped(event -> {
            Dragboard db = event.getDragboard();
            boolean success = false;
            if (db.hasFiles()) for (File file : db.getFiles()) {
                if (file.getName().endsWith(".anim.bin")) {
                    FileTransferManager.writeXml(FileTransferManager.readBin(file), FileTransferManager.promptSaveXml(file, stage));
                } else if (file.getName().endsWith(".anim.xml")) {
                    FileTransferManager.writeBin(FileTransferManager.readXml(file), FileTransferManager.promptSaveBin(file, stage));
                }
                success = true;
            }
            /* let the source know whether the string was successfully
             * transferred and used */
            event.setDropCompleted(success);

            event.consume();
        });

        FX_Hierarchy.buildHierarchy();
        FX_PropertiesView.buildPropertiesView();
        FX_Hierarchy.buildHierarchySwitcherButtons();

        SceneManager.setScene(new AnimationScene());

        FX_Canvas.buildCanvas();
        FX_Timeline.buildTimeline();

        dragTarget.getChildren().addAll(FX_Hierarchy.getHierarchySwitcherButtons(), FX_Hierarchy.getHierarchy(), FX_PropertiesView.getPropertiesView());
        dragTarget.setPrefSize(1920, 1080);

        VBox vBox2 = new VBox();
        Pane pane = new Pane(FX_Canvas.getCanvas());
        vBox2.getChildren().addAll(pane, FX_Timeline.getTimeline());

        FX_Canvas.getCanvas().setWidth(1000);
        FX_Canvas.getCanvas().setHeight(1000);

        SplitPane splitPane = new SplitPane(vBox2, dragTarget);
        vBox2.prefHeightProperty().bind(splitPane.heightProperty());
        pane.prefHeightProperty().bind(splitPane.heightProperty());
        splitPane.setPrefSize(1920, 1080);

        splitPane.setDividerPositions(0.7);
        FX_Canvas.getCanvas().setOnScroll(MouseWheelMovedManager::onMouseWheelMoved);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(menuBar, splitPane);
        vBox.setPrefSize(1920, 1080);

        scene = new Scene(vBox, 1920, 1080);

    }

}
