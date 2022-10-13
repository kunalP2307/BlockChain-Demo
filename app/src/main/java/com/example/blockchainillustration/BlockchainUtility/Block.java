package com.example.blockchainillustration.BlockchainUtility;

public class Block {
    private int blockNo;
    private int nonce;
    private String data;
    private String hash;


    public Block(){

    }

    public Block(int blockNo,String data){
        this.blockNo = blockNo;
        this.data = data;
    }

    public int getBlockNo() {
        return blockNo;
    }

    public void setBlockNo(int blockNo) {
        this.blockNo = blockNo;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

}
