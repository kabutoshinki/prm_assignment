package com.example.exe_2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.exe_2.data.Product;
import com.example.exe_2.R;

public class IntroActivity extends AppCompatActivity {
    Button addBtn,showBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_intro);

        Product product = getIntent().getParcelableExtra("product");
        System.out.println("main activity: "+(product==null) );

        showBtn = findViewById(R.id.showBtn);
        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showListProduct();
            }
        });


        addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFormAddProduct();
            }
        });

    }

    public void openFormAddProduct(){
        Intent intent = new Intent(IntroActivity.this, AddProductActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
        finish();
    }

    public void showListProduct(){
        Intent intent = new Intent(IntroActivity.this, ShowActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);

        finish();
    }
}