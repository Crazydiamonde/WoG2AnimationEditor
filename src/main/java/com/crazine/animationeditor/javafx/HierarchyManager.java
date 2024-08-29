package com.crazine.animationeditor.javafx;

import com.crazine.animationeditor.AnimationLoader;
import com.crazine.animationeditor.SceneManager;
import com.crazine.animationeditor.animation.*;
import com.crazine.animationeditor.resources.SetDefaults;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseButton;
import javafx.scene.input.TransferMode;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

public class HierarchyManager {

    public static Image getObjectIcon(Class<? extends AnimationObject> type, boolean terrain) {

        String iconName = switch (type.getName()) {
            case "addin", "Addin_addin", "Addin_id", "Addin_name",
                    "Addin_type", "Addin_version", "Addin_description",
                    "Addin_author", "Addin_levels", "Addin_level",
                    "Addin_dir", "Addin_wtf_name",
                    "Addin_subtitle", "Addin_ocd" -> "addin/addin";
            case "BallInstance" -> "level/BallInstance";
            case "button" -> "scene/button";
            case "buttongroup" -> "scene/buttongroup";
            case "camera" -> "level/camera";
            case "circle" -> "scene/circle";
            case "compositegeom" -> "scene/compositegeom";
            case "endoncollision" -> "level/endoncollision";
            case "endonmessage" -> "level/endonmessage";
            case "endonnogeom" -> "level/endonnogeom";
            case "fire" -> "level/fire";
            case "font" -> "resrc/font";
            case "hinge" -> "scene/hinge";
            case "label" -> "scene/label";
            case "level" -> "level/level";
            case "levelexit" -> "level/levelexit";
            case "line" -> "scene/line";
            case "linearforcefield" -> "scene/linearforcefield";
            case "loopsound" -> "level/loopsound";
            case "motor" -> "scene/motor";
            case "music" -> "level/music";
            case "particles" -> "scene/particles";
            case "pipe" -> "level/pipe";
            case "poi" -> "level/poi";
            case "rectangle" -> "scene/rectangle";
            case "radialforcefield" -> "scene/radialforcefield";
            case "ResourceManifest" -> "resrc/resourcemanifest";
            case "Resources" -> "resrc/resources";
            case "Image" -> "resrc/resrcimage";
            case "scene" -> "scene/scene";
            case "SceneLayer" -> "scene/SceneLayer";
            case "SetDefaults" -> "resrc/setdefaults";
            case "signpost" -> "level/signpost";
            case "slider" -> "scene/slider";
            case "Sound" -> "resrc/sound";
            case "Strand" -> "level/Strand";
            case "string" -> "text/textstring";
            case "strings" -> "text/textstrings";
            case "targetheight" -> "level/targetheight";
            case "Vertex" -> "level/Vertex";

            case "CameraKeyFrame" -> "level/camera";
            case "Pin" -> "scene/hinge";
            case "Item" -> "scene/SceneLayer";
            case "UserVariable" -> "addin/addin";

            default -> null;
        };
        if (iconName == null) return null;

        if (terrain)
            iconName = "WoG2/TerrainBallInstance";

        return null; // FileManager.getIcon("ObjectIcons/" + iconName + ".png");

    }

    public static Image getItemIcon(String name) {

        String iconName = switch (name) {

            case "LevelExit" -> "level/levelexit";
            case "CameraEOL", "CameraControl" -> "level/camera";
            case "Pool" -> "level/pipe";
            case "TerrainClear" -> "WoG2/terrainClear";
            case "TerrainDeadly" -> "WoG2/terrainDeadly";
            case "TerrainFrictionless" -> "WoG2/terrainFrictionless";
            case "TerrainNonSticky" -> "WoG2/terrainNonSticky";
            case "TerrainSticky" -> "WoG2/terrainSticky";
            case "TerrainUnwalkable" -> "WoG2/terrainUnwalkable";

            default -> "scene/SceneLayer";
        };
        if (iconName == null) return null;

        return null; // FileManager.getIcon("ObjectIcons/" + iconName + ".png");

    }


    private static int oldDropIndex;
    public static void setOldDropIndex(int oldDropIndex) {
        HierarchyManager.oldDropIndex = oldDropIndex;
    }


    private static TreeTableRow<AnimationObject> dragSourceRow;
    public static TreeTableRow<AnimationObject> getDragSourceRow() {
        return dragSourceRow;
    }


    public static void updateNameCell(TreeTableCell<AnimationObject, String> cell, String item, boolean empty) {

        if (empty) {
            // If this is an empty cell, set its text and graphic to empty.
            // This prevents the cell from retaining other cells' information.
            cell.setText(null);
            cell.setGraphic(null);
        } else {
            // setTextFill(Paint.valueOf("FFFFFFFF"));
            // Update this cell's text.
            cell.setText(item);
            // Override the default padding that ruins the text.
            cell.setPadding(new Insets(-2, 0, 0, 3));
        }

    }


    public static void updateElementCell(TreeTableCell<AnimationObject, String> cell, String item, boolean empty) {

        if (empty) {
            // If this is an empty cell, set its text and graphic to empty.
            // This prevents the cell from retaining other cells' information.
            cell.setText(null);
            cell.setGraphic(null);
        } else {
            // Update this cell's text.
            cell.setText(item);
            // Override the default padding that ruins the text.
            cell.setPadding(new Insets(-2, 0, 0, 3));

            if (cell.getTableRow().getItem() != null) {
                ImageView imageView;

                /*

                boolean terrain = false;
                if (cell.getTableRow().getItem() instanceof _2_Level_BallInstance && cell.getTableRow().getItem().getAttribute("type").stringValue().equals("Terrain")) {
                    terrain = true;
                }
                imageView = new ImageView(getObjectIcon(cell.getTableRow().getItem().getClass(), terrain));
                if (cell.getTableRow().getItem().getType().equals("Item")) {
                    cell.setText(cell.getTableRow().getItem().getAttribute("type").stringValue());
                    imageView.setImage(getItemIcon(cell.getTableRow().getItem().getAttribute("type").stringValue()));
                    imageView.setFitWidth(16);
                    imageView.setFitHeight(16);
                }

                // If the cell's EditorObject is invalid, display its graphic with a warning symbol.
                // Otherwise, just display its graphic.

                boolean valid = true;

                EditorObject editorObject = cell.getTableRow().getItem();

                for (EditorAttribute attribute : editorObject.getAttributes()) {
                    if (attribute.stringValue().isEmpty()) {
                        if (!InputField.verify(editorObject, attribute.getType(), attribute.getDefaultValue(), attribute.getRequired())) {
                            valid = false;
                        }
                    } else if (!InputField.verify(editorObject, attribute.getType(), attribute.actualValue(), attribute.getRequired())) {
                        valid = false;
                    }
                }

                if (!valid) {
                    ImageView failedImg = new ImageView(FileManager.getFailedImage());
                    cell.setGraphic(new StackPane(imageView, failedImg));
                    cell.setStyle("-fx-text-fill: red");
                } else {
                    cell.setGraphic(imageView);
                    cell.setStyle("-fx-text-fill: black");
                }

                 */
            }
        }

    }


    public static boolean handleDragDrop(TreeTableView<AnimationObject> hierarchy, int toIndex) {

        // TODO: give the user a way to choose if they want an object to be a child of the object above it

        if (toIndex == oldDropIndex) return false;

        AnimationObject toItem = hierarchy.getTreeItem(toIndex).getValue();

        AnimationObject fromItem = hierarchy.getTreeItem(oldDropIndex).getValue();

        ArrayList<AnimationObject> list = new ArrayList<>();

        int indexOfToItemInList = list.indexOf(toItem);

        /*

        // YOU CAN'T PUT AN OBJECT INSIDE ITSELF
        if (toItem.getChildren().contains(fromItem)) return false;

        // Or inside an object that doesn't have it as a possible child
        if (Stream.of(toItem.getParent().getPossibleChildren()).noneMatch(e -> e.equals(fromItem.getType())))
            return false;

        // Or above every SetDefaults (meaning at position 2) if it's a resource
        if ((fromItem instanceof ResrcImage || fromItem instanceof Sound || fromItem instanceof Font) && toIndex == 2)
            return false;

        // Or anywhere that would put a resource at position 2 if it's a SetDefaults
        if (fromItem instanceof SetDefaults && (oldDropIndex == 2 && !(hierarchy.getTreeItem(3).getValue() instanceof SetDefaults)))
            return false;

        // Add the dragged item just above the item that it gets dragged to
        int indexOfToItem = toItem.getParent().getChildren().indexOf(toItem);

        fromItem.getParent().getChildren().remove(fromItem);
        fromItem.getParent().getTreeItem().getChildren().remove(fromItem.getTreeItem());

        fromItem.setParent(toItem.getParent(), indexOfToItem);

        list.remove(fromItem);
        list.add(indexOfToItemInList, fromItem);

        if (fromItem.getParent() instanceof Resources) LevelManager.getLevel().reAssignSetDefaultsToAllResources();
        else if (fromItem instanceof Vertex) fromItem.getParent().update();

         */

        hierarchy.getSelectionModel().select(toIndex);
        hierarchy.refresh();

        return true;

    }


    public static TreeTableRow<AnimationObject> createRow(TreeTableView<AnimationObject> hierarchy) {

        TreeTableRow<AnimationObject> row = new TreeTableRow<>();

        row.setOnMousePressed(event -> {
            if (row.getTreeItem() == null) return;
            if (event.getButton().equals(MouseButton.SECONDARY)) row.setContextMenu(contextMenuForEditorObject(row));
        });

        row.setOnDragDetected(event -> {
            TreeItem<AnimationObject> selected2 = hierarchy.getSelectionModel().getSelectedItem();
            if (selected2 == null) return;

            if (row.getTreeItem() == null) return;

            Dragboard db = hierarchy.startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putString(selected2.getValue().getClass().getName());
            db.setContent(content);
            oldDropIndex = row.getIndex();
            event.consume();

            dragSourceRow = row;

            row.setId("dragTarget");

        });

        row.setOnDragExited(event -> {
            // row.setStyle("");
            row.setStyle("-fx-border-width: 0 0 0 0;");
            row.setTranslateY(0);
            row.setPadding(new Insets(1, 0, 0, 0));
        });

        row.setOnDragOver(event -> {
            if (event.getDragboard().hasString() && row.getTreeItem() != null) {

                if (event.getY() + row.getTranslateY() >= 9) {
                    row.setStyle("-fx-border-color: #a0a0ff; -fx-border-width: 0 0 2 0;");
                    row.setTranslateY(1);
                } else {
                    row.setStyle("-fx-border-color: #a0a0ff; -fx-border-width: 2 0 0 0;");
                    row.setTranslateY(-1);
                }
                row.setPadding(new Insets(0.5, 0, -0.5, 0));

                row.toFront();

                event.acceptTransferModes(TransferMode.MOVE);

            }
            event.consume();
        });

        row.setOnDragDropped(event -> {
            dragSourceRow.setId("notDragTarget");
            if (!row.isEmpty()) {
                int toIndex = row.getIndex();
                if (event.getY() + row.getTranslateY() >= 9) toIndex += 1;
                if (toIndex > oldDropIndex) toIndex -= 1;
                boolean completed = handleDragDrop(hierarchy, toIndex);
                event.setDropCompleted(event.getDragboard().hasString() && completed);

                if (completed) {
                    hierarchy.getSelectionModel().clearSelection();
                    hierarchy.getSelectionModel().select(FX_Hierarchy.getHierarchy().getTreeItem(toIndex));
                    // UndoManager.registerChange(new HierarchyDragAction((WOG2Object) FX_Hierarchy.getHierarchy().getTreeItem(oldDropIndex).getValue().value, oldDropIndex, toIndex));
                }

            }
            event.consume();
        });

        row.setPadding(new Insets(1, 0, 0, 0));

        return row;

    }


    public static ContextMenu contextMenuForEditorObject(TreeTableRow<AnimationObject> row) {

        Object object = row.getTreeItem().getValue();

        // Create the content menu.
        ContextMenu menu = new ContextMenu();

        // For every object that can be created as a child of this object:
        for (Field field : object.getClass().getFields()) {

            if (field.getType().isArray()) {

                if (field.getType().componentType().getGenericSuperclass() == AnimationObject.class) {

                    ArrayList<String> toAdd = new ArrayList<>();
                    if (field.getType().componentType().getSimpleName().equals("AnimationElement")) {
                        toAdd.add("Blank");
                        toAdd.add("Keyframe");
                        toAdd.add("Part");
                        toAdd.add("Property 8");
                        toAdd.add("Property 9");
                    } else if (field.getType().componentType().getSimpleName().equals("Resource")) {
                        toAdd.add("SetDefaults");
                        toAdd.add("Image");
                    } else {
                        toAdd.add(field.getType().componentType().getSimpleName());
                    }

                    for (String item : toAdd) {
                        // Create a menu item representing creating this child.
                        MenuItem addItemItem = new MenuItem(" Add " + item);

                        // Attempt to set graphics for this menu item.
                        addItemItem.setGraphic(new ImageView());

                        // Set the item's action to creating the child, with the object as its parent.
                        addItemItem.setOnAction(event -> {
                            try {
                                AnimationObject[] array = (AnimationObject[]) field.get(object);
                                Object[] newArray = Arrays.copyOf(array, array.length + 1);
                                System.arraycopy(array, 0, newArray, 0, array.length);
                                Object child = null;
                                if (field.getType().componentType().getSimpleName().equals("AnimationElement")) {
                                    if (item.equals("Blank")) child = new AnimationBlank();
                                    if (item.equals("Keyframe")) child = new AnimationKeyframe();
                                    if (item.equals("Part")) child = new AnimationPartReference();
                                    if (item.equals("Property 8")) child = new AnimationProperty8();
                                    if (item.equals("Property 9")) child = new AnimationProperty9();
                                } else if (field.getType().componentType().getSimpleName().equals("Resource")) {
                                    if (item.equals("Image")) child = new com.crazine.animationeditor.resources.Image();
                                    if (item.equals("SetDefaults")) child = new SetDefaults();
                                } else {
                                    child = field.getType().componentType().getConstructors()[0].newInstance();
                                }
                                System.out.println("got here");
                                newArray[newArray.length - 1] = child;
                                field.set(object, field.getType().cast(newArray));
                                if (child instanceof AnimationObject wog2Object) {
                                    row.getTreeItem().getChildren().add(wog2Object.getTreeItem());
                                }
                            } catch (Exception e) {
                                // Alarms.errorMessage(e);
                            }
                        });

                        menu.getItems().add(addItemItem);
                    }

                }

            }

        }

        return menu;

    }

}
