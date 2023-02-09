package com.example.exe_2.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.exe_2.data.NewProduct;
import com.example.exe_2.data.Product;
import com.example.exe_2.adapter.ProductAdapter;
import com.example.exe_2.R;

import java.util.ArrayList;

public class ShowActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    private ImageView homeBtn;
    private Button addNewProduct;
    public ArrayList<Product> listProducts = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_show);

        recyclerView = findViewById(R.id.recyclerView);
        addNewProduct = findViewById(R.id.addNewProduct);

        addNewProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAddActivity();
            }
        });

        productAdapter = new ProductAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        productAdapter.initData(getListProducts());
        recyclerView.setAdapter(productAdapter);

        homeBtn = findViewById(R.id.homeBtn);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnIntroActivity();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Product product = NewProduct.product;
        System.out.println("product: "+ product.toString());
        if(!(product.getName()==null)){
            productAdapter.addData(product);
            System.out.println("success");
            recyclerView.setAdapter(productAdapter);
        }
                NewProduct.product = new Product();
    }

    private void returnIntroActivity(){
        Intent intent = new Intent(this, IntroActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }
    private ArrayList<Product> getListProducts(){
        ArrayList<Product> list = new ArrayList<>();
        list.add(new Product(R.drawable.ic_launcher_background,"a","b",1,2.2,"Huy"));
        list.add(new Product(R.drawable.ic_launcher_background,"c","d",2,3.2,"Huy"));
        list.add(new Product(R.drawable.ic_launcher_background,"e","f",3,4.2,"Huy"));
        list.add(new Product(R.drawable.ic_launcher_background,"g","h",4,2.2,"Huy"));

        return  list;
    }
    private void startAddActivity(){
        Intent intent = new Intent(ShowActivity.this, AddProductActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

}