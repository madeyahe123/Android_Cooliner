package com.latihan.cooliner;

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

public class CardViewFoodAdapter {


    public class CardViewHeroAdapter extends RecyclerView.Adapter<CardViewHeroAdapter.CardViewViewHolder> {
        private ArrayList<Food> listFood;

        public CardViewFoodAdapter(ArrayList<Food> list) {
            this.listFood = list;
        }


        @NonNull
        @Override
        public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.jawatimur, viewGroup, false);
            return new CardViewViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final CardViewViewHolder holder, int position) {

            final Food hero = listFood.get(position);

            Glide.with(holder.itemView.getContext())
                    .load(hero.getPhoto())
                    .apply(new RequestOptions().override(350, 550))
                    .into(holder.imgPhoto);

            holder.tvName.setText(hero.getName());
            holder.tvDetail.setText(hero.getDetail());

            holder.btnFavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(holder.itemView.getContext(), "Favorite " +
                            listFood.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
                }
            });

            holder.btnShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(holder.itemView.getContext(), "Share " +
                            listFood.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
                }
            });

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(holder.itemView.getContext(), "Share " +
                            listFood.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return listFood.size();
        }

        public class CardViewViewHolder extends RecyclerView.ViewHolder {
            ImageView imgPhoto;
            TextView tvName, tvDetail;
            Button btnFavorite, btnShare;

            public CardViewViewHolder(View itemView) {
                super(itemView);
                imgPhoto = itemView.findViewById(R.id.img_item_photo);
                tvDetail = itemView.findViewById(R.id.tv_item_detail);
                tvName = itemView.findViewById(R.id.tv_item_name);
                btnFavorite = itemView.findViewById(R.id.btn_set_favorite);
                btnShare = itemView.findViewById(R.id.btn_set_share);
            }
        }

    }
}
