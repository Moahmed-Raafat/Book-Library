package com.example.booklibrary;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private MaterialCardView parent;
        private TextView bookAuthor,bookName,bookInformation;
        private ImageView arrow_up,arrow_down,bookImage;
        private RelativeLayout secondRelativeLayout;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);

            parent=itemView.findViewById(R.id.parent);
            bookName=itemView.findViewById(R.id.bookName);
            bookAuthor=itemView.findViewById(R.id.bookAuthor);
            bookInformation=itemView.findViewById(R.id.bookInformation);
            arrow_up=itemView.findViewById(R.id.arrow_up);
            arrow_down=itemView.findViewById(R.id.arrow_down);
            bookImage=itemView.findViewById(R.id.bookImage);
            secondRelativeLayout=itemView.findViewById(R.id.secondRelativeLayout);

            arrow_down.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Book book=books.get(getAdapterPosition());
                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });

            arrow_up.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Book book=books.get(getAdapterPosition());
                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }

    public RecycleViewAdapter(Context context)
    {
        this.context=context;

    }

    private ArrayList<Book> books=new ArrayList<>();

    //to refresh the data inside the recycleView
    public void setBooks(ArrayList<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.books_list_item,parent,
                false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        if(books.get(position).isExpanded())
        {
            holder.secondRelativeLayout.setVisibility(View.VISIBLE);
            holder.arrow_down.setVisibility(View.GONE);
            TransitionManager.beginDelayedTransition(holder.parent);
        }
        else
        {
            holder.secondRelativeLayout.setVisibility(View.GONE);
            holder.arrow_down.setVisibility(View.VISIBLE);
            TransitionManager.beginDelayedTransition(holder.parent);
        }

        Glide.with(context)
                .asBitmap()
                .load(books.get(position).getImageUrl())
                .into(holder.bookImage);

        holder.bookName.setText(books.get(position).getName());
        holder.bookAuthor.setText(books.get(position).getAuthor());
        holder.bookInformation.setText(books.get(position).getInformation());

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Book book;
                book=new Book(books.get(position).getId(),books.get(position).getName(),books.get(position).getAuthor(),
                        books.get(position).getImageUrl(),books.get(position).getInformation());

                Intent intent=new Intent(context,BookActivity.class);
                intent.putExtra("KEY_NAME", book);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return books.size();
    }



}
