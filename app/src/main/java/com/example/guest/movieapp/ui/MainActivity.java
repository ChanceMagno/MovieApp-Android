package com.example.guest.movieapp.ui;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.guest.movieapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.submitTitleButton)
    FloatingActionButton mSubmitTitleButton;
    @Bind(R.id.movieTitleInput)
    EditText mMovieTitleInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSubmitTitleButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mSubmitTitleButton) {
            String title = mMovieTitleInput.getText().toString();
            Intent intent = new Intent(MainActivity.this, MovieActivity.class);
            intent.putExtra("title", title);
            startActivity(intent);
        }
    }
}
