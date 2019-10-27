package th.ac.su.sc.nakhonpathom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
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
import th.ac.su.sc.nakhonpathom.room_db.AppDatabase;

import static th.ac.su.sc.nakhonpathom.db.DatabaseHelper.COL_DISTRICT;
import static th.ac.su.sc.nakhonpathom.db.DatabaseHelper.COL_ID;
import static th.ac.su.sc.nakhonpathom.db.DatabaseHelper.COL_IMAGE;
import static th.ac.su.sc.nakhonpathom.db.DatabaseHelper.COL_NAME;
import static th.ac.su.sc.nakhonpathom.db.DatabaseHelper.TABLE_PLACE;

public class MainActivity extends AppCompatActivity {

    private List<Place> mPlaceList = new ArrayList<>();
    private RecyclerViewAdapter mAdapter;

    private AppDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabase = AppDatabase.getInstance(MainActivity.this);

        // สร้าง Worker Thread
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                // โค้ดในเมธอดนี้รันใน Worker Thread
                mPlaceList = mDatabase.placeDao().getAllPlace();

                final RecyclerView recyclerView = findViewById(R.id.recycler_view);

                mAdapter = new RecyclerViewAdapter(
                        MainActivity.this,
                        R.layout.item_place,
                        mPlaceList
                );

                final LinearLayoutManager lm = new LinearLayoutManager(MainActivity.this);

                // ส่งโค้ดกลับไปรันใน UI Thread (Main Thread)
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // โค้ดในเมธอดนี้รันใน UI Thread (Main Thread)
                        recyclerView.setLayoutManager(lm);
                        recyclerView.setAdapter(mAdapter);
                    }
                });
            }
        });
        t.start();

        Button addPlaceButton = findViewById(R.id.add_place_button);
        addPlaceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo: อ่านข้อมูลจาก place_name_edit_text แล้ว insert ลง database

                //อ่านข้อมูลจาก place_name_edit_text มาพักเก็บลงตัวแปร name
                EditText placeNameEditText = findViewById(R.id.place_name_edit_text);
                String name = placeNameEditText.getText().toString();

                final Place place = new Place(0, name, "", R.mipmap.ic_launcher);

                // สร้าง Worker Thread
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        // โค้ดส่วนนี้รันใน Worker Thread
                        mDatabase.placeDao().insertPlace(place);

                        //mPlaceList = mDatabase.placeDao().getAllPlace();

                        mPlaceList.clear();
                        mPlaceList.addAll(mDatabase.placeDao().getAllPlace());

                        // ส่งโค้ดกลับไปรันใน UI Thread (Main Thread)
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                // โค้ดในเมธอดนี้รันใน UI Thread (Main Thread)
                                mAdapter.notifyDataSetChanged();
                            }
                        });
                    }
                });
                t.start();
            }
        });
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

} // ปิด MainActivity









