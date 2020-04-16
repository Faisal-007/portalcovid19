package com.example.portalcovid_19;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class artikelAdapter extends RecyclerView.Adapter<artikelAdapter.ListViewHolder> {
    private ArrayList<artikel> listArtikel;
    private OnItemClickCallback onItemClickCallback;

    public artikelAdapter(ArrayList<artikel> list){
        this.listArtikel = list;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallBack){
        this.onItemClickCallback = onItemClickCallBack;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_artikel,viewGroup,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        artikel Artikel = listArtikel.get(position);
        Glide.with(holder.itemView.getContext())
                .load(Artikel.getFotoProfil())
                .apply(new RequestOptions().override(55,55))
                .into(holder.fotoArtikel);
        holder.judulArtikel.setText(Artikel.getJudul());
        holder.isiArtikel.setText(Artikel.getIsi());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listArtikel.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listArtikel.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        ImageView fotoArtikel;
        TextView judulArtikel,isiArtikel;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            fotoArtikel = itemView.findViewById(R.id.foto_artikel);
            judulArtikel = itemView.findViewById(R.id.judul_artikel);
            isiArtikel = itemView.findViewById(R.id.isi_artikel);
        }
    }

    public interface OnItemClickCallback{
        void onItemClicked(artikel data);
    }
}
