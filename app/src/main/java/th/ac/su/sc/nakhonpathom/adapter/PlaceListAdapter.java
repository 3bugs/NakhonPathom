package th.ac.su.sc.nakhonpathom.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import th.ac.su.sc.nakhonpathom.R;
import th.ac.su.sc.nakhonpathom.model.Place;

public class PlaceListAdapter extends ArrayAdapter<Place> {

    private Context mContext;
    private int mResource;
    private List<Place> mPlaceList;

    public PlaceListAdapter(@NonNull Context context, int resource, @NonNull List<Place> placeList) {
        super(context, resource, placeList);
        this.mContext = context;
        this.mResource = resource;
        this.mPlaceList = placeList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // ทำการ Inflate layout
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = convertView;
        if (v == null) {
            v = inflater.inflate(mResource, parent, false);
        }

        // เข้าถึงออบเจ็ค Place ตาม position ที่ ListView ขอมา
        Place place = mPlaceList.get(position);

        // กำหนดชื่อสถานที่ลงใน TextView (place_name_text_view)
        TextView placeNameTextView = v.findViewById(R.id.place_name_text_view);
        placeNameTextView.setText(place.name);

        // กำหนดชื่ออำเภอลงใน TextView (district_text_view)
        TextView districtTextView = v.findViewById(R.id.district_text_view);
        districtTextView.setText("อำเภอ".concat(place.district));

        ImageView logoImageView = v.findViewById(R.id.logo_image_view);
        logoImageView.setImageResource(place.imageRes);

        return v;
    }
}








