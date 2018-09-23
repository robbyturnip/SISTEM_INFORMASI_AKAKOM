package com.gmail.robbyturnip333.akakommobile;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by robby on 1/6/18.
 */
public class Berita extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);
        ContentAdapter adapter = new ContentAdapter(recyclerView.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return recyclerView;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView gambar;
        public ImageView gambarAdmin;
        public TextView judul;
        public TextView penjelasan;
        public TextView tanggal;
        public TextView penulis;

        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.berita, parent, false));
            gambar = (ImageView) itemView.findViewById(R.id.gambarBerita);
            judul = (TextView) itemView.findViewById(R.id.judulberita);
            penjelasan = (TextView) itemView.findViewById(R.id.penjelasan);
            gambarAdmin = (ImageView) itemView.findViewById(R.id.gambarAdmin);
            tanggal = (TextView) itemView.findViewById(R.id.tanggalberita);
            penulis = (TextView) itemView.findViewById(R.id.penulisberita);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, RincianBerita.class);
                    intent.putExtra(RincianBerita.EXTRA_POSITION, getAdapterPosition());
                    context.startActivity(intent);
                }
            });

            ImageButton favoriteImageButton = (ImageButton) itemView.findViewById(R.id.baca);
            favoriteImageButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, RincianBerita.class);
                    intent.putExtra(RincianBerita.EXTRA_POSITION, getAdapterPosition());
                    context.startActivity(intent);
                }
            });

            ImageButton shareImageButton = (ImageButton) itemView.findViewById(R.id.sebar);
            shareImageButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent sebar=new Intent(Intent.ACTION_SEND);
                    sebar.setType("text/plain");
                    String diskripsi="deskripsi";
                    String tujuan="tujuan";
                    sebar.putExtra(Intent.EXTRA_SUBJECT,tujuan);
                    sebar.putExtra(Intent.EXTRA_TEXT,diskripsi);
                    context.startActivity(Intent.createChooser(sebar,"Sebar Pakai"));
                }
            });
        }
    }

    /**
     * Adapter to display recycler view.
     */
    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        // Set numbers of Card in RecyclerView.
        private static final int LENGTH = 6;

        private final String[] judul;
        private final String[] penjelasan;
        private final String[] penulis;
        private final String[] tanggal;
        private final Drawable[] gambarAdmin;
        private final Drawable[] gambar;

        public ContentAdapter(Context context) {
            Resources resources = context.getResources();
            judul = resources.getStringArray(R.array.judulberita);
            penjelasan = resources.getStringArray(R.array.deskripsi_awal_berita);
            penulis= resources.getStringArray(R.array.penulis);
            tanggal = resources.getStringArray(R.array.tanggalberita);
            TypedArray b = resources.obtainTypedArray(R.array.gambarAdmin);
            gambarAdmin = new Drawable[b.length()];
            for (int i = 0; i < gambarAdmin.length; i++) {
                gambarAdmin[i] = b.getDrawable(i);
            }
            b.recycle();
            TypedArray a = resources.obtainTypedArray(R.array.gambar_berita);
            gambar = new Drawable[a.length()];
            for (int i = 0; i < gambar.length; i++) {
                gambar[i] = a.getDrawable(i);
            }
            a.recycle();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.gambar.setImageDrawable(gambar[position % gambar.length]);
            holder.judul.setText(judul[position % judul.length]);
            holder.penjelasan.setText(penjelasan[position % penjelasan.length]);
            holder.gambarAdmin.setImageDrawable(gambarAdmin[position % gambarAdmin.length]);
            holder.penulis.setText(penulis[position % penulis.length]);
            holder.tanggal.setText(tanggal[position % tanggal.length]);
        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }
    }
}

