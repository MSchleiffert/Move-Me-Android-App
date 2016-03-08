package com.example.arjen.fblogin.Models;

import org.w3c.dom.Text;

/**
 * Created by Menno on 8-3-2016.
 */
public class Events {
    int eventId;
    String eventName;
    Text eventDescription;
    String evenLocation;

    public Events(String eventName, Text eventDescription, String evenLocation) {
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.evenLocation = evenLocation;
    }

    public int getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Text getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(Text eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEvenLocation() {
        return evenLocation;
    }

    public void setEvenLocation(String evenLocation) {
        this.evenLocation = evenLocation;
    }

}
