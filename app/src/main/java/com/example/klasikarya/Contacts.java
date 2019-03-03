package com.example.klasikarya;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Contacts extends AppCompatActivity {

    private Button backToMenu;
    private TextView toInstagram;
    private TextView toYoutube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        backToMenu = (Button) findViewById(R.id.btnBackToMenu_contatcs);

        backToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Contacts.this, SecondActivity.class));
            }
        });

        toInstagram = (TextView) findViewById(R.id.tvToInstagram);

        toInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked_btn("https://instagram.com/klasikarya");
            }
        });

        toYoutube = (TextView) findViewById(R.id.tvToYoutube);

        toYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked_btn("https://www.youtube.com/watch?v=aYL9DNqUKJU");
            }
        });

    }

    public void clicked_btn(String url){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }


}
