package com.crazine.animationeditor.javafx;

import javafx.geometry.Orientation;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.VBox;

public class FX_Timeline {

    private static final VBox timeline = new VBox();
    public static VBox getTimeline() {
        return timeline;
    }


    private static final ScrollBar scrollBar = new ScrollBar();
    public static ScrollBar getScrollBar() {
        return scrollBar;
    }


    public static void buildTimeline() {

        scrollBar.setOrientation(Orientation.HORIZONTAL);

        timeline.getChildren().add(scrollBar);

    }

}
