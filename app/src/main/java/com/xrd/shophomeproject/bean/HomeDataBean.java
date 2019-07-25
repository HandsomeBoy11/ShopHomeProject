package com.xrd.shophomeproject.bean;

import java.util.List;

/**
 * Created by WJ on 2019/5/6.
 */

public class HomeDataBean {

    /**
     * 轮播图
     */
    public static class TypeBanner {
        //轮播连接
        private List<String> urls;
        //轮播标题
        private List<String> titles;

        public List<String> getUrls() {
            return urls;
        }
        public void setUrls(List<String> urls) {
            this.urls = urls;
        }

        public List<String> getTitles() {
            return titles;
        }

        public void setTitles(List<String> titles) {
            this.titles = titles;
        }
    }

    /**
     * 品牌图
     */
    public static class TypeBrand {

        private String picFirst;
        private String firstTitle;
        private String firstLable;
        private String secondLable;
        private String picSecond;
        private String secondTitle;
        private String thirdLable;
        private String fourthLable;
        private String picThird;
        private String thirdTitle;
        private String fifthLable;
        private String sixthLable;

        public String getPicFirst() {
            return picFirst;
        }

        public void setPicFirst(String picFirst) {
            this.picFirst = picFirst;
        }

        public String getFirstTitle() {
            return firstTitle;
        }

        public void setFirstTitle(String firstTitle) {
            this.firstTitle = firstTitle;
        }

        public String getFirstLable() {
            return firstLable;
        }

        public void setFirstLable(String firstLable) {
            this.firstLable = firstLable;
        }

        public String getSecondLable() {
            return secondLable;
        }

        public void setSecondLable(String secondLable) {
            this.secondLable = secondLable;
        }

        public String getPicSecond() {
            return picSecond;
        }

        public void setPicSecond(String picSecond) {
            this.picSecond = picSecond;
        }

        public String getSecondTitle() {
            return secondTitle;
        }

        public void setSecondTitle(String secondTitle) {
            this.secondTitle = secondTitle;
        }

        public String getThirdLable() {
            return thirdLable;
        }

        public void setThirdLable(String thirdLable) {
            this.thirdLable = thirdLable;
        }

        public String getFourthLable() {
            return fourthLable;
        }

        public void setFourthLable(String fourthLable) {
            this.fourthLable = fourthLable;
        }

        public String getPicThird() {
            return picThird;
        }

        public void setPicThird(String picThird) {
            this.picThird = picThird;
        }

        public String getThirdTitle() {
            return thirdTitle;
        }

        public void setThirdTitle(String thirdTitle) {
            this.thirdTitle = thirdTitle;
        }

        public String getFifthLable() {
            return fifthLable;
        }

        public void setFifthLable(String fifthLable) {
            this.fifthLable = fifthLable;
        }

        public String getSixthLable() {
            return sixthLable;
        }

        public void setSixthLable(String sixthLable) {
            this.sixthLable = sixthLable;
        }
    }

    /**
     * 榜单
     */
    public static class TypeFocus {

        private String title;
        private String content;

        private String picFirst;
        private String picSecond;
        private String picThird;
        private String picFourth;
        private String picFifth;
        private String picSixth;
        private String picSeventh;

        private String titleFirst;
        private String titleSecond;
        private String titleThird;
        private String titleFourth;
        private String titleFifth;
        private String titleSixth;
        private String titleSeventh;
        private String titleEighth;

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

        public String getPicFirst() {
            return picFirst;
        }

        public void setPicFirst(String picFirst) {
            this.picFirst = picFirst;
        }

        public String getPicSecond() {
            return picSecond;
        }

        public void setPicSecond(String picSecond) {
            this.picSecond = picSecond;
        }

        public String getPicThird() {
            return picThird;
        }

        public void setPicThird(String picThird) {
            this.picThird = picThird;
        }

        public String getPicFourth() {
            return picFourth;
        }

        public void setPicFourth(String picFourth) {
            this.picFourth = picFourth;
        }

        public String getPicFifth() {
            return picFifth;
        }

        public void setPicFifth(String picFifth) {
            this.picFifth = picFifth;
        }

        public String getPicSixth() {
            return picSixth;
        }

        public void setPicSixth(String picSixth) {
            this.picSixth = picSixth;
        }

        public String getPicSeventh() {
            return picSeventh;
        }

        public void setPicSeventh(String picSeventh) {
            this.picSeventh = picSeventh;
        }

        public String getTitleFirst() {
            return titleFirst;
        }

        public void setTitleFirst(String titleFirst) {
            this.titleFirst = titleFirst;
        }

        public String getTitleSecond() {
            return titleSecond;
        }

        public void setTitleSecond(String titleSecond) {
            this.titleSecond = titleSecond;
        }

        public String getTitleThird() {
            return titleThird;
        }

        public void setTitleThird(String titleThird) {
            this.titleThird = titleThird;
        }

        public String getTitleFourth() {
            return titleFourth;
        }

        public void setTitleFourth(String titleFourth) {
            this.titleFourth = titleFourth;
        }

        public String getTitleFifth() {
            return titleFifth;
        }

        public void setTitleFifth(String titleFifth) {
            this.titleFifth = titleFifth;
        }

        public String getTitleSixth() {
            return titleSixth;
        }

        public void setTitleSixth(String titleSixth) {
            this.titleSixth = titleSixth;
        }

        public String getTitleSeventh() {
            return titleSeventh;
        }

        public void setTitleSeventh(String titleSeventh) {
            this.titleSeventh = titleSeventh;
        }

        public String getTitleEighth() {
            return titleEighth;
        }

        public void setTitleEighth(String titleEighth) {
            this.titleEighth = titleEighth;
        }
    }

    /**
     * 精选
     */
    public static class TypeSelect {

        private String urlFirst;
        private String urlSecond;
        private String urlThird;

        public String getUrlFirst() {
            return urlFirst;
        }

        public void setUrlFirst(String urlFirst) {
            this.urlFirst = urlFirst;
        }

        public String getUrlSecond() {
            return urlSecond;
        }

        public void setUrlSecond(String urlSecond) {
            this.urlSecond = urlSecond;
        }

        public String getUrlThird() {
            return urlThird;
        }

        public void setUrlThird(String urlThird) {
            this.urlThird = urlThird;
        }

        //横向滑动的图片
        private List<String> urls;

        public List<String> getUrls() {
            return urls;
        }

        public void setUrls(List<String> urls) {
            this.urls = urls;
        }
    }

    /**
     * 精选
     */
    public static class TypeBottom {

        private String url;
        private String title;
        private String content;
        private double price;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
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

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public TypeBottom(String url, String title, String content, double price) {
            this.url = url;
            this.title = title;
            this.content = content;
            this.price = price;
        }
    }
}
