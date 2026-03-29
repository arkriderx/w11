package com.vikiner.w11.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vikiner.w11.R;
import com.vikiner.w11.model.Match;

import java.util.ArrayList;
import java.util.List;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.MatchViewHolder> {

    private List<Match> matchList = new ArrayList<>();

    public void setData(List<Match> matchList) {
        this.matchList = matchList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_match, parent, false);
        return new MatchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchViewHolder holder, int position) {
        Match match = matchList.get(position);
        holder.tvTeams.setText(match.getName());
        holder.tvScore.setText("Score: " + match.getScore());
    }

    @Override
    public int getItemCount() {
        return matchList.size();
    }

    static class MatchViewHolder extends RecyclerView.ViewHolder {
        TextView tvTeams, tvScore;

        public MatchViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTeams = itemView.findViewById(R.id.tvMatchTeams);
            tvScore = itemView.findViewById(R.id.tvMatchScore);
        }
    }
}