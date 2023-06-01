package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Carousel;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    EditText name,mob,email;
    Button button;
    Boolean direction = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Integer> list = new ArrayList<>(4);
        list.add(R.drawable.ram1);
        list.add(R.drawable.ram2);
        list.add(R.drawable.ram3);
        list.add(R.drawable.ram4);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewId);
        LinearLayoutManager atat = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(atat);
//      recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        AdapterRecyc irir = new AdapterRecyc(this, list);
        recyclerView.setAdapter(irir);

        LinearSnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
//                if(atat.findFirstCompletelyVisibleItemPosition()<(irir.getItemCount()-1)){
//                    Log.e("findFirst(if)==  ",String.valueOf(atat.findFirstCompletelyVisibleItemPosition()));
//                    Log.e("findLast(if)=  ",String.valueOf(atat.findLastCompletelyVisibleItemPosition()+1));
//                    atat.smoothScrollToPosition(recyclerView,new RecyclerView.State(),atat.findLastCompletelyVisibleItemPosition()+1);
//                }else if(atat.findLastCompletelyVisibleItemPosition()==(irir.getItemCount()-1)){
//                    Log.e("findLast(else)=  ",String.valueOf(atat.findLastCompletelyVisibleItemPosition()+1));
//                    atat.smoothScrollToPosition(recyclerView,new RecyclerView.State(),0);
            if(atat.findFirstCompletelyVisibleItemPosition()==0){direction = true;}
            if(atat.findLastCompletelyVisibleItemPosition()==(irir.getItemCount()-1)){direction = false;}
            if(atat.findFirstCompletelyVisibleItemPosition()<(irir.getItemCount()-1) && direction==true) {
                atat.smoothScrollToPosition(recyclerView,new RecyclerView.State(),atat.findFirstCompletelyVisibleItemPosition()+1);
            }
            else if(atat.findFirstCompletelyVisibleItemPosition()>0 && direction==false){
                    atat.smoothScrollToPosition(recyclerView,new RecyclerView.State(),atat.findFirstCompletelyVisibleItemPosition()-1);
            }
            }
        },0,3000);
        IntentFunction();
    }

    private void IntentFunction() {
        name = findViewById(R.id.edittext1);
        mob = findViewById(R.id.edittext2);
        email = findViewById(R.id.edittext3);
        button = findViewById(R.id.idbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1 = name.getText().toString();
                String mob1 = mob.getText().toString();
                String email1 = email.getText().toString();
                Intent intent = new Intent(getApplicationContext(),display.class);
                intent.putExtra("name1",name1);
                intent.putExtra("mob1",mob1);
                intent.putExtra("email1",email1);
                startActivity(intent);
            }
        });
    }

}