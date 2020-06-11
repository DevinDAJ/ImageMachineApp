package com.daj.imagemachine.dbhelpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static String DB_NAME = "dbImageMachineApp";

    private static final int DB_VERSION = 0;

    private static final String CREATE_MACHINE_TABLE = String.format("CREATE TABLE %s"
            + " (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
            " %s TEXT NOT NULL," +
            " %s TEXT NOT NULL," +
            " %s TEXT NOT NULL," +
            " %s TEXT NOT NULL)",
            DBContract.TABLE_MACHINE,
            DBContract.machineTableColums.COLUMN_MAC_ID,
            DBContract.machineTableColums.COLUMN_MAC_NAME,
            DBContract.machineTableColums.COLUMN_MAC_TYPE,
            DBContract.machineTableColums.COLUMN_MAC_CODE,
            DBContract.machineTableColums.COLUMN_MAC_LAST_MT_DATE
    );

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_MACHINE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ DBContract.TABLE_MACHINE);
        onCreate(db);
    }
}
