package com.vikiner.w11.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.vikiner.w11.fragments.MatchesFragment;
import com.vikiner.w11.fragments.PlayersFragment;
import com.vikiner.w11.fragments.TeamsFragment;

public class MainPagerAdapter extends FragmentStateAdapter {

    public MainPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return TeamsFragment.getInstance();
            case 1:
                return PlayersFragment.getInstance();
            default:
                return MatchesFragment.getInstance();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
