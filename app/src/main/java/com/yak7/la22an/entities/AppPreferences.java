package com.yak7.la22an.entities;

import android.content.Context;
import android.content.SharedPreferences;

public class AppPreferences {
    public static final String EXTRA_SETTINGS = "SETTINGS";
    private GameSettings gameSettings;
    private static final String PREFERENCES_NAME = "WORD";
    private SharedPreferences preferences;

    public AppPreferences(Context context)
    {
        preferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);

    }
    public static final String[] WORDS1 = {"РАДИО", "КАША", "ЛИТИЙ", "НАТРИЙ",
             "ГАРАЖ", "СТЕК", "ПИЛОТ", "ЖЕЛЕЗО", "АЗОТ", "ТУМАН", "КИЕВ", "НЕЖИН",
            "КОТ", "КРОТ"};

    public static final String[] WORDS2 = {"МАДАГАСКАР","ЧЕРНИГОВ", "АНДРОИД", "МОЗАМБИК", "ПОЛИФЕНОЛ", "СТАНЦИЯ",
            "ВОЛЬФРАМ", "ПОЛИТИКА","МЕРКУРИЙ", "СИНОПТИК","ПРИЛУКИ","КАЛЬЦИЙ", "КОБАЛЬТ"};

    public static final String[] WORDS = {};

}