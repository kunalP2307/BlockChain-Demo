package com.example.blockchainillustration.BlockchainUtility;

public class Block {
    private int blockNo;
    private int nonce;
    private String data;
    private String hash;
    private String prev;

    public Block(){

    }

    public Block(int blockNo,String data){
        this.blockNo = blockNo;
        this.data = data;
    }

    public Block(int blockNo, int nonce, String data, String hash, String prev) {
        this.blockNo = blockNo;
        this.nonce = nonce;
        this.data = data;
        this.hash = hash;
        this.prev = prev;
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

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }


}
