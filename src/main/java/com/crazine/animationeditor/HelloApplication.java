package com.crazine.animationeditor;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class HelloApplication extends Application {

    private static File lastReadBinFile = null;
    private static File lastWriteBinFile = null;
    private static File lastReadXmlFile = null;
    private static File lastWriteXmlFile = null;
    private static boolean wasLastToXml = false;

    @Override
    public void start(Stage stage) throws IOException {

        MenuBar menuBar = new MenuBar();

        Menu fileMenu = new Menu("File");

        MenuItem binToXml = new MenuItem("Translate .anim.bin to .anim.xml...");
        binToXml.setOnAction(event -> {
            File binFile = promptOpenBin(stage);
            writeXml(readBin(binFile), promptSaveXml(binFile, stage));
        });

        MenuItem xmlToBin = new MenuItem("Translate .anim.xml to .anim.bin...");
        xmlToBin.setOnAction(event -> {
            File xmlFile = promptOpenXml(stage);
            writeBin(readXml(xmlFile), promptSaveBin(xmlFile, stage));
        });

        MenuItem repeat = new MenuItem("Repeat last operation");
        repeat.setOnAction(event -> {
            if (wasLastToXml) {
                writeXml(readBin(lastReadBinFile), lastWriteXmlFile);
            } else {
                writeBin(readXml(lastReadXmlFile), lastWriteBinFile);
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
                    writeXml(readBin(file), promptSaveXml(file, stage));
                } else if (file.getName().endsWith(".anim.xml")) {
                    writeBin(readXml(file), promptSaveBin(file, stage));
                }
                success = true;
            }
            /* let the source know whether the string was successfully
             * transferred and used */
            event.setDropCompleted(success);

            event.consume();
        });
        dragTarget.getChildren().addAll(menuBar);
        dragTarget.setPrefSize(200, 200);

        Scene scene = new Scene(dragTarget, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

    public static File promptOpenXml(Stage stage) {
        FileChooser openXml = new FileChooser();
        openXml.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML File", "*.anim.xml"));
        if (lastReadXmlFile != null) openXml.setInitialDirectory(lastReadXmlFile.getParentFile());
        return openXml.showOpenDialog(stage);
    }

    public static File promptSaveXml(File binFile, Stage stage) {
        FileChooser saveXml = new FileChooser();
        saveXml.setInitialFileName(binFile.getName().replace(".anim.bin", ".anim.xml"));
        return saveXml.showSaveDialog(stage);
    }

    public static BinAnimation readXml(File xmlFile) {
        BinAnimation binAnimation;
        try {
            XmlMapper xmlMapper = new XmlMapper();
            binAnimation = xmlMapper.readValue(xmlFile, BinAnimation.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        lastReadXmlFile = xmlFile;
        lastWriteXmlFile = xmlFile;
        return binAnimation;
    }

    public static void writeXml(BinAnimation binAnimation, File xmlFile) {
        if (xmlFile == null) return;
        lastWriteXmlFile = xmlFile;
        lastReadXmlFile = xmlFile;
        wasLastToXml = true;
        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            xmlMapper.writeValue(xmlFile, binAnimation);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File promptOpenBin(Stage stage) {
        FileChooser openBin = new FileChooser();
        openBin.getExtensionFilters().add(new FileChooser.ExtensionFilter("Animation File", "*.anim.bin"));
        if (lastReadBinFile != null) openBin.setInitialDirectory(lastReadBinFile.getParentFile());
        return openBin.showOpenDialog(stage);
    }

    public static File promptSaveBin(File xmlFile, Stage stage) {
        FileChooser saveBin = new FileChooser();
        saveBin.setInitialFileName(xmlFile.getName().replace(".anim.xml", ".anim.bin"));
        return saveBin.showSaveDialog(stage);
    }

    public static BinAnimation readBin(File binFile) {
        BinAnimation binAnimation;
        try {
            binAnimation = AnimBinReader.read(binFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        lastReadBinFile = binFile;
        lastWriteBinFile = binFile;
        return binAnimation;
    }

    public static void writeBin(BinAnimation binAnimation, File binFile) {
        if (binFile == null) return;
        lastWriteBinFile = binFile;
        lastReadBinFile = binFile;
        wasLastToXml = false;
        try {
            AnimBinWriter.write(binFile.toPath(), binAnimation);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}