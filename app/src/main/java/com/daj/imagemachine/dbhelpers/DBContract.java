package com.daj.imagemachine.dbhelpers;

import android.provider.BaseColumns;

public class DBContract {

    public static final String TABLE_MACHINE = "machine_table";

    public static final class machineTableColums implements BaseColumns {
        public static String COLUMN_MAC_ID = "machine_id";
        public static String COLUMN_MAC_NAME = "machine_name";
        public static String COLUMN_MAC_TYPE = "machine_type";
        public static String COLUMN_MAC_CODE = "machine_code";
        public static String COLUMN_MAC_LAST_MT_DATE = "machine_last_mt_date";
    }
}
