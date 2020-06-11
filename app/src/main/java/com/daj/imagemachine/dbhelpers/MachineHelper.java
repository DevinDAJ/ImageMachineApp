package com.daj.imagemachine.dbhelpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.daj.imagemachine.models.Machine;

import static com.daj.imagemachine.dbhelpers.DBContract.TABLE_MACHINE;
import static com.daj.imagemachine.dbhelpers.DBContract.machineTableColums;

public class MachineHelper {
    private static final String DB_TABLE = TABLE_MACHINE;
    private static DBHelper dbHelper;
    private static MachineHelper INSTANCE;

    private static SQLiteDatabase database;

    public MachineHelper(Context context) {
        dbHelper = new DBHelper(context);
    }

    public static MachineHelper getINSTANCE(Context context) {
        if(INSTANCE == null) {
            synchronized (SQLiteOpenHelper.class) {
                if(INSTANCE == null) {
                    INSTANCE = new MachineHelper(context);
                }
            }
        }
        return INSTANCE;
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();

        if(database.isOpen()) {
            database.close();
        }
    }

    public Cursor getAllItem(String orderBy, String ascDesc) {
        return database.query(DB_TABLE,
                null,
                null,
                null,
                null,
                null,
                orderBy + " " + ascDesc);
    }

    public Cursor getItem(String id) {
        return database.query(DB_TABLE,
                null,
                machineTableColums.COLUMN_MAC_ID + " = ?",
                new String[]{id},
                null,
                null,
                null,
                null
        );
    }

    public long insertItem(ContentValues values) {
        return database.insert(DB_TABLE, null, values);
    }

    public int updateItem(String id, ContentValues values) {
        return database.update(DB_TABLE, values, machineTableColums.COLUMN_MAC_ID + " = ?", new String[]{id});
    }

    public int deleteItem(String id) {
        return database.delete(DB_TABLE, machineTableColums.COLUMN_MAC_ID + " = ?", new String[]{id});
    }
}
