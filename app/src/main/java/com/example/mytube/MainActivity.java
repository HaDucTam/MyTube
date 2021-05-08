package com.example.mytube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText edit = findViewById(R.id.editText);
        ImageButton im = findViewById(R.id.btplay);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = edit.getText().toString();
                //Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                intent.putExtra("LINK", s);
                startActivity(intent);
            }
        });
    }
}