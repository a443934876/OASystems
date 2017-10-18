package com.example.oasystems.utils;

import org.litepal.crud.DataSupport;


/**
 * 项目名称：OASystems
 * 创建时间：2017/9/27 17:00
 * 注释说明：
 */

public class Inform extends DataSupport  {

    private String title;
    private String content;
    private String date;
    private int imageView;

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Inform{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                ", imageView=" + imageView +
                '}';
    }
}
