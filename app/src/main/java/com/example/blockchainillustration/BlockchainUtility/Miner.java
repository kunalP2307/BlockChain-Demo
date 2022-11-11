package com.example.blockchainillustration.BlockchainUtility;

import android.util.Log;

public class Miner {
    public static final int miningDifficulty = 3;

    public static Block mineBlock(Block block){
        String data = block.getData();
        int blockNo = block.getBlockNo();
        String hash = "";
        int nonce = 0;

        while(true){
            hash = SHACalculator.getSHA256(blockNo+data+nonce);
            Log.d("Miner", "mineBlock: "+"  "+data+hash+"   "+nonce);
            if(hash.charAt(0) == '0' && hash.charAt(1) == '0' && hash.charAt(2) == '0' && hash.charAt(3) == '0') {
                System.out.println(hash);
                System.out.println(nonce);
                Log.d("Miner", "mineBlock: "+hash +"\t"+nonce);
                break;
            }
            nonce++;
        }
        block.setNonce(nonce);
        block.setHash(hash);
        return block;
    }

    public static Block mineBlockWithPrev(Block block,String prev){
        String data = block.getData();
        int blockNo = block.getBlockNo();
        String hash = "";
        int nonce = 0;

//        && hash.charAt(2) == '0' && hash.charAt(3) == '0'
        while(true){
            hash = SHACalculator.getSHA256(blockNo+data+prev+nonce);
            Log.d("Miner", "mineBlock: "+"  "+data+hash+"   "+nonce);
            if(hash.charAt(0) == '0' && hash.charAt(1) == '0') {
                System.out.println(hash);
                System.out.println(nonce);
                Log.d("Miner", "mineBlock: "+hash +"\t"+nonce);
                break;
            }
            nonce++;
        }
        block.setNonce(nonce);
        block.setHash(hash);
        return block;
    }
}
