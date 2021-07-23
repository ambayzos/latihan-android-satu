package com.example.latihanandorid.satu;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class About extends AppCompatActivity {
    private String title = "About";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        setActionBarTitle(title);

        ImageView imgMe = findViewById(R.id.img_item_photo);

        Glide.with(this)
                .load("https://d17ivq9b7rppb3.cloudfront.net/small/avatar/202107190051575b7ee8bda26ba84d61b23bfa17a91aae.png")
                .apply(new RequestOptions())
                .into(imgMe);

    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


}
