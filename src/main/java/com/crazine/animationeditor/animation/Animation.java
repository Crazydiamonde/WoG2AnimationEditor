package com.crazine.animationeditor.animation;

import com.crazine.animationeditor.BinAnimation;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.io.IOException;
import java.io.StringWriter;

public class Animation {

    @JacksonXmlProperty(isAttribute = true)
    public int fps;

    @JacksonXmlElementWrapper(localName = "states", useWrapping = false)
    @JacksonXmlProperty(localName = "state")
    public AnimationState[] animationStates;


    public Animation(BinAnimation binAnimation) {

        fps = binAnimation.fps;

        int animationStateIndex = 0;
        animationStates = new AnimationState[binAnimation.defineGroups.length];
        for (BinAnimation.DefineGroup defineGroup : binAnimation.defineGroups) {

            AnimationState animationState = new AnimationState();

            animationState.name = binAnimation.getString(binAnimation.stringDefinitions[
                    binAnimation.groupNameStringTableIndices[animationStateIndex]].stringTableIndex);
            animationState.globalId = defineGroup.globalId;
            animationState.localId = defineGroup.localId;
            BinAnimation.GroupTiming groupTiming = binAnimation.groupTimings[defineGroup.uid];
            animationState.durationFrames = groupTiming.durationFrames;
            animationState.unknown1 = groupTiming.unknown1;

            animationState.animationSections = new AnimationSection[groupTiming.timingIndexLength];
            animationState.animationEvents = new AnimationEvent[groupTiming.timedEventLength];

            animationGroup(animationState.animationSections, animationState.animationEvents, binAnimation, defineGroup.uid);

            animationStates[animationStateIndex] = animationState;
            animationStateIndex++;

        }

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        xmlMapper.enableDefaultTyping();
        StringWriter writer = new StringWriter();
        try {
            xmlMapper.writeValue(writer, this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(writer);

    }


    private void animationGroup(AnimationSection[] animationSections, AnimationEvent[] animationEvents, BinAnimation binAnimation, int animationGroupIndex) {

        BinAnimation.GroupTiming groupTiming = binAnimation.groupTimings[animationGroupIndex];

        for (int animationSectionIndex = 0; animationSectionIndex < groupTiming.timingIndexLength; animationSectionIndex++) {

            BinAnimation.TimingIndex timingIndex = binAnimation.timingIndices[groupTiming.timingIndexOffset + animationSectionIndex];

            AnimationSection animationSection = new AnimationSection();

            animationSection.group = timingIndex.group;
            animationSection.animationElements = new AnimationElement[timingIndex.timingLength];

            for (int animationElementIndex = 0; animationElementIndex < timingIndex.timingLength; animationElementIndex++) {

                BinAnimation.KeyframeTiming keyframeTiming = binAnimation.keyframeTimings[timingIndex.timingOffset + animationElementIndex];

                switch (keyframeTiming.sequenceId) {

                    case 0 -> {

                        AnimationBlank animationBlank = new AnimationBlank();

                        animationBlank.untilFrame = keyframeTiming.untilFrame;

                        animationSection.animationElements[animationElementIndex] = animationBlank;

                    }

                    case 1 -> {

                        BinAnimation.Keyframe keyframe = binAnimation.keyframes[keyframeTiming.keyframe];

                        AnimationKeyframe animationKeyframe = new AnimationKeyframe();

                        BinAnimation.GroupTiming groupTiming1 = binAnimation.groupTimings[keyframe.attribute1];
                        animationKeyframe.animationSections = new AnimationSection[groupTiming1.timingIndexLength];
                        animationKeyframe.animationEvents = new AnimationEvent[groupTiming1.timedEventLength];
                        animationGroup(animationKeyframe.animationSections, animationKeyframe.animationEvents, binAnimation, keyframe.attribute1);
                        animationKeyframe.untilFrame = keyframeTiming.untilFrame;
                        animationKeyframe.durationFrames = groupTiming1.durationFrames;
                        animationKeyframe.unknown1 = groupTiming1.unknown1;
                        animationKeyframe.unknown2 = keyframe.attribute2;
                        animationKeyframe.angleTopLeft = keyframe.angleTopLeft;
                        animationKeyframe.angleBottomRight = keyframe.angleBottomRight;
                        animationKeyframe.x1 = keyframe.x1;
                        animationKeyframe.y1 = keyframe.y1;
                        animationKeyframe.x2 = keyframe.x2;
                        animationKeyframe.y2 = keyframe.y2;
                        animationKeyframe.scaleX = keyframe.scaleX;
                        animationKeyframe.scaleY = keyframe.scaleY;
                        animationKeyframe.colorize = keyframe.colorize;
                        animationKeyframe.unknown3 = keyframe.attribute12;

                        animationSection.animationElements[animationElementIndex] = animationKeyframe;

                    }

                    case 2 -> {

                        BinAnimation.ImageProperties imageProperties = binAnimation.imageProperties[keyframeTiming.keyframe];

                        AnimationPart animationPart = new AnimationPart();

                        animationPart.untilFrame = keyframeTiming.untilFrame;
                        animationPart.image = binAnimation.getString(binAnimation.stringDefinitions[
                                binAnimation.imageStringTableIndices[imageProperties.imageIndex]].stringTableIndex);
                        animationPart.angleTopLeft = imageProperties.angleTopLeft;
                        animationPart.angleBottomRight = imageProperties.angleBottomRight;
                        animationPart.centerX = imageProperties.centerX;
                        animationPart.centerY = imageProperties.centerY;
                        animationPart.offsetX = imageProperties.offsetX;
                        animationPart.offsetY = imageProperties.offsetY;
                        animationPart.scaleX = imageProperties.scaleX;
                        animationPart.scaleY = imageProperties.scaleY;
                        animationPart.colorize = imageProperties.colorize;
                        animationPart.unknown1 = imageProperties.attribute11;

                        animationSection.animationElements[animationElementIndex] = animationPart;

                    }

                    case 3 -> {

                        BinAnimation.Property9 property9 = binAnimation.property9s[keyframeTiming.keyframe];

                        AnimationProperty9 animationProperty9 = new AnimationProperty9();

                        animationProperty9.untilFrame = keyframeTiming.untilFrame;
                        animationProperty9.attribute1 = property9.attribute1;
                        animationProperty9.attribute2 = property9.attribute2;
                        animationProperty9.attribute3 = property9.attribute3;
                        animationProperty9.attribute4 = property9.attribute4;
                        animationProperty9.attribute5 = property9.attribute5;
                        animationProperty9.attribute6 = property9.attribute6;
                        animationProperty9.attribute7 = property9.attribute7;

                        animationSection.animationElements[animationElementIndex] = animationProperty9;

                    }

                    case 4 -> {

                        BinAnimation.Property8 property8 = binAnimation.property8s[keyframeTiming.keyframe];

                        AnimationProperty8 animationProperty8 = new AnimationProperty8();

                        animationProperty8.untilFrame = keyframeTiming.untilFrame;
                        animationProperty8.unknown1 = property8.attribute1;
                        animationProperty8.unknown2 = property8.attribute2;

                        animationSection.animationElements[animationElementIndex] = animationProperty8;

                    }

                }

            }

            animationSections[animationSectionIndex] = animationSection;

        }

        for (int animationEventIndex = 0; animationEventIndex < groupTiming.timedEventLength; animationEventIndex++) {

            BinAnimation.TimedEvent timedEvent = binAnimation.timedEvents[groupTiming.timedEventOffset + animationEventIndex];

            AnimationEvent animationEvent = new AnimationEvent();

            animationEvent.groupId = timedEvent.groupId;
            animationEvent.active = timedEvent.active;
            animationEvent.delay = timedEvent.delay;

            animationEvents[animationEventIndex] = animationEvent;

        }

    }

}
