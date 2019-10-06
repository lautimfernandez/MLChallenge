package com.example.mlchallenge.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Product implements Serializable {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("price")
    @Expose
    private float price;

    @SerializedName("condition")
    @Expose
    private String condition;

    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;

    @SerializedName("sold_quantity")
    @Expose
    private int soldQuantity;

    @SerializedName("available_quantity")
    @Expose
    private int avaliableQuantity;

    @SerializedName("accepts_mercadopago")
    @Expose
    private boolean acceptsMercadoPago;

    @SerializedName("address")
    @Expose
    private Address address;

    @SerializedName("shipping")
    @Expose
    private Shipping shipping;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public float getPrice() {
        return price;
    }

    public String getCondition() {
        return condition;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public int getSoldQuantity() {
        return soldQuantity;
    }

    public int getAvaliableQuantity() {
        return avaliableQuantity;
    }

    public boolean getAcceptsMercadoPago() {
        return acceptsMercadoPago;
    }

    public Address getAddress() {
        return address;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public String getPriceFormated() {
        final NumberFormat decimalFormat = new DecimalFormat().getNumberInstance(Locale.GERMAN);
        decimalFormat.setRoundingMode(RoundingMode.CEILING);
        decimalFormat.setMaximumFractionDigits(2);
        return decimalFormat.format(price);
    }
}
