package com.crazine.animationeditor;

import com.crazine.animationeditor.animation.*;
import com.crazine.animationeditor.javafx.FX_Scene;
import com.crazine.animationeditor.resources.*;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import javafx.scene.control.TreeItem;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.util.Arrays;

public class AnimationLoader {

    public static ResourceManifest openResources(File resourceFile) {

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.addHandler(new DeserializationProblemHandler() {
            @Override
            public boolean handleUnknownProperty(DeserializationContext ctxt, JsonParser p, JsonDeserializer<?> deserializer, Object beanOrClass, String propertyName) throws IOException {
                if (beanOrClass instanceof Resources resources) {
                    if (resources.resources == null) resources.resources = new Resource[0];
                    resources.resources = Arrays.copyOf(resources.resources, resources.resources.length + 1);
                    Resource child = switch (propertyName) {
                        case "SetDefaults" -> p.readValueAs(SetDefaults.class);
                        //case "Sound" -> resources.resources.add(p.readValueAs(Sound.class));
                        case "Image" -> p.readValueAs(Image.class);
                        default -> null;
                    };
                    resources.resources[resources.resources.length - 1] = child;
                    return true;
                } else return false;
            }
        });

        try {
            return xmlMapper.readValue(resourceFile, ResourceManifest.class);
        } catch (Exception e) {
            e.printStackTrace();
            // Alarms.errorMessage(e);
            return null;
        }

    }


    public static void recursivelyAdd(TreeItem<AnimationObject> treeItem) throws Exception {

        treeItem.setExpanded(true);

        Object object = treeItem.getValue();

        // Loop through all children
        for (Field field : object.getClass().getFields()) {
            if (field.isAnnotationPresent(HideTreeItem.class)) continue;
            Object child = field.get(object);
            if (child == null) continue;
            if ((child instanceof AnimationObject wog2Object && wog2Object.toString() == null)) {
                treeItem.getChildren().add(wog2Object.getTreeItem());
                recursivelyAdd(wog2Object.getTreeItem());
            } else if (child instanceof Object[] arrayList && arrayList.length > 0 && arrayList[0] != null && !arrayList[0].getClass().getPackage().getName().endsWith("lang") && !(arrayList[0] instanceof AnimationObject wog2Object && wog2Object.toString() != null)) for (Object child2 : arrayList) if (child2 instanceof AnimationObject wog2Object) {
                treeItem.getChildren().add(wog2Object.getTreeItem());
                recursivelyAdd(wog2Object.getTreeItem());
            }
        }

    }


    public static void recursivelyAdd2(TreeItem<PropertiesViewObject> treeItem) throws Exception {

        Object object = treeItem.getValue().object;

        // Loop through all children
        for (Field field : object.getClass().getFields()) {
            if (field.isAnnotationPresent(HideTreeItem.class)) continue;
            Object child = field.get(object);
            if (child == null) continue;
            if (!(child instanceof Object[] objects) || !(objects instanceof AnimationObject[])) {
                TreeItem<PropertiesViewObject> treeItem2 = new TreeItem<>(new PropertiesViewObject(object, field));
                treeItem.getChildren().add(treeItem2);
            }
        }

    }

}
