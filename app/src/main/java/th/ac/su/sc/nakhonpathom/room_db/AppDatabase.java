package th.ac.su.sc.nakhonpathom.room_db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import th.ac.su.sc.nakhonpathom.model.Place;

@Database(entities = {Place.class}, exportSchema = false, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DB_NAME = "place.db";

    public abstract PlaceDao placeDao();

    private static AppDatabase mInstance;

    public static synchronized AppDatabase getInstance(Context context) {
        if (mInstance == null) {
            mInstance = Room
                    .databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            DB_NAME
                    )
                    .build();
        }
        return mInstance;
    }
}
