package th.ac.su.sc.nakhonpathom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import th.ac.su.sc.nakhonpathom.adapter.PlaceListAdapter;
import th.ac.su.sc.nakhonpathom.adapter.RecyclerViewAdapter;
import th.ac.su.sc.nakhonpathom.db.DatabaseHelper;
import th.ac.su.sc.nakhonpathom.model.Place;

import static th.ac.su.sc.nakhonpathom.db.DatabaseHelper.COL_DISTRICT;
import static th.ac.su.sc.nakhonpathom.db.DatabaseHelper.COL_ID;
import static th.ac.su.sc.nakhonpathom.db.DatabaseHelper.COL_IMAGE;
import static th.ac.su.sc.nakhonpathom.db.DatabaseHelper.COL_NAME;
import static th.ac.su.sc.nakhonpathom.db.DatabaseHelper.TABLE_PLACE;

public class MainActivity extends AppCompatActivity {

    private List<Place> mPlaceList = new ArrayList<>();
    private RecyclerViewAdapter mAdapter;

    private DatabaseHelper mDbHelper;
    private SQLiteDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //populateData();

        mDbHelper = new DatabaseHelper(MainActivity.this);
        mDatabase = mDbHelper.getWritableDatabase();

        readFormDb();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        mAdapter = new RecyclerViewAdapter(
                MainActivity.this,
                R.layout.item_place,
                mPlaceList
        );

        LinearLayoutManager lm
                = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(mAdapter);

        Button addPlaceButton = findViewById(R.id.add_place_button);
        addPlaceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo: อ่านข้อมูลจาก place_name_edit_text แล้ว insert ลง database

                //อ่านข้อมูลจาก place_name_edit_text มาพักเก็บลงตัวแปร name
                EditText placeNameEditText = findViewById(R.id.place_name_edit_text);
                String name = placeNameEditText.getText().toString();

                //เอาคัวแปร name ไป insert ลง database
                ContentValues cv = new ContentValues();
                cv.put(COL_NAME, name);
                cv.put(COL_DISTRICT, "");
                cv.put(COL_IMAGE, R.mipmap.ic_launcher);
                mDatabase.insert(TABLE_PLACE, null, cv);

                readFormDb();
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    private void readFormDb() {
        mPlaceList.clear();

        Cursor cursor = mDatabase.query(TABLE_PLACE, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(COL_ID));
            String name = cursor.getString(cursor.getColumnIndex(COL_NAME));
            String district = cursor.getString(cursor.getColumnIndex(COL_DISTRICT));
            int image = cursor.getInt(cursor.getColumnIndex(COL_IMAGE));

            Place place = new Place(id, name, district, image);
            mPlaceList.add(place);
        }
    }

    private void populateData() {
        /*Place place = new Place("พระปฐมเจดีย์", "เมือง", R.drawable.prathomchedi);
        mPlaceList.add(place);

        place = new Place("บ้านปายนา", "นครชัยศรี", R.drawable.paina);
        mPlaceList.add(place);

        place = new Place("พิพิธภัณฑ์รถเก่า", "นครชัยศรี", R.drawable.jesadatechnikmuseum);
        mPlaceList.add(place);

        place = new Place("ตลาดท่านา", "นครชัยศรี", R.drawable.thanamarket);
        mPlaceList.add(place);

        place = new Place("วัดกลางบางแก้ว", "นครชัยศรี", R.drawable.watklangbangkaew);
        mPlaceList.add(place);

        place = new Place("ตลาดน้ำลำพญา", "บางเลน", R.drawable.lamphayamarket);
        mPlaceList.add(place);

        place = new Place("ตลาดน้ำทุ่งบัวแดง", "บางเลน", R.drawable.buadang);
        mPlaceList.add(place);

        place = new Place("Tree & Tide Riverside", "บางเลน", R.drawable.treetide);
        mPlaceList.add(place);*/
    }
}









