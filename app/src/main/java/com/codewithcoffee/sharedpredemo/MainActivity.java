package com.codewithcoffee.sharedpredemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.codewithcoffee.sharedpredemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = binding.etValue.getText().toString();
                SharedPreferences preferences = getSharedPreferences("msg",MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("tb",message);
                editor.apply();

                binding.tvDisplay.setText(message);
            }
        });

//        Get the value of Shared Preferences Back
        SharedPreferences reader = getSharedPreferences("msg",MODE_PRIVATE);
        String read = reader.getString("tb","Empty");
        binding.tvDisplay.setText(read);


    }
}