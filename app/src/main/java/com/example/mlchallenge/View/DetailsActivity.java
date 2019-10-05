package com.example.mlchallenge.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mlchallenge.Model.Product;
import com.example.mlchallenge.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    @BindView(R.id.imageDetails)
    ImageView imageDetails;
    @BindView(R.id.soldQuantity)
    TextView soldQuantity;
    @BindView(R.id.titleDetails)
    TextView titleDetails;
    @BindView(R.id.priceDetails)
    TextView priceDetails;
    @BindView(R.id.address)
    TextView address;
    @BindView(R.id.shipping)
    ImageView shipping;
    @BindView(R.id.mercadoPago)
    ImageView mercadoPago;
    @BindView(R.id.spinner)
    Spinner avaliableQuantity;
    @BindView(R.id.buy)
    Button comprar;
    @BindView(R.id.cart)
    Button cart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle extras = getIntent().getExtras();
        Product product = (Product) extras.getSerializable("product");
        ButterKnife.bind(this);

        soldQuantity.setText(product.getSoldQuantity() + "");
        titleDetails.setText(product.getTitle());
        priceDetails.setText("$"+product.getPrice());
        address.setText(product.getAddress().getStateName()+ ", "  +product.getAddress().getCityName());
        if(product.getShipping().isFreeShipping()){
            shipping.setVisibility(View.VISIBLE);
        }
        if(product.getAcceptsMercadoPago()){
            mercadoPago.setVisibility(View.VISIBLE);
        }

        Glide.with(this)
                .load(product.getThumbnail())
                .into(imageDetails);



    }
}
