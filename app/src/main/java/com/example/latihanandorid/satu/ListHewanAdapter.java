package com.example.latihanandorid.satu;

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


public class ListHewanAdapter extends RecyclerView.Adapter<ListHewanAdapter.ListViewHolder> {

    private ArrayList<Hewan> listHewan;

    public ListHewanAdapter(ArrayList<Hewan> list) {
        this.listHewan = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
       View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid_hewan, viewGroup, false);

        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Hewan hewan = listHewan.get(position);
        Glide.with(holder.itemView.getContext())
                .load(hewan.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);

    }

    @Override
    public int getItemCount() {
        return listHewan.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
                ImageView imgPhoto;

        public ListViewHolder(@NonNull  View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
