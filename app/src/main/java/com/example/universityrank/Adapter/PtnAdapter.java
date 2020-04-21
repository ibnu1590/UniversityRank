package com.example.universityrank.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.universityrank.Model.Ptn;
import com.example.universityrank.R;


import java.util.ArrayList;

public class PtnAdapter extends RecyclerView.Adapter<PtnAdapter.ListViewHolder> {
    public interface OnItemClickCallback {
        void onItemClicked(Ptn ptn);
    }

    private OnItemClickCallback onItemClickCallback;
    private ArrayList<Ptn> listPtn;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public PtnAdapter(ArrayList<Ptn> listPtn) {
        this.listPtn = listPtn;
    }

    @NonNull
    @Override
    public PtnAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ptn, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PtnAdapter.ListViewHolder holder, int position) {
        Ptn ptn = listPtn.get(position);
        Glide.with(holder.itemView.getContext())
                .load(ptn.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);

        holder.tvName.setText(ptn.getName());
        holder.tvRank.setText(ptn.getRank());
        holder.tvDetail.setText(ptn.getDetail());
        holder.tvWeb.setText(ptn.getWeb());
        holder.tvAddress.setText(ptn.getAddress());
        holder.tvTelp.setText(ptn.getTelp());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listPtn.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return listPtn.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvRank, tvDetail, tvWeb, tvAddress, tvTelp;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRank = itemView.findViewById(R.id.tv_item_rank);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
            tvWeb = itemView.findViewById(R.id.tv_item_web);
            tvAddress = itemView.findViewById(R.id.tv_item_address);
            tvTelp = itemView.findViewById(R.id.tv_item_telp);
        }
    }
}
