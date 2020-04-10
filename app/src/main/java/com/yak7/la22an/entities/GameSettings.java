package com.yak7.la22an.entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameSettings implements Parcelable {
    public static final List<Integer> AVAILABLE_GAME_LENGTHS = Arrays.asList(60, 120, 600);
    public static final List<Worddl> AVAILABLE_WORDDL = Arrays.asList(
            new Worddl(6),
            new Worddl(9)

    );
    public static final GameSettings DEFAULT = new GameSettings(
            AVAILABLE_GAME_LENGTHS.get(0),
            AVAILABLE_WORDDL.get(0)
    );
    private int seconds;
    private Worddl worddl;

    public GameSettings(int seconds, Worddl worddl) {
        this.seconds = seconds;
        this.worddl = worddl;
    }

    public int getSeconds() {
        return seconds;
    }

    public Worddl getWorddl() {
        return worddl;
    }

    @Override
    public String toString() {
        return "GameSettings{" +
                "seconds=" + seconds +
                ", worddl=" + worddl +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.seconds);
        dest.writeParcelable(this.worddl, flags);
    }

    protected GameSettings(Parcel in) {
        this.seconds = in.readInt();
        this.worddl = in.readParcelable(Worddl.class.getClassLoader());
    }

    public static final Parcelable.Creator<GameSettings> CREATOR = new Parcelable.Creator<GameSettings>() {
        @Override
        public GameSettings createFromParcel(Parcel source) {
            return new GameSettings(source);
        }

        @Override
        public GameSettings[] newArray(int size) {
            return new GameSettings[size];
        }
    };
}
