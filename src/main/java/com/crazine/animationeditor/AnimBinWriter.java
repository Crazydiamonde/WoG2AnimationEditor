package com.crazine.animationeditor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class AnimBinWriter {

    public static void write(Path path, BinAnimation binAnimation) throws IOException {

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        int[] counts = new int[26];
        int[] propertyLocations = new int[26];
        int i = 0;
        for (Field field : BinAnimation.class.getFields()) {
            try {
                Object data = field.get(binAnimation);
                if (data == null) {
                    if (i < 26) {
                        counts[i] = 0;
                        propertyLocations[i] = output.size() + 220;
                        i++;
                    }
                } else if (data instanceof Object[] array) {
                    System.out.println(Arrays.toString(array));
                    if (i < 26) {
                        counts[i] = array.length;
                        propertyLocations[i] = output.size() + 220;
                    }
                    i++;
                    if (i == 26) {
                        output.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(array.length).array());
                        output.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(array.length).array());
                    }
                    for (Object child : array) {
                        if (child instanceof Integer integer) {
                            output.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(integer).array());
                        } else if (child instanceof String string) {
                            output.write(string.getBytes());
                            output.write(0);
                        } else {
                            for (Field childField : child.getClass().getFields()) {
                                Object childData = childField.get(child);
                                if (childData instanceof Integer integer) {
                                    output.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(integer).array());
                                } else if (childData instanceof Float _float) {
                                    output.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putFloat(_float).array());
                                } else if (childData instanceof Boolean bool) {
                                    output.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(bool ? 1 : 0).array());
                                } else if (childData instanceof String string) {
                                    output.write(string.getBytes());
                                    for (int j = 0; j < 4 - string.length(); j++) output.write(0);
                                }
                            }
                        }
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        byte[] yourEntireLife = output.toByteArray();

        ByteArrayOutputStream realOutput = new ByteArrayOutputStream();

        counts[25] = 0;

        for (int j = 0; j < 26; j++) {
            realOutput.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(counts[j]).array());
            realOutput.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(propertyLocations[j]).array());
        }

        realOutput.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(yourEntireLife.length + 220 - propertyLocations[25]).array());
        realOutput.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(propertyLocations[25]).array());

        realOutput.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(binAnimation.fps).array());

        realOutput.write(yourEntireLife);

        Files.write(path, realOutput.toByteArray());

    }

}
