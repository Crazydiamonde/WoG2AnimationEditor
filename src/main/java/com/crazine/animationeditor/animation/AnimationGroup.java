package com.crazine.animationeditor.animation;

import com.crazine.animationeditor.FinalBinAnimation;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class AnimationGroup extends AnimationObject {

    @JacksonXmlProperty(isAttribute = true)
    public int durationFrames;

    @JacksonXmlProperty(isAttribute = true)
    public int unknown1;

    @JacksonXmlElementWrapper(localName = "elements", useWrapping = false)
    public AnimationSection[] animationSections;

    @JacksonXmlElementWrapper(localName = "events", useWrapping = false)
    @JacksonXmlProperty(localName = "Event")
    public AnimationEvent[] animationEvents;


    public AnimationGroup(FinalBinAnimation binAnimation, int animationGroupIndex) {

        FinalBinAnimation.AnimationGroup animationGroup = binAnimation.animationGroups[animationGroupIndex];

        durationFrames = animationGroup.duration1;

        unknown1 = animationGroup.duration2;

        animationSections = new AnimationSection[animationGroup.sectionLength];
        for (int sectionIndex = 0; sectionIndex < animationGroup.sectionLength; sectionIndex++) {
            int animationSectionIndex = sectionIndex + animationGroup.sectionOffset;
            animationSections[sectionIndex] = new AnimationSection(binAnimation, animationSectionIndex);
        }

        animationEvents = new AnimationEvent[animationGroup.eventLength];
        for (int eventIndex = 0; eventIndex < animationGroup.eventLength; eventIndex++) {
            int animationEventIndex = eventIndex + animationGroup.eventOffset;
            animationEvents[eventIndex] = new AnimationEvent(binAnimation, animationEventIndex);
        }

    }

}
