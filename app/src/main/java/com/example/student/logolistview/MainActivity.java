package com.example.student.logolistview;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends ListActivity {
    String[] listimage_title = new String[]{
            "facebook",
            "instagram",
            "zalo",
            "twitter",
            "google",
            "adidas",
            "tin tuc 24h",
            "youtube",
            "skype",
            "gmail"
    };
    int[] listviewImage = new int[]{
            R.drawable.facebook, R.drawable.instargram, R.drawable.zalo, R.drawable.twitter,
            R.drawable.google, R.drawable.addidas, R.drawable.tintuc24gio, R.drawable.youtube,
            R.drawable.skype, R.drawable.gmail
    };
    String[] listlinkimage = new String[]{
        "https://vi-vn.facebook.com/",
        "https://www.instagram.com/?hl=vi",
        "https://id.zalo.me/account?continue=https%3A%2F%2Fchat.zalo.me%2F",
        "https://twitter.com/?lang=vi",
        "https://www.google.com.vn/?hl=vi",
        "https://www.adidas.com/us",
        "https://www.24h.com.vn/",
        "https://www.youtube.com/?gl=VN",
        "https://www.skype.com/en/",
        "https://www.google.com/intl/vi/gmail/about/#"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 10; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listviewImage", Integer.toString(listviewImage[i]));
            hm.put("listviewTitle", listimage_title[i]);
            list.add(hm);
        }

        String[] from = {"listviewImage", "listviewTitle"};
        int[] to = {R.id.image_view, R.id.image_title};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), list, R.layout.listview_activity, from, to);
//        ListView androidListView = (ListView) findViewById(R.id.listview_hinh);
        setListAdapter(simpleAdapter);
    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(this, "You have selected " + listlinkimage[position], Toast.LENGTH_SHORT).show();
        String url=listlinkimage[position];
        Intent intent=new Intent(MainActivity.this,Main2Activity.class);
        intent.putExtra("url",url);
        startActivity(intent);
    }

    public void onClick(View view) {
        ListView listView = getListView();

        String itemSelected = "Selected items: \n";
        for (int i = 0; i < listView.getCount(); i++){
            if(listView.isItemChecked(i)){
                itemSelected += listView.getItemAtPosition(i) + "\n";
            }
        }
        Toast.makeText(this, itemSelected, Toast.LENGTH_LONG).show();
    }
}
