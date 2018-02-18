package com.khilman.www.kumpulanwidget.activity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.khilman.www.kumpulanwidget.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SpinnerActivity extends AppCompatActivity {
    // Buat data array
    String[] arrayNamaBuah = {"Alpukat", "Apel", "Ceri", "Durian", "Jambu Air", "Manggis", "Strawberry"};
    int[] arrayGambarBuah = {R.drawable.alpukat1, R.drawable.apel1, R.drawable.ceri1, R.drawable.duriani, R.drawable.jambuairi, R.drawable.manggisi, R.drawable.strawberrya};
    int[] arraySuaraBuah = {R.raw.alpukat, R.raw.apel, R.raw.ceri, R.raw.durian, R.raw.jambuair, R.raw.manggis, R.raw.strawberry};

    @BindView(R.id.spinnerBuah)
    Spinner spinnerBuah;
    @BindView(R.id.ivBuah)
    ImageView ivBuah;
    @BindView(R.id.tvNamaBuah)
    TextView tvNamaBuah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        ButterKnife.bind(this);

        // Buat adapterposition
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                                                                android.R.layout.simple_dropdown_item_1line,
                                                                arrayNamaBuah);
        // Set adapter ke Spinner
        spinnerBuah.setAdapter(adapter);
        // Event ketika item dari spinner di klik
        spinnerBuah.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                // Aksi jika item dipilih
                tvNamaBuah.setText(arrayNamaBuah[position]);
                ivBuah.setImageResource(arrayGambarBuah[position]);

                // Putar Suara
                putarSuara(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }

    public void putarSuara(int position) {
        // Panggil Media Player Class
        MediaPlayer mediaPlayer = MediaPlayer.create(this, arraySuaraBuah[position]);
        // Putar audio
        mediaPlayer.start();
    }

    @OnClick(R.id.ivBuah)
    public void onViewClicked() {
    }
}
