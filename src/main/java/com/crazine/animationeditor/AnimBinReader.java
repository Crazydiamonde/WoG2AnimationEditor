package com.crazine.animationeditor;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.nio.file.Path;

public class AnimBinReader {

    private static int readInt(ByteArrayInputStream input) throws IOException {
        return ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt(0);
    }

    private static float readFloat(ByteArrayInputStream input) throws IOException {
        return ByteBuffer.wrap(input.readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getFloat(0);
    }


    public static BinAnimation read(Path path) throws IOException {

        BinAnimation binAnimation = new BinAnimation();

        ByteArrayInputStream input = new ByteArrayInputStream(Files.readAllBytes(path));
        int int1 = readInt(input);
        input.skipNBytes(4);
        int secretCount = readInt(input);
        input.skipNBytes(4);
        int int5 = readInt(input);
        input.skipNBytes(4);
        int int7 = readInt(input);
        input.skipNBytes(4);
        int keyframeCount = readInt(input);
        input.skipNBytes(4);
        int imageDataCount = readInt(input);
        input.skipNBytes(4);
        int int13 = readInt(input);
        input.skipNBytes(4);
        int int15 = readInt(input);
        input.skipNBytes(4);
        int int17 = readInt(input);
        input.skipNBytes(4);
        int int19 = readInt(input);
        input.skipNBytes(12);
        int int23 = readInt(input);
        input.skipNBytes(28);
        int int31 = readInt(input);
        input.skipNBytes(4);
        int int33 = readInt(input);
        input.skipNBytes(4);
        int int35 = readInt(input);
        input.skipNBytes(4);
        int int37 = readInt(input);
        input.skipNBytes(4);
        int int39 = readInt(input);
        input.skipNBytes(4);
        int int41 = readInt(input);
        input.skipNBytes(4);
        int int43 = readInt(input);
        input.skipNBytes(4);
        int int45 = readInt(input);
        input.skipNBytes(4);
        int int47 = readInt(input);
        input.skipNBytes(28);

        binAnimation.fps = readInt(input);

        binAnimation.defineGroups = new BinAnimation.DefineGroup[int1];
        for (int i = 0; i < int1; i++) {
            binAnimation.defineGroups[i] = new BinAnimation.DefineGroup();
            binAnimation.defineGroups[i].globalId = readInt(input);
            binAnimation.defineGroups[i].localId = readInt(input);
            binAnimation.defineGroups[i].uid = readInt(input);
        }

        binAnimation.groupTimings = new BinAnimation.GroupTiming[secretCount];
        for (int i = 0; i < secretCount; i++) {
            binAnimation.groupTimings[i] = new BinAnimation.GroupTiming();
            binAnimation.groupTimings[i].durationFrames = readInt(input);
            binAnimation.groupTimings[i].unknown1 = readInt(input);
            binAnimation.groupTimings[i].timingIndexOffset = readInt(input);
            binAnimation.groupTimings[i].timingIndexLength = readInt(input);
            binAnimation.groupTimings[i].timedEventOffset = readInt(input);
            binAnimation.groupTimings[i].timedEventLength = readInt(input);
        }

        binAnimation.timingIndices = new BinAnimation.TimingIndex[int5];
        for (int i = 0; i < int5; i++) {
            binAnimation.timingIndices[i] = new BinAnimation.TimingIndex();
            binAnimation.timingIndices[i].group = readInt(input);
            binAnimation.timingIndices[i].timingOffset = readInt(input);
            binAnimation.timingIndices[i].timingLength = readInt(input);
        }

        binAnimation.keyframeTimings = new BinAnimation.KeyframeTiming[int7];
        for (int i = 0; i < int7; i++) {
            binAnimation.keyframeTimings[i] = new BinAnimation.KeyframeTiming();
            binAnimation.keyframeTimings[i].sequenceId = readInt(input);
            binAnimation.keyframeTimings[i].keyframe = readInt(input);
            binAnimation.keyframeTimings[i].untilFrame = readInt(input);
        }

        binAnimation.keyframes = new BinAnimation.Keyframe[keyframeCount];
        for (int i = 0; i < keyframeCount; i++) {
            binAnimation.keyframes[i] = new BinAnimation.Keyframe();
            binAnimation.keyframes[i].attribute1 = readInt(input);
            binAnimation.keyframes[i].attribute2 = readInt(input);
            binAnimation.keyframes[i].angleTopLeft = readFloat(input);
            binAnimation.keyframes[i].angleBottomRight = readFloat(input);
            binAnimation.keyframes[i].x1 = readFloat(input);
            binAnimation.keyframes[i].y1 = readFloat(input);
            binAnimation.keyframes[i].x2 = readFloat(input);
            binAnimation.keyframes[i].y2 = readFloat(input);
            binAnimation.keyframes[i].scaleX = readFloat(input);
            binAnimation.keyframes[i].scaleY = readFloat(input);
            binAnimation.keyframes[i].colorize = readInt(input);
            binAnimation.keyframes[i].attribute12 = readFloat(input);
        }

        binAnimation.imageProperties = new BinAnimation.ImageProperties[imageDataCount];
        for (int i = 0; i < imageDataCount; i++) {
            binAnimation.imageProperties[i] = new BinAnimation.ImageProperties();
            binAnimation.imageProperties[i].imageIndex = readInt(input);
            binAnimation.imageProperties[i].angleTopLeft = readFloat(input);
            binAnimation.imageProperties[i].angleBottomRight = readFloat(input);
            binAnimation.imageProperties[i].centerX = readFloat(input);
            binAnimation.imageProperties[i].centerY = readFloat(input);
            binAnimation.imageProperties[i].offsetX = readFloat(input);
            binAnimation.imageProperties[i].offsetY = readFloat(input);
            binAnimation.imageProperties[i].scaleX = readFloat(input);
            binAnimation.imageProperties[i].scaleY = readFloat(input);
            binAnimation.imageProperties[i].colorize = readInt(input);
            binAnimation.imageProperties[i].attribute11 = readInt(input);
        }

        binAnimation.property7s = new BinAnimation.Property7[int13];
        for (int i = 0; i < int13; i++) {
            binAnimation.property7s[i] = new BinAnimation.Property7();
            binAnimation.property7s[i].attribute1 = readInt(input);
            binAnimation.property7s[i].attribute2 = readInt(input);
            binAnimation.property7s[i].attribute3 = readInt(input);
            binAnimation.property7s[i].attribute4 = readInt(input);
            binAnimation.property7s[i].attribute5 = readInt(input);
        }

        binAnimation.property8s = new BinAnimation.Property8[int15];
        for (int i = 0; i < int15; i++) {
            binAnimation.property8s[i] = new BinAnimation.Property8();
            binAnimation.property8s[i].attribute1 = readInt(input);
            binAnimation.property8s[i].attribute2 = readInt(input);
        }

        binAnimation.property9s = new BinAnimation.Property9[int17];
        for (int i = 0; i < int17; i++) {
            binAnimation.property9s[i] = new BinAnimation.Property9();
            binAnimation.property9s[i].attribute1 = readInt(input);
            binAnimation.property9s[i].attribute2 = readFloat(input);
            binAnimation.property9s[i].attribute3 = readFloat(input);
            binAnimation.property9s[i].attribute4 = readFloat(input);
            binAnimation.property9s[i].attribute5 = readFloat(input);
            binAnimation.property9s[i].attribute6 = readFloat(input);
            binAnimation.property9s[i].attribute7 = readFloat(input);
        }

        binAnimation.timedEvents = new BinAnimation.TimedEvent[int19];
        for (int i = 0; i < int19; i++) {
            binAnimation.timedEvents[i] = new BinAnimation.TimedEvent();
            binAnimation.timedEvents[i].active = readInt(input) == 1;
            binAnimation.timedEvents[i].delay = readInt(input);
            binAnimation.timedEvents[i].groupId = readInt(input);
        }

        binAnimation.unused1 = new Byte[0];

        binAnimation.property11s = new BinAnimation.Property11[int23];
        for (int i = 0; i < int23; i++) {
            binAnimation.property11s[i] = new BinAnimation.Property11();
            binAnimation.property11s[i].attribute1 = readInt(input);
            binAnimation.property11s[i].attribute2 = readInt(input);
            binAnimation.property11s[i].attribute3 = readInt(input);
            binAnimation.property11s[i].attribute4 = readInt(input);
            binAnimation.property11s[i].attribute5 = readInt(input);
            binAnimation.property11s[i].attribute6 = readInt(input);
            binAnimation.property11s[i].attribute7 = readInt(input);
            binAnimation.property11s[i].attribute8 = readInt(input);
            binAnimation.property11s[i].attribute9 = readInt(input);
            binAnimation.property11s[i].attribute10 = readInt(input);
        }

        binAnimation.unused2 = new Byte[0];
        binAnimation.unused3 = new Byte[0];
        binAnimation.unused4 = new Byte[0];

        binAnimation.property12s = new BinAnimation.Property12[int31];
        for (int i = 0; i < int31; i++) {
            binAnimation.property12s[i] = new BinAnimation.Property12();
            binAnimation.property12s[i].attribute1 = readInt(input);
            binAnimation.property12s[i].attribute2 = readInt(input);
            binAnimation.property12s[i].attribute3 = readInt(input);
            binAnimation.property12s[i].attribute4 = readInt(input);
            binAnimation.property12s[i].attribute5 = readInt(input);
            binAnimation.property12s[i].attribute6 = readFloat(input);
            binAnimation.property12s[i].attribute7 = readInt(input);
            binAnimation.property12s[i].attribute8 = readInt(input);
            binAnimation.property12s[i].attribute9 = readInt(input);
            binAnimation.property12s[i].attribute10 = readInt(input);
            binAnimation.property12s[i].attribute11 = readInt(input);
            binAnimation.property12s[i].attribute12 = readInt(input);
            binAnimation.property12s[i].attribute13 = readInt(input);
            binAnimation.property12s[i].attribute14 = readInt(input);
            binAnimation.property12s[i].attribute15 = readInt(input);
            binAnimation.property12s[i].attribute16 = readInt(input);
            binAnimation.property12s[i].attribute17 = readInt(input);
            binAnimation.property12s[i].attribute18 = readInt(input);
            binAnimation.property12s[i].attribute19 = readInt(input);
            binAnimation.property12s[i].attribute20 = readInt(input);
            binAnimation.property12s[i].attribute21 = readInt(input);
            binAnimation.property12s[i].attribute22 = readInt(input);
            binAnimation.property12s[i].attribute23 = readInt(input);
        }

        binAnimation.property13s = new BinAnimation.Property13[int33];
        for (int i = 0; i < int33; i++) {
            binAnimation.property13s[i] = new BinAnimation.Property13();
            binAnimation.property13s[i].attribute1 = readInt(input);
            binAnimation.property13s[i].attribute2 = readFloat(input);
            binAnimation.property13s[i].attribute3 = readInt(input);
            binAnimation.property13s[i].attribute4 = readInt(input);
            binAnimation.property13s[i].attribute5 = readInt(input);
            binAnimation.property13s[i].attribute6 = readInt(input);
            binAnimation.property13s[i].attribute7 = readInt(input);
        }

        binAnimation.property14s = new BinAnimation.Property14[int35];
        for (int i = 0; i < int35; i++) {
            binAnimation.property14s[i] = new BinAnimation.Property14();
            binAnimation.property14s[i].attribute1 = readInt(input);
            binAnimation.property14s[i].attribute2 = readInt(input);
            binAnimation.property14s[i].attribute3 = readInt(input);
            binAnimation.property14s[i].attribute4 = readInt(input);
            binAnimation.property14s[i].attribute5 = readInt(input);
            binAnimation.property14s[i].attribute6 = readInt(input);
            binAnimation.property14s[i].attribute7 = readInt(input);
            binAnimation.property14s[i].attribute8 = readInt(input);
            binAnimation.property14s[i].attribute9 = readInt(input);
            binAnimation.property14s[i].attribute10 = readInt(input);
            binAnimation.property14s[i].attribute11 = readInt(input);
            binAnimation.property14s[i].attribute12 = readInt(input);
            binAnimation.property14s[i].attribute13 = readInt(input);
            binAnimation.property14s[i].attribute14 = readInt(input);
            binAnimation.property14s[i].attribute15 = readInt(input);
            binAnimation.property14s[i].attribute16 = readInt(input);
            binAnimation.property14s[i].attribute17 = readInt(input);
            binAnimation.property14s[i].attribute18 = readInt(input);
            binAnimation.property14s[i].attribute19 = readInt(input);
            binAnimation.property14s[i].attribute20 = readInt(input);
            binAnimation.property14s[i].attribute21 = readInt(input);
            binAnimation.property14s[i].attribute22 = readInt(input);
            binAnimation.property14s[i].attribute23 = readInt(input);
            binAnimation.property14s[i].attribute24 = readInt(input);
            binAnimation.property14s[i].attribute25 = readInt(input);
            binAnimation.property14s[i].attribute26 = readInt(input);
            binAnimation.property14s[i].attribute27 = readInt(input);
            binAnimation.property14s[i].attribute28 = readInt(input);
            binAnimation.property14s[i].attribute29 = readInt(input);
            binAnimation.property14s[i].attribute30 = readInt(input);
            binAnimation.property14s[i].attribute31 = readInt(input);
            binAnimation.property14s[i].attribute32 = readInt(input);
            binAnimation.property14s[i].attribute33 = readInt(input);
            binAnimation.property14s[i].attribute34 = readInt(input);
            binAnimation.property14s[i].attribute35 = readInt(input);
            binAnimation.property14s[i].attribute36 = readInt(input);
            binAnimation.property14s[i].attribute37 = readInt(input);
            binAnimation.property14s[i].attribute38 = readInt(input);
            binAnimation.property14s[i].attribute39 = readInt(input);
        }

        binAnimation.property15s = new BinAnimation.Property15[int37];
        for (int i = 0; i < int37; i++) {
            binAnimation.property15s[i] = new BinAnimation.Property15();
            binAnimation.property15s[i].attribute1 = readInt(input);
            binAnimation.property15s[i].attribute2 = readInt(input);
            binAnimation.property15s[i].attribute3 = readInt(input);
        }

        binAnimation.imageStringTableIndices = new Integer[int39];
        for (int i = 0; i < int39; i++) {
            binAnimation.imageStringTableIndices[i] = readInt(input);
        }

        binAnimation.soundStringTableIndices = new Integer[int41];
        for (int i = 0; i < int41; i++) {
            binAnimation.soundStringTableIndices[i] = readInt(input);
        }

        binAnimation.particleStringTableIndices = new Integer[int43];
        for (int i = 0; i < int43; i++) {
            binAnimation.particleStringTableIndices[i] = readInt(input);
        }

        binAnimation.XMLDataStringTableIndices = new Integer[int45];
        for (int i = 0; i < int45; i++) {
            binAnimation.XMLDataStringTableIndices[i] = readInt(input);
        }

        binAnimation.groupNameStringTableIndices = new Integer[int47];
        for (int i = 0; i < int47; i++) {
            binAnimation.groupNameStringTableIndices[i] = readInt(input);
        }

        binAnimation.property16s = new BinAnimation.Property16[int1];
        for (int i = 0; i < int1; i++) {
            binAnimation.property16s[i] = new BinAnimation.Property16();
            binAnimation.property16s[i].attribute1 = readInt(input);
            binAnimation.property16s[i].attribute2 = readInt(input);
        }

        int stringCount = readInt(input);
        input.skipNBytes(4);

        binAnimation.stringDeclarations = new BinAnimation.StringDeclaration[stringCount];
        for (int i = 0; i < stringCount; i++) {
            binAnimation.stringDeclarations[i] = new BinAnimation.StringDeclaration();
            binAnimation.stringDeclarations[i].stringIndex = readInt(input);
            binAnimation.stringDeclarations[i].attribute2 = readInt(input);
        }

        binAnimation.stringDefinitions = new BinAnimation.StringDefinition[stringCount];
        for (int i = 0; i < stringCount; i++) {
            binAnimation.stringDefinitions[i] = new BinAnimation.StringDefinition();
            String lang = new String(input.readNBytes(4));
            binAnimation.stringDefinitions[i].language = lang.contains("\u0000") ? lang.substring(0, lang.indexOf("\u0000")) : lang;
            binAnimation.stringDefinitions[i].stringTableIndex = readInt(input);
        }

        binAnimation.stringTableBytes = input.readAllBytes();
        binAnimation.stringTable = new String(binAnimation.stringTableBytes).split("\u0000");

        return binAnimation;

    }


    public static FinalBinAnimation readFinal(Path path) throws IOException {

        FinalBinAnimation finalBinAnimation = new FinalBinAnimation();

        ByteArrayInputStream input = new ByteArrayInputStream(Files.readAllBytes(path));
        int int1 = readInt(input);
        input.skipNBytes(4);
        int secretCount = readInt(input);
        input.skipNBytes(4);
        int int5 = readInt(input);
        input.skipNBytes(4);
        int int7 = readInt(input);
        input.skipNBytes(4);
        int keyframeCount = readInt(input);
        input.skipNBytes(4);
        int imageDataCount = readInt(input);
        input.skipNBytes(4);
        int int13 = readInt(input);
        input.skipNBytes(4);
        int int15 = readInt(input);
        input.skipNBytes(4);
        int int17 = readInt(input);
        input.skipNBytes(4);
        int int19 = readInt(input);
        input.skipNBytes(12);
        int int23 = readInt(input);
        input.skipNBytes(28);
        int int31 = readInt(input);
        input.skipNBytes(4);
        int int33 = readInt(input);
        input.skipNBytes(4);
        int int35 = readInt(input);
        input.skipNBytes(4);
        int int37 = readInt(input);
        input.skipNBytes(4);
        int int39 = readInt(input);
        input.skipNBytes(4);
        int int41 = readInt(input);
        input.skipNBytes(4);
        int int43 = readInt(input);
        input.skipNBytes(4);
        int int45 = readInt(input);
        input.skipNBytes(4);
        int int47 = readInt(input);
        input.skipNBytes(28);

        finalBinAnimation.animationFPS = readInt(input);

        finalBinAnimation.animationStates = new FinalBinAnimation.AnimationState[int1];
        for (int i = 0; i < int1; i++) {
            finalBinAnimation.animationStates[i] = new FinalBinAnimation.AnimationState();
            finalBinAnimation.animationStates[i].globalIdHash = readInt(input);
            finalBinAnimation.animationStates[i].localIdHash = readInt(input);
            finalBinAnimation.animationStates[i].groupIndex = readInt(input);
        }

        finalBinAnimation.animationGroups = new FinalBinAnimation.AnimationGroup[secretCount];
        for (int i = 0; i < secretCount; i++) {
            finalBinAnimation.animationGroups[i] = new FinalBinAnimation.AnimationGroup();
            finalBinAnimation.animationGroups[i].duration1 = readInt(input);
            finalBinAnimation.animationGroups[i].duration2 = readInt(input);
            finalBinAnimation.animationGroups[i].sectionOffset = readInt(input);
            finalBinAnimation.animationGroups[i].sectionLength = readInt(input);
            finalBinAnimation.animationGroups[i].eventOffset = readInt(input);
            finalBinAnimation.animationGroups[i].eventLength = readInt(input);
        }

        finalBinAnimation.animationSections = new FinalBinAnimation.AnimationSection[int5];
        for (int i = 0; i < int5; i++) {
            finalBinAnimation.animationSections[i] = new FinalBinAnimation.AnimationSection();
            finalBinAnimation.animationSections[i].type = FinalBinAnimation.AnimationSectionType.values()[readInt(input)];
            finalBinAnimation.animationSections[i].elementOffset = readInt(input);
            finalBinAnimation.animationSections[i].elementLength = readInt(input);
        }

        finalBinAnimation.animationElements = new FinalBinAnimation.AnimationElement[int7];
        for (int i = 0; i < int7; i++) {
            finalBinAnimation.animationElements[i] = new FinalBinAnimation.AnimationElement();
            finalBinAnimation.animationElements[i].type = FinalBinAnimation.AnimationElementType.values()[readInt(input)];
            finalBinAnimation.animationElements[i].offset = readInt(input);
            finalBinAnimation.animationElements[i].frame = readInt(input);
        }

        finalBinAnimation.animationKeyframes = new FinalBinAnimation.AnimationKeyframe[keyframeCount];
        for (int i = 0; i < keyframeCount; i++) {
            finalBinAnimation.animationKeyframes[i] = new FinalBinAnimation.AnimationKeyframe();
            finalBinAnimation.animationKeyframes[i].groupIndex = readInt(input);
            finalBinAnimation.animationKeyframes[i].unknown1 = readInt(input);
            finalBinAnimation.animationKeyframes[i].angleTopLeft = readFloat(input);
            finalBinAnimation.animationKeyframes[i].angleBottomRight = readFloat(input);
            finalBinAnimation.animationKeyframes[i].centerX = readFloat(input);
            finalBinAnimation.animationKeyframes[i].centerY = readFloat(input);
            finalBinAnimation.animationKeyframes[i].offsetX = readFloat(input);
            finalBinAnimation.animationKeyframes[i].offsetY = readFloat(input);
            finalBinAnimation.animationKeyframes[i].scaleX = readFloat(input);
            finalBinAnimation.animationKeyframes[i].scaleY = readFloat(input);
            finalBinAnimation.animationKeyframes[i].colorize = readInt(input);
            finalBinAnimation.animationKeyframes[i].unknown2 = readFloat(input);
        }

        finalBinAnimation.animationParts = new FinalBinAnimation.AnimationPart[imageDataCount];
        for (int i = 0; i < imageDataCount; i++) {
            finalBinAnimation.animationParts[i] = new FinalBinAnimation.AnimationPart();
            finalBinAnimation.animationParts[i].imageIndex = readInt(input);
            finalBinAnimation.animationParts[i].angleTopLeft = readFloat(input);
            finalBinAnimation.animationParts[i].angleBottomRight = readFloat(input);
            finalBinAnimation.animationParts[i].centerX = readFloat(input);
            finalBinAnimation.animationParts[i].centerY = readFloat(input);
            finalBinAnimation.animationParts[i].offsetX = readFloat(input);
            finalBinAnimation.animationParts[i].offsetY = readFloat(input);
            finalBinAnimation.animationParts[i].scaleX = readFloat(input);
            finalBinAnimation.animationParts[i].scaleY = readFloat(input);
            finalBinAnimation.animationParts[i].colorize = readInt(input);
            finalBinAnimation.animationParts[i].attribute11 = readInt(input);
        }

        finalBinAnimation.animationExternals = new FinalBinAnimation.AnimationExternal[int13];
        for (int i = 0; i < int13; i++) {
            finalBinAnimation.animationExternals[i] = new FinalBinAnimation.AnimationExternal();
            finalBinAnimation.animationExternals[i].globalIdHash = readInt(input);
            finalBinAnimation.animationExternals[i].type = FinalBinAnimation.AnimationExternalType.values()[readInt(input)];
            finalBinAnimation.animationExternals[i].property12Offset = readInt(input);
            finalBinAnimation.animationExternals[i].property9Offset = readInt(input);
            finalBinAnimation.animationExternals[i].property9Length = readInt(input);
        }

        finalBinAnimation.animationProperty8s = new FinalBinAnimation.AnimationProperty8[int15];
        for (int i = 0; i < int15; i++) {
            finalBinAnimation.animationProperty8s[i] = new FinalBinAnimation.AnimationProperty8();
            finalBinAnimation.animationProperty8s[i].unknown1 = readInt(input);
            finalBinAnimation.animationProperty8s[i].unknown2 = readInt(input);
        }

        finalBinAnimation.animationProperty9s = new FinalBinAnimation.AnimationProperty9[int17];
        for (int i = 0; i < int17; i++) {
            finalBinAnimation.animationProperty9s[i] = new FinalBinAnimation.AnimationProperty9();
            finalBinAnimation.animationProperty9s[i].type = FinalBinAnimation.AnimationProperty9Type.values()[readInt(input)];
            finalBinAnimation.animationProperty9s[i].unknown1 = readFloat(input);
            finalBinAnimation.animationProperty9s[i].unknown2 = readFloat(input);
            finalBinAnimation.animationProperty9s[i].unknown3 = readFloat(input);
            finalBinAnimation.animationProperty9s[i].unknown4 = readFloat(input);
            finalBinAnimation.animationProperty9s[i].unknown5 = readFloat(input);
            finalBinAnimation.animationProperty9s[i].unknown6 = readFloat(input);
        }

        finalBinAnimation.animationEvents = new FinalBinAnimation.AnimationEvent[int19];
        for (int i = 0; i < int19; i++) {
            finalBinAnimation.animationEvents[i] = new FinalBinAnimation.AnimationEvent();
            finalBinAnimation.animationEvents[i].type = FinalBinAnimation.AnimationEventType.values()[readInt(input)];
            finalBinAnimation.animationEvents[i].frame = readInt(input);
            finalBinAnimation.animationEvents[i].unknown1 = readInt(input);
        }

        finalBinAnimation.animationProperty11s = new FinalBinAnimation.AnimationProperty11[int23];
        for (int i = 0; i < int23; i++) {
            finalBinAnimation.animationProperty11s[i] = new FinalBinAnimation.AnimationProperty11();
            finalBinAnimation.animationProperty11s[i].globalIdHash = readInt(input);
            finalBinAnimation.animationProperty11s[i].type = FinalBinAnimation.AnimationProperty11Type.values()[readInt(input)];
            finalBinAnimation.animationProperty11s[i].unknown1 = readInt(input);
            finalBinAnimation.animationProperty11s[i].unknown2 = readInt(input);
            finalBinAnimation.animationProperty11s[i].unknown3 = readInt(input);
            finalBinAnimation.animationProperty11s[i].unknown4 = readInt(input);
            finalBinAnimation.animationProperty11s[i].unknown5 = readInt(input);
            finalBinAnimation.animationProperty11s[i].unknown6 = readInt(input);
            finalBinAnimation.animationProperty11s[i].unknown7 = readInt(input);
        }

        finalBinAnimation.animationProperty12s = new FinalBinAnimation.AnimationProperty12[int31];
        for (int i = 0; i < int31; i++) {
            finalBinAnimation.animationProperty12s[i] = new FinalBinAnimation.AnimationProperty12();
            finalBinAnimation.animationProperty12s[i].type = FinalBinAnimation.AnimationProperty12Type.values()[readInt(input)];
            finalBinAnimation.animationProperty12s[i].idHash = readInt(input);
            finalBinAnimation.animationProperty12s[i].attribute3 = readInt(input);
            finalBinAnimation.animationProperty12s[i].attribute4 = readInt(input);
            finalBinAnimation.animationProperty12s[i].attribute5 = readInt(input);
            finalBinAnimation.animationProperty12s[i].attribute6 = readFloat(input);
            finalBinAnimation.animationProperty12s[i].attribute7 = readInt(input);
            finalBinAnimation.animationProperty12s[i].attribute8 = readInt(input);
            finalBinAnimation.animationProperty12s[i].attribute9 = readInt(input);
            finalBinAnimation.animationProperty12s[i].attribute10 = readInt(input);
            finalBinAnimation.animationProperty12s[i].attribute11 = readInt(input);
            finalBinAnimation.animationProperty12s[i].attribute12 = readInt(input);
            finalBinAnimation.animationProperty12s[i].attribute13 = readInt(input);
            finalBinAnimation.animationProperty12s[i].attribute14 = readInt(input);
            finalBinAnimation.animationProperty12s[i].attribute15 = readInt(input);
            finalBinAnimation.animationProperty12s[i].attribute16 = readInt(input);
            finalBinAnimation.animationProperty12s[i].attribute17 = readInt(input);
            finalBinAnimation.animationProperty12s[i].attribute18 = readInt(input);
            finalBinAnimation.animationProperty12s[i].attribute19 = readInt(input);
            finalBinAnimation.animationProperty12s[i].attribute20 = readInt(input);
            finalBinAnimation.animationProperty12s[i].attribute21 = readInt(input);
            finalBinAnimation.animationProperty12s[i].attribute22 = readInt(input);
            finalBinAnimation.animationProperty12s[i].stringTableIndex = readInt(input);
        }

        finalBinAnimation.animationProperty13s = new FinalBinAnimation.AnimationProperty13[int33];
        for (int i = 0; i < int33; i++) {
            finalBinAnimation.animationProperty13s[i] = new FinalBinAnimation.AnimationProperty13();
            finalBinAnimation.animationProperty13s[i].attribute1 = readInt(input);
            finalBinAnimation.animationProperty13s[i].attribute2 = readFloat(input);
            finalBinAnimation.animationProperty13s[i].attribute3 = readInt(input);
            finalBinAnimation.animationProperty13s[i].attribute4 = readInt(input);
            finalBinAnimation.animationProperty13s[i].attribute5 = readInt(input);
            finalBinAnimation.animationProperty13s[i].attribute6 = readInt(input);
            finalBinAnimation.animationProperty13s[i].attribute7 = readInt(input);
        }

        finalBinAnimation.animationProperty14s = new FinalBinAnimation.AnimationProperty14[int35];
        for (int i = 0; i < int35; i++) {
            finalBinAnimation.animationProperty14s[i] = new FinalBinAnimation.AnimationProperty14();
            finalBinAnimation.animationProperty14s[i].attribute1 = readInt(input);
            finalBinAnimation.animationProperty14s[i].attribute2 = readInt(input);
            finalBinAnimation.animationProperty14s[i].attribute3 = readInt(input);
            finalBinAnimation.animationProperty14s[i].attribute4 = readInt(input);
            finalBinAnimation.animationProperty14s[i].attribute5 = readInt(input);
            finalBinAnimation.animationProperty14s[i].attribute6 = readInt(input);
            finalBinAnimation.animationProperty14s[i].attribute7 = readInt(input);
            finalBinAnimation.animationProperty14s[i].attribute8 = readInt(input);
            finalBinAnimation.animationProperty14s[i].attribute9 = readInt(input);
            finalBinAnimation.animationProperty14s[i].attribute10 = readInt(input);
            finalBinAnimation.animationProperty14s[i].attribute11 = readInt(input);
            finalBinAnimation.animationProperty14s[i].attribute12 = readInt(input);
            finalBinAnimation.animationProperty14s[i].attribute13 = readInt(input);
            finalBinAnimation.animationProperty14s[i].attribute14 = readInt(input);
            finalBinAnimation.animationProperty14s[i].attribute15 = readInt(input);
            finalBinAnimation.animationProperty14s[i].attribute16 = readInt(input);
            finalBinAnimation.animationProperty14s[i].attribute17 = readInt(input);
            finalBinAnimation.animationProperty14s[i].attribute18 = readInt(input);
            finalBinAnimation.animationProperty14s[i].attribute19 = readInt(input);
            finalBinAnimation.animationProperty14s[i].attribute20 = readInt(input);
            finalBinAnimation.animationProperty14s[i].attribute21 = readInt(input);
            finalBinAnimation.animationProperty14s[i].attribute22 = readInt(input);
            finalBinAnimation.animationProperty14s[i].attribute23 = readInt(input);
            finalBinAnimation.animationProperty14s[i].attribute24 = readInt(input);
            finalBinAnimation.animationProperty14s[i].attribute25 = readInt(input);
            finalBinAnimation.animationProperty14s[i].attribute26 = readInt(input);
            finalBinAnimation.animationProperty14s[i].attribute27 = readInt(input);
            finalBinAnimation.animationProperty14s[i].attribute28 = readInt(input);
            finalBinAnimation.animationProperty14s[i].attribute29 = readInt(input);
            finalBinAnimation.animationProperty14s[i].attribute30 = readInt(input);
            finalBinAnimation.animationProperty14s[i].attribute31 = readInt(input);
            finalBinAnimation.animationProperty14s[i].attribute32 = readInt(input);
            finalBinAnimation.animationProperty14s[i].attribute33 = readInt(input);
            finalBinAnimation.animationProperty14s[i].attribute34 = readInt(input);
            finalBinAnimation.animationProperty14s[i].attribute35 = readInt(input);
            finalBinAnimation.animationProperty14s[i].attribute36 = readInt(input);
            finalBinAnimation.animationProperty14s[i].attribute37 = readInt(input);
            finalBinAnimation.animationProperty14s[i].attribute38 = readInt(input);
            finalBinAnimation.animationProperty14s[i].attribute39 = readInt(input);
        }

        finalBinAnimation.animationProperty15s = new FinalBinAnimation.AnimationProperty15[int37];
        for (int i = 0; i < int37; i++) {
            finalBinAnimation.animationProperty15s[i] = new FinalBinAnimation.AnimationProperty15();
            finalBinAnimation.animationProperty15s[i].idHash1 = readInt(input);
            finalBinAnimation.animationProperty15s[i].idHash2 = readInt(input);
            finalBinAnimation.animationProperty15s[i].unknown1 = readInt(input);
        }

        finalBinAnimation.animationImageStringTableIndices = new int[int39];
        for (int i = 0; i < int39; i++) {
            finalBinAnimation.animationImageStringTableIndices[i] = readInt(input);
        }

        finalBinAnimation.animationSoundStringTableIndices = new int[int41];
        for (int i = 0; i < int41; i++) {
            finalBinAnimation.animationSoundStringTableIndices[i] = readInt(input);
        }

        finalBinAnimation.animationParticleStringTableIndices = new int[int43];
        for (int i = 0; i < int43; i++) {
            finalBinAnimation.animationParticleStringTableIndices[i] = readInt(input);
        }

        finalBinAnimation.animationXMLDataStringTableIndices = new int[int45];
        for (int i = 0; i < int45; i++) {
            finalBinAnimation.animationXMLDataStringTableIndices[i] = readInt(input);
        }

        finalBinAnimation.animationStateNameStringTableIndices = new int[int47];
        for (int i = 0; i < int47; i++) {
            finalBinAnimation.animationStateNameStringTableIndices[i] = readInt(input);
        }

        finalBinAnimation.animationProperty16s = new FinalBinAnimation.AnimationProperty16[int1];
        for (int i = 0; i < int1; i++) {
            finalBinAnimation.animationProperty16s[i] = new FinalBinAnimation.AnimationProperty16();
            finalBinAnimation.animationProperty16s[i].idHash1 = readInt(input);
            finalBinAnimation.animationProperty16s[i].idHash2 = readInt(input);
        }

        int stringCount = readInt(input);
        input.skipNBytes(4);

        finalBinAnimation.animationStringDeclarations = new FinalBinAnimation.AnimationStringDeclaration[stringCount];
        for (int i = 0; i < stringCount; i++) {
            finalBinAnimation.animationStringDeclarations[i] = new FinalBinAnimation.AnimationStringDeclaration();
            finalBinAnimation.animationStringDeclarations[i].stringIndex = readInt(input);
            finalBinAnimation.animationStringDeclarations[i].unknown1 = readInt(input);
        }

        finalBinAnimation.animationStringDefinitions = new FinalBinAnimation.AnimationStringDefinition[stringCount];
        for (int i = 0; i < stringCount; i++) {
            finalBinAnimation.animationStringDefinitions[i] = new FinalBinAnimation.AnimationStringDefinition();
            String lang = new String(input.readNBytes(4));
            finalBinAnimation.animationStringDefinitions[i].language = lang.contains("\u0000") ? lang.substring(0, lang.indexOf("\u0000")) : lang;
            finalBinAnimation.animationStringDefinitions[i].stringTableIndex = readInt(input);
        }

        finalBinAnimation.animationStringTable = input.readAllBytes();

        return finalBinAnimation;

    }

}
