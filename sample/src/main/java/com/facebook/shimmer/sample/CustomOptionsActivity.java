package com.facebook.shimmer.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.facebook.shimmer.Shimmer;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomOptionsActivity extends Activity implements AdapterView.OnItemSelectedListener {

    // Array with animation options.
    public static final String[] animationOptions = {
            "Left To Right",
            "Top To Bottom",
            "Right To Left",
            "Bottom To Top"
    };
    Shimmer shimmer;
    // Array list for spinner
    ArrayList<String> animationOptionList = new ArrayList<>();
    // Global objects.
    private Spinner shimmerAnimationSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_options);
        shimmerAnimationSpinner = findViewById(R.id.spinner_shimmer_animation);

        // Adding all the options for spinner.
        animationOptionList.addAll(Arrays.asList(animationOptions));

        ArrayAdapter<String> animationAdapter = new ArrayAdapter<>(this
                , android.R.layout.simple_spinner_item, animationOptionList);

        // Drop down layout style - list view with radio button
        animationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        shimmerAnimationSpinner.setAdapter(animationAdapter);

        //shimmer = new Shimmer();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Toast.makeText(this, "Please Select some options", Toast.LENGTH_SHORT).show();
    }
}
