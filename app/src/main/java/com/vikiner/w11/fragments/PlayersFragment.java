package com.vikiner.w11.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vikiner.w11.R;
import com.vikiner.w11.adapter.PlayerAdapter;
import com.vikiner.w11.model.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayersFragment extends Fragment {

    private static PlayersFragment instance;
    private PlayerAdapter adapter;

    public static PlayersFragment getInstance() {
        if (instance == null) instance = new PlayersFragment();
        return instance;
    }

    public void updateData(List<Player> players) {
        if (adapter != null) adapter.setData(players);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter = new PlayerAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setData(new ArrayList<>());
    }
}