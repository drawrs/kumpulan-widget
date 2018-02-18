package com.khilman.www.kumpulanwidget.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import com.khilman.www.kumpulanwidget.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MessageBoxActivity extends AppCompatActivity {

    @BindView(R.id.btnToast)
    Button btnToast;
    @BindView(R.id.btnAlert)
    Button btnAlert;
    @BindView(R.id.btnCustomAlert)
    Button btnCustomAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_box);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnToast)
    public void onBtnToastClicked() {
        // Menampilkan toast
        Toast.makeText(this, "Ini aku toast loh", Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.btnAlert)
    public void onBtnAlertClicked() {
        /// tmapilkan alert dialog
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Keluar");
        alert.setMessage("Anda yakin ingin keluar dari Aplikasi ?");

        alert.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // tampilkan toast
                Toast.makeText(MessageBoxActivity.this, "Ya dipilih", Toast.LENGTH_LONG).show();

            }
        });
        alert.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // tampilkan toast
                Toast.makeText(MessageBoxActivity.this, "Tidak dipilih", Toast.LENGTH_LONG).show();
            }   
        });
        alert.setNeutralButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // tampilkan toast
                Toast.makeText(MessageBoxActivity.this, "batal dipilih", Toast.LENGTH_LONG).show();
            }
        });



    }

    @OnClick(R.id.btnCustomAlert)
    public void onBtnCustomAlertClicked() {
    }
}
