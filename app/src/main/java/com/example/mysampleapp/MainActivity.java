package com.example.mysampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import zendesk.core.AnonymousIdentity;
import zendesk.core.Identity;
import zendesk.core.Zendesk;
import zendesk.support.Support;
import zendesk.support.guide.HelpCenterActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Zendesk.INSTANCE.init(this, "https://z3nericagirges.zendesk.com",
                "d9d0bad461a6baef2184440f02366a78a520719f886cbe53",
                "mobile_sdk_client_a1b2bc0a0fb8ded629bb");

        Identity identity = new AnonymousIdentity();
        Zendesk.INSTANCE.setIdentity(identity);

        Support.INSTANCE.init(Zendesk.INSTANCE);

        Button helpCenterButton = (Button) findViewById(R.id.help_button);

        helpCenterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                HelpCenterActivity.builder()
                        .show(MainActivity.this);
            }
        });
    }
}