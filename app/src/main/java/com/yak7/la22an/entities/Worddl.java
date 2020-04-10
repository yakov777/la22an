package com.yak7.la22an.entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Objects;

public class Worddl implements Parcelable {
    private final int d1;


    public Worddl(int d1) {
        this.d1 = d1;

    }

    public int getD1() {
        return d1;
    }


    @Override
    public String toString() {
        return "Worddl{" +
                "d1=" + d1 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worddl worddl = (Worddl) o;
        return d1 == worddl.d1;
    }

    @Override
    public int hashCode() {
        return Objects.hash(d1);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.d1);
    }

    protected Worddl(Parcel in) {
        this.d1 = in.readInt();
    }

    public static final Parcelable.Creator<Worddl> CREATOR = new Parcelable.Creator<Worddl>() {
        @Override
        public Worddl createFromParcel(Parcel source) {
            return new Worddl(source);
        }

        @Override
        public Worddl[] newArray(int size) {
            return new Worddl[size];
        }
    };
}
