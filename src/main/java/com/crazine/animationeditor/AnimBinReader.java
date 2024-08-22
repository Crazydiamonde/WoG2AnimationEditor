package com.crazine.animationeditor;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.nio.file.Path;

public class AnimBinReader {

    public static BinAnimation read(Path path) throws IOException {

        BinAnimation binAnimation = new BinAnimation();

        ByteArrayInputStream input = new ByteArrayInputStream(Files.readAllBytes(path));
        int int1 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        input.skipNBytes(4);
        int secretCount = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        input.skipNBytes(4);
        int int5 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        input.skipNBytes(4);
        int int7 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        input.skipNBytes(4);
        int keyframeCount = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        input.skipNBytes(4);
        int imageDataCount = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        input.skipNBytes(4);
        int int13 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        input.skipNBytes(4);
        int int15 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        input.skipNBytes(4);
        int int17 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        input.skipNBytes(4);
        int int19 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        input.skipNBytes(12);
        int int23 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        input.skipNBytes(28);
        int int31 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        input.skipNBytes(4);
        int int33 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        input.skipNBytes(4);
        int int35 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        input.skipNBytes(4);
        int int37 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        input.skipNBytes(4);
        int int39 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        input.skipNBytes(4);
        int int41 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        input.skipNBytes(4);
        int int43 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        input.skipNBytes(4);
        int int45 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        input.skipNBytes(4);
        int int47 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        input.skipNBytes(28);

        binAnimation.fps = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);

        binAnimation.defineGroups = new BinAnimation.DefineGroup[int1];
        for (int i = 0; i < int1; i++) {
            binAnimation.defineGroups[i] = new BinAnimation.DefineGroup();
            binAnimation.defineGroups[i].globalId = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.defineGroups[i].localId = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.defineGroups[i].uid = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        }

        binAnimation.groupTimings = new BinAnimation.GroupTiming[secretCount];
        for (int i = 0; i < secretCount; i++) {
            binAnimation.groupTimings[i] = new BinAnimation.GroupTiming();
            binAnimation.groupTimings[i].durationFrames = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.groupTimings[i].unknown1 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.groupTimings[i].timingIndexOffset = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.groupTimings[i].timingIndexLength = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.groupTimings[i].timedEventOffset = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.groupTimings[i].timedEventLength = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        }

        binAnimation.timingIndices = new BinAnimation.TimingIndex[int5];
        for (int i = 0; i < int5; i++) {
            binAnimation.timingIndices[i] = new BinAnimation.TimingIndex();
            binAnimation.timingIndices[i].group = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.timingIndices[i].timingOffset = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.timingIndices[i].timingLength = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        }

        binAnimation.keyframeTimings = new BinAnimation.KeyframeTiming[int7];
        for (int i = 0; i < int7; i++) {
            binAnimation.keyframeTimings[i] = new BinAnimation.KeyframeTiming();
            binAnimation.keyframeTimings[i].sequenceId = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.keyframeTimings[i].keyframe = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.keyframeTimings[i].untilFrame = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        }

        binAnimation.keyframes = new BinAnimation.Keyframe[keyframeCount];
        for (int i = 0; i < keyframeCount; i++) {
            binAnimation.keyframes[i] = new BinAnimation.Keyframe();
            binAnimation.keyframes[i].attribute1 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.keyframes[i].attribute2 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.keyframes[i].angleTopLeft = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getFloat(0);
            binAnimation.keyframes[i].angleBottomRight = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getFloat(0);
            binAnimation.keyframes[i].x1 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getFloat(0);
            binAnimation.keyframes[i].y1 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getFloat(0);
            binAnimation.keyframes[i].x2 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getFloat(0);
            binAnimation.keyframes[i].y2 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getFloat(0);
            binAnimation.keyframes[i].scaleX = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getFloat(0);
            binAnimation.keyframes[i].scaleY = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getFloat(0);
            binAnimation.keyframes[i].colorize = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.keyframes[i].attribute12 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getFloat(0);
        }

        binAnimation.imageProperties = new BinAnimation.ImageProperties[imageDataCount];
        for (int i = 0; i < imageDataCount; i++) {
            binAnimation.imageProperties[i] = new BinAnimation.ImageProperties();
            binAnimation.imageProperties[i].imageIndex = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.imageProperties[i].angleTopLeft = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getFloat(0);
            binAnimation.imageProperties[i].angleBottomRight = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getFloat(0);
            binAnimation.imageProperties[i].centerX = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getFloat(0);
            binAnimation.imageProperties[i].centerY = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getFloat(0);
            binAnimation.imageProperties[i].offsetX = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getFloat(0);
            binAnimation.imageProperties[i].offsetY = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getFloat(0);
            binAnimation.imageProperties[i].scaleX = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getFloat(0);
            binAnimation.imageProperties[i].scaleY = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getFloat(0);
            binAnimation.imageProperties[i].colorize = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.imageProperties[i].attribute11 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        }

        binAnimation.property7s = new BinAnimation.Property7[int13];
        for (int i = 0; i < int13; i++) {
            binAnimation.property7s[i] = new BinAnimation.Property7();
            binAnimation.property7s[i].attribute1 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property7s[i].attribute2 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property7s[i].attribute3 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property7s[i].attribute4 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property7s[i].attribute5 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        }

        binAnimation.property8s = new BinAnimation.Property8[int15];
        for (int i = 0; i < int15; i++) {
            binAnimation.property8s[i] = new BinAnimation.Property8();
            binAnimation.property8s[i].attribute1 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property8s[i].attribute2 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        }

        binAnimation.property9s = new BinAnimation.Property9[int17];
        for (int i = 0; i < int17; i++) {
            binAnimation.property9s[i] = new BinAnimation.Property9();
            binAnimation.property9s[i].attribute1 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property9s[i].attribute2 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getFloat(0);
            binAnimation.property9s[i].attribute3 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getFloat(0);
            binAnimation.property9s[i].attribute4 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getFloat(0);
            binAnimation.property9s[i].attribute5 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getFloat(0);
            binAnimation.property9s[i].attribute6 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getFloat(0);
            binAnimation.property9s[i].attribute7 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getFloat(0);
        }

        binAnimation.timedEvents = new BinAnimation.TimedEvent[int19];
        for (int i = 0; i < int19; i++) {
            binAnimation.timedEvents[i] = new BinAnimation.TimedEvent();
            binAnimation.timedEvents[i].active = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0) == 1;
            binAnimation.timedEvents[i].delay = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.timedEvents[i].groupId = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        }

        binAnimation.unused1 = new Byte[0];

        binAnimation.property11s = new BinAnimation.Property11[int23];
        for (int i = 0; i < int23; i++) {
            binAnimation.property11s[i] = new BinAnimation.Property11();
            binAnimation.property11s[i].attribute1 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property11s[i].attribute2 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property11s[i].attribute3 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property11s[i].attribute4 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property11s[i].attribute5 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property11s[i].attribute6 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property11s[i].attribute7 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property11s[i].attribute8 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property11s[i].attribute9 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property11s[i].attribute10 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        }

        binAnimation.unused2 = new Byte[0];
        binAnimation.unused3 = new Byte[0];
        binAnimation.unused4 = new Byte[0];

        binAnimation.property12s = new BinAnimation.Property12[int31];
        for (int i = 0; i < int31; i++) {
            binAnimation.property12s[i] = new BinAnimation.Property12();
            binAnimation.property12s[i].attribute1 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property12s[i].attribute2 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property12s[i].attribute3 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property12s[i].attribute4 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property12s[i].attribute5 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property12s[i].attribute6 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getFloat(0);
            binAnimation.property12s[i].attribute7 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property12s[i].attribute8 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property12s[i].attribute9 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property12s[i].attribute10 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property12s[i].attribute11 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property12s[i].attribute12 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property12s[i].attribute13 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property12s[i].attribute14 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property12s[i].attribute15 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property12s[i].attribute16 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property12s[i].attribute17 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property12s[i].attribute18 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property12s[i].attribute19 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property12s[i].attribute20 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property12s[i].attribute21 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property12s[i].attribute22 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property12s[i].attribute23 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        }

        binAnimation.property13s = new BinAnimation.Property13[int33];
        for (int i = 0; i < int33; i++) {
            binAnimation.property13s[i] = new BinAnimation.Property13();
            binAnimation.property13s[i].attribute1 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property13s[i].attribute2 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getFloat(0);
            binAnimation.property13s[i].attribute3 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property13s[i].attribute4 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property13s[i].attribute5 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property13s[i].attribute6 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property13s[i].attribute7 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        }

        binAnimation.property14s = new BinAnimation.Property14[int35];
        for (int i = 0; i < int35; i++) {
            binAnimation.property14s[i] = new BinAnimation.Property14();
            binAnimation.property14s[i].attribute1 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property14s[i].attribute2 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property14s[i].attribute3 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property14s[i].attribute4 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property14s[i].attribute5 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property14s[i].attribute6 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property14s[i].attribute7 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property14s[i].attribute8 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property14s[i].attribute9 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property14s[i].attribute10 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property14s[i].attribute11 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property14s[i].attribute12 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property14s[i].attribute13 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property14s[i].attribute14 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property14s[i].attribute15 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property14s[i].attribute16 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property14s[i].attribute17 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property14s[i].attribute18 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property14s[i].attribute19 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property14s[i].attribute20 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property14s[i].attribute21 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property14s[i].attribute22 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property14s[i].attribute23 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property14s[i].attribute24 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property14s[i].attribute25 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property14s[i].attribute26 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property14s[i].attribute27 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property14s[i].attribute28 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property14s[i].attribute29 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property14s[i].attribute30 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property14s[i].attribute31 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property14s[i].attribute32 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property14s[i].attribute33 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property14s[i].attribute34 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property14s[i].attribute35 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property14s[i].attribute36 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property14s[i].attribute37 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property14s[i].attribute38 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property14s[i].attribute39 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        }

        binAnimation.property15s = new BinAnimation.Property15[int37];
        for (int i = 0; i < int37; i++) {
            binAnimation.property15s[i] = new BinAnimation.Property15();
            binAnimation.property15s[i].attribute1 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property15s[i].attribute2 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property15s[i].attribute3 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        }

        binAnimation.imageStringTableIndices = new Integer[int39];
        for (int i = 0; i < int39; i++) {
            binAnimation.imageStringTableIndices[i] = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        }

        binAnimation.soundStringTableIndices = new Integer[int41];
        for (int i = 0; i < int41; i++) {
            binAnimation.soundStringTableIndices[i] = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        }

        binAnimation.particleStringTableIndices = new Integer[int43];
        for (int i = 0; i < int43; i++) {
            binAnimation.particleStringTableIndices[i] = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        }

        binAnimation.XMLDataStringTableIndices = new Integer[int45];
        for (int i = 0; i < int45; i++) {
            binAnimation.XMLDataStringTableIndices[i] = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        }

        binAnimation.groupNameStringTableIndices = new Integer[int47];
        for (int i = 0; i < int47; i++) {
            binAnimation.groupNameStringTableIndices[i] = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        }

        binAnimation.property16s = new BinAnimation.Property16[int1];
        for (int i = 0; i < int1; i++) {
            binAnimation.property16s[i] = new BinAnimation.Property16();
            binAnimation.property16s[i].attribute1 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.property16s[i].attribute2 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        }

        int stringCount = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        input.skipNBytes(4);

        binAnimation.stringDeclarations = new BinAnimation.StringDeclaration[stringCount];
        for (int i = 0; i < stringCount; i++) {
            binAnimation.stringDeclarations[i] = new BinAnimation.StringDeclaration();
            binAnimation.stringDeclarations[i].stringIndex = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
            binAnimation.stringDeclarations[i].attribute2 = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        }

        binAnimation.stringDefinitions = new BinAnimation.StringDefinition[stringCount];
        for (int i = 0; i < stringCount; i++) {
            binAnimation.stringDefinitions[i] = new BinAnimation.StringDefinition();
            String lang = new String(input.readNBytes(4));
            binAnimation.stringDefinitions[i].language = lang.contains("\u0000") ? lang.substring(0, lang.indexOf("\u0000")) : lang;
            binAnimation.stringDefinitions[i].stringTableIndex = ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
        }

        binAnimation.stringTable = new String(input.readAllBytes()).split("\u0000");



        int i1 = 0;
        for (BinAnimation.GroupTiming groupTiming : binAnimation.groupTimings) {

            System.out.println("Begin group timing " + i1);
            i1++;

            int i2 = 0;
            for (int timingIndexI = groupTiming.timingIndexOffset; timingIndexI < groupTiming.timingIndexOffset + groupTiming.timingIndexLength; timingIndexI++) {

                BinAnimation.TimingIndex timingIndex = binAnimation.timingIndices[timingIndexI];

                System.out.println("Begin timing index " + i2);
                i2++;

                for (int timingI = timingIndex.timingOffset; timingI < timingIndex.timingOffset + timingIndex.timingLength; timingI++) {

                    BinAnimation.KeyframeTiming keyframeTiming = binAnimation.keyframeTimings[timingI];

                    System.out.println(keyframeTiming.sequenceId + " : " + keyframeTiming.keyframe + " : " + keyframeTiming.untilFrame);

                }

                System.out.println();

            }

            System.out.println();

        }



        return binAnimation;

    }

}
