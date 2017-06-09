package com.krazzylabs.notes.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by DJ-KIRU-LAPPY on 15/05/2017.
 */

public class Note implements Parcelable{

    String key;
    Boolean isActive;

    String title;
    String body;
    String colour;
    ArrayList<String> label;
    String last_update;
    String status;


    // Default Constructor
    public Note() {
        this.setIsActive(false);
    }

    public Note(Note note) {
        this.key = note.getKey();
        this.isActive = note.getIsActive();
        this.title = note.getTitle();
        this.body = note.getBody();
        this.colour = note.getColour();
        this.label = note.getLabel();
        this.last_update = note.getLast_update();
        this.status = note.getStatus();
    }

    // Parameterized Constructor

    public Note(String title, String body, String colour, ArrayList<String> label, String last_update, String status) {
        this.title = title;
        this.body = body;
        this.colour = colour;
        this.label = label;
        this.last_update = last_update;
        this.status = status;
    }

    public Note(String key, String title, String body, String colour, ArrayList<String> label, String last_update, String status) {
        this.key = key;
        this.title = title;
        this.body = body;
        this.colour = colour;
        this.label = label;
        this.last_update = last_update;
        this.status = status;
    }

    // Getter and Setter

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public ArrayList<String> getLabel() {
        return label;
    }

    public void setLabel(ArrayList<String> label) {
        this.label = label;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addLabel(String newlabel){
        this.label.add(newlabel);
    }

    public void removeKey(){this.key = null;}

    public void removeIsActive(){this.isActive = null;}

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean keyExists(){
        Boolean flag = false;
        try {
            if(this.getKey()==null)
                flag = false;
            else
                flag = true;
        }catch (Exception e){
            flag = false;
        }
        return flag;
    }

    // Parcelable Implementation Methods

    public Note(Parcel source) {
        key = source.readString();
        title = source.readString();
        body = source.readString();
        colour = source.readString();
        //label = source.createStringArrayList();
        last_update = source.readString();
        status = source.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(key);
        parcel.writeString(title);
        parcel.writeString(body);
        parcel.writeString(colour);
        parcel.writeString(last_update);
        //parcel.writeStringList(label);
        parcel.writeString(status);

    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };
}
