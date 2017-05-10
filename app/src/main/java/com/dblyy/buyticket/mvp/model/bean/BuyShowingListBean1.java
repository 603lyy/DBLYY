package com.dblyy.buyticket.mvp.model.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * 作者：linyaye on 2017/4/21 14:39
 */

public class BuyShowingListBean1 implements MultiItemEntity {

    public static final int SHOWING = 1;
    public static final int UNSHOW = SHOWING + 1;

    @Override
    public int getItemType() {
        return nearestShowtime.isIsTicket() ? SHOWING : UNSHOW;
    }

    /**
     * actorName1 : 吴亦凡
     * actorName2 : 林更新
     * btnText :
     * commonSpecial : 唐僧"重色轻友"与悟空反目
     * directorName : 徐克
     * img : http://img5.mtime.cn/mt/2017/01/27/114649.37790398_1280X720X2.jpg
     * is3D : true
     * isDMAX : true
     * isFilter : false
     * isHot : true
     * isIMAX : false
     * isIMAX3D : true
     * isNew : false
     * length : 108
     * movieId : 208325
     * nearestShowtime : {"isTicket":true,"nearestCinemaCount":152,"nearestShowDay":1486022400,"nearestShowtimeCount":1797}
     * rDay : 28
     * rMonth : 1
     * rYear : 2017
     * ratingFinal : 6.7
     * titleCn : 西游伏妖篇
     * titleEn : Journey to the West: Demon Chapter
     * type : 奇幻 / 动作 / 喜剧
     * wantedCount : 2631
     */

    private String actorName1;
    private String actorName2;
    private String btnText;
    private String commonSpecial;
    private String directorName;
    private String img;
    private boolean is3D;
    private boolean isDMAX;
    private boolean isFilter;
    private boolean isHot;
    private boolean isIMAX;
    private boolean isIMAX3D;
    private boolean isNew;
    private int length;
    private int movieId;
    /**
     * isTicket : true
     * nearestCinemaCount : 152
     * nearestShowDay : 1486022400
     * nearestShowtimeCount : 1797
     */

    private NearestShowtimeBean nearestShowtime;
    private int rDay;
    private int rMonth;
    private int rYear;
    private double ratingFinal;
    private String titleCn;
    private String titleEn;
    private String type;
    private int wantedCount;

    public String getActorName1() {
        return actorName1;
    }

    public void setActorName1(String actorName1) {
        this.actorName1 = actorName1;
    }

    public String getActorName2() {
        return actorName2;
    }

    public void setActorName2(String actorName2) {
        this.actorName2 = actorName2;
    }

    public String getBtnText() {
        return btnText;
    }

    public void setBtnText(String btnText) {
        this.btnText = btnText;
    }

    public String getCommonSpecial() {
        return commonSpecial;
    }

    public void setCommonSpecial(String commonSpecial) {
        this.commonSpecial = commonSpecial;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public boolean isIs3D() {
        return is3D;
    }

    public void setIs3D(boolean is3D) {
        this.is3D = is3D;
    }

    public boolean isIsDMAX() {
        return isDMAX;
    }

    public void setIsDMAX(boolean isDMAX) {
        this.isDMAX = isDMAX;
    }

    public boolean isIsFilter() {
        return isFilter;
    }

    public void setIsFilter(boolean isFilter) {
        this.isFilter = isFilter;
    }

    public boolean isIsHot() {
        return isHot;
    }

    public void setIsHot(boolean isHot) {
        this.isHot = isHot;
    }

    public boolean isIsIMAX() {
        return isIMAX;
    }

    public void setIsIMAX(boolean isIMAX) {
        this.isIMAX = isIMAX;
    }

    public boolean isIsIMAX3D() {
        return isIMAX3D;
    }

    public void setIsIMAX3D(boolean isIMAX3D) {
        this.isIMAX3D = isIMAX3D;
    }

    public boolean isIsNew() {
        return isNew;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public NearestShowtimeBean getNearestShowtime() {
        return nearestShowtime;
    }

    public void setNearestShowtime(NearestShowtimeBean nearestShowtime) {
        this.nearestShowtime = nearestShowtime;
    }

    public int getRDay() {
        return rDay;
    }

    public void setRDay(int rDay) {
        this.rDay = rDay;
    }

    public int getRMonth() {
        return rMonth;
    }

    public void setRMonth(int rMonth) {
        this.rMonth = rMonth;
    }

    public int getRYear() {
        return rYear;
    }

    public void setRYear(int rYear) {
        this.rYear = rYear;
    }

    public double getRatingFinal() {
        return ratingFinal;
    }

    public void setRatingFinal(double ratingFinal) {
        this.ratingFinal = ratingFinal;
    }

    public String getTitleCn() {
        return titleCn;
    }

    public void setTitleCn(String titleCn) {
        this.titleCn = titleCn;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWantedCount() {
        return wantedCount;
    }

    public void setWantedCount(int wantedCount) {
        this.wantedCount = wantedCount;
    }


    public static class NearestShowtimeBean {
        private boolean isTicket;
        private int nearestCinemaCount;
        private int nearestShowDay;
        private int nearestShowtimeCount;

        public boolean isIsTicket() {
            return isTicket;
        }

        public void setIsTicket(boolean isTicket) {
            this.isTicket = isTicket;
        }

        public int getNearestCinemaCount() {
            return nearestCinemaCount;
        }

        public void setNearestCinemaCount(int nearestCinemaCount) {
            this.nearestCinemaCount = nearestCinemaCount;
        }

        public int getNearestShowDay() {
            return nearestShowDay;
        }

        public void setNearestShowDay(int nearestShowDay) {
            this.nearestShowDay = nearestShowDay;
        }

        public int getNearestShowtimeCount() {
            return nearestShowtimeCount;
        }

        public void setNearestShowtimeCount(int nearestShowtimeCount) {
            this.nearestShowtimeCount = nearestShowtimeCount;
        }
    }
}
