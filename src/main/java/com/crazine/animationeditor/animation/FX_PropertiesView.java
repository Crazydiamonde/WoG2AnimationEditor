package com.crazine.animationeditor.animation;

import com.crazine.animationeditor.PropertiesViewObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TextFieldTreeTableCell;

import java.lang.reflect.Field;

public class FX_PropertiesView {

    private static final TreeTableView<PropertiesViewObject> propertiesView = new TreeTableView<>();
    public static TreeTableView<PropertiesViewObject> getPropertiesView() {
        return propertiesView;
    }


    public static void buildPropertiesView() {

        TreeTableColumn<PropertiesViewObject, String> name = new TreeTableColumn<>("Name");
        name.setCellValueFactory(param ->
                new SimpleStringProperty(param.getValue().getValue().field.getName()));
        name.setPrefWidth(360);

        TreeTableColumn<PropertiesViewObject, String> value = new TreeTableColumn<>("Value");
        value.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());
        value.setCellValueFactory(param ->
        {
            try {
                if (param.getValue().getValue().field.get(param.getValue().getValue().object) instanceof Object[] array) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < array.length; i++) {
                        stringBuilder.append(array[i].toString());
                        if (i != array.length - 1) stringBuilder.append(",");
                    }
                    return new SimpleStringProperty(stringBuilder.toString());
                } else {
                    return new SimpleStringProperty(param.getValue().getValue().field.get(param.getValue().getValue().object).toString());
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
        value.setPrefWidth(360);

        propertiesView.getColumns().add(name);

        propertiesView.getColumns().add(value);

        propertiesView.setEditable(true);
        value.setEditable(true);

        value.setOnEditCommit(event -> {
            try {

                Object object = event.getRowValue().getValue().object;
                Field field = event.getRowValue().getValue().field;

                if (field.getType().getGenericSuperclass() == AnimationObject.class) {
                    object = field.get(object);
                    field = object.getClass().getFields()[0];
                }

                Object oldAttribute = field.get(object);
                switch (field.getGenericType().getTypeName()) {
                    case "int" -> field.setInt(object, Integer.parseInt(event.getNewValue()));
                    case "float" -> field.setFloat(object, Float.parseFloat(event.getNewValue()));
                    case "string" -> field.set(object, event.getNewValue());
                    case "boolean" -> field.setBoolean(object, Boolean.parseBoolean(event.getNewValue()));
                    default -> {
                        try {
                            ((AnimationObject)object).fromString(event.getNewValue());
                        } catch (IllegalArgumentException ignored) {

                        }
                    }
                }

                if (field.get(object) != oldAttribute) {
                    // UndoManager.registerChange(new AttributeChangeAction((AnimationObject) object, field, oldAttribute, field.get(object)));
                } else {
                    propertiesView.refresh();
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (NumberFormatException e) {
                event.consume();
                propertiesView.edit(propertiesView.getRow(event.getRowValue()), value);
            }
        });


        propertiesView.setColumnResizePolicy(TreeTableView.CONSTRAINED_RESIZE_POLICY);

        propertiesView.setShowRoot(false);

    }

}
