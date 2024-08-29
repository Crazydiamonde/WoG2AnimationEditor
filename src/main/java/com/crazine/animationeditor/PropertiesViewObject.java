package com.crazine.animationeditor;

import java.lang.reflect.Field;

public class PropertiesViewObject {

    public Object object;
    public Field field;

    public PropertiesViewObject(Object object, Field field) {
        this.object = object;
        this.field = field;
    }

}
