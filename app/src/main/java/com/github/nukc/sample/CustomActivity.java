package com.github.nukc.sample;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.github.nukc.stateview.StateView;

public class CustomActivity extends AppCompatActivity {

    private StateView mStateView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear_layout);

        mStateView = StateView.inject(linearLayout);
        mStateView.setEmptyResource(R.layout.view_empty);
        mStateView.setRetryResource(R.layout.view_retry);

        mStateView.setOnRetryClickListener(new StateView.OnRetryClickListener() {
            @Override
            public void onRetryClick() {
                //do something
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.menu_inject, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.show_empty:
                mStateView.showEmpty();
                break;
            case R.id.show_retry:
                mStateView.showRetry();
                break;
            case R.id.show_loading:
                mStateView.showLoading();
                break;
            case R.id.show_content:
                mStateView.showContent();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
