package com.JavaStudy.HspMiddleJavaTest.Collection_.Exercise;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author mingyu
 * @version 1.0
 */
public class CollectionsExercise01 {
    public static void main(String[] args) {
        News news1 = new News("新冠确诊超千万，数百万印度教信徒赴恒河“圣浴”引起民众担忧");
        News news2 = new News("男子突然想起2个月前钓的鱼还在网兜中，捞起一看赶紧放生");

        ArrayList<News> newsList = new ArrayList();
        newsList.add(news1);
        newsList.add(news2);

        int size = newsList.size();
        for (int i = size -1; i >=0; i--) {
            News newsTemp =  newsList.get(i);
            String titleTemp =  newsTemp.getTitle();
            System.out.println(((String)titleTemp).substring(0, 15)+"...");
        }


    }
}
class News{
    private String title;
    private String content;

    public News(String title) {
        this.title = title;
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

    @Override
    public String toString() {
        return "News{" +
                "title='" + title +
                '}';
    }
}