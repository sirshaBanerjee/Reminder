package com.banerjee.sirsha.eventreminder.activity;

import com.banerjee.sirsha.eventreminder.R;
import com.banerjee.sirsha.eventreminder.fragment.HomeFragment;

/**
 * Created by indianic on 15/2/18.
 */

public class HomeActivity extends BaseActivity {
    @Override
    protected int defineLayoutResource() {
        return R.layout.activity_home;
    }

    @Override
    protected void initializeComponents() {
        replaceFragment(R.id.activity_home_flContainer, getSupportFragmentManager(), new HomeFragment(), false);
    }
}
