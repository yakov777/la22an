package com.yak7.la22an;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.yak7.la22an.entities.GameSettings;
import com.yak7.la22an.entities.Worddl;

import java.util.ArrayList;
import java.util.List;

public class SettingsActivity extends AppCompatActivity {
    public static final String TAG = SettingsActivity.class.getSimpleName();
    public static final String EXTRA_SETTINGS = "SETTINGS";
    private Spinner gameLengthSpinner;
    private RadioGroup worlddlRadioGroup;
    private int id=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        gameLengthSpinner = findViewById(R.id.gameLengthSpinner);
        worlddlRadioGroup = findViewById(R.id.worddlRadioGroup);
        GameSettings gameSettings = getIntent().getParcelableExtra(EXTRA_SETTINGS);
        List<GameLength> gameLengths = getAvailableGameLengths();
   initSpinner(gameLengths);
  initRadioButtons(savedInstanceState == null ? gameSettings.getWorddl() : null);
        if (savedInstanceState == null)
        {
            int selectedPosition = getGameLengthPosition(gameLengths, gameSettings.getSeconds());
            gameLengthSpinner.setSelection(selectedPosition);
        }
        findViewById(R.id.saveButton).setOnClickListener(v -> {
            GameLength selestedGameLength = (GameLength) gameLengthSpinner.getSelectedItem();
        int selectedRadioButtonId = worlddlRadioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = worlddlRadioGroup.findViewById(selectedRadioButtonId);
        Worddl worddl = (Worddl) radioButton.getTag();
        GameSettings updateGameSettings = new GameSettings(selestedGameLength.seconds, worddl);
            Log.d(TAG, "Settings has been update: " + updateGameSettings);
            Intent intent = new Intent();
            intent.putExtra(EXTRA_SETTINGS, updateGameSettings);
            setResult(RESULT_OK, intent);
            finish();
        });
    }

    private void initRadioButtons(@Nullable Worddl activeWorddl)  {
for (Worddl worddl : GameSettings.AVAILABLE_WORDDL)
{
    RadioButton radioButton = new RadioButton(this);
        radioButton.setId(++id);
        radioButton.setText(getString(R.string.worlddl_value, worddl.getD1()));
        radioButton.setTag(worddl);
        if (worddl.equals(activeWorddl)) {radioButton.setChecked(true);}
        worlddlRadioGroup.addView(radioButton);
}

    }


    private void initSpinner(List<GameLength> availableGameLengths){
    ArrayAdapter<GameLength> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,
            availableGameLengths);
  gameLengthSpinner.setAdapter(adapter);

  }
    private List<GameLength> getAvailableGameLengths() {
     List<GameLength> list = new ArrayList<>();
     for (int seconds : GameSettings.AVAILABLE_GAME_LENGTHS)
     {  GameLength length = new GameLength(seconds, getString(R.string.length_value, seconds ));
    list.add(length);
            }
     return list;
    }

    private int getGameLengthPosition(List<GameLength> list, int seconds)
    {
     for (int i = 0; i < list.size(); i++) {
    if (list.get(i).seconds == seconds) return i;
     }
     return 0;
    }

    static class GameLength {
        private int seconds;
        private String humanReadableTitle;

        GameLength(int seconds, String humanReadableTitle) {
            this.seconds = seconds;
            this.humanReadableTitle = humanReadableTitle;
        }

        @NonNull
        @Override
        public String toString() {
            return humanReadableTitle;
        }
    }

}
