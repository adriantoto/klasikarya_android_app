package com.example.klasikarya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OurProducts extends AppCompatActivity {

    private Button backToMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_products);

        backToMenu = (Button) findViewById(R.id.btnBackToMenu_product);

        backToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OurProducts.this, SecondActivity.class));
            }
        });

    }
}
