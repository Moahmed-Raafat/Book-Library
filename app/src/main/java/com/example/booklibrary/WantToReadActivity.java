package com.example.booklibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class WantToReadActivity extends AppCompatActivity {

    private RecyclerView recycleView3;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_want_to_read);

        recycleView3=findViewById(R.id.recycleView3);


        ArrayList<Book> list3=new ArrayList<>();
        databaseHelper=new DatabaseHelper(this);
        list3=databaseHelper.getEveryoneWantToRead();
        RecycleViewAdapter adapter3=new RecycleViewAdapter(this);
        adapter3.setBooks(list3);
        recycleView3.setAdapter(adapter3);
        recycleView3.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}