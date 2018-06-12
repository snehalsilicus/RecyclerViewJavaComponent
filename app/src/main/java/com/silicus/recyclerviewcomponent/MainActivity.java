package com.silicus.recyclerviewcomponent;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMonthClickListener{


    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView recyclerViewDemo;
    private DemoAdapter adapter;

    private List<String> dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerViewDemo = findViewById(R.id.recyclerViewDemo);
        recyclerViewDemo.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,
                false));
        recyclerViewDemo.setHasFixedSize(true);


        // init datasource
        createDataSource();

        // Adapter
        // Java : DemoAdapter
        // XML : list_item_demo
        adapter = new DemoAdapter(this, this);
        recyclerViewDemo.setAdapter(adapter);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter.addAllData(dataSource);
            }
        },5000);

    }


    public void createDataSource(){
        dataSource = new ArrayList<>();
        dataSource.add("Jan");
        dataSource.add("XYZ");
        dataSource.add("PQR");
        dataSource.add("ABC");
        dataSource.add("DEF");
        dataSource.add("OUY");
        dataSource.add("OPI");
        dataSource.add("MNB");
    }

    @Override
    public void onMonthClick(int position, String month) {
        Log.d(TAG, "Position: "+position);
        Log.d(TAG,"Month: "+month);
    }
}
