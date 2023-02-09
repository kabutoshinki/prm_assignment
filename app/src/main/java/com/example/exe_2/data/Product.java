package com.example.exe_2.data;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Product implements Parcelable {
    private int image;
    private String id;
    private String name;
    private int quantity;
    private double price;
    private String maker;

    public Product(){

    }
    public Product(int image,String id, String name, int quantity, double price, String maker) {
        this.image = image;
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.maker = maker;
    }

    protected Product(Parcel in) {
        image = in.readInt();
        id = in.readString();
        name = in.readString();
        quantity = in.readInt();
        price = in.readDouble();
        maker = in.readString();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "image=" + image +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", maker='" + maker + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(image);
        dest.writeString(id);
        dest.writeString(name);
        dest.writeInt(quantity);
        dest.writeDouble(price);
        dest.writeString(maker);
    }
}
