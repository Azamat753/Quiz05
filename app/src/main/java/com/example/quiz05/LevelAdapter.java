package com.example.quiz05;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LevelAdapter extends RecyclerView.Adapter<LevelAdapter.LevelViewHolder> {

    public LevelAdapter(ArrayList<QuestionModel> list,ItemListener listener) {
        this.list = list;
        this.listener = listener;
    }

    ItemListener listener;
    ArrayList<QuestionModel> list;
    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public LevelAdapter.LevelViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_level,parent,false);
        return new LevelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull LevelAdapter.LevelViewHolder holder, int position) {
       holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class LevelViewHolder extends RecyclerView.ViewHolder {
        Button button;
        public LevelViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.level_btn);
        }

        public void onBind(QuestionModel model){
            button.setText(model.getCurrentLevel());
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(model);
                }
            });
        }
    }
    public interface ItemListener{
        void onItemClick(QuestionModel model);
    }
}
