package com.yak7.la22an;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.yak7.la22an.entities.GameSettings;

public class MenuActivity extends AppCompatActivity {
    private static final String KEY_SETTINGS = "SETTINGS";
    private static final String TAG = MenuActivity.class.getSimpleName();
    private static final int RQ_SETTINGS = 1;
    private GameSettings settings = GameSettings.DEFAULT;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        if (savedInstanceState != null) {
            settings = savedInstanceState.getParcelable(KEY_SETTINGS);
        }

        findViewById(R.id.settingsButton).setOnClickListener(v -> {
            Intent intent = new Intent(this, SettingsActivity.class);
            intent.putExtra(SettingsActivity.EXTRA_SETTINGS, settings);
            startActivityForResult(intent, RQ_SETTINGS);
        });

        findViewById(R.id.startGameButton).setOnClickListener(v -> {
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra(GameActivity.EXTRA_SETTINGS, settings);
           startActivity(intent);
        });
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(KEY_SETTINGS, settings);
    }
@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
{
    super.onActivityResult(requestCode,resultCode,data);
    if (requestCode == RQ_SETTINGS && resultCode == RESULT_OK) {
         settings = data.getParcelableExtra(SettingsActivity.EXTRA_SETTINGS);
        Log.d(TAG, "Got new settings" + settings);
    }
}
}
