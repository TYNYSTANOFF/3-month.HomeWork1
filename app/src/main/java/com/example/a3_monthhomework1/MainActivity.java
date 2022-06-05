package com.example.a3_monthhomework1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText first;
    private EditText second;
    private EditText third;
    private Button send;
    public static final String KEY_FOR_INTENT = "key.intent";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        first = findViewById(R.id.et_first);
        second = findViewById(R.id.et_second);
        third = findViewById(R.id.et_third);
        send = findViewById(R.id.btn_send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setType("plain/text");
                intent.setData(Uri.parse("mailto:"));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{first.getText().toString()});
                intent.putExtra(Intent.EXTRA_SUBJECT, second.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, third.getText().toString());
                startActivity(Intent.createChooser(intent, "Отправка письма..."));
//                try {
//                    startActivity(Intent.createChooser(intent, "Send mail..."));
//                } catch (android.content.ActivityNotFoundException ex) {
//                    Toast.makeText(MainActivity.this, "There are no clients installed.", Toast.LENGTH_SHORT).show();
//                }
//                startActivity(intent);
            }
        });
    }
//

}