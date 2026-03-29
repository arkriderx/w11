package com.vikiner.w11.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vikiner.w11.R;
import com.vikiner.w11.model.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder> {

    private List<Player> playerList = new ArrayList<>();

    public void setData(List<Player> playerList) {
        this.playerList = playerList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_player, parent, false);
        return new PlayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder holder, int position) {
        Player player = playerList.get(position);
        holder.tvName.setText(player.getName());
        holder.tvPosition.setText("Position: " + player.getPosition());
        holder.tvTeam.setText("Team: " + player.getTeam());
    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }

    static class PlayerViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvPosition, tvTeam;

        public PlayerViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvPlayerName);
            tvPosition = itemView.findViewById(R.id.tvPlayerPosition);
            tvTeam = itemView.findViewById(R.id.tvPlayerTeam);
        }
    }
}
