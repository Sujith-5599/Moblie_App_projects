package com.example.ex4alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {
    private MediaPlayer mediaPlayer;

    @Override
    public void onReceive(Context context, Intent intent) {
        mediaPlayer = MediaPlayer.create(context, R.raw.jailer);
        mediaPlayer.start();
        Toast.makeText(context, "Alarm... Get up!", Toast.LENGTH_LONG).show();
    }
}

