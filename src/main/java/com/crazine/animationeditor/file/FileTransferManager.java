package com.crazine.animationeditor.file;

import com.crazine.animationeditor.AnimBinReader;
import com.crazine.animationeditor.AnimBinWriter;
import com.crazine.animationeditor.BinAnimation;
import com.crazine.animationeditor.FinalBinAnimation;
import com.crazine.animationeditor.animation.Animation;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class FileTransferManager {

    public enum FileTransferMode {
        BIN_TO_XML,
        XML_TO_BIN,
    }

    private static FileTransferMode transferMode;
    public static FileTransferMode getTransferMode() {
        return transferMode;
    }
    public static void setTransferMode(FileTransferMode transferMode) {
        FileTransferManager.transferMode = transferMode;
    }


    private static File lastOpenedXml = null;
    public static File getLastOpenedXml() {
        return lastOpenedXml;
    }
    public static void setLastOpenedXml(File lastOpenedXml) {
        FileTransferManager.lastOpenedXml = lastOpenedXml;
    }

    private static File lastOpenedBin = null;
    public static File getLastOpenedBin() {
        return lastOpenedBin;
    }
    public static void setLastOpenedBin(File lastOpenedBin) {
        FileTransferManager.lastOpenedBin = lastOpenedBin;
    }

    private static File lastSavedXml = null;
    public static File getLastSavedXml() {
        return lastSavedXml;
    }
    public static void setLastSavedXml(File lastSavedXml) {
        FileTransferManager.lastSavedXml = lastSavedXml;
    }

    private static File lastSavedBin = null;
    public static File getLastSavedBin() {
        return lastSavedBin;
    }
    public static void setLastSavedBin(File lastSavedBin) {
        FileTransferManager.lastSavedBin = lastSavedBin;
    }


    public static File promptOpenBin(Stage stage) {
        FileChooser openBin = new FileChooser();
        openBin.getExtensionFilters().add(new FileChooser.ExtensionFilter("Animation File", "*.anim.bin"));
        if (lastOpenedBin != null) openBin.setInitialDirectory(lastOpenedBin.getParentFile());
        else if (lastSavedBin != null) openBin.setInitialDirectory(lastSavedBin.getParentFile());
        return openBin.showOpenDialog(stage);
    }

    public static File promptOpenXml(Stage stage) {
        FileChooser openXml = new FileChooser();
        openXml.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML File", "*.anim.xml"));
        if (lastOpenedXml != null) openXml.setInitialDirectory(lastOpenedXml.getParentFile());
        else if (lastSavedXml != null) openXml.setInitialDirectory(lastSavedXml.getParentFile());
        return openXml.showOpenDialog(stage);
    }


    public static File promptSaveBin(File xmlFile, Stage stage) {
        FileChooser saveBin = new FileChooser();
        saveBin.setInitialFileName(xmlFile.getName().replace(".anim.xml", ".anim.bin"));
        if (lastSavedBin != null) saveBin.setInitialDirectory(lastSavedBin.getParentFile());
        else if (lastOpenedBin != null) saveBin.setInitialDirectory(lastOpenedBin.getParentFile());
        return saveBin.showSaveDialog(stage);
    }

    public static File promptSaveXml(File binFile, Stage stage) {
        FileChooser saveXml = new FileChooser();
        saveXml.setInitialFileName(binFile.getName().replace(".anim.bin", ".anim.xml"));
        if (lastSavedXml != null) saveXml.setInitialDirectory(lastSavedXml.getParentFile());
        else if (lastOpenedXml != null) saveXml.setInitialDirectory(lastOpenedXml.getParentFile());
        return saveXml.showSaveDialog(stage);
    }


    public static FinalBinAnimation readBin(File binFile) {
        FinalBinAnimation binAnimation;
        try {
            binAnimation = AnimBinReader.readFinal(binFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        lastOpenedBin = binFile;
        lastSavedBin = binFile;
        return binAnimation;
    }

    public static FinalBinAnimation readXml(File xmlFile) {
        FinalBinAnimation binAnimation;
        try {
            XmlMapper xmlMapper = new XmlMapper();
            binAnimation = xmlMapper.readValue(xmlFile, FinalBinAnimation.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        lastOpenedXml = xmlFile;
        lastSavedXml = xmlFile;
        return binAnimation;
    }


    public static void writeBin(FinalBinAnimation binAnimation, File binFile) {
        if (binFile == null) return;
        lastSavedBin = binFile;
        lastOpenedBin = binFile;
        transferMode = FileTransferMode.XML_TO_BIN;
        //try {
            //AnimBinWriter.write(binFile.toPath(), binAnimation);
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}
    }

    public static void writeXml(Animation binAnimation, FinalBinAnimation finalBinAnimation, File xmlFile) {
        if (xmlFile == null) return;
        lastSavedXml = xmlFile;
        lastOpenedXml = xmlFile;
        transferMode = FileTransferMode.BIN_TO_XML;
        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            xmlMapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
            xmlMapper.writeValue(new File(xmlFile.getPath() + ".old.xml"), finalBinAnimation);
            xmlMapper.writeValue(new File(xmlFile.getPath() + ".new.xml"), binAnimation);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
