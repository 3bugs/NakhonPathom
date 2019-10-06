package th.ac.su.sc.nakhonpathom.room_db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import th.ac.su.sc.nakhonpathom.model.Place;

@Dao
public interface PlaceDao {

    @Query("SELECT * FROM place")
    List<Place> getAllPlace();

    @Insert
    void insertPlace(Place place);
}
