package com.nabin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Emergency extends AppCompatActivity {

    Button message;
    EditText friendsnum;
    String phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);

        message = (Button)findViewById(R.id.message);
        friendsnum = (EditText)findViewById(R.id.friendsnum);


        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phone = friendsnum.getText().toString();
                Intent send = new Intent(Intent.ACTION_VIEW);
                send.putExtra("address",phone);
                send.putExtra("sms_body", "I am in emergency please help");
                send.setType("vnd.android-dir/mms-sms");
                startActivity(send);
            }
        });


    }

}
