package com.khilman.www.kumpulanwidget.activity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.khilman.www.kumpulanwidget.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListViewActivity extends AppCompatActivity {
    // Buat data array
    String[] arrayNamaBuah = {"Alpukat", "Apel", "Ceri", "Durian", "Jambu Air", "Manggis", "Strawberry"};
    int[] arrayGambarBuah = {R.drawable.alpukat1, R.drawable.apel1, R.drawable.ceri1, R.drawable.duriani, R.drawable.jambuairi, R.drawable.manggisi, R.drawable.strawberrya};
    int[] arraySuaraBuah = {R.raw.alpukat, R.raw.apel, R.raw.ceri, R.raw.durian, R.raw.jambuair, R.raw.manggis, R.raw.strawberry};
    @BindView(R.id.listView)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ButterKnife.bind(this);
        // Buat class ListBuahAdapter dan bawa 3 parameter : context, namabuah, gambarbuah
        ListBuahAdapter adapter = new ListBuahAdapter(this, arrayNamaBuah, arrayGambarBuah);
        // Set adapter ke list view
        listView.setAdapter(adapter);
        // event ketika item di klik
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posisi, long l) {
                // perintah kita apa
                // putar audio
               putarSuara(posisi);

            }
        });

    }
    public void putarSuara(int position) {
        // Panggil Media Player Class
        MediaPlayer mediaPlayer = MediaPlayer.create(this, arraySuaraBuah[position]);
        // Putar audio
        mediaPlayer.start();
    }

    // Class Adapter List view
    private class ListBuahAdapter extends BaseAdapter {

        // Global variable untuk menampung data dari Konstruktor
        String[] namaBuah;
        int[] gambarBuah;
        Context context;

        // Konstruktor untuk menangkap data dari Class Pemanggil
        public ListBuahAdapter(Context context, String[] arrayNamaBuah, int[] arrayGambarBuah) {
            // Data yg di bawa kita set ke Global variable
            this.namaBuah = arrayNamaBuah;
            this.gambarBuah = arrayGambarBuah;
            this.context = context;
        }

        @Override
        public int getCount() {
            return namaBuah.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {

            View v = convertView;
            // Buat layour inflater
            LayoutInflater inflater = LayoutInflater.from(context);
            // Inflate layout yang tadi kita buat
            v = inflater.inflate(R.layout.item_buah, null);

            ImageView ivGambarBuah = (ImageView) v.findViewById(R.id.ivBuah);
            TextView tvNamaBuah = (TextView) v.findViewById(R.id.tvNamaBuah);

            tvNamaBuah.setText(namaBuah[position]);
            ivGambarBuah.setImageResource(gambarBuah[position]);
            return v;
        }
    }
}
