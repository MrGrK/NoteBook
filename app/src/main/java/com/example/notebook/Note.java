package com.example.notebook;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Date;

public class Note implements Parcelable {

    private String fTitle;
    private String fText;
    private String fDate;

    public Note(String pTitle, String pText, String pDate) {
        setfText(pText);
        setfTitle(pTitle);
        setfDate(pDate.toString());
    }

    protected Note(Parcel in) {
        fTitle = in.readString();
        fText = in.readString();
        fDate = in.readString();
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

    public String getfTitle() {
        return fTitle;
    }

    public void setfTitle(String pTitle) {
        fTitle = pTitle;
    }

    public String getfText() {
        return fText;
    }

    public void setfText(String pText) {
        fText = pText;
    }

    public String getfDate() {
        return fDate;
    }

    public void setfDate(String pDate) {
        fDate = pDate;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fTitle);
        dest.writeString(fText);
        dest.writeString(fDate.toString());
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
