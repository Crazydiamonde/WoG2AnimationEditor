package com.crazine.animationeditor.javafx;

import com.crazine.animationeditor.AnimationLoader;
import com.crazine.animationeditor.AnimationScene;
import com.crazine.animationeditor.PropertiesViewObject;
import com.crazine.animationeditor.SceneManager;
import com.crazine.animationeditor.animation.AnimationObject;
import com.crazine.animationeditor.animation.FX_PropertiesView;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;

public class FX_Hierarchy {

    private static final TreeTableView<AnimationObject> hierarchy = new TreeTableView<>();
    public static TreeTableView<AnimationObject> getHierarchy() {
        return hierarchy;
    }


    public static void buildHierarchy() {

        hierarchy.setRowFactory(treeTableView -> HierarchyManager.createRow(hierarchy));

        TreeTableColumn<AnimationObject, String> element = new TreeTableColumn<>();
        element.setGraphic(new Label("Element"));
        element.setCellFactory(column -> new TreeTableCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                HierarchyManager.updateElementCell(this, item, empty);
            }
        });
        element.setCellValueFactory(new TreeItemPropertyValueFactory<>("type"));
        element.setPrefWidth(360);
        element.setSortable(false);

        TreeTableColumn<AnimationObject, String> type = new TreeTableColumn<>();
        type.setGraphic(new Label("ID or Name"));
        type.setCellFactory(column -> new TreeTableCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                HierarchyManager.updateNameCell(this, item, empty);
            }
        });
        type.setCellValueFactory(new TreeItemPropertyValueFactory<>("id"));
        type.setPrefWidth(360);
        type.setSortable(false);

        hierarchy.getColumns().add(element);

        hierarchy.getColumns().add(type);

        hierarchy.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) return;
            SceneManager.getScene().setSelected(newValue.getValue());
            TreeItem<PropertiesViewObject> treeItem = new TreeItem<>(new PropertiesViewObject(newValue.getValue(), newValue.getValue().getClass().getFields()[0]));
            try {
                AnimationLoader.recursivelyAdd2(treeItem);
            } catch (Exception e) {
                // Alarms.errorMessage(e);
            }
            FX_PropertiesView.getPropertiesView().setRoot(treeItem);
        });


        hierarchy.setColumnResizePolicy(TreeTableView.CONSTRAINED_RESIZE_POLICY);
        hierarchy.setSortMode(TreeSortMode.ONLY_FIRST_LEVEL);
    }


    private static final TabPane hierarchySwitcherButtons = new TabPane();
    public static TabPane getHierarchySwitcherButtons() {
        return hierarchySwitcherButtons;
    }


    public static void buildHierarchySwitcherButtons() {

        // Create the three buttons.
        Tab keyframes = new Tab("Keyframes");
        Tab parts = new Tab("Parts");
        Tab resources = new Tab("Resources");

        hierarchySwitcherButtons.getTabs().addAll(keyframes, parts, resources);
        hierarchySwitcherButtons.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        hierarchySwitcherButtons.setMinHeight(30);
        hierarchySwitcherButtons.setMaxHeight(30);
        hierarchySwitcherButtons.setPrefHeight(30);
        hierarchySwitcherButtons.setPadding(new Insets(-6, -6, -6, -6));

        hierarchySwitcherButtons.getSelectionModel().selectedItemProperty().addListener((observableValue, tab, t1) -> {

            if (SceneManager.getScene() == null) return;

            AnimationScene _level = SceneManager.getScene();

            TreeItem<AnimationObject> rootObject;
            if (t1 == keyframes) {
                rootObject = _level.getAnimationManifest();
                hierarchy.setShowRoot(true);
            }
            else if (t1 == parts) {
                rootObject = _level.getPartManifest();
                hierarchy.setShowRoot(false);
            }
            else if (t1 == resources) {
                rootObject = _level.getResourceManifest();
                hierarchy.setShowRoot(false);
            }
            else return;

            hierarchy.setRoot(rootObject);
            hierarchy.refresh();
            hierarchy.getRoot().setExpanded(true);
            _level.setCurrentlySelectedSection(t1.getText());

        });

    }


}
