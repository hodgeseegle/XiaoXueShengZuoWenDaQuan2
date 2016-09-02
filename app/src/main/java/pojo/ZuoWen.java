package pojo;

import java.io.Serializable;

/**
 * Created by shuaijiguang on 2016/8/1.
 */
public class ZuoWen implements Serializable{
    private String title;
    private String type;
    private String grade;
    private String txt;

    public ZuoWen() {
    }

    public ZuoWen(String title, String txt) {
        this.title = title;
        this.txt = txt;
    }
    public ZuoWen(String title, String txt, String grade){
        this.title = title;
        this.txt = txt;
        this.grade = grade;
    }

    public ZuoWen(String title, String txt, String grade, String type) {
        this.title = title;
        this.txt = txt;
        this.grade = grade;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    @Override
    public String toString() {
        return "ZuoWen{" +
                "title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", grade='" + grade + '\'' +
                ", txt='" + txt + '\'' +
                '}';
    }
}
