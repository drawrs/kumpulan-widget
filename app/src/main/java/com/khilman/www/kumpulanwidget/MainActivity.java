package com.khilman.www.kumpulanwidget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.khilman.www.kumpulanwidget.activity.ListViewActivity;
import com.khilman.www.kumpulanwidget.activity.MessageBoxActivity;
import com.khilman.www.kumpulanwidget.activity.RadioActivity;
import com.khilman.www.kumpulanwidget.activity.SpinnerActivity;
import com.khilman.www.kumpulanwidget.activity.VideoActivity;
import com.khilman.www.kumpulanwidget.activity.ViewPagerActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btnSpinner)
    Button btnSpinner;
    @BindView(R.id.btnListView)
    Button btnListView;
    @BindView(R.id.btnMsgBox)
    Button btnMsgBox;
    @BindView(R.id.btnViewPager)
    Button btnViewPager;
    @BindView(R.id.btnVideo)
    Button btnVideo;
    @BindView(R.id.btnRadio)
    Button btnRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnSpinner)
    public void onBtnSpinnerClicked() {
        // perintah
        startActivity(new Intent(this, SpinnerActivity.class));
    }

    @OnClick(R.id.btnListView)
    public void onBtnListViewClicked() {
        // Perintah
        startActivity(new Intent(this, ListViewActivity.class));
    }

    @OnClick(R.id.btnMsgBox)
    public void onBtnMsgBoxClicked() {
        // perintah
        startActivity(new Intent(this, MessageBoxActivity.class));
    }

    @OnClick(R.id.btnViewPager)
    public void onViewPagerClicked() {
        // perintah
        startActivity(new Intent(this, ViewPagerActivity.class));
    }


    @OnClick(R.id.btnVideo)
    public void onBtnVideoClicked() {
        startActivity(new Intent(this, VideoActivity.class));
    }

    @OnClick(R.id.btnRadio)
    public void onBtnRadioClicked() {
        startActivity(new Intent(this, RadioActivity.class));

    }
}
