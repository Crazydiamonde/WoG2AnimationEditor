module com.crazine.animationeditor {

    requires javafx.controls;
    requires javafx.swing;
    requires com.fasterxml.jackson.dataformat.xml;
    requires com.fasterxml.jackson.databind;
    requires java.desktop;
    requires com.github.luben.zstd_jni;

    exports com.crazine.animationeditor;
    exports com.crazine.animationeditor.animation;
    exports com.crazine.animationeditor.resources;

}