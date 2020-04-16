package com.example.portalcovid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class artikelDetail extends AppCompatActivity{

    public static final String JUDUL = "JUDUL";
    public static final String ISI = "ISI";
    public static final String FOTO_ARTIKEL = "FOTO ARTIKEL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artikel_detail);
        getWindow().setStatusBarColor(Color.rgb(222,26,26));
        TextView tvJudul, tvIsi;
        ImageView fotoArtikel,tombolKembali;

        tvJudul = findViewById(R.id.detail_judul_artikel);
        tvIsi = findViewById(R.id.detail_isi_artikel);
        fotoArtikel = findViewById(R.id.detail_foto_artikel);

        String judul = getIntent().getStringExtra(JUDUL);
        String isi = getIntent().getStringExtra(ISI);
        int foto = getIntent().getIntExtra(FOTO_ARTIKEL,0);

        tvJudul.setText(judul);
        tvIsi.setText(isi);
        fotoArtikel.setImageResource(foto);
    }

}
