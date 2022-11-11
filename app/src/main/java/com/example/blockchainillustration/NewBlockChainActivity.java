package com.example.blockchainillustration;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NewBlockChainActivity extends AppCompatActivity implements TextWatcher {
    private static final int CHAIN_SIZE = 5;
    EditText editTextData1,editTextData2;
    Button buttonMine[];
    EditText editTextBlockNo[],editTextNonce[],editTextData[];
    TextView textViewPrev[],textViewtHash[];
    View viewBlock[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_block_chain);
        editTextData1 = findViewById(R.id.edit_text_data_block_5);
        editTextData2 = findViewById(R.id.edit_text_data_block_5);
        Toast.makeText(this, editTextData1.getText().toString()+editTextData2.getText().toString(), Toast.LENGTH_SHORT).show();
        View view = findViewById(R.id.layout_block_cell_5);
        view.setBackgroundColor(Color.rgb(255, 204, 204));

        bindComponents();

    }

    private void bindComponents() {
        initComponents();

        editTextBlockNo[0] = findViewById(R.id.edit_text_block_no_block_1);
        editTextBlockNo[1] = findViewById(R.id.edit_text_block_no_block_2);
        editTextBlockNo[2] = findViewById(R.id.edit_text_block_no_block_3);
        editTextBlockNo[3] = findViewById(R.id.edit_text_block_no_block_4);
        editTextBlockNo[4] = findViewById(R.id.edit_text_block_no_block_5);

        editTextNonce[0] = findViewById(R.id.edit_text_nonce_block_1);
        editTextNonce[1] = findViewById(R.id.edit_text_nonce_block_2);
        editTextNonce[2] = findViewById(R.id.edit_text_nonce_block_3);
        editTextNonce[3] = findViewById(R.id.edit_text_nonce_block_4);
        editTextNonce[4] = findViewById(R.id.edit_text_nonce_block_5);

        editTextData[0] = findViewById(R.id.edit_text_data_block_1);
        editTextData[1] = findViewById(R.id.edit_text_data_block_2);
        editTextData[2] = findViewById(R.id.edit_text_data_block_3);
        editTextData[3] = findViewById(R.id.edit_text_data_block_4);
        editTextData[4] = findViewById(R.id.edit_text_data_block_5);

        textViewtHash[0] = findViewById(R.id.text_area_hash_block_1);
        textViewtHash[1] = findViewById(R.id.text_area_hash_block_2);
        textViewtHash[2] = findViewById(R.id.text_area_hash_block_3);
        textViewtHash[3] = findViewById(R.id.text_area_hash_block_4);
        textViewtHash[4] = findViewById(R.id.text_area_hash_block_5);

        textViewPrev[0] = findViewById(R.id.text_area_prev_block_1);
        textViewPrev[1] = findViewById(R.id.text_area_prev_block_2);
        textViewPrev[2] = findViewById(R.id.text_area_prev_block_3);
        textViewPrev[3] = findViewById(R.id.text_area_prev_block_4);
        textViewPrev[4] = findViewById(R.id.text_area_prev_block_5);

        buttonMine[0] = findViewById(R.id.button_mine_block_1);
        buttonMine[1] = findViewById(R.id.button_mine_block_2);
        buttonMine[2] = findViewById(R.id.button_mine_block_3);
        buttonMine[3] = findViewById(R.id.button_mine_block_4);
        buttonMine[4] = findViewById(R.id.button_mine_block_5);

        viewBlock[0] = findViewById(R.id.layout_block_cell_1);
        viewBlock[1] = findViewById(R.id.layout_block_cell_2);
        viewBlock[2] = findViewById(R.id.layout_block_cell_3);
        viewBlock[3] = findViewById(R.id.layout_block_cell_4);
        viewBlock[4] = findViewById(R.id.layout_block_cell_5);


        for(int i=0; i<5; i++){
            int finalI = i;
            buttonMine[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(NewBlockChainActivity.this, ""+ finalI, Toast.LENGTH_SHORT).show();
                }
            });
            editTextData[i].addTextChangedListener(this);
            viewBlock[i].setBackgroundColor(Color.rgb(255, 204, 204));
        }
    }

    private void initComponents() {
        editTextBlockNo = new EditText[CHAIN_SIZE];
        editTextData = new EditText[CHAIN_SIZE];
        editTextNonce = new EditText[CHAIN_SIZE];
        textViewtHash = new TextView[CHAIN_SIZE];
        textViewPrev = new TextView[CHAIN_SIZE];
        buttonMine = new Button[CHAIN_SIZE];
        viewBlock = new View[CHAIN_SIZE];
    }

    private void textChanged(int i){
        changedMinedStatusOwnwords(i);
    }

    private void changedMinedStatusOwnwords(int i){

    }
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        for (int i = 0; i < CHAIN_SIZE; i++) {
            if (editable == editTextData[i].getEditableText()) {
                textChanged(i);
                break;
            }
        }
    }
}