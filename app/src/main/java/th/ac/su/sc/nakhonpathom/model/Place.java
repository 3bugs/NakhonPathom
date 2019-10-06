package th.ac.su.sc.nakhonpathom.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "place")
public class Place {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "district")
    public String district;

    @ColumnInfo(name = "image")
    public int imageRes;

    public Place(int id, String name, String district, int imageRes) {
        this.id = id;
        this.name = name;
        this.district = district;
        this.imageRes = imageRes;
    }
}
