package com.holden.birdwatcher;

import android.os.Parcel;
import android.os.Parcelable;

public class Bird implements Parcelable {

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Bird createFromParcel(Parcel in) {
            return new Bird(in);
        }

        public Bird[] newArray(int size) {
            return new Bird[size];
        }
    };
    private int birdId;
    private BirdSize size;
    private String name;
    private String sciName;
    private ConStatus conStatus;
    private String iconFileName;

    public Bird(int birdId, BirdSize size, String name, String sciName, ConStatus conStatus, String iconFileName) {
        this.birdId = birdId;
        this.size = size;
        this.name = name;
        this.sciName = sciName;
        this.conStatus = conStatus;
        this.iconFileName = iconFileName;
    }

    public Bird(Parcel in) {
        this.birdId = in.readInt();
        this.size = size.valueOf(in.readString());
        this.name = in.readString();
        this.sciName = in.readString();
        this.conStatus = conStatus.valueOf(in.readString());
        this.iconFileName = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(birdId);
        out.writeString(this.size.name());
        out.writeString(name);
        out.writeString(sciName);
        out.writeString(this.conStatus.name());
        out.writeString(iconFileName);
    }

    public int getBirdId() {
        return birdId;
    }

    public BirdSize getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public String getSciName() {
        return sciName;
    }

    public ConStatus getConStatus() {
        return conStatus;
    }

    public String getIconFileName() {
        return iconFileName;
    }
}
