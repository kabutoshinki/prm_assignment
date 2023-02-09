package com.example.exe_2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exe_2.data.Product;
import com.example.exe_2.R;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{

    private Context context;
    private ArrayList<Product> listProducts;

    public ProductAdapter(Context context) {
        this.context = context;
    }

    public void initData(ArrayList<Product>list){
        this.listProducts = list;
        notifyDataSetChanged();
    }
    public void addData(Product product){
        this.listProducts.add(product);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_view,parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = listProducts.get(position);
        if(product==null){
            return;
        }
        holder.image.setImageResource(product.getImage());
        holder.productId.setText(product.getId());
        holder.productName.setText(product.getName());
        holder.quantity.setText(String.valueOf(product.getQuantity()));
        holder.price.setText(String.valueOf(product.getPrice()));
        holder.maker.setText(product.getMaker());
    }

    @Override
    public int getItemCount() {
        if(listProducts !=null){
            return listProducts.size();
        }
        return 0;
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{
        private TextView productId,productName,quantity,price,maker;
        private ImageView image;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageProduct);
            productId = itemView.findViewById(R.id.productId);
            productName = itemView.findViewById(R.id.productName);
            quantity = itemView.findViewById(R.id.quantity);
            price = itemView.findViewById(R.id.price);
            maker = itemView.findViewById(R.id.maker);
        }
    }
}