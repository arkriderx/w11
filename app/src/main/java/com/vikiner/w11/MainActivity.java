package com.vikiner.w11;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.vikiner.w11.adapter.MainPagerAdapter;
import com.vikiner.w11.fragments.MatchesFragment;
import com.vikiner.w11.fragments.PlayersFragment;
import com.vikiner.w11.fragments.TeamsFragment;
import com.vikiner.w11.model.Match;
import com.vikiner.w11.model.Player;
import com.vikiner.w11.model.Team;
import com.vikiner.w11.provider.DataProvider;
import com.vikiner.w11.repository.MatchRepository;
import com.vikiner.w11.repository.PlayerRepository;
import com.vikiner.w11.repository.TeamRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private EditText etSearch;
    private Spinner spinnerSort;

    private TeamRepository teamRepository;
    private PlayerRepository playerRepository;
    private MatchRepository matchRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        etSearch = findViewById(R.id.etSearch);
        spinnerSort = findViewById(R.id.spinnerSort);

        setupRepositories();
        setupViewPager();
        setupSpinner();
        setupSearch();

        updateCurrentTabData("");
    }

    private void setupRepositories() {
        DataProvider provider = new DataProvider();

        teamRepository = new TeamRepository();
        playerRepository = new PlayerRepository();
        matchRepository = new MatchRepository();

        provider.createSampleTeams().forEach(teamRepository::add);
        provider.createSamplePlayers().forEach(playerRepository::add);
        provider.createSampleMatches().forEach(matchRepository::add);
    }

    private void setupViewPager() {
        viewPager.setAdapter(new MainPagerAdapter(this));

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setText("Teams");
                            break;
                        case 1:
                            tab.setText("Players");
                            break;
                        case 2:
                            tab.setText("Matches");
                            break;
                    }
                }).attach();

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                updateCurrentTabData(etSearch.getText().toString());
            }
        });
    }

    private void setupSpinner() {
        String[] sortOptions = {"Name A-Z", "Name Z-A"};
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                sortOptions
        );
        spinnerSort.setAdapter(spinnerAdapter);

        spinnerSort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateCurrentTabData(etSearch.getText().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }

    private void setupSearch() {
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateCurrentTabData(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void updateCurrentTabData(String query) {
        int currentTab = viewPager.getCurrentItem();
        String sortOption = spinnerSort.getSelectedItem().toString();

        switch (currentTab) {
            case 0:
                List<Team> teams = teamRepository.filter(team ->
                        team.getName().toLowerCase().contains(query.toLowerCase()) ||
                                team.getCountry().toLowerCase().contains(query.toLowerCase()) ||
                                team.getLeague().toLowerCase().contains(query.toLowerCase()));

                teams = sortTeams(teams, sortOption);
                TeamsFragment.getInstance().updateData(teams);
                break;

            case 1:
                List<Player> players = playerRepository.filter(player ->
                        player.getName().toLowerCase().contains(query.toLowerCase()) ||
                                player.getPosition().toLowerCase().contains(query.toLowerCase()) ||
                                player.getTeam().toLowerCase().contains(query.toLowerCase()));

                players = sortPlayers(players, sortOption);
                PlayersFragment.getInstance().updateData(players);
                break;

            case 2:
                List<Match> matches = matchRepository.filter(match ->
                        match.getName().toLowerCase().contains(query.toLowerCase()) ||
                                match.getScore().toLowerCase().contains(query.toLowerCase()));

                matches = sortMatches(matches, sortOption);
                MatchesFragment.getInstance().updateData(matches);
                break;
        }
    }

    private List<Team> sortTeams(List<Team> teams, String option) {
        if (option.equals("Name Z-A")) {
            teams.sort((a, b) -> b.getName().compareToIgnoreCase(a.getName()));
        } else {
            teams.sort((a, b) -> a.getName().compareToIgnoreCase(b.getName()));
        }
        return teams;
    }

    private List<Player> sortPlayers(List<Player> players, String option) {
        if (option.equals("Name Z-A")) {
            players.sort((a, b) -> b.getName().compareToIgnoreCase(a.getName()));
        } else {
            players.sort((a, b) -> a.getName().compareToIgnoreCase(b.getName()));
        }
        return players;
    }

    private List<Match> sortMatches(List<Match> matches, String option) {
        if (option.equals("Name Z-A")) {
            matches.sort((a, b) -> b.getName().compareToIgnoreCase(a.getName()));
        } else {
            matches.sort((a, b) -> a.getName().compareToIgnoreCase(b.getName()));
        }
        return matches;
    }
}