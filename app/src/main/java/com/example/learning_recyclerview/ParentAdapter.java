package com.example.learning_recyclerview;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.ViewHolder> {

    private List<Integer> mViewColors;
    private List<String> mAnimals;
    private LayoutInflater mInflater;
    private Context cntx;

    // data is passed into the constructor
    ParentAdapter(Context context, List<Integer> colors, List<String> animals) {
        this.mInflater = LayoutInflater.from(context);
        cntx = context;

        this.mViewColors = colors;
        this.mAnimals = animals;
    }

    @NonNull
    @Override
    public ParentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.parent_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentAdapter.ViewHolder holder, int position) {
        int color = mViewColors.get(position);
        String animal = mAnimals.get(position);
        holder.text.setText(animal);

        ArrayList<Integer> viewColors = new ArrayList<>();
        viewColors.add(Color.BLUE);
        viewColors.add(Color.YELLOW);
        viewColors.add(Color.MAGENTA);
        viewColors.add(Color.RED);
        viewColors.add(Color.BLACK);

        ArrayList<String> animalNames = new ArrayList<>();
        animalNames.add("Horse");
        animalNames.add("Cow");
        animalNames.add("Camel");
        animalNames.add("Sheep");
        animalNames.add("Goat");

        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(holder.recyclerView.getContext(), LinearLayoutManager.HORIZONTAL, false);
        holder.recyclerView.setLayoutManager(horizontalLayoutManager);
        ChildAdapter adapter;
        adapter = new ChildAdapter(cntx, viewColors, animalNames);
        holder.recyclerView.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return mAnimals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text;

        RecyclerView recyclerView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.textView);
            recyclerView = itemView.findViewById(R.id.rv_child);

        }
    }

    public String getItem(int id) {
        return mAnimals.get(id);
    }
}
