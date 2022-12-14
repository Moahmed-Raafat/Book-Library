package com.example.booklibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class BookActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView imageView;
    private Button btnAddToAllBooks,btnAddToCurrentlyReading
            ,btnAddToWantToRead,btnAddToFavourite,btnAddToAlreadyReadBooks;
    private TextView textViewBookName,textViewBookAuthor,textViewBookInformation;

    DatabaseHelper databaseHelper;
    Book book;
    Intent intent;

    public void iniViews()
    {
        imageView=findViewById(R.id.imageView);
        btnAddToAllBooks=findViewById(R.id.btnAddToAllBooks);
        btnAddToCurrentlyReading=findViewById(R.id.btnAddToCurrentlyReading);
        btnAddToWantToRead=findViewById(R.id.btnAddToWantToRead);
        btnAddToFavourite=findViewById(R.id.btnAddToFavourite);
        btnAddToAlreadyReadBooks=findViewById(R.id.btnAddToAlreadyReadBooks);
        textViewBookName=findViewById(R.id.textViewBookName);
        textViewBookAuthor=findViewById(R.id.textViewBookAuthor);
        textViewBookInformation=findViewById(R.id.textViewBookInformation);

        btnAddToAllBooks.setOnClickListener(this);
        btnAddToCurrentlyReading.setOnClickListener(this);
        btnAddToWantToRead.setOnClickListener(this);
        btnAddToFavourite.setOnClickListener(this);
        btnAddToAlreadyReadBooks.setOnClickListener(this);
    }

    public void setData(Book book)
    {
        Glide.with(this)
                .asBitmap().load(book.getImageUrl())
                .into(imageView);
        textViewBookName.setText("Name: "+book.getName());
        textViewBookAuthor.setText("Author: "+book.getAuthor());
        textViewBookInformation.setText("information:\n"+book.getInformation());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        iniViews();
        intent=getIntent();

        book= (Book) getIntent().getSerializableExtra("KEY_NAME");
        setData(book);
        databaseHelper=new DatabaseHelper(BookActivity.this);


        if(databaseHelper.searchOne(book))
        {
            btnAddToAllBooks.setEnabled(false);
        }
        else if(databaseHelper.searchOneCurrentlyReading(book))
        {
            btnAddToCurrentlyReading.setEnabled(false);
        }
        else if(databaseHelper.searchOneWantToRead(book))
        {
            btnAddToWantToRead.setEnabled(false);
        }
        else if(databaseHelper.searchOneFavourite(book))
        {
            btnAddToFavourite.setEnabled(false);
        }
        else if(databaseHelper.searchOneAlreadyReadBooks(book))
        {
            btnAddToAlreadyReadBooks.setEnabled(false);
        }
    }

    @Override
    public void onClick(View view) {
        databaseHelper=new DatabaseHelper(BookActivity.this);

        switch(view.getId())
        {
            case R.id.btnAddToAllBooks:

                if(!databaseHelper.searchOne(book))
                {
                    databaseHelper.addOne(book);
                    btnAddToAllBooks.setEnabled(false);

                    Toast.makeText(BookActivity.this,"book has been added to the list",
                            Toast.LENGTH_SHORT).show();

                    if(databaseHelper.searchOneCurrentlyReading(book))
                    {
                        databaseHelper.deleteOneCurrentlyReading(book);
                        btnAddToCurrentlyReading.setEnabled(true);
                    }
                    else if(databaseHelper.searchOneWantToRead(book))
                    {
                        databaseHelper.deleteOneWantToRead(book);
                        btnAddToWantToRead.setEnabled(true);
                    }
                    else if(databaseHelper.searchOneFavourite(book))
                    {
                        databaseHelper.deleteOneFavourite(book);
                        btnAddToFavourite.setEnabled(true);
                    }
                    else if(databaseHelper.searchOneAlreadyReadBooks(book))
                    {
                        databaseHelper.deleteOneAlreadyReadBooks(book);
                        btnAddToAlreadyReadBooks.setEnabled(true);
                    }
                    intent=new Intent(BookActivity.this,AllBooksActivity.class);
                    startActivity(intent);
                }
                break;



            case R.id.btnAddToCurrentlyReading:

                if(!databaseHelper.searchOneCurrentlyReading(book))
                {
                    databaseHelper.addOneCurrentlyReading(book);
                    btnAddToCurrentlyReading.setEnabled(false);

                    Toast.makeText(BookActivity.this,"book has been added to the list",
                            Toast.LENGTH_SHORT).show();

                    if(databaseHelper.searchOne(book))
                    {
                        databaseHelper.deleteOne(book);
                        btnAddToAllBooks.setEnabled(true);
                    }
                    else if(databaseHelper.searchOneWantToRead(book))
                    {
                        databaseHelper.deleteOneWantToRead(book);
                        btnAddToWantToRead.setEnabled(true);
                    }
                    else if(databaseHelper.searchOneFavourite(book))
                    {
                        databaseHelper.deleteOneFavourite(book);
                        btnAddToFavourite.setEnabled(true);

                    }
                    else if(databaseHelper.searchOneAlreadyReadBooks(book))
                    {
                        databaseHelper.deleteOneAlreadyReadBooks(book);
                        btnAddToAlreadyReadBooks.setEnabled(true);
                    }
                    intent=new Intent(BookActivity.this,CurrentlyReadingActivity.class);
                    startActivity(intent);
                }

                break;



            case R.id.btnAddToWantToRead:

                if(!databaseHelper.searchOneWantToRead(book))
                {
                    databaseHelper.addOneWantToRead(book);
                    btnAddToWantToRead.setEnabled(false);
                    Toast.makeText(BookActivity.this,"book has been added to the list",
                            Toast.LENGTH_SHORT).show();

                    if(databaseHelper.searchOne(book))
                    {
                        databaseHelper.deleteOne(book);
                        btnAddToAllBooks.setEnabled(true);
                    }
                    else if(databaseHelper.searchOneCurrentlyReading(book))
                    {
                        databaseHelper.deleteOneCurrentlyReading(book);
                        btnAddToCurrentlyReading.setEnabled(true);
                    }
                    else if(databaseHelper.searchOneFavourite(book))
                    {
                        databaseHelper.deleteOneFavourite(book);
                        btnAddToFavourite.setEnabled(true);
                    }
                    else if(databaseHelper.searchOneAlreadyReadBooks(book))
                    {
                        databaseHelper.deleteOneAlreadyReadBooks(book);
                        btnAddToAlreadyReadBooks.setEnabled(true);
                    }
                    intent=new Intent(BookActivity.this,WantToReadActivity.class);
                    startActivity(intent);
                }
                break;

            case R.id.btnAddToFavourite:

                if(!databaseHelper.searchOneFavourite(book))
                {
                    databaseHelper.addOneFavourite(book);
                    btnAddToFavourite.setEnabled(false);
                    Toast.makeText(BookActivity.this,"book has been added to the list",
                            Toast.LENGTH_SHORT).show();

                    if(databaseHelper.searchOne(book))
                    {
                        databaseHelper.deleteOne(book);
                        btnAddToAllBooks.setEnabled(true);
                    }
                    else if(databaseHelper.searchOneCurrentlyReading(book))
                    {
                        databaseHelper.deleteOneCurrentlyReading(book);
                        btnAddToCurrentlyReading.setEnabled(true);
                    }
                    else if(databaseHelper.searchOneWantToRead(book))
                    {
                        databaseHelper.deleteOneWantToRead(book);
                        btnAddToWantToRead.setEnabled(true);
                    }
                    else if(databaseHelper.searchOneAlreadyReadBooks(book))
                    {
                        databaseHelper.deleteOneAlreadyReadBooks(book);
                        btnAddToAlreadyReadBooks.setEnabled(true);
                    }
                    intent=new Intent(BookActivity.this,FavouriteActivity.class);
                    startActivity(intent);
                }

                break;

            case R.id.btnAddToAlreadyReadBooks:

                if(!databaseHelper.searchOneAlreadyReadBooks(book))
                {
                    databaseHelper.addOneAlreadyReadBooks(book);
                    btnAddToAlreadyReadBooks.setEnabled(false);

                    Toast.makeText(BookActivity.this,"book has been added to the list",
                            Toast.LENGTH_SHORT).show();

                    if(databaseHelper.searchOne(book))
                    {
                        databaseHelper.deleteOne(book);
                        btnAddToAllBooks.setEnabled(true);
                    }
                    else if(databaseHelper.searchOneCurrentlyReading(book))
                    {
                        databaseHelper.deleteOneCurrentlyReading(book);
                        btnAddToCurrentlyReading.setEnabled(true);
                    }
                    else if(databaseHelper.searchOneWantToRead(book))
                    {
                        databaseHelper.deleteOneWantToRead(book);
                        btnAddToWantToRead.setEnabled(true);
                    }
                    else if(databaseHelper.searchOneFavourite(book))
                    {
                        databaseHelper.deleteOneFavourite(book);
                        btnAddToFavourite.setEnabled(true);
                    }

                    intent=new Intent(BookActivity.this,AlreadyReadBooksActivity.class);
                    startActivity(intent);
                }




            /*case R.id.btnAddToAllBooks:

                    databaseHelper.addOne(book);

                    btnAddToAllBooks.setEnabled(false);
                    btnAddToCurrentlyReading.setEnabled(true);
                    btnAddToWantToRead.setEnabled(true);
                    btnAddToFavourite.setEnabled(true);
                    btnAddToAlreadyReadBooks.setEnabled(true);

                    Toast.makeText(BookActivity.this,"book has been added to the list",
                            Toast.LENGTH_SHORT).show();

                    if(databaseHelper.searchOneCurrentlyReading(book))
                    {
                        databaseHelper.deleteOneCurrentlyReading(book);
                    }
                    else if(databaseHelper.searchOneWantToRead(book))
                    {
                        databaseHelper.deleteOneWantToRead(book);
                    }
                    else if(databaseHelper.searchOneFavourite(book))
                    {
                        databaseHelper.deleteOneFavourite(book);
                    }
                    else if(databaseHelper.searchOneAlreadyReadBooks(book))
                    {
                        databaseHelper.deleteOneAlreadyReadBooks(book);
                    }
                    intent=new Intent(BookActivity.this,AllBooksActivity.class);
                    this.startActivity(intent);

                    break;

            case R.id.btnAddToCurrentlyReading:

                    databaseHelper.addOneCurrentlyReading(book);

                    btnAddToAllBooks.setEnabled(true);
                    btnAddToCurrentlyReading.setEnabled(false);
                    btnAddToWantToRead.setEnabled(true);
                    btnAddToFavourite.setEnabled(true);
                    btnAddToAlreadyReadBooks.setEnabled(true);

                    Toast.makeText(BookActivity.this,"book has been added to the list",
                            Toast.LENGTH_SHORT).show();

                    if(databaseHelper.searchOne(book))
                    {
                        databaseHelper.deleteOne(book);
                    }
                    else if(databaseHelper.searchOneWantToRead(book))
                    {
                        databaseHelper.deleteOneWantToRead(book);
                    }
                    else if(databaseHelper.searchOneFavourite(book))
                    {
                        databaseHelper.deleteOneFavourite(book);
                    }
                    else if(databaseHelper.searchOneAlreadyReadBooks(book))
                    {
                        databaseHelper.deleteOneAlreadyReadBooks(book);
                    }
                    intent=new Intent(BookActivity.this,CurrentlyReadingActivity.class);
                    this.startActivity(intent);

                    break;

            case R.id.btnAddToWantToRead:

                    databaseHelper.addOneWantToRead(book);

                    btnAddToAllBooks.setEnabled(true);
                    btnAddToCurrentlyReading.setEnabled(true);
                    btnAddToWantToRead.setEnabled(false);
                    btnAddToFavourite.setEnabled(true);
                    btnAddToAlreadyReadBooks.setEnabled(true);

                    Toast.makeText(BookActivity.this,"book has been added to the list",
                            Toast.LENGTH_SHORT).show();

                    if(databaseHelper.searchOne(book))
                    {
                        databaseHelper.deleteOne(book);
                    }
                    else if(databaseHelper.searchOneCurrentlyReading(book))
                    {
                        databaseHelper.deleteOneCurrentlyReading(book);
                    }
                    else if(databaseHelper.searchOneFavourite(book))
                    {
                        databaseHelper.deleteOneFavourite(book);
                    }
                    else if(databaseHelper.searchOneAlreadyReadBooks(book))
                    {
                        databaseHelper.deleteOneAlreadyReadBooks(book);
                    }
                    intent=new Intent(BookActivity.this,WantToReadActivity.class);
                    this.startActivity(intent);

                    break;

            case R.id.btnAddToFavourite:

                    databaseHelper.addOneFavourite(book);

                    btnAddToAllBooks.setEnabled(true);
                    btnAddToCurrentlyReading.setEnabled(true);
                    btnAddToWantToRead.setEnabled(true);
                    btnAddToFavourite.setEnabled(false);
                    btnAddToAlreadyReadBooks.setEnabled(true);

                    Toast.makeText(BookActivity.this,"book has been added to the list",
                            Toast.LENGTH_SHORT).show();

                    if(databaseHelper.searchOne(book))
                    {
                        databaseHelper.deleteOne(book);
                    }
                    else if(databaseHelper.searchOneCurrentlyReading(book))
                    {
                        databaseHelper.deleteOneCurrentlyReading(book);
                    }
                    else if(databaseHelper.searchOneWantToRead(book))
                    {
                        databaseHelper.deleteOneWantToRead(book);
                    }
                    else if(databaseHelper.searchOneAlreadyReadBooks(book))
                    {
                        databaseHelper.deleteOneAlreadyReadBooks(book);
                    }
                    intent=new Intent(BookActivity.this,FavouriteActivity.class);
                    this.startActivity(intent);

                    break;

            case R.id.btnAddToAlreadyReadBooks:




                    databaseHelper.addOneAlreadyReadBooks(book);

                    btnAddToAllBooks.setEnabled(true);
                    btnAddToCurrentlyReading.setEnabled(true);
                    btnAddToWantToRead.setEnabled(true);
                    btnAddToFavourite.setEnabled(true);
                    btnAddToAlreadyReadBooks.setEnabled(false);

                    Toast.makeText(BookActivity.this,"book has been added to the list",
                            Toast.LENGTH_SHORT).show();

                    if(databaseHelper.searchOne(book))
                    {
                        databaseHelper.deleteOne(book);
                    }
                    else if(databaseHelper.searchOneCurrentlyReading(book))
                    {
                        databaseHelper.deleteOneCurrentlyReading(book);
                    }
                    else if(databaseHelper.searchOneWantToRead(book))
                    {
                        databaseHelper.deleteOneWantToRead(book);
                    }
                    else if(databaseHelper.searchOneFavourite(book))
                    {
                        databaseHelper.deleteOneFavourite(book);
                    }



                    intent=new Intent(BookActivity.this,AlreadyReadBooksActivity.class);
                    this.startActivity(intent);

                    break;
                    */

            default:break;
        }

    }
}