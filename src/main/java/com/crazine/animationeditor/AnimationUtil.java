package com.crazine.animationeditor;

public class AnimationUtil {

    public static String getStringFromStringTable(byte[] stringTable, int stringTableIndex) {
        StringBuilder stringBuilder = new StringBuilder();
        while (stringTable[stringTableIndex] != 0x00) {
            stringBuilder.append((char)stringTable[stringTableIndex]);
            stringTableIndex++;
        }
        return stringBuilder.toString();
    }

}
