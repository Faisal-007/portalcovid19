package com.example.portalcovid_19;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class RumahSakitAdapter extends RecyclerView.Adapter<RumahSakitAdapter.ListViewHolder> {
    private ArrayList<RumahSakit> listRumahSakit;
    private OnItemClickCallback onItemClickCallback;

    public RumahSakitAdapter(ArrayList<RumahSakit> list){
        this.listRumahSakit = list;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallBack){
        this.onItemClickCallback = onItemClickCallBack;
    }

    @NonNull
    @Override
    public RumahSakitAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rs,viewGroup,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RumahSakitAdapter.ListViewHolder holder, int position) {
        final RumahSakit rumahsakit = listRumahSakit.get(position);
        Glide.with(holder.itemView.getContext())
                .load(rumahsakit.getFotoRS())
                .apply(new RequestOptions().override(55,55))
                .into(holder.fotoRumahSakit);
        holder.namaRS.setText(rumahsakit.getNamaRS());
        holder.alamatRS.setText(rumahsakit.getAlamatRS());
        holder.koordinatRS.setText("Koordinat : " + rumahsakit.getKoordinatRS());
        holder.teleponRS.setText("Telepon : " + rumahsakit.getNomorRS());

        holder.btnTelepon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + rumahsakit.getNomorRS()));
                v.getContext().startActivity(intent);
            }
        });

        holder.btnPeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://maps.google.com/maps?daddr=" + rumahsakit.getKoordinatRS()));
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listRumahSakit.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView fotoRumahSakit;
        TextView namaRS,alamatRS,koordinatRS,teleponRS;
        Button btnPeta,btnTelepon;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            fotoRumahSakit = itemView.findViewById(R.id.foto_rs);
            namaRS = itemView.findViewById(R.id.nama_rs);
            alamatRS = itemView.findViewById(R.id.alamat_rs);
            koordinatRS = itemView.findViewById(R.id.koordinat_rs);
            teleponRS = itemView.findViewById(R.id.telepon_rs);
            btnPeta = itemView.findViewById(R.id.btn_peta);
            btnTelepon = itemView.findViewById(R.id.btn_telepon);

        }
    }

    public interface OnItemClickCallback{
        void onItemClicked(RumahSakit data);
    }
}
