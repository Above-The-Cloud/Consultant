package com.example.consultant.former;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.List;
import java.util.ArrayList;
import android.widget.ListView;

import com.example.consultant.R;
import com.example.consultant.adapters.time_adapter;

public class free extends AppCompatActivity {
    private List<time> freelist =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free);
        initfree();
        time_adapter adapter =new time_adapter(free.this,R.layout.free_item,freelist);
        ListView listview =(ListView)findViewById(R.id.list_free);
        listview.setAdapter(adapter);
    }
    private void initfree()
    {
        time a = new time("7:00-8:00");
        freelist.add(a);
        time b = new time("8:00-9:00");
        freelist.add(b);
        time c = new time("9:00-10:00");
        freelist.add(c);
        time d = new time("10:00-11:00");
        freelist.add(d);
        time e = new time("11:00-12:00");
        freelist.add(e);
        time f = new time("12:00-13:00");
        freelist.add(f);
        time g = new time("13:00-14:00");
        freelist.add(g);
        time h = new time("14:00-15:00");
        freelist.add(h);
        time i = new time("15:00-16:00");
        freelist.add(i);
        time j = new time("16:00-17:00");
        freelist.add(j);
        time k = new time("17:00-18:00");
        freelist.add(k);
        time l = new time("18:00-19:00");
        freelist.add(l);
        time m = new time("19:00-20:00");
        freelist.add(m);
        time n = new time("20:00-21:00");
        freelist.add(n);
        time o = new time("21:00-22:00");
        freelist.add(o);
        time p = new time("22:00-23:00");
        freelist.add(p);
    }
}
