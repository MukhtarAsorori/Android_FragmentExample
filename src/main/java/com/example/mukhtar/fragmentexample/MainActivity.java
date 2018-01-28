package com.example.mukhtar.fragmentexample;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ListFragment.ItemClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListFragment fragment = new ListFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.frame_layout_master, fragment)
                .commit();

        if (findViewById(R.id.frame_layout_detail) != null) {
            showDetailFragment();
        }
    }

    @Override
    public void itemClicked(CharSequence message, int background)
    {
        if (findViewById(R.id.frame_layout_detail) == null) {
            Intent intent = DetailActivity.newIntent(this, message, background);
            startActivity(intent);
        }else{
            DetailFragment fragment = DetailFragment.newFragment(message, background);
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .add(R.id.frame_layout_detail, fragment)
                    .commit();
        }
    }

    private void showDetailFragment()
    {
        DetailFragment fragment = DetailFragment.newFragment(this.getString(R.string.top), R.color.volite_100);
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.frame_layout_detail, fragment)
                .commit();
    }

}// MainActivity
