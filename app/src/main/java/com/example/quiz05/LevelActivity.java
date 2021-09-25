package com.example.quiz05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class LevelActivity extends AppCompatActivity implements LevelAdapter.ItemListener {
    RecyclerView recyclerView;
    LevelAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        initAdapter();
    }
    private void initAdapter() {
        recyclerView = findViewById(R.id.level_recycler);
        ArrayList<QuestionModel> listModel = new ArrayList<>();
        QuestionModel questionModel1 = new QuestionModel("1 уровень",
                "Зимой и летом одним цветом?",
                "Ель", "Ель", "Яйцо",
                "Кровь", "Президент");
        QuestionModel questionModel2 = new QuestionModel("2 уровень",
                "H2o что это?",
                "Вода", "огонь", "Вода",
                "Уголь", "Соль");
        QuestionModel questionModel3 = new QuestionModel("3 уровень",
                "Зимой и летом одним цветом",
                "Ель", "Ель", "Яйцр",
                "Кровь", "Президент");
        listModel.add(questionModel1);
        listModel.add(questionModel2);
        listModel.add(questionModel3);
        adapter = new LevelAdapter(listModel,this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(QuestionModel model) {
        Intent intent = new Intent(LevelActivity.this,GameActivity.class);
        intent.putExtra("model",model);
        startActivity(intent);
    }
}