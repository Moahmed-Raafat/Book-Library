package com.example.booklibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class FavouriteActivity extends AppCompatActivity {

    private RecyclerView recycleView4;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);

        recycleView4=findViewById(R.id.recycleView4);


        ArrayList<Book> list4=new ArrayList<>();
        databaseHelper=new DatabaseHelper(this);
        list4=databaseHelper.getEveryoneFavourite();
        RecycleViewAdapter adapter4=new RecycleViewAdapter(this);
        adapter4.setBooks(list4);
        recycleView4.setAdapter(adapter4);
        recycleView4.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}