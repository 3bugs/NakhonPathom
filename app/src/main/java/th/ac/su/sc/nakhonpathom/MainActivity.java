package th.ac.su.sc.nakhonpathom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] mPlaceList = new String[]{
            "พระปฐมเจดีย์", "บ้านปายนา", "พิพิธภัณฑ์รถเก่า", "ตลาดท่านา", "วัดกลางบางแก้ว"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ทำการอ้างอิงไปยัง ListView ใน layout file
        ListView placeListView = findViewById(R.id.place_list_view);

        // สร้าง adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                mPlaceList
        );

        // เอา adapter ไปผูกกับ ListView โดยเรียกใช้เมธอด setAdapter ของ ListView
        placeListView.setAdapter(adapter);

        // สร้าง listener เพื่อระบุโค้ดการทำงาน เมื่อแต่ละ item ถูกคลิก
        placeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // อ่านชื่อสถานที่ของ item ที่ถูกคลิก จากอาร์เรย์ mPlaceList มาเก็บลงตัวแปร placeName
                String placeName = mPlaceList[position];

                // แสดงชื่อสถานที่ออกมาใน Toast
                Toast.makeText(MainActivity.this, placeName, Toast.LENGTH_SHORT).show();
            }
        });
    }
}









