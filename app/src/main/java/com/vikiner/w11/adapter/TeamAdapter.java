package com.vikiner.w11.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vikiner.w11.R;
import com.vikiner.w11.model.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {

    private List<Team> teamList = new ArrayList<>();

    public void setData(List<Team> teamList) {
        this.teamList = teamList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team, parent, false);
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        Team team = teamList.get(position);
        holder.tvName.setText(team.getName());
        holder.tvCountry.setText("Country: " + team.getCountry());
        holder.tvLeague.setText("League: " + team.getLeague());
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    static class TeamViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvCountry, tvLeague;

        public TeamViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvTeamName);
            tvCountry = itemView.findViewById(R.id.tvTeamCountry);
            tvLeague = itemView.findViewById(R.id.tvTeamLeague);
        }
    }
}
