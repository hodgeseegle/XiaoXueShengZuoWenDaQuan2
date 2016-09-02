package com.example.shuaijiguang.XiaoXueShengZuoWenDaQuan2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView go;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        initView();
    }

    private void initView() {

        go = (ImageView) findViewById(R.id.welcome_go);
        go.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        go.setPressed(view.getId()==R.id.welcome_go);
        startActivity(new Intent(MainActivity.this,Second_SearchActivity.class));

        finish();
    }
}
