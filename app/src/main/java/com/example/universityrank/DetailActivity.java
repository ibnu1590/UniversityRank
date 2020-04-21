package com.example.universityrank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    public static String EXTRA_NAME = "universitas";
    public static String EXTRA_RANK = "rank";
    public static String EXTRA_DETAIL = "detail";
    public static String EXTRA_WEB = "web";
    public static String EXTRA_ADDRESS = "address";
    public static String EXTRA_TELP = "telp";
    public static String EXTRA_PHOTO = "photo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView arrowBack = findViewById(R.id.imgBack);
        arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        TextView tvName = findViewById(R.id.txtName);
        TextView tvRank = findViewById(R.id.txtRank);
        TextView tvDetail = findViewById(R.id.txtDetail);
        TextView tvWeb = findViewById(R.id.txtWeb);
        TextView tvAddress = findViewById(R.id.txtAddress);
        TextView tvTelp = findViewById(R.id.txtTelp);
        ImageView imgPhoto = findViewById(R.id.detail_photo);

        tvName.setText(getIntent().getStringExtra(EXTRA_NAME));
        tvRank.setText(getIntent().getStringExtra(EXTRA_RANK));
        tvDetail.setText(getIntent().getStringExtra(EXTRA_DETAIL));
        tvWeb.setText(getIntent().getStringExtra(EXTRA_WEB));
        tvAddress.setText(getIntent().getStringExtra(EXTRA_ADDRESS));
        tvTelp.setText(getIntent().getStringExtra(EXTRA_TELP));
        Glide.with(this)
                .load(getIntent().getStringExtra(EXTRA_PHOTO))
                .into(imgPhoto);

    }
}
