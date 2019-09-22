package th.ac.su.sc.nakhonpathom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import th.ac.su.sc.nakhonpathom.adapter.PlaceListAdapter;
import th.ac.su.sc.nakhonpathom.model.Place;

public class MainActivity extends AppCompatActivity {

    /*private String[] mPlaceList = new String[]{
            "พระปฐมเจดีย์", "บ้านปายนา", "พิพิธภัณฑ์รถเก่า", "ตลาดท่านา", "วัดกลางบางแก้ว",
            "ตลาดน้ำลำพญา", "ตลาดน้ำทุ่งบัวแดง", "Tree & Tide Riverside"
    };*/

    private List<Place> mPlaceList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateData();

        // ทำการอ้างอิงไปยัง ListView ใน layout file
        ListView placeListView = findViewById(R.id.place_list_view);

        // สร้าง adapter
        PlaceListAdapter adapter = new PlaceListAdapter(
                MainActivity.this, // context
                R.layout.item_place, // ระบุ layout สำหรับแต่ละ item ใน list
                mPlaceList // แหล่งข้อมูล (data source) ในที่นี้คือ อาร์เรย์ของสตริง
        );

        // เอา adapter ไปผูกกับ ListView โดยเรียกใช้เมธอด setAdapter ของ ListView
        placeListView.setAdapter(adapter);

        // สร้าง listener เพื่อระบุโค้ดการทำงาน เมื่อแต่ละ item ถูกคลิก
        placeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // อ่านชื่อสถานที่ของ item ที่ถูกคลิก จากอาร์เรย์ mPlaceList มาเก็บลงตัวแปร placeName
                Place place = mPlaceList.get(position);
                String placeName = place.name;

                // แสดงชื่อสถานที่ออกมาใน Toast
                Toast.makeText(MainActivity.this, placeName, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, PlaceDetailsActivity.class);
                intent.putExtra("name", place.name);
                intent.putExtra("image", place.imageRes);
                startActivity(intent);
            }
        });
    }

    private void populateData() {
        Place place = new Place("พระปฐมเจดีย์", "เมือง", R.drawable.prathomchedi);
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
        mPlaceList.add(place);
    }
}









