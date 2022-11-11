package com.example.blockchainillustration;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.blockchainillustration.BlockchainUtility.Block;
import com.example.blockchainillustration.BlockchainUtility.Miner;

public class BlockActivity extends AppCompatActivity {
    EditText editTextBlockNo,editTextNonce,editTextData;
    TextView textViewHash;
    View viewBlock;
    Button buttonMine;
    ProgressBar progressBarMining;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_block);
        bindComponents();
        addListeners();

        buttonMine.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                progressBarMining.setVisibility(View.VISIBLE);
                initBlock();
                progressBarMining.setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        initBlock();
    }

    private void initBlock(){
        buttonMine.setText("Mining...");
        buttonMine.setEnabled(false);
        buttonMine.setBackgroundColor(Color.rgb(224,224,224));


        int blockNo = Integer.parseInt(editTextBlockNo.getText().toString());
        String data = editTextData.getText().toString();

        Block block = new Block(blockNo,data);
        block = Miner.mineBlock(block);
        textViewHash.setText(block.getHash());
        editTextNonce.setText(Integer.toString(block.getNonce()));
        changeBGCtoGreen();

        buttonMine.setText("Mine");
        buttonMine.setEnabled(true);
        buttonMine.setBackgroundColor(Color.rgb(102,102,255));

    }

    private void disableButton() {
        Log.d("BlockActivity", "disableButton: ");
        buttonMine.setText("Mining...");
        buttonMine.setEnabled(false);
        buttonMine.setBackgroundColor(Color.rgb(224,224,224));
    }

    private void enableButton(){
        buttonMine.setText("Mine");
        buttonMine.setEnabled(true);
        buttonMine.setBackgroundColor(Color.rgb(102,102,255));

    }
    private void addListeners() {
        editTextBlockNo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                changeBGCtoRed();
            }
        });
        editTextNonce.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                changeBGCtoRed();
            }
        });
        editTextData.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                changeBGCtoRed();
            }
        });
    }

    private void changeBGCtoRed() {
        viewBlock.setBackgroundColor(Color.rgb(255,204,204));
    }

    private void changeBGCtoGreen() {
        viewBlock.setBackgroundColor(Color.rgb(204,255,204));
    }

    private void bindComponents() {
        editTextBlockNo = findViewById(R.id.edit_text_block_no_block);
        editTextNonce = findViewById(R.id.edit_text_nonce_block);
        editTextData = findViewById(R.id.edit_text_data_block);
        textViewHash = findViewById(R.id.text_area_hash_block_5);
        viewBlock = findViewById(R.id.layout_block_cell_1);
        buttonMine = findViewById(R.id.button_block_mine_cell);
        progressBarMining = findViewById(R.id.progress_bar_mining);
    }
}