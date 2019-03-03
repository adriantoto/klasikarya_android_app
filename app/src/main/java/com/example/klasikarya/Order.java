package com.example.klasikarya;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Order extends AppCompatActivity {

    private EditText companyName, phone, socialMedia, product;
    private Button submit;
    String nama_company, nomor_hp, sosmed, produk;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        setupUIViews();

        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    //uploading data to the database
                    //FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                    sendUserData();
                    progressDialog.setMessage("Your data had been sent! Our staff will contact you ASAP. Thanks!");
                    progressDialog.show();
                    finish();
                    startActivity(new Intent(Order.this, OrderSplashScreen.class));
                }
            }
        });


    }

    private void setupUIViews(){
        companyName = (EditText) findViewById(R.id.etCompanyName);
        phone = (EditText) findViewById(R.id.etPhone);
        socialMedia = (EditText) findViewById(R.id.etOtherSocialMedia);
        product = (EditText) findViewById(R.id.etOrderProduct);
        submit = (Button) findViewById(R.id.btnSubmit);
    }

    private Boolean validate(){
        Boolean result = false;
        nama_company = companyName.getText().toString();
        nomor_hp = phone.getText().toString();
        sosmed = socialMedia.getText().toString();
        produk = product.getText().toString();

        if(nama_company.isEmpty() || nomor_hp.isEmpty() || produk.isEmpty()){
            Toast.makeText(this, "Please enter all the details", Toast.LENGTH_LONG).show();
        }else{
            result = true;
        }
        return result;
    }

    private void sendUserData(){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference(firebaseAuth.getCurrentUser().getUid());
        UserOrder userOrder = new UserOrder(nama_company, nomor_hp, sosmed, produk);
        myRef.setValue(userOrder);
    }

}
