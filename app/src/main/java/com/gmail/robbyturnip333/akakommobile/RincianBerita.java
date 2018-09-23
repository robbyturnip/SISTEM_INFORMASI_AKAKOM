package com.gmail.robbyturnip333.akakommobile;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by robby on 1/6/18.
 */

public class RincianBerita extends AppCompatActivity {

    public static final String EXTRA_POSITION = "position";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rincianberita);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);


        int postion = getIntent().getIntExtra(EXTRA_POSITION, 0);
        Resources resources = getResources();
        String[] judul = resources.getStringArray(R.array.judulberita);
        TextView jud = (TextView) findViewById(R.id.judul);
        jud.setText(judul[postion % judul.length]);
        collapsingToolbar.setTitle("Berita");

        String[] rincian = resources.getStringArray(R.array.rincian_deskripsi_berita);
        TextView det = (TextView) findViewById(R.id.rincian);
        det.setText(rincian[postion % rincian.length]);

        String[] tanggal = resources.getStringArray(R.array.tanggalberita);
        TextView tgl =  (TextView) findViewById(R.id.tanggal);
        tgl.setText(tanggal[postion % tanggal.length]);

        String[] penulis = resources.getStringArray(R.array.penulis);
        TextView pen = (TextView) findViewById(R.id.penulis);
        pen.setText(penulis[postion % penulis.length]);

        TypedArray gambar= resources.obtainTypedArray(R.array.gambar_berita);
        ImageView gam = (ImageView) findViewById(R.id.foto);
        gam.setImageDrawable(gambar.getDrawable(postion % gambar.length()));

        gambar.recycle();
    }
}

