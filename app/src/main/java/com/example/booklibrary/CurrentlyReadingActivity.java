package com.example.booklibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class CurrentlyReadingActivity extends AppCompatActivity {

    private RecyclerView recycleView2;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currently_reading);

        recycleView2=findViewById(R.id.recycleView2);
        

        ArrayList<Book> list2=new ArrayList<>();
        databaseHelper=new DatabaseHelper(this);
        list2=databaseHelper.getEveryoneCurrentlyReading();
        RecycleViewAdapter adapter2=new RecycleViewAdapter(this);
        adapter2.setBooks(list2);
        recycleView2.setAdapter(adapter2);
        recycleView2.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}