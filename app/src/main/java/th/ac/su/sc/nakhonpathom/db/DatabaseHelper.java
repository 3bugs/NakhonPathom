package th.ac.su.sc.nakhonpathom.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_PLACE = "place";

    private static final String COL_ID = "_id";
    private static final String COL_NAME = "name";
    private static final String COL_DISTRICT = "district";
    private static final String COL_IMAGE = "image";

    private static final String SQL_CREATE_PLACE =
            "CREATE TABLE " + TABLE_PLACE + " ("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_NAME + " TEXT, "
            + COL_DISTRICT + " TEXT, "
            + COL_IMAGE + " INTEGER )";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_PLACE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
