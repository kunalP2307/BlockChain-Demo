package com.example.blockchainillustration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonHash,buttonBlock,buttonBlockChain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        this.buttonBlockChain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,NewBlockChainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void bindComponents() {
        this.buttonBlock = findViewById(R.id.button_block);
        this.buttonHash = findViewById(R.id.button_hash);
        this.buttonBlockChain = findViewById(R.id.button_block_chain);

    }
}