package com.example.booklibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class AlreadyReadBooksActivity extends AppCompatActivity {

    private RecyclerView recycleView5;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_already_read_books);

        recycleView5=findViewById(R.id.recycleView5);


        ArrayList<Book> list5=new ArrayList<>();
        databaseHelper=new DatabaseHelper(this);
        list5=databaseHelper.getEveryoneAlreadyReadBooks();
        RecycleViewAdapter adapter5=new RecycleViewAdapter(this);
        adapter5.setBooks(list5);
        recycleView5.setAdapter(adapter5);
        recycleView5.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}