package th.ac.su.sc.nakhonpathom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import th.ac.su.sc.nakhonpathom.adapter.RecyclerViewAdapter;
import th.ac.su.sc.nakhonpathom.model.Place;

public class MainActivity extends AppCompatActivity {

    private List<Place> mPlaceList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateData();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(
                MainActivity.this,
                R.layout.item_place,
                mPlaceList
        );

        LinearLayoutManager lm
                = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(adapter);

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









