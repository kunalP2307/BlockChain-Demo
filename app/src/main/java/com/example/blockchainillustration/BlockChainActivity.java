package com.example.blockchainillustration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.blockchainillustration.BlockchainUtility.Block;
import com.example.blockchainillustration.BlockchainUtility.Miner;

import java.util.ArrayList;
import java.util.List;

public class BlockChainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private BCAdapter bcAdapter;
    private List<Block> blockList = new ArrayList<>();
    private final static int chainSize = 6;
    String TAG = "BlockChainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_block_chain);

        recyclerView = findViewById(R.id.recyclerView);
        bcAdapter = new BCAdapter(blockList, new ClickListener() {
            @Override
            public void onPositionClicked(int position) {
                View view = recyclerView.getChildAt(position);
                if(view != null){
                    String prev = "0000000000000000000000000000000000000000000000000000000000000000";
                    Block block = blockList.get(position);
                    String data = block.getData();
                    if(position != 0)
                        prev = blockList.get(position-1).getHash();

                    Block minedBLock = Miner.mineBlockWithPrev(block,prev);

                    blockList.get(position).setData(data);
                    blockList.get(position).setPrev(prev);
                    blockList.get(position).setNonce(minedBLock.getNonce());
                    blockList.get(position).setHash(minedBLock.getHash());
                    blockList.get(position).setMinedStatus(true);
                    bcAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void textChanged(int position) {
                /*Toast.makeText(BlockChainActivity.this, "changed", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "textChanged: ");*/
                //Toast.makeText(BlockChainActivity.this, position, Toast.LENGTH_SHORT).show();

                View view = recyclerView.getChildAt(position);
                if(view != null){
                    EditText editTextData;
                    editTextData = view.findViewById(R.id.edit_text_data_block);
                    String data = editTextData.getText().toString();
                    if(!data.equals("")){
                        Toast.makeText(BlockChainActivity.this, data, Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "textChanged: data found");
                        blockList.get(position).setData(data);
                        recyclerView.post(new Runnable() {
                            @Override
                            public void run() {
                                bcAdapter.notifyDataSetChanged();
                            }
                        });
                        for(int i=position; i<blockList.size(); i++) {
                            blockList.get(i).setMinedStatus(false);
                            recyclerView.post(new Runnable() {
                                @Override
                                public void run() {
                                    bcAdapter.notifyDataSetChanged();
                                }
                            });
                        }
                    }
                }
            }
        });
        bcAdapter.notifyDataSetChanged();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(bcAdapter);
        prepareDate();
        Log.d(TAG, "onCreate: ");
    }

    private void prepareDate() {
        String prev = "0000000000000000000000000000000000000000000000000000000000000000";
        Log.d(TAG, ":prepareDate ");
        for (int i = 0; i < chainSize; i++) {
            Block block = new Block();
            block.setBlockNo(i);
            block.setData("");
            block.setPrev(prev);
            Block minedBlock = Miner.mineBlockWithPrev(block,prev);
            block.setHash(minedBlock.getHash());
            block.setPrev(prev);
            block.setNonce(minedBlock.getNonce());
            prev = minedBlock.getHash();
            blockList.add(block);
        }
        //bcAdapter.notifyDataSetChanged();
    }

//    private void mineBlock(int blockNo){
//        EditText editTextBlockNo,editTextData,editTextNonce;
//        TextView textViewPrev,textViewHash;
//        View view  = recyclerView.getChildAt(blockNo);
//
//        editTextBlockNo = findViewById(R.id.edit_text_block_block_no_cell);
//        editTextData = findViewById(R.id.edit_text_block_data_cell);
//        editTextNonce = findViewById(R.id.edit_text_block_nonce_cell);
//        textViewPrev = findViewById(R.id.text_area_block_prev_cell);
//        textViewHash = findViewById(R.id.text_area_block_hash_cell);
//
//
//        Block block = new Block();
//        block.setBlockNo(Integer.parseInt(editTextBlockNo.getText().toString()));
//        block.setData(editTextData.getText().toString());
//        block.setPrev(editTextNonce.getText().toString());
//        block.setPrev(textViewPrev.getText().toString());
//
//        //Block minedBLock = Miner.mineBlockWithPrev(block);
//
//        //textViewHash.setText(minedBLock.getHash());
//        editTextNonce.setText(Integer.toString(minedBLock.getNonce()));
//
//        //alertNextBlocs(blockNo++);
//        recyclerView = findViewById(R.id.recyclerView);
//        view = recyclerView.getChildAt(blockNo + 1);
//        if(view != null){
//            View viewBlock = view.findViewById(R.id.layout_block_cell_new);
//            viewBlock.setBackgroundColor(Color.rgb(255,204,204));
//        }
//    }

    private void alertNextBlocs(int blockNo){
        for(int i=blockNo; i<chainSize; i++){

        }
    }
    /*
    private void initBlockChain(){
        Log.d(TAG, "initBlockChain: ");

        View view;
        EditText editTextBlockNo,editTextData;
        TextView textViewPrev,textViewHash,textViewPrevOfNext;
        String prev;
        Block block;
        for(int i=0; i<chainSize; i++){

            view = recyclerView.getChildAt(i);
            if(view != null) {
                Log.d(TAG, "initBlockChain: ");
                editTextBlockNo = view.findViewById(R.id.edit_text_block_block_no_cell);
                editTextData = view.findViewById(R.id.edit_text_block_data_cell);
                textViewPrev = view.findViewById(R.id.text_area_block_prev_cell);
                textViewHash = view.findViewById(R.id.text_area_block_hash_cell);

                block = new Block();
                block.setBlockNo(Integer.parseInt(editTextBlockNo.getText().toString()));
                block.setData(editTextData.getText().toString());
                block.setPrev(textViewPrev.getText().toString());

                Block minedBlock = Miner.mineBlockWithPrev(block);
                textViewHash.setText(minedBlock.getHash());

                if (i != chainSize - 1) {
                    view = recyclerView.getChildAt(i + 1);
                    textViewPrevOfNext = view.findViewById(R.id.text_area_block_prev_cell);
                    textViewPrevOfNext.setText(minedBlock.getHash());
                }
            }
        }
    }
    */
}