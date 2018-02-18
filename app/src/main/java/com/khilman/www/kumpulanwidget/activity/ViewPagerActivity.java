package com.khilman.www.kumpulanwidget.activity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.khilman.www.kumpulanwidget.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewPagerActivity extends AppCompatActivity {

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    String[] namaBuah = new SpinnerActivity().arrayNamaBuah;
    int[] gambarBuah = new SpinnerActivity().arrayGambarBuah;
    int[] suaraBuah = new SpinnerActivity().arraySuaraBuah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        ButterKnife.bind(this);

        // Buat adapter untuk View Pager
        ViewPagerAdaper adapter = new ViewPagerAdaper(this, namaBuah, gambarBuah, suaraBuah);
        // set adapter ke view pager
        viewPager.setAdapter(adapter);
    }

    private class ViewPagerAdaper extends PagerAdapter {
        // Buat variable penampung
        String[] namaBuah;
        int[] gambarBuah;
        int[] suaraBuah;
        Context context;
        public ViewPagerAdaper(Context ctx, String[] namaBuah, int[] gambarBuah, int[] suaraBuah) {
            // Inisialisasi vairable dngan data yangdi bawa boleh constructor
            this.namaBuah = namaBuah;
            this.gambarBuah = gambarBuah;
            this.suaraBuah = suaraBuah;
            this.context = ctx;
        }

        @Override
        public int getCount() {
            return namaBuah.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {

            return view == ((LinearLayout)object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.pager_item, null);

            // Inisialisasi widget
            ImageView ivGambarBuah = (ImageView) view.findViewById(R.id.ivGambarBuah);
            TextView tvNamaBuah = (TextView) view.findViewById(R.id.tvNamaBuah);
            // Set nilai ke wiget
            ivGambarBuah.setImageResource(gambarBuah[position]);
            tvNamaBuah.setText(namaBuah[position]);
            // event
            ivGambarBuah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // putar audio buah
                    putarSuara(position);
                }
            });
            // tambahan
            ((ViewPager)container).addView(view);
            return view;
        }
        public void putarSuara(int position) {
            // Panggil Media Player Class
            MediaPlayer mediaPlayer = MediaPlayer.create(context, suaraBuah[position]);
            // Putar audio
            mediaPlayer.start();
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager)container).removeView((LinearLayout)object);
        }
    }
}
