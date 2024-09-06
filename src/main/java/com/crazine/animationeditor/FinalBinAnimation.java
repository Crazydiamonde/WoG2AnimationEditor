package com.crazine.animationeditor;

public class FinalBinAnimation {

    public static class AnimationState {
        public int globalIdHash;
        public int localIdHash;
        public int groupIndex;
    }

    public static class AnimationGroup {
        public int duration1;
        public int duration2;
        public int sectionOffset;
        public int sectionLength;
        public int eventOffset;
        public int eventLength;
    }

    public enum AnimationSectionType {
        TYPE_0,
        TYPE_1,
        TYPE_2,
    }
    public static class AnimationSection {
        public AnimationSectionType type;
        public int elementOffset;
        public int elementLength;
    }

    public enum AnimationElementType {
        TYPE_0,
        TYPE_1,
        TYPE_2,
        TYPE_3,
        TYPE_4,
    }
    public static class AnimationElement {
        public AnimationElementType type;
        public int offset;
        public int frame;
    }

    public static class AnimationKeyframe {
        public int groupIndex;
        public int unknown1;
        public float angleTopLeft;
        public float angleBottomRight;
        public float centerX;
        public float centerY;
        public float offsetX;
        public float offsetY;
        public float scaleX;
        public float scaleY;
        public int colorize;
        public float unknown2;
    }

    public static class AnimationPart {
        public int imageIndex;
        public float angleTopLeft;
        public float angleBottomRight;
        public float centerX;
        public float centerY;
        public float offsetX;
        public float offsetY;
        public float scaleX;
        public float scaleY;
        public int colorize;
        public int attribute11;
    }

    public enum AnimationExternalType {
        TYPE_0,
        TYPE_1,
        TYPE_2,
        TYPE_3,
        TYPE_4,
        TYPE_5,
        TYPE_6,
        TYPE_7,
        TYPE_8,
    }
    public static class AnimationExternal {
        public int globalIdHash;
        public AnimationExternalType type;
        public int property12Offset;
        public int property9Offset;
        public int property9Length;
    }

    public static class AnimationProperty8 {
        public int unknown1;
        public int unknown2;
    }

    public enum AnimationProperty9Type {
        TYPE_0,
        TYPE_1,
    }
    public static class AnimationProperty9 {
        public AnimationProperty9Type type;
        public float unknown1;
        public float unknown2;
        public float unknown3;
        public float unknown4;
        public float unknown5;
        public float unknown6;
    }

    public enum AnimationEventType {
        TYPE_0,
        TYPE_1,
    }
    public static class AnimationEvent {
        public AnimationEventType type;
        public int frame;
        public int unknown1;
    }

    public enum AnimationProperty11Type {
        TYPE_0,
        TYPE_1,
    }
    public static class AnimationProperty11 {
        public int globalIdHash;
        public AnimationProperty11Type type;
        public int unknown1;
        public int unknown2;
        public int unknown3;
        public int unknown4;
        public int unknown5;
        public int unknown6;
        public int unknown7;
    }

    public enum AnimationProperty12Type {
        TYPE_0,
        TYPE_1,
        TYPE_2,
        TYPE_3,
    }
    public static class AnimationProperty12 {
        public AnimationProperty12Type type;
        public int idHash;
        public int attribute3;
        public int attribute4;
        public int attribute5;
        public float attribute6;
        // GroupTiming, TimingIndex, KeyframeTiming, Keyframes
        public int attribute7;
        // GroupTiming, TimingIndex, KeyframeTiming, Keyframes, TimedEvent, Strings
        public int attribute8;
        // GroupTiming, TimingIndex, KeyframeTiming, Keyframes, ImageProperties, Property7, Property9, TimedEvent, Property12, Strings
        public int attribute9;
        // GroupTiming, TimingIndex, KeyframeTiming, Keyframes, ImageProperties, Property7, Property9, TimedEvent, Property12, Strings
        public int attribute10;
        public int attribute11;
        public int attribute12;
        public int attribute13;
        public int attribute14;
        public int attribute15;
        public int attribute16;
        public int attribute17;
        public int attribute18;
        public int attribute19;
        public int attribute20;
        public int attribute21;
        public int attribute22;
        public int stringTableIndex;
    }

    public static class AnimationProperty13 {
        public int attribute1;
        public float attribute2;
        public int attribute3;
        public int attribute4;
        public int attribute5;
        public int attribute6;
        public int attribute7;
    }

    public static class AnimationProperty14 {
        public int attribute1;
        public int attribute2;
        public int attribute3;
        public int attribute4;
        public int attribute5;
        public int attribute6;
        public int attribute7;
        public int attribute8;
        public int attribute9;
        public int attribute10;
        public int attribute11;
        public int attribute12;
        public int attribute13;
        public int attribute14;
        public int attribute15;
        public int attribute16;
        public int attribute17;
        public int attribute18;
        public int attribute19;
        public int attribute20;
        public int attribute21;
        public int attribute22;
        public int attribute23;
        public int attribute24;
        public int attribute25;
        public int attribute26;
        public int attribute27;
        public int attribute28;
        public int attribute29;
        public int attribute30;
        public int attribute31;
        public int attribute32;
        public int attribute33;
        public int attribute34;
        public int attribute35;
        public int attribute36;
        public int attribute37;
        public int attribute38;
        public int attribute39;
    }

    public static class AnimationProperty15 {
        public int idHash1;
        public int idHash2;
        public int unknown1;
    }

    public static class AnimationProperty16 {
        public int idHash1;
        public int idHash2;
    }

    public static class AnimationStringDeclaration {
        public int stringIndex;
        public int unknown1;
    }

    public static class AnimationStringDefinition {
        public String language;
        public int stringTableIndex;
    }

    public int animationFPS;
    public FinalBinAnimation.AnimationState[] animationStates;
    public FinalBinAnimation.AnimationGroup[] animationGroups;
    public FinalBinAnimation.AnimationSection[] animationSections;
    public FinalBinAnimation.AnimationElement[] animationElements;
    public FinalBinAnimation.AnimationKeyframe[] animationKeyframes;
    public FinalBinAnimation.AnimationPart[] animationParts;
    public FinalBinAnimation.AnimationExternal[] animationExternals;
    public FinalBinAnimation.AnimationProperty8[] animationProperty8s;
    public FinalBinAnimation.AnimationProperty9[] animationProperty9s;
    public FinalBinAnimation.AnimationEvent[] animationEvents;
    public FinalBinAnimation.AnimationProperty11[] animationProperty11s;
    public FinalBinAnimation.AnimationProperty12[] animationProperty12s;
    public FinalBinAnimation.AnimationProperty13[] animationProperty13s;
    public FinalBinAnimation.AnimationProperty14[] animationProperty14s;
    public FinalBinAnimation.AnimationProperty15[] animationProperty15s;
    public int[] animationImageStringTableIndices;
    public int[] animationSoundStringTableIndices;
    public int[] animationParticleStringTableIndices;
    public int[] animationXMLDataStringTableIndices;
    public int[] animationStateNameStringTableIndices;
    public FinalBinAnimation.AnimationProperty16[] animationProperty16s;
    public FinalBinAnimation.AnimationStringDeclaration[] animationStringDeclarations;
    public FinalBinAnimation.AnimationStringDefinition[] animationStringDefinitions;
    public byte[] animationStringTable;

}
