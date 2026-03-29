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
import com.vikiner.w11.adapter.MatchAdapter;
import com.vikiner.w11.model.Match;

import java.util.ArrayList;
import java.util.List;

public class MatchesFragment extends Fragment {

    private static MatchesFragment instance;
    private MatchAdapter adapter;

    public static MatchesFragment getInstance() {
        if (instance == null) instance = new MatchesFragment();
        return instance;
    }

    public void updateData(List<Match> matches) {
        if (adapter != null) adapter.setData(matches);
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
        adapter = new MatchAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setData(new ArrayList<>());
    }
}
