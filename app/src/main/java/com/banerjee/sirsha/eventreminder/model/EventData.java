package com.banerjee.sirsha.eventreminder.model;

/**
 * Created by indianic on 16/2/18.
 */

public class EventData {

    private String eventName = "";
    private String eventTime = "";
    private String eventDate = "";
    private String eventRepeatMode = "";

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventRepeatMode() {
        return eventRepeatMode;
    }

    public void setEventRepeatMode(String eventRepeatMode) {
        this.eventRepeatMode = eventRepeatMode;
    }
}
