package com.example.exe_2.data;

import java.util.ArrayList;

public class NewProduct {
    private ArrayList<Product> listProduct;
    public static  Product product = new Product();
    public ArrayList<Product> getListProduct(){
        return this.listProduct;
    }

    public  void addProductProduct(Product product){
        ArrayList<Product> list = this.listProduct;
        list.add(product);
        this.listProduct = list;
    }

    public ArrayList<Product> addAll(ArrayList<Product> list){
       this.listProduct = list;
        return  this.listProduct;
    }
}
