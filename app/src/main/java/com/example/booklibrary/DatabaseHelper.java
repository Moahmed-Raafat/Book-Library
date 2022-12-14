package com.example.booklibrary;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.io.File;
import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String BOOK_TABLE="BOOK_TABLE";
    public static final String COLUMN_BOOK_ID="ID";
    public static final String COLUMN_BOOK_NAME="BOOK_NAME";
    public static final String COLUMN_BOOK_AUTHOR="BOOK_AUTHOR";
    public static final String COLUMN_BOOK_IMAGE_URL="BOOK_IMAGE_URL";
    public static final String COLUMN_BOOK_INFORMATION="BOOK_INFORMATION";

    public static final String CURRENTLY_READING_TABLE="CURRENTLY_READING_TABLE";
    public static final String COLUMN_CURRENTLY_READING_ID="ID";
    public static final String COLUMN_CURRENTLY_READING_NAME="BOOK_NAME";
    public static final String COLUMN_CURRENTLY_READING_AUTHOR="BOOK_AUTHOR";
    public static final String COLUMN_CURRENTLY_READING_IMAGE_URL="BOOK_IMAGE_URL";
    public static final String COLUMN_CURRENTLY_READING_INFORMATION="BOOK_INFORMATION";

    public static final String WANT_TO_READ_TABLE="WANT_TO_READ_TABLE";
    public static final String COLUMN_WANT_TO_READ_ID="ID";
    public static final String COLUMN_WANT_TO_READ_NAME="BOOK_NAME";
    public static final String COLUMN_WANT_TO_READ_AUTHOR="BOOK_AUTHOR";
    public static final String COLUMN_WANT_TO_READ_IMAGE_URL="BOOK_IMAGE_URL";
    public static final String COLUMN_WANT_TO_READ_INFORMATION="BOOK_INFORMATION";

    public static final String FAVOURITE_TABLE="FAVOURITE_TABLE";
    public static final String COLUMN_FAVOURITE_ID="ID";
    public static final String COLUMN_FAVOURITE_NAME="BOOK_NAME";
    public static final String COLUMN_FAVOURITE_AUTHOR="BOOK_AUTHOR";
    public static final String COLUMN_FAVOURITE_IMAGE_URL="BOOK_IMAGE_URL";
    public static final String COLUMN_FAVOURITE_INFORMATION="BOOK_INFORMATION";

    public static final String ALREADY_READ_BOOKS_TABLE="ALREADY_READ_BOOKS_TABLE";
    public static final String COLUMN_ALREADY_READ_BOOKS_ID="ID";
    public static final String COLUMN_ALREADY_READ_BOOKS_NAME="BOOK_NAME";
    public static final String COLUMN_ALREADY_READ_BOOKS_AUTHOR="BOOK_AUTHOR";
    public static final String COLUMN_ALREADY_READ_BOOKS_IMAGE_URL="BOOK_IMAGE_URL";
    public static final String COLUMN_ALREADY_READ_BOOKS_INFORMATION="BOOK_INFORMATION";



    public DatabaseHelper(@Nullable Context context)
    {
        super(context, "Book.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {



        String createTableStatement=" CREATE TABLE "+ BOOK_TABLE +
                " ( " + COLUMN_BOOK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_BOOK_NAME + " TEXT, " +
                COLUMN_BOOK_AUTHOR + " TEXT, " +
                COLUMN_BOOK_IMAGE_URL + " TEXT, " +
                COLUMN_BOOK_INFORMATION + " TEXT )" ;
        db.execSQL(createTableStatement);

        String createTableStatement2=" CREATE TABLE "+ CURRENTLY_READING_TABLE +
                " ( " + COLUMN_CURRENTLY_READING_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_CURRENTLY_READING_NAME + " TEXT, " +
                COLUMN_CURRENTLY_READING_AUTHOR + " TEXT, " +
                COLUMN_CURRENTLY_READING_IMAGE_URL + " TEXT, " +
                COLUMN_CURRENTLY_READING_INFORMATION + " TEXT )" ;
        db.execSQL(createTableStatement2);


        String createTableStatement3=" CREATE TABLE "+ WANT_TO_READ_TABLE +
                " ( " + COLUMN_WANT_TO_READ_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_WANT_TO_READ_NAME + " TEXT, " +
                COLUMN_WANT_TO_READ_AUTHOR + " TEXT, " +
                COLUMN_WANT_TO_READ_IMAGE_URL + " TEXT, " +
                COLUMN_WANT_TO_READ_INFORMATION + " TEXT )" ;
        db.execSQL(createTableStatement3);

        String createTableStatement4=" CREATE TABLE "+ FAVOURITE_TABLE +
                " ( " + COLUMN_FAVOURITE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_FAVOURITE_NAME + " TEXT, " +
                COLUMN_FAVOURITE_AUTHOR + " TEXT, " +
                COLUMN_FAVOURITE_IMAGE_URL + " TEXT, " +
                COLUMN_FAVOURITE_INFORMATION + " TEXT )" ;
        db.execSQL(createTableStatement4);

        String createTableStatement5=" CREATE TABLE "+ ALREADY_READ_BOOKS_TABLE +
                " ( " + COLUMN_ALREADY_READ_BOOKS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_ALREADY_READ_BOOKS_NAME + " TEXT, " +
                COLUMN_ALREADY_READ_BOOKS_AUTHOR + " TEXT, " +
                COLUMN_ALREADY_READ_BOOKS_IMAGE_URL + " TEXT, " +
                COLUMN_ALREADY_READ_BOOKS_INFORMATION + " TEXT )" ;
        db.execSQL(createTableStatement5);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public boolean addOne(Book book)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(COLUMN_BOOK_NAME,book.getName());
        contentValues.put(COLUMN_BOOK_AUTHOR,book.getAuthor());
        contentValues.put(COLUMN_BOOK_IMAGE_URL,book.getImageUrl());
        contentValues.put(COLUMN_BOOK_INFORMATION,book.getInformation());

        long insert= db.insert(BOOK_TABLE,null,contentValues);
        if(insert==-1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }
    public boolean addOneCurrentlyReading(Book book)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(COLUMN_CURRENTLY_READING_NAME,book.getName());
        contentValues.put(COLUMN_CURRENTLY_READING_AUTHOR,book.getAuthor());
        contentValues.put(COLUMN_CURRENTLY_READING_IMAGE_URL,book.getImageUrl());
        contentValues.put(COLUMN_CURRENTLY_READING_INFORMATION,book.getInformation());

        long insert= db.insert(CURRENTLY_READING_TABLE,null,contentValues);
        if(insert==-1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }
    public boolean addOneWantToRead(Book book)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(COLUMN_WANT_TO_READ_NAME,book.getName());
        contentValues.put(COLUMN_WANT_TO_READ_AUTHOR,book.getAuthor());
        contentValues.put(COLUMN_WANT_TO_READ_IMAGE_URL,book.getImageUrl());
        contentValues.put(COLUMN_WANT_TO_READ_INFORMATION,book.getInformation());

        long insert= db.insert(WANT_TO_READ_TABLE,null,contentValues);
        if(insert==-1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }
    public boolean addOneFavourite(Book book)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(COLUMN_FAVOURITE_NAME,book.getName());
        contentValues.put(COLUMN_FAVOURITE_AUTHOR,book.getAuthor());
        contentValues.put(COLUMN_FAVOURITE_IMAGE_URL,book.getImageUrl());
        contentValues.put(COLUMN_FAVOURITE_INFORMATION,book.getInformation());

        long insert= db.insert(FAVOURITE_TABLE,null,contentValues);
        if(insert==-1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }
    public boolean addOneAlreadyReadBooks(Book book)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(COLUMN_ALREADY_READ_BOOKS_NAME,book.getName());
        contentValues.put(COLUMN_ALREADY_READ_BOOKS_AUTHOR,book.getAuthor());
        contentValues.put(COLUMN_ALREADY_READ_BOOKS_IMAGE_URL,book.getImageUrl());
        contentValues.put(COLUMN_ALREADY_READ_BOOKS_INFORMATION,book.getInformation());

        long insert= db.insert(ALREADY_READ_BOOKS_TABLE,null,contentValues);
        if(insert==-1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }



    public ArrayList<Book> getEveryone()
    {
        ArrayList<Book> returnList=new ArrayList<>();
        String queryString="SELECT * FROM " + BOOK_TABLE ;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(queryString,null);

        if(cursor.moveToFirst())
        {
            do{
                int bookId=cursor.getInt(0);
                String bookName= cursor.getString(1);
                String bookAuthor= cursor.getString(2);
                String bookImageUrl= cursor.getString(3);
                String bookInformation= cursor.getString(4);

                Book newBook=new Book(bookId,bookName,bookAuthor,bookImageUrl,bookInformation);
                returnList.add(newBook);
            }
            while(cursor.moveToNext());
        }
        else
        {
            //Do Nothing
        }

        cursor.close();
        db.close();
        return returnList;
    }
    public ArrayList<Book> getEveryoneCurrentlyReading()
    {
        ArrayList<Book> returnList=new ArrayList<>();
        String queryString="SELECT * FROM " + CURRENTLY_READING_TABLE ;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(queryString,null);

        if(cursor.moveToFirst())
        {
            do{
                int bookId=cursor.getInt(0);
                String bookName= cursor.getString(1);
                String bookAuthor= cursor.getString(2);
                String bookImageUrl= cursor.getString(3);
                String bookInformation= cursor.getString(4);

                Book newBook=new Book(bookId,bookName,bookAuthor,bookImageUrl,bookInformation);
                returnList.add(newBook);
            }
            while(cursor.moveToNext());
        }
        else
        {
            //Do Nothing
        }

        cursor.close();
        db.close();
        return returnList;
    }
    public ArrayList<Book> getEveryoneWantToRead()
    {
        ArrayList<Book> returnList=new ArrayList<>();
        String queryString="SELECT * FROM " + WANT_TO_READ_TABLE ;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(queryString,null);

        if(cursor.moveToFirst())
        {
            do{
                int bookId=cursor.getInt(0);
                String bookName= cursor.getString(1);
                String bookAuthor= cursor.getString(2);
                String bookImageUrl= cursor.getString(3);
                String bookInformation= cursor.getString(4);

                Book newBook=new Book(bookId,bookName,bookAuthor,bookImageUrl,bookInformation);
                returnList.add(newBook);
            }
            while(cursor.moveToNext());
        }
        else
        {
            //Do Nothing
        }

        cursor.close();
        db.close();
        return returnList;
    }
    public ArrayList<Book> getEveryoneFavourite()
    {
        ArrayList<Book> returnList=new ArrayList<>();
        String queryString="SELECT * FROM " + FAVOURITE_TABLE ;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(queryString,null);

        if(cursor.moveToFirst())
        {
            do{
                int bookId=cursor.getInt(0);
                String bookName= cursor.getString(1);
                String bookAuthor= cursor.getString(2);
                String bookImageUrl= cursor.getString(3);
                String bookInformation= cursor.getString(4);

                Book newBook=new Book(bookId,bookName,bookAuthor,bookImageUrl,bookInformation);
                returnList.add(newBook);
            }
            while(cursor.moveToNext());
        }
        else
        {
            //Do Nothing
        }

        cursor.close();
        db.close();
        return returnList;
    }
    public ArrayList<Book> getEveryoneAlreadyReadBooks()
    {
        ArrayList<Book> returnList=new ArrayList<>();
        String queryString="SELECT * FROM " + ALREADY_READ_BOOKS_TABLE ;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(queryString,null);

        if(cursor.moveToFirst())
        {
            do{
                int bookId=cursor.getInt(0);
                String bookName= cursor.getString(1);
                String bookAuthor= cursor.getString(2);
                String bookImageUrl= cursor.getString(3);
                String bookInformation= cursor.getString(4);

                Book newBook=new Book(bookId,bookName,bookAuthor,bookImageUrl,bookInformation);
                returnList.add(newBook);
            }
            while(cursor.moveToNext());
        }
        else
        {
            //Do Nothing
        }

        cursor.close();
        db.close();
        return returnList;
    }



    public boolean deleteOne(Book book)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String queryString="DELETE FROM " + BOOK_TABLE + " WHERE " + COLUMN_BOOK_ID +
                " = " + book.getId() ;
        Cursor cursor=db.rawQuery(queryString,null);
        if(cursor.moveToFirst())
        {
            return true;
        }
        else
        {
            return false;
        }


    }
    public boolean deleteOneCurrentlyReading(Book book)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String queryString="DELETE FROM " + CURRENTLY_READING_TABLE + " WHERE " + COLUMN_CURRENTLY_READING_ID +
                " = " + book.getId();
        Cursor cursor=db.rawQuery(queryString,null);
        if(cursor.moveToFirst())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean deleteOneWantToRead(Book book)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String queryString="DELETE FROM " + WANT_TO_READ_TABLE + " WHERE " + COLUMN_WANT_TO_READ_ID +
                " = " + book.getId();
        Cursor cursor=db.rawQuery(queryString,null);
        if(cursor.moveToFirst())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean deleteOneFavourite(Book book)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String queryString="DELETE FROM " + FAVOURITE_TABLE + " WHERE " + COLUMN_FAVOURITE_ID +
                " = " + book.getId();
        Cursor cursor=db.rawQuery(queryString,null);
        if(cursor.moveToFirst())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean deleteOneAlreadyReadBooks(Book book)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String queryString="DELETE FROM " + ALREADY_READ_BOOKS_TABLE + " WHERE " + COLUMN_ALREADY_READ_BOOKS_ID +
                " = " + book.getId();
        Cursor cursor=db.rawQuery(queryString,null);
        if(cursor.moveToFirst())
        {
            return true;
        }
        else
        {
            return false;
        }
    }




    public boolean searchOne(Book book)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String queryString="SELECT * FROM " + BOOK_TABLE + " WHERE " + COLUMN_BOOK_ID
                 + " = " + book.getId();
        Cursor cursor=db.rawQuery(queryString,null);

        //if the book has been found
        if(cursor.getCount()>0)
        {
            if(cursor.moveToFirst())
            {
                do {

                    return true;
                }
                while(cursor.moveToNext());
            }
        }
        //no data found
        return false;
    }
    public boolean searchOneCurrentlyReading(Book book)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String queryString="SELECT * FROM " + CURRENTLY_READING_TABLE + " WHERE " + COLUMN_CURRENTLY_READING_ID
                + " = " + book.getId();
        Cursor cursor=db.rawQuery(queryString,null);

        //if the book has been found
        if(cursor.getCount()>0)
        {
            if(cursor.moveToFirst())
            {
                do {

                    return true;
                }
                while(cursor.moveToNext());
            }
        }
        //no data found

        return false;
    }
    public boolean searchOneWantToRead(Book book)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String queryString="SELECT * FROM " + WANT_TO_READ_TABLE + " WHERE " + COLUMN_WANT_TO_READ_ID
                + " = " + book.getId();
        Cursor cursor=db.rawQuery(queryString,null);

        //if the book has been found
        if(cursor.getCount()>0)
        {
            if(cursor.moveToFirst())
            {
                do {

                    return true;
                }
                while(cursor.moveToNext());
            }
        }
        //no data found

        return false;
    }
    public boolean searchOneFavourite(Book book)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String queryString="SELECT * FROM " + FAVOURITE_TABLE + " WHERE " + COLUMN_FAVOURITE_ID
                + " = " + book.getId();
        Cursor cursor=db.rawQuery(queryString,null);

        //if the book has been found
        if(cursor.getCount()>0)
        {
            if(cursor.moveToFirst())
            {
                do {

                    return true;
                }
                while(cursor.moveToNext());
            }
        }
        //no data found

        return false;
    }
    public boolean searchOneAlreadyReadBooks(Book book)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String queryString="SELECT * FROM " + ALREADY_READ_BOOKS_TABLE + " WHERE " + COLUMN_ALREADY_READ_BOOKS_ID
                + " = " + book.getId();
        Cursor cursor=db.rawQuery(queryString,null);

        //if the book has been found
        if(cursor.getCount()>0)
        {
            if(cursor.moveToFirst())
            {
                do {

                    return true;
                }
                while(cursor.moveToNext());
            }
        }
        //no data found

        return false;
    }



    public static boolean doesDatabaseExist(Context context, String dbName) {
        File dbFile = context.getDatabasePath(dbName);
        return dbFile.exists();
    }




}
