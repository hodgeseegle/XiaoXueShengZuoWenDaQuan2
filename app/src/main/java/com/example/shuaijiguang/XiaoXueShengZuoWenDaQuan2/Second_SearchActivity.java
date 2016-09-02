package com.example.shuaijiguang.XiaoXueShengZuoWenDaQuan2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import DB.DBManager;

public class Second_SearchActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView img_search, img_grade, img_type;
    private EditText et;
    public static DBManager db;
    public static String info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_search);

        initView();

    }

    private void initView() {

        et = (EditText) findViewById(R.id.search_et);
        img_search = (ImageView) findViewById(R.id.search_search);
        img_grade = (ImageView) findViewById(R.id.search_grade);
        img_type = (ImageView) findViewById(R.id.search_type);


        img_search.setOnClickListener(this);
        img_grade.setOnClickListener(this);
        img_type.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        db = new DBManager(this);
        switch (view.getId()) {
            case R.id.search_search: {

                info = et.getText().toString();

                if (!info.equals("")) {

                    db.getSearchList(info);

                } else {

                    db.getAllList();

                }

                startActivity(new Intent(Second_SearchActivity.this, SearchListActivity.class));
            }break;

            case R.id.search_grade: {

                startActivity(new Intent(Second_SearchActivity.this, Nianji.class));

            }break;

            case R.id.search_type: {

                startActivity(new Intent(Second_SearchActivity.this, LeiBie.class));

            }break;
        }
    }


 ///////////////////退出框////////////

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            showNormalDialog();
        }
        return false;
    }

    private void showNormalDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Second_SearchActivity.this);
        builder.setIcon(R.mipmap.logo);
        builder.setTitle("退出");
        builder.setMessage("真的要退出吗 ?");
        builder.setPositiveButton("是的", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setNegativeButton("再看看", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }
}
