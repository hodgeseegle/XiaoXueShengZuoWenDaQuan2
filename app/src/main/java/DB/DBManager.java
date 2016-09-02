package DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import pojo.ZuoWen;

/**
 * Created by shuaijiguang on 2016/8/1.
 */
public class DBManager {
    public final static String fileName = "xxszw.db";
    public final static String tableName = "ZuoWenDaQuan";
    public final static String yinianji = "一年级";
    public final static String ernianji = "二年级";
    public final static String sannianji = "三年级";
    public final static String sinianji = "四年级";
    public final static String wunianji = "五年级";
    public final static String liunianji = "六年级";

    public final static String xieren = "写人";
    public final static String xiejing = "写景";
    public final static String xiewu = "写物";
    public final static String kantu = "看图";
    public final static String shuxin = "书信";
    public final static String duhougan = "读后感";
    public final static String xushi = "叙事";
    public final static String xiangxiang = "想象";
    public final static String erge = "儿歌";
    public final static String tonghua = "童话";
    public final static String riji = "日记";
    public final static String kaoshi = "考试";

    private Context context;
    private SQLiteDatabase db;
    public static List<ZuoWen> list;
    File file;

    public DBManager(Context context) {
        this.context = context;
        file = new File("data/data/" + context.getPackageName() + "/aa");
        if (!file.exists()) {
            file.mkdir();
        }
        createDataBase();

        db = SQLiteDatabase.openOrCreateDatabase(file.getAbsoluteFile() + "/zuowen.db", null);
    }

    private void createDataBase() {

        try {
            InputStream in = context.getAssets().open(fileName);
            OutputStream out = new FileOutputStream(file.getAbsoluteFile() + "/zuowen.db");
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) != -1) {
                out.write(buffer, 0, length);
            }
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getSearchList(String info) {

        list = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from " + tableName + " where title like '" + info + "%'", null);
        while (cursor.moveToNext()) {
            String title = cursor.getString(cursor.getColumnIndex("title"));
            String txt = cursor.getString(cursor.getColumnIndex("txt"));

            list.add(new ZuoWen(title, txt));
        }
        cursor.close();
    }

    public void getAllList() {

        list = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from " + tableName, null);
        while (cursor.moveToNext()) {
            String title = cursor.getString(cursor.getColumnIndex("title"));
            String txt = cursor.getString(cursor.getColumnIndex("txt"));

            list.add(new ZuoWen(title, txt));
        }
        cursor.close();
    }

    public void getGradeList(String grade) {
        list = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from " + tableName + " where nianji = ?", new String[]{grade});
        while (cursor.moveToNext()) {
            String title = cursor.getString(cursor.getColumnIndex("title"));
            String txt = cursor.getString(cursor.getColumnIndex("txt"));
            String nianji = cursor.getString(cursor.getColumnIndex("nianji"));
            list.add(new ZuoWen(title, txt, nianji));
        }
        cursor.close();
    }
    public void getTypeList(String type){
        list = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from " + tableName + " where class = ?", new String[]{type});
        while (cursor.moveToNext()) {
            String title = cursor.getString(cursor.getColumnIndex("title"));
            String txt = cursor.getString(cursor.getColumnIndex("txt"));
            String nianji = cursor.getString(cursor.getColumnIndex("nianji"));
            String type1 = cursor.getString(cursor.getColumnIndex("class"));
            list.add(new ZuoWen(title, txt, nianji,type1));
        }
        cursor.close();
    }
}
