package com.crazine.animationeditor;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class BinAnimation {

    public static class DefineGroup {

        @JacksonXmlProperty (isAttribute = true)
        public int globalId;

        @JacksonXmlProperty (isAttribute = true)
        public int localId;

        @JacksonXmlProperty (isAttribute = true)
        public int uid;

    }

    public static class GroupTiming {

        @JacksonXmlProperty (isAttribute = true)
        public int durationFrames;

        @JacksonXmlProperty (isAttribute = true)
        public int unknown1;

        @JacksonXmlProperty (isAttribute = true)
        public int timingIndexOffset;
        @JacksonXmlProperty (isAttribute = true)
        public int timingIndexLength;

        @JacksonXmlProperty (isAttribute = true)
        public int keyframeOffset;
        @JacksonXmlProperty (isAttribute = true)
        public int keyframeLength;

    }

    public static class TimingIndex {

        @JacksonXmlProperty (isAttribute = true)
        public int group;

        @JacksonXmlProperty (isAttribute = true)
        public int timingOffset;

        @JacksonXmlProperty (isAttribute = true)
        public int timingLength;

    }

    public static class KeyframeTiming {

        @JacksonXmlProperty (isAttribute = true)
        public int sequenceId;

        @JacksonXmlProperty (isAttribute = true)
        public int keyframe;

        @JacksonXmlProperty (isAttribute = true)
        public int untilFrame;

    }

    public static class Keyframe {

        // GroupTiming, TimingIndex, KeyframeTiming
        @JacksonXmlProperty (isAttribute = true)
        public int attribute1;

        @JacksonXmlProperty (isAttribute = true)
        public int attribute2;
        @JacksonXmlProperty (isAttribute = true)
        public float angleTopLeft;
        @JacksonXmlProperty (isAttribute = true)
        public float angleBottomRight;
        @JacksonXmlProperty (isAttribute = true)
        public float x1;
        @JacksonXmlProperty (isAttribute = true)
        public float y1;
        @JacksonXmlProperty (isAttribute = true)
        public float x2;
        @JacksonXmlProperty (isAttribute = true)
        public float y2;
        @JacksonXmlProperty (isAttribute = true)
        public float scaleX;
        @JacksonXmlProperty (isAttribute = true)
        public float scaleY;
        @JacksonXmlProperty (isAttribute = true)
        public int colorize;
        @JacksonXmlProperty (isAttribute = true)
        public float attribute12;
    }

    public static class ImageProperties {

        // TimingIndex, KeyframeTiming, ImageProperties, ImageStringTableIndices, Strings
        @JacksonXmlProperty (isAttribute = true)
        public int imageIndex;

        @JacksonXmlProperty (isAttribute = true)
        public float angleTopLeft;
        @JacksonXmlProperty (isAttribute = true)
        public float angleBottomRight;
        @JacksonXmlProperty (isAttribute = true)
        public float centerX;
        @JacksonXmlProperty (isAttribute = true)
        public float centerY;
        @JacksonXmlProperty (isAttribute = true)
        public float offsetX;
        @JacksonXmlProperty (isAttribute = true)
        public float offsetY;
        @JacksonXmlProperty (isAttribute = true)
        public float scaleX;
        @JacksonXmlProperty (isAttribute = true)
        public float scaleY;
        @JacksonXmlProperty (isAttribute = true)
        public int colorize;

        // DefineGroup, GroupTiming, TimingIndex, KeyframeTiming, ImageProperties, ImageStringTableIndices, PartNameStringTableIndices, Property16, Strings
        @JacksonXmlProperty (isAttribute = true)
        public int attribute11;

    }

    public static class Property7 {
        @JacksonXmlProperty (isAttribute = true)
        public int attribute1;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute2;

        // GroupTiming, TimingIndex, KeyframeTiming, Keyframes, Property7, Property9, TimedEvent, Strings
        @JacksonXmlProperty (isAttribute = true)
        public int attribute3;

        // GroupTiming, TimingIndex, KeyframeTiming, Keyframes, Property7, Property9, TimedEvent
        @JacksonXmlProperty (isAttribute = true)
        public int attribute4;

        @JacksonXmlProperty (isAttribute = true)
        public int attribute5;
    }

    public static class Property8 {

        // GroupTiming, TimingIndex, KeyframeTiming, Strings
        @JacksonXmlProperty (isAttribute = true)
        public int attribute1;

        @JacksonXmlProperty (isAttribute = true)
        public int attribute2;
    }

    public static class Property9 {

        // GroupTiming, TimingIndex, KeyframeTiming, TimedEvent, Strings
        @JacksonXmlProperty (isAttribute = true)
        public int attribute1;

        @JacksonXmlProperty (isAttribute = true)
        public float attribute2;
        @JacksonXmlProperty (isAttribute = true)
        public float attribute3;
        @JacksonXmlProperty (isAttribute = true)
        public float attribute4;
        @JacksonXmlProperty (isAttribute = true)
        public float attribute5;
        @JacksonXmlProperty (isAttribute = true)
        public float attribute6;
        @JacksonXmlProperty (isAttribute = true)
        public float attribute7;
    }

    public static class TimedEvent {

        @JacksonXmlProperty (isAttribute = true)
        public boolean active;

        @JacksonXmlProperty (isAttribute = true)
        public int delay;

        @JacksonXmlProperty (isAttribute = true)
        public int groupId;

    }

    public static class Property11 {
        @JacksonXmlProperty (isAttribute = true)
        public int attribute1;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute2;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute3;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute4;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute5;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute6;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute7;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute8;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute9;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute10;
    }

    public static class Property12 {

        // KeyframeTiming, Keyframes
        @JacksonXmlProperty (isAttribute = true)
        public int attribute1;

        @JacksonXmlProperty (isAttribute = true)
        public int attribute2;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute3;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute4;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute5;
        @JacksonXmlProperty (isAttribute = true)
        public float attribute6;

        // GroupTiming, TimingIndex, KeyframeTiming, Keyframes
        @JacksonXmlProperty (isAttribute = true)
        public int attribute7;

        // GroupTiming, TimingIndex, KeyframeTiming, Keyframes, TimedEvent, Strings
        @JacksonXmlProperty (isAttribute = true)
        public int attribute8;

        // GroupTiming, TimingIndex, KeyframeTiming, Keyframes, ImageProperties, Property7, Property9, TimedEvent, Property12, Strings
        @JacksonXmlProperty (isAttribute = true)
        public int attribute9;

        // GroupTiming, TimingIndex, KeyframeTiming, Keyframes, ImageProperties, Property7, Property9, TimedEvent, Property12, Strings
        @JacksonXmlProperty (isAttribute = true)
        public int attribute10;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute11;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute12;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute13;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute14;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute15;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute16;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute17;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute18;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute19;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute20;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute21;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute22;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute23;
    }

    public static class Property13 {
        @JacksonXmlProperty (isAttribute = true)
        public int attribute1;
        @JacksonXmlProperty (isAttribute = true)
        public float attribute2;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute3;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute4;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute5;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute6;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute7;
    }

    public static class Property14 {
        @JacksonXmlProperty (isAttribute = true)
        public int attribute1;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute2;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute3;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute4;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute5;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute6;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute7;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute8;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute9;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute10;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute11;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute12;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute13;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute14;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute15;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute16;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute17;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute18;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute19;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute20;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute21;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute22;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute23;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute24;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute25;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute26;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute27;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute28;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute29;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute30;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute31;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute32;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute33;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute34;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute35;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute36;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute37;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute38;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute39;
    }

    public static class Property15 {
        @JacksonXmlProperty (isAttribute = true)
        public int attribute1;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute2;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute3;
    }

    public static class Property16 {
        @JacksonXmlProperty (isAttribute = true)
        public int attribute1;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute2;
    }

    public static class StringDeclaration {
        @JacksonXmlProperty (isAttribute = true)
        public int stringIndex;
        @JacksonXmlProperty (isAttribute = true)
        public int attribute2;
    }

    public static class StringDefinition {
        @JacksonXmlProperty (isAttribute = true)
        public String language;
        @JacksonXmlProperty (isAttribute = true)
        public int stringTableIndex;
    }

    @JacksonXmlProperty (isAttribute = true)
    public int fps;

    @JacksonXmlElementWrapper (localName = "defineGroups")
    @JacksonXmlProperty (localName = "defineGroup")
    public DefineGroup[] defineGroups;
    @JacksonXmlElementWrapper (localName = "groupTimings")
    @JacksonXmlProperty (localName = "groupTiming")
    public GroupTiming[] groupTimings;
    @JacksonXmlElementWrapper (localName = "timingIndices")
    @JacksonXmlProperty (localName = "timingIndex")
    public TimingIndex[] timingIndices;
    @JacksonXmlElementWrapper (localName = "keyframeTimings")
    @JacksonXmlProperty (localName = "keyframeTiming")
    public KeyframeTiming[] keyframeTimings;
    @JacksonXmlElementWrapper (localName = "keyframes")
    @JacksonXmlProperty (localName = "keyframe")
    public Keyframe[] keyframes;
    @JacksonXmlElementWrapper (localName = "imageProperties")
    @JacksonXmlProperty (localName = "imageProperties")
    public ImageProperties[] imageProperties;
    @JacksonXmlElementWrapper (localName = "property7s")
    @JacksonXmlProperty (localName = "property7")
    public Property7[] property7s;
    @JacksonXmlElementWrapper (localName = "property8s")
    @JacksonXmlProperty (localName = "property8")
    public Property8[] property8s;
    @JacksonXmlElementWrapper (localName = "property9s")
    @JacksonXmlProperty (localName = "property9")
    public Property9[] property9s;
    @JacksonXmlElementWrapper (localName = "timedEvents")
    @JacksonXmlProperty (localName = "property10")
    public TimedEvent[] timedEvents;
    @JacksonXmlElementWrapper (localName = "unused1")
    @JacksonXmlProperty (localName = "unused1")
    public Byte[] unused1;
    @JacksonXmlElementWrapper (localName = "property11s")
    @JacksonXmlProperty (localName = "property11")
    public Property11[] property11s;
    @JacksonXmlElementWrapper (localName = "unused2")
    @JacksonXmlProperty (localName = "unused2")
    public Byte[] unused2;
    @JacksonXmlElementWrapper (localName = "unused3")
    @JacksonXmlProperty (localName = "unused3")
    public Byte[] unused3;
    @JacksonXmlElementWrapper (localName = "unused4")
    @JacksonXmlProperty (localName = "unused4")
    public Byte[] unused4;
    @JacksonXmlElementWrapper (localName = "property12s")
    @JacksonXmlProperty (localName = "property12s")
    public Property12[] property12s;
    @JacksonXmlElementWrapper (localName = "property13s")
    @JacksonXmlProperty (localName = "property13s")
    public Property13[] property13s;
    @JacksonXmlElementWrapper (localName = "property14s")
    @JacksonXmlProperty (localName = "property14s")
    public Property14[] property14s;
    @JacksonXmlElementWrapper (localName = "property15s")
    @JacksonXmlProperty (localName = "property15s")
    public Property15[] property15s;
    @JacksonXmlElementWrapper (localName = "imageStringTableIndices")
    @JacksonXmlProperty (localName = "imageStringTableIndices")
    public Integer[] imageStringTableIndices;
    @JacksonXmlElementWrapper (localName = "soundStringTableIndices")
    @JacksonXmlProperty (localName = "soundStringTableIndices")
    public Integer[] soundStringTableIndices;
    @JacksonXmlElementWrapper (localName = "particleStringTableIndices")
    @JacksonXmlProperty (localName = "particleStringTableIndices")
    public Integer[] particleStringTableIndices;
    @JacksonXmlElementWrapper (localName = "XMLDataStringTableIndices")
    @JacksonXmlProperty (localName = "XMLDataStringTableIndices")
    public Integer[] XMLDataStringTableIndices;
    @JacksonXmlElementWrapper (localName = "groupNameStringTableIndices")
    @JacksonXmlProperty (localName = "groupNameStringTableIndices")
    public Integer[] groupNameStringTableIndices;
    @JacksonXmlElementWrapper (localName = "property16s")
    @JacksonXmlProperty (localName = "property16s")
    public Property16[] property16s;
    @JacksonXmlElementWrapper (localName = "stringDeclarations")
    @JacksonXmlProperty (localName = "stringDeclarations")
    public StringDeclaration[] stringDeclarations;
    @JacksonXmlElementWrapper (localName = "stringDefinitions")
    @JacksonXmlProperty (localName = "stringDefinitions")
    public StringDefinition[] stringDefinitions;
    @JacksonXmlElementWrapper (localName = "stringTable")
    @JacksonXmlProperty (localName = "string")
    public String[] stringTable;

}
