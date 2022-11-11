package com.example.blockchainillustration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonHash,buttonBlock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(MainActivity.this,NewBlockChainActivity.class));

        bindComponents();
        addListeners();
    }

    private void addListeners() {
        this.buttonHash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,HashActivity.class);
                startActivity(intent);
            }
        });
        this.buttonBlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,BlockActivity.class);
                startActivity(intent);
            }
        });
    }

    private void bindComponents() {
        this.buttonBlock = findViewById(R.id.button_block);
        this.buttonHash = findViewById(R.id.button_hash);
    }
}