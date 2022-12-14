package com.example.booklibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {

    private RecyclerView recycleView;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);


        recycleView=findViewById(R.id.recycleView);

        ArrayList<Book> list=new ArrayList<>();
        databaseHelper=new DatabaseHelper(this);
        list=databaseHelper.getEveryone();
        RecycleViewAdapter adapter=new RecycleViewAdapter(this);
        adapter.setBooks(list);
        recycleView.setAdapter(adapter);
        recycleView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}