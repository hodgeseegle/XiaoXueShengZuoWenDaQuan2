package adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.shuaijiguang.XiaoXueShengZuoWenDaQuan2.R;

import java.util.List;

import pojo.ZuoWen;

/**
 * Created by shuaijiguang on 2016/8/1.
 */
public class SearchAdapter extends BaseAdapter {
    List<ZuoWen> list;
    LayoutInflater inflater;
    Typeface typeFace;
    public SearchAdapter(Context context, List<ZuoWen> list) {
        this.list = list;
        inflater = LayoutInflater.from(context);

    //////////////设置字体//////
        typeFace = Typeface.createFromAsset(context.getAssets(), "fonts/fzjzjt.ttf");
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {


        ViewHolder holder ;

        if (convertView == null) {

            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_searchlist, null);
            holder.tv_num = (TextView) convertView.findViewById(R.id.item_searchlist_tvnum);
            holder.tv_title = (TextView) convertView.findViewById(R.id.item_searchlist_tvtitle);

            holder.tv_title.setTypeface(typeFace);   /////设置字体

            convertView.setTag(holder);
        } else {

            holder = (ViewHolder) convertView.getTag();

        }

    ///////////////////////////////获取编号  数字小于10的部分 格式为 0X

        int num = i + 1;

        if (num<10){

            holder.tv_num.setText("0"+num);

        }else {

            holder.tv_num.setText(num+"");

        }

            holder.tv_title.setText(list.get(i).getTitle());

        return convertView;
    }



 ///////存储 关联布局的控件///////

    private class ViewHolder {

        TextView tv_num, tv_title;
    }
}
