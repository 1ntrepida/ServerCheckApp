package com.example.android.servercheck;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void refresh(View view) {
        ServerCheckCode data = new ServerCheckCode();
        data.loadInfo();
        TextView info = (TextView) findViewById(R.id.info);
        info.setText(data.output("Australia","42ms"));
    }

}
