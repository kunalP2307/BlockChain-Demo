package com.example.blockchainillustration;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blockchainillustration.BlockchainUtility.Block;

import java.lang.ref.WeakReference;
import java.util.List;

public class BCAdapter extends RecyclerView.Adapter<BCAdapter.BlockViewHolder> {
    private List<Block> blockList;
    private final ClickListener clickListener;

    class BlockViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        EditText blockNo, nonce,data;
        TextView hash,prev;
        View viewBlock;
        Button buttonMine;
        private WeakReference<ClickListener> listenerRef;

        BlockViewHolder(View view,ClickListener clickListener) {
            super(view);
            listenerRef = new WeakReference<>(clickListener);
            blockNo = view.findViewById(R.id.edit_text_block_block_no_cell);
            nonce = view.findViewById(R.id.edit_text_block_nonce_cell);
            data = view.findViewById(R.id.edit_text_block_data_cell);
            hash = view.findViewById(R.id.text_area_block_hash_cell);
            buttonMine = view.findViewById(R.id.button_block_mine_cell);
            viewBlock = view.findViewById(R.id.layout_block_cell_new);
            prev = view.findViewById(R.id.text_area_block_prev_cell);
            buttonMine.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            if(v.getId() == buttonMine.getId()){
                String text = data.getText().toString();
                Toast.makeText(v.getContext(), "heyyyyyyy"+text, Toast.LENGTH_SHORT).show();
            }
            listenerRef.get().onPositionClicked(getAdapterPosition());
        }
    }

    public BCAdapter(List<Block> blockList,ClickListener clickListener){
        this.blockList = blockList;
        this.clickListener = clickListener;
    }
    @NonNull
    @Override
    public BlockViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.block_cell, parent, false);
        return new BlockViewHolder(viewItem,clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull BlockViewHolder holder, int position) {
        Block block = blockList.get(position);
        holder.blockNo.setText(Integer.toString(block.getBlockNo()));
        holder.nonce.setText(Integer.toString(block.getNonce()));
        holder.data.setText(block.getData());
        holder.hash.setText(block.getHash());
        holder.prev.setText(block.getPrev());
        holder.viewBlock.setBackgroundColor(Color.rgb(204,255,204));
    }

    @Override
    public int getItemCount() {
        return blockList.size();
    }
}
