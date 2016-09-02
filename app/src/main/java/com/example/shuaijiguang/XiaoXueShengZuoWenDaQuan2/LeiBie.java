package com.example.shuaijiguang.XiaoXueShengZuoWenDaQuan2;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import DB.DBManager;

public class LeiBie extends AppCompatActivity implements View.OnClickListener {

    private ImageView back, xieren, xiejing, xiewu, kantu, shuxin, duhougan, xushi, xiangxiang, erge, tonghua, riji, kaoshi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.type);
        initView();
        initEvent();
    }

    private void initEvent() {
        back.setOnClickListener(this);
        xieren.setOnClickListener(this);
        xiejing.setOnClickListener(this);
        xiewu.setOnClickListener(this);
        kantu.setOnClickListener(this);
        shuxin.setOnClickListener(this);
        duhougan.setOnClickListener(this);
        xushi.setOnClickListener(this);
        xiangxiang.setOnClickListener(this);
        erge.setOnClickListener(this);
        tonghua.setOnClickListener(this);
        riji.setOnClickListener(this);
        kaoshi.setOnClickListener(this);
    }

    private void initView() {
        back = (ImageView) findViewById(R.id.type_back);
        xieren = (ImageView) findViewById(R.id.type_xieren);
        xiejing = (ImageView) findViewById(R.id.type_xiejing);
        xiewu = (ImageView) findViewById(R.id.type_xiewu);
        kantu = (ImageView) findViewById(R.id.type_kantu);
        shuxin = (ImageView) findViewById(R.id.type_shuxin);
        duhougan = (ImageView) findViewById(R.id.type_duhougan);
        xushi = (ImageView) findViewById(R.id.type_xushi);
        xiangxiang = (ImageView) findViewById(R.id.type_xiangxiang);
        erge = (ImageView) findViewById(R.id.type_erge);
        tonghua = (ImageView) findViewById(R.id.type_tonghua);
        riji = (ImageView) findViewById(R.id.type_riji);
        kaoshi = (ImageView) findViewById(R.id.type_kaoshi);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.type_back: {
            //    back.setPressed(view.getId() == R.id.type_back);
                finish();
            }
            break;
            case R.id.type_xieren: {
                String type = DBManager.xieren;
                Second_SearchActivity.db.getTypeList(type);
                Intent it = new Intent(LeiBie.this, SearchListActivity.class);
                it.putExtra("type", type);
                startActivity(it);
            }
            break;
            case R.id.type_xiejing: {
                String type = DBManager.xiejing;
                Second_SearchActivity.db.getTypeList(type);
                Intent it = new Intent(LeiBie.this, SearchListActivity.class);
                it.putExtra("type", type);
                startActivity(it);
            }
            break;
            case R.id.type_xiewu: {
                String type = DBManager.xiewu;
                Second_SearchActivity.db.getTypeList(type);
                Intent it = new Intent(LeiBie.this, SearchListActivity.class);
                it.putExtra("type", type);
                startActivity(it);
            }
            break;
            case R.id.type_kantu: {
                String type = DBManager.kantu;
                Second_SearchActivity.db.getTypeList(type);
                Intent it = new Intent(LeiBie.this, SearchListActivity.class);
                it.putExtra("type", type);
                startActivity(it);
            }
            break;
            case R.id.type_shuxin: {
                String type = DBManager.shuxin;
                Second_SearchActivity.db.getTypeList(type);
                Intent it = new Intent(LeiBie.this, SearchListActivity.class);
                it.putExtra("type", type);
                startActivity(it);
            }
            break;
            case R.id.type_duhougan: {
                String type = DBManager.duhougan;
                Second_SearchActivity.db.getTypeList(type);
                Intent it = new Intent(LeiBie.this, SearchListActivity.class);
                it.putExtra("type", type);
                startActivity(it);
            }
            break;
            case R.id.type_xushi: {
                String type = DBManager.xushi;
                Second_SearchActivity.db.getTypeList(type);
                Intent it = new Intent(LeiBie.this, SearchListActivity.class);
                it.putExtra("type", type);
                startActivity(it);
            }
            break;
            case R.id.type_xiangxiang: {
                String type = DBManager.xiangxiang;
                Second_SearchActivity.db.getTypeList(type);
                Intent it = new Intent(LeiBie.this, SearchListActivity.class);
                it.putExtra("type", type);
                startActivity(it);
            }
            break;
            case R.id.type_erge: {
                String type = DBManager.erge;
                Second_SearchActivity.db.getTypeList(type);
                Intent it = new Intent(LeiBie.this, SearchListActivity.class);
                it.putExtra("type", type);
                startActivity(it);
            }
            break;
            case R.id.type_tonghua: {
                String type = DBManager.tonghua;
                Second_SearchActivity.db.getTypeList(type);
                Intent it = new Intent(LeiBie.this, SearchListActivity.class);
                it.putExtra("type", type);
                startActivity(it);
            }
            break;
            case R.id.type_riji: {
                String type = DBManager.riji;
                Second_SearchActivity.db.getTypeList(type);
                Intent it = new Intent(LeiBie.this, SearchListActivity.class);
                it.putExtra("type", type);
                startActivity(it);
            }
            break;
            case R.id.type_kaoshi: {
                String type = DBManager.kaoshi;
                Second_SearchActivity.db.getTypeList(type);
                Intent it = new Intent(LeiBie.this, SearchListActivity.class);
                it.putExtra("type", type);
                startActivity(it);
            }
            break;


        }
    }
}
