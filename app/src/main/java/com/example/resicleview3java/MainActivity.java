package com.example.resicleview3java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.resicleview3java.R;
import com.example.resicleview3java.adapter.CustomAdapter;
import com.example.resicleview3java.model.User;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {

    private Context context;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        List<User> members = prepareMemberList();
        refreshAdapter(members);
    }

    private void initView() {
        context = this;
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 1));
    }

    private List<User> prepareMemberList() {
        List<User> members = new ArrayList<>();
        members.add(new User());
        for (int i = 0; i < 30; i++) {
            if (i == 0 || i == 5 || i == 16 || i == 25) {
                members.add(new User("Murodjon" + i, "Avazov" + i, false));
            } else {
                members.add(new User
                        ("Murodjon" + i, "Avazov" + i, true));
            }
        }
        members.add(new User());
        return members;
    }

    private void refreshAdapter(List<User> members) {
        CustomAdapter adapter = new CustomAdapter(context,members);
        recyclerView.setAdapter(adapter);
    }
}
