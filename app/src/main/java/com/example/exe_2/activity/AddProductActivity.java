package com.example.exe_2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.exe_2.data.NewProduct;
import com.example.exe_2.data.Product;
import com.example.exe_2.R;

public class AddProductActivity extends AppCompatActivity {
    private EditText editId,editName,editQuantity,editPrice,editMaker;
    private Button addProductBtn,returnBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_add_product);
        editId = findViewById(R.id.editId);
        editName = findViewById(R.id.editName);
        editQuantity = findViewById(R.id.editQuantity);
        editPrice = findViewById(R.id.editPrice);
        editMaker = findViewById(R.id.editMaker);

        addProductBtn = findViewById( R.id.addProductBtn);
        returnBtn = findViewById(R.id.returnBtn);

        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnIntroActivity();
            }
        });

        addProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData();
            }
        });


    }


    private void addData(){
        boolean checkId = editId.getText().toString().isEmpty();
        boolean checkName = editName.getText().toString().isEmpty();
        boolean checkQuantity = editQuantity.getText().toString().isEmpty();
        boolean checkPrice = editPrice.getText().toString().isEmpty();
        boolean checkMaker = editMaker.getText().toString().isEmpty();
        if(checkId || checkName || checkQuantity || checkPrice || checkMaker){
            Toast.makeText(AddProductActivity.this, "Please Fill Full Information", Toast.LENGTH_SHORT).show();
        }
        if(!checkId && !checkName && !checkQuantity && !checkPrice && !checkMaker){
            Product product = new Product(R.drawable.ic_launcher_background,editId.getText().toString(),editName.getText().toString(),(Integer.parseInt(editQuantity.getText().toString())),Double.parseDouble(editPrice.getText().toString()),editMaker.getText().toString());
            Intent intent = new Intent(AddProductActivity.this, ShowActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            intent.putExtra("product",  product);
            NewProduct.product = product;
            startActivity(intent);
            finish();

        }
    }
    private void returnIntroActivity(){
        Intent intent = new Intent(this, IntroActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }


}