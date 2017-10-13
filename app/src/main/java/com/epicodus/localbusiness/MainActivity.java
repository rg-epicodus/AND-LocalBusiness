package com.epicodus.localbusiness;


import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.findDrinksButton) ImageButton mFindDrinksButton;
    @Bind(R.id.locationEditText) EditText mLocationEditText;
    @Bind(R.id.appNameTextView) TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface rubikFont = Typeface.createFromAsset(getAssets(), "fonts/rubikregular.ttf");
        mAppNameTextView.setTypeface(rubikFont);

        mFindDrinksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String location = mLocationEditText.getText().toString();
                Toast.makeText(MainActivity.this, "Find Drinks Clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, DrinksActivity.class);
                intent.putExtra("location", location);
                startActivity(intent);
            }
        });

    }
}
