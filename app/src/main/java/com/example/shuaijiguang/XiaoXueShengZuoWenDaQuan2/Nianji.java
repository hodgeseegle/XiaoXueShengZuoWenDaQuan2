package com.example.shuaijiguang.XiaoXueShengZuoWenDaQuan2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import DB.DBManager;

public class Nianji extends AppCompatActivity implements View.OnClickListener {

    private ImageView one, two, three, four, five, six, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grade);

        initView();
        initEvent();
    }

    private void initEvent() {
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    private void initView() {
        one = (ImageView) findViewById(R.id.grade_one);
        two = (ImageView) findViewById(R.id.grade_two);
        three = (ImageView) findViewById(R.id.grade_three);
        four = (ImageView) findViewById(R.id.grade_four);
        five = (ImageView) findViewById(R.id.grade_five);
        six = (ImageView) findViewById(R.id.grade_six);

        back = (ImageView) findViewById(R.id.grade_back);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.grade_one: {
                Second_SearchActivity.db.getGradeList(DBManager.yinianji);
                String grade = DBManager.yinianji;
                Intent it = new Intent(Nianji.this, SearchListActivity.class);
                it.putExtra("grade", grade);
                startActivity(it);
            }
            break;
            case R.id.grade_two: {
                Second_SearchActivity.db.getGradeList(DBManager.ernianji);
                String grade = DBManager.ernianji;
                Intent it = new Intent(Nianji.this, SearchListActivity.class);
                it.putExtra("grade", grade);
                startActivity(it);
            }
            break;
            case R.id.grade_three: {
                Second_SearchActivity.db.getGradeList(DBManager.sannianji);
                String grade = DBManager.sannianji;
                Intent it = new Intent(Nianji.this, SearchListActivity.class);
                it.putExtra("grade", grade);
                startActivity(it);
            }
            break;
            case R.id.grade_four: {
                Second_SearchActivity.db.getGradeList(DBManager.sinianji);
                String grade = DBManager.sinianji;
                Intent it = new Intent(Nianji.this, SearchListActivity.class);
                it.putExtra("grade", grade);
                startActivity(it);
            }
            break;
            case R.id.grade_five: {
                Second_SearchActivity.db.getGradeList(DBManager.wunianji);
                String grade = DBManager.wunianji;
                Intent it = new Intent(Nianji.this, SearchListActivity.class);
                it.putExtra("grade", grade);
                startActivity(it);
            }
            break;
            case R.id.grade_six: {
                Second_SearchActivity.db.getGradeList(DBManager.liunianji);
                String grade = DBManager.liunianji;
                Intent it = new Intent(Nianji.this, SearchListActivity.class);
                it.putExtra("grade", grade);
                startActivity(it);
            }
            break;
            case R.id.grade_back: {
                back.setPressed(view.getId() == R.id.grade_back);
                finish();
            }
            break;
        }
    }
}
