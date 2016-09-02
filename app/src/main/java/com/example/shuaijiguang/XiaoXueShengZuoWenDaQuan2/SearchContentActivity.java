package com.example.shuaijiguang.XiaoXueShengZuoWenDaQuan2;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shuaijiguang.XiaoXueShengZuoWenDaQuan2.R;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.SynthesizerListener;

import pojo.ZuoWen;

public class SearchContentActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView img_back, img_yuyin;
    private TextView tv_title, tv_txt;
    private String title, txt, allContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchcontent);

        SpeechUtility.createUtility(this, SpeechConstant.APPID+"=57996577");

        initView();

        Intent it = getIntent();
        ZuoWen info = (ZuoWen) it.getSerializableExtra("info");
        title = info.getTitle();
        txt = info.getTxt();

        initEvent();

    }

    private void initEvent() {

        img_back.setOnClickListener(this);
        img_yuyin.setOnClickListener(this);
        tv_title.setText(title);
        tv_txt.setText(Html.fromHtml(txt));
        allContent = tv_title.getText().toString() + tv_txt.getText().toString();
    }

    private void initView() {
        img_back = (ImageView) findViewById(R.id.searchcontent_back);
        img_yuyin = (ImageView) findViewById(R.id.searchcontent_yuyin);

        tv_title = (TextView) findViewById(R.id.searchcontent_tv_title);
        tv_txt = (TextView) findViewById(R.id.searchcontent_tv_txt);

        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/fzjzjt.ttf");
        tv_title.setTypeface(typeFace);
        tv_txt.setTypeface(typeFace);

    }

    SpeechSynthesizer mTts;

    boolean flag = true;
    boolean flag1 = true;

    @Override
    public void onClick(View view) {
        setEvent(view);
        switch (view.getId()) {

            case R.id.searchcontent_back: {

                finish();

            }break;


            case R.id.searchcontent_yuyin: {

                mTts = SpeechSynthesizer.createSynthesizer(this, null);

                mTts.setParameter(SpeechConstant.VOICE_NAME, "xiaoqian");
                mTts.setParameter(SpeechConstant.SPEED, "50");
                mTts.setParameter(SpeechConstant.VOLUME, "80");
                mTts.setParameter(SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_CLOUD);

                if (flag) {
                    mTts.startSpeaking(allContent, mSynListener);
                    flag = false;

                    Log.i("MainActivity","==========开始播放============");

                } else {

                    if (flag1) {

                        mTts.pauseSpeaking();

                        Log.i("MainActivity","==============暂停==============="+mTts.isSpeaking());

                        flag1=false;

                    } else {
                        mTts.resumeSpeaking();
                        Log.i("MainActivity","===============停止============"+mTts.isSpeaking());
                        flag1=true;
                    }
                }
            }
            break;
        }
    }

    private SynthesizerListener mSynListener = new SynthesizerListener() {
        public void onCompleted(SpeechError error) {
        }

        public void onBufferProgress(int percent, int beginPos, int endPos, String info) {
        }

        public void onSpeakBegin() {
        }

        public void onSpeakPaused() {
        }

        public void onSpeakProgress(int percent, int beginPos, int endPos) {
        }

        public void onSpeakResumed() {
        }

        public void onEvent(int arg0, int arg1, int arg2, Bundle arg3) {
        }
    };

    private void setEvent(View view) {
        img_back.setPressed(view.getId() == R.id.searchcontent_back);
        img_yuyin.setSelected(view.getId() == R.id.searchcontent_yuyin);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mTts != null) {
            mTts.stopSpeaking();
        }
    }

}
