package com.example.oasystems.utils;

import org.litepal.crud.DataSupport;

import java.util.Date;
import java.util.List;

/**
 * 项目名称：OASystems
 * 创建时间：2017/9/28 15:08
 * 注释说明：
 */

public    class InformData   {
    public boolean saveInformsData(String title, String content, String date, int imageView){
        Inform inform = new Inform();
        inform.setTitle(title);
        inform.setContent(content);
        inform.setDate(date);
        inform.setImageView(imageView);
        return inform.save();
    }
    public List<Inform> findAll(){
        List<Inform> informList = DataSupport.findAll(Inform.class);
        return informList;
    }
}
