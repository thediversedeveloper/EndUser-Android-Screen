package com.example.inventoryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {


    private Object View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    public void smsSendMessage(View Object view;
        view){

        TextView textView = (TextView) findViewById(R.id.mobilenumber);

        String smsNumber = String.format("smsto: %s", textView.getText().toString());

        EditText smsEditText = (EditText) findViewById(R.id.mobilenumber);

        String sms = smsEditText.getText().toString();

     public getClass(Intent)
        Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
        smsIntent.setData(Uri.parse(smsNumber));
        smsIntent.putExtra("sms_body", sms);

        if (smsIntent.resolveActivity(getPackageManager()) != null) {

        } else
            Log.d(Item, "Can't send action");


    }
}

