package com.example.shuaijiguang.XiaoXueShengZuoWenDaQuan2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import adapter.SearchAdapter;
import DB.DBManager;
import pojo.ZuoWen;
import refresh.RefreshableView;

public class SearchListActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private ListView lv;
    private TextView tv_content, tv_num,tv_content2,tv_content3;
    private ImageView img_back;
    public static SearchAdapter adapter;
    private String s;
    RefreshableView refreshableView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchlist);




        s = Second_SearchActivity.info;
        lv = (ListView) findViewById(R.id.searchlist_lv);
        img_back = (ImageView) findViewById(R.id.searchlist_back);
        tv_content = (TextView) findViewById(R.id.searchlist_tv_et);
        tv_content2 = (TextView) findViewById(R.id.searchlist_tv_et2);
        tv_content3 = (TextView) findViewById(R.id.searchlist_tv_et3);
        tv_num = (TextView) findViewById(R.id.searchlist_tv_num);

        adapter = new SearchAdapter(this, DBManager.list);
        lv.setAdapter(adapter);

        refreshableView = (RefreshableView) findViewById(R.id.refreshable_view);

        initEvent();


    }

    private void initEvent() {

    ////////////点击 按年级查询 后  跳转到此页面

        String grade = getIntent().getStringExtra("grade");
        tv_content.setText(s);
        tv_num.setText(DBManager.list.size() + "篇");
        tv_content2.setText(grade);


     ///////////点击 按类别查询 后  跳转到此页面

        String type = getIntent().getStringExtra("type");
        tv_content3.setText(type);

        img_back.setOnClickListener(this);

        lv.setOnItemClickListener(this);


  ///////////// 下拉刷新 功能 ///////////////

        refreshableView.setOnRefreshListener(new RefreshableView.PullToRefreshListener() {
            @Override
            public void onRefresh() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                refreshableView.finishRefreshing();
            }
        },0);
    }


    @Override
    public void onClick(View view) {
      //  img_back.setPressed(view.getId() == R.id.searchlist_back);

        finish();
    }



 /////////////对 ListView 的列表点击 进行跳转

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent it = new Intent(SearchListActivity.this, SearchContentActivity.class);
        ZuoWen info = DBManager.list.get(i);
        it.putExtra("info",info);
        startActivity(it);
    }
}
