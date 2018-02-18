package com.khilman.www.kumpulanwidget.activity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.khilman.www.kumpulanwidget.R;
import com.wang.avi.AVLoadingIndicatorView;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RadioActivity extends AppCompatActivity {

    @BindView(R.id.btnPlayRadio)
    Button btnPlayRadio;
    @BindView(R.id.btnStopRadio)
    Button btnStopRadio;


    MediaPlayer mediaPlayer;
    @BindView(R.id.radioIndicator)
    AVLoadingIndicatorView radioIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        ButterKnife.bind(this);

        // disable btn Stop
        btnStopRadio.setEnabled(false);
    }

    @OnClick(R.id.btnPlayRadio)
    public void onBtnPlayRadioClicked() {
        // inisialisasi mediaPlayer
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource("http://103.16.198.36:9160/stream");
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    // mulai radionya
                    mediaPlayer.start();
                    // disable tombol play ketika radio berjalan
                    btnPlayRadio.setEnabled(false);
                    btnStopRadio.setEnabled(true);
                    // tampilkan aviloader
                    radioIndicator.setVisibility(View.VISIBLE);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.btnStopRadio)
    public void onBtnStopRadioClicked() {
        // stop radio
        mediaPlayer.stop();
        // enable button lagi
        btnPlayRadio.setEnabled(true);
        btnStopRadio.setEnabled(false);
        // sembunyikan avi loader
        radioIndicator.setVisibility(View.INVISIBLE);
    }
}
