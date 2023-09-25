package com.funix.lab6_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicViewHolder>{
    private List<Music> mlist;
    private Context mContext;

    public MusicAdapter(Context mContext, List<Music>list) {
        this.mContext = mContext;
        this.mlist=list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.item_song,parent,false);
        return new MusicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicViewHolder holder, int position) {
        Music item=mlist.get(position);
        holder.tvName.setText(item.getMusicName());

    }

    @Override
    public int getItemCount() {
            return this.mlist.size();
    }

    public class MusicViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        public MusicViewHolder(@NonNull View itemView) {
            super(itemView);
           tvName=itemView.findViewById(R.id.tv_song);
        }
    }
}
