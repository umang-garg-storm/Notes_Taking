package com.example.notestaking.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notestaking.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    List<String> titles;
    List<String> content;

    public Adapter(List<String> titles, List<String> content) {
        this.titles = titles;
        this.content = content;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_view_layout,parent,false);
        return new ViewHolder(view); // to create the view for recyclerview to display data //
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        // bind actual data recived from main Activity and bind it to the views assigned down wards
         holder.noteTitle.setText(titles.get(position));
         holder.noteContent.setText(content.get(position));
         // To set Background Color for CardView
        holder.mCardView.setCardBackgroundColor(holder.view.getResources().getColor(getRandomColor(),null));
        // to get Random color Automatic
        // to display message for clicking particular views in recyclerview
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "The Item is Clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private int getRandomColor() {
        // Method for getting Random Color code form colors.xml
        List<Integer> colorCode = new ArrayList<>();
        colorCode.add(R.color.purple_200);
        colorCode.add(R.color.purple_500);
        colorCode.add(R.color.purple_700);
        colorCode.add(R.color.teal_200);
        colorCode.add(R.color.teal_700);
        colorCode.add(R.color.white);
        colorCode.add(R.color.red);
        colorCode.add(R.color.dark_Purple);
        colorCode.add(R.color.light_pink);
        colorCode.add(R.color.does_not);

        Random randomColor = new Random(); // Created Random Class for Random Selection of Colors....//
        int number = randomColor.nextInt(colorCode.size());
        return colorCode.get(number);
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // variable created for views(note view layout)
        TextView noteTitle,noteContent;
        View view;
        //Created Variable for CardVIew
        CardView mCardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // assigned XML resources for above textViews(above)
            noteTitle = itemView.findViewById(R.id.titles);
            noteContent = itemView.findViewById(R.id.content);
            view = itemView;
            //assigning XML Resources for CardView
            mCardView = itemView.findViewById(R.id.noteCard);

        }
    }
}