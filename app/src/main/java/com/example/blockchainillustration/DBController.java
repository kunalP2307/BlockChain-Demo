package com.example.blockchainillustration;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.blockchainillustration.BlockchainUtility.Block;

import java.util.List;

public class DBController extends SQLiteOpenHelper {

    String sql;
    SQLiteDatabase sqLiteDatabase;
    final String TAG = "DBController";

    public DBController(Context context) {
        super(context, "blockchain.db", null, 1);
        sqLiteDatabase = this.getWritableDatabase();
        Log.d(TAG, "DBController: Connection Established.! :"+sqLiteDatabase);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sql = "CREATE TABLE IF NOT EXISTS BlockChain " +
                "(blockNo INT," +
                "nonce INT," +
                "data TEXT," +
                "hash TEXT,"+
                "prev TEXT)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sql = "DROP TABLE IF EXISTS BlockChain";
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }

    public int reWriteChain(List<Block> blockList){

        ContentValues contentValues = new ContentValues();
        long updateCount = 0;

        sqLiteDatabase.execSQL("delete from BlockChain");
        
        for(int i=0; i<blockList.size(); i++){
            contentValues.put("blockNo",blockList.get(i).getBlockNo());
            contentValues.put("nonce",blockList.get(i).getNonce());
            contentValues.put("data",blockList.get(i).getData());
            contentValues.put("hash",blockList.get(i).getData());
            contentValues.put("prev",blockList.get(i).getPrev());
            try {
                updateCount = sqLiteDatabase.insertOrThrow("BlockChain", null, contentValues);
            }catch (SQLiteConstraintException e){
                Log.d(TAG, "insertRecord: inside catch");
                return -2;
            }
        }
        return (int)updateCount;

    }
}
