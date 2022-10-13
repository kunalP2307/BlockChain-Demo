
package com.example.blockchainillustration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.example.blockchainillustration.BlockchainUtility.SHACalculator;

public class HashActivity extends AppCompatActivity {
    private TextView textViewHash;
    private EditText editTextData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hash);
        getSupportActionBar().setTitle("SHA256 Hash");  // provide compatibility to all the versions
        bindComponents();
        addListeners();
    }

    private void addListeners() {
        editTextData.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String data = editTextData.getText().toString();
                String hash = SHACalculator.getSHA256(data);
                textViewHash.setText(hash);
            }
        });
    }

    private void bindComponents() {
        this.textViewHash = findViewById(R.id.text_area_hash_hash);
        this.editTextData = findViewById(R.id.text_area_hash_data);
    }
}