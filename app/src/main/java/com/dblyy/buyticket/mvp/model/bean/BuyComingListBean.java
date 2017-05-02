package com.dblyy.buyticket.mvp.model.bean;

import java.util.List;

/**
 * 作者：linyaye on 2017/5/2 16:06
 */

public class BuyComingListBean {

    /**
     * actor1 : 约翰尼·德普
     * actor2 : 哈维尔·巴登
     * director : 乔阿吉姆·罗恩尼
     * id : 151657
     * image : http://img5.mtime.cn/mt/2017/04/26/104828.45826051_1280X720X2.jpg
     * isFilter : false
     * isTicket : false
     * isVideo : true
     * locationName : 美国
     * rDay : 26
     * rMonth : 5
     * rYear : 2017
     * releaseDate : 5月26日上映
     * title : 加勒比海盗5：死无对证
     * type : 动作 / 冒险 / 喜剧
     * videoCount : 3
     * videos : [{"hightUrl":"","image":"http://img5.mtime.cn/mg/2017/04/26/180822.29960666.jpg","length":132,"title":"加勒比海盗5：死无对证 中国版预告片","url":"http://vfx.mtime.cn/Video/2017/04/26/mp4/170426180717935708.mp4","videoId":65451},{"hightUrl":"","image":"http://img5.mtime.cn/mg/2017/03/02/222501.71065428.jpg","length":147,"title":"加勒比海盗5 中文版剧场预告片","url":"http://vfx.mtime.cn/Video/2017/03/02/mp4/170302221701685514.mp4","videoId":64787},{"hightUrl":"","image":"http://img5.mtime.cn/mg/2017/02/06/104022.11523116.jpg","length":81,"title":"加勒比海盗5 中文版超级碗预告片","url":"http://vfx.mtime.cn/Video/2017/02/06/mp4/170206141612267325.mp4","videoId":64457}]
     * wantedCount : 2447
     */

    private List<AttentionBean> attention;
    /**
     * actor1 : 朱亚文
     * actor2 : 欧豪
     * director : 刘伟强
     * id : 230647
     * image : http://img5.mtime.cn/mt/2017/04/17/093319.17113068_1280X720X2.jpg
     * isFilter : false
     * isTicket : false
     * isVideo : true
     * locationName : 中国
     * rDay : 28
     * rMonth : 7
     * rYear : 2017
     * releaseDate : 7月28日上映
     * title : 建军大业
     * type : 剧情
     * videoCount : 3
     * videos : [{"hightUrl":"","image":"http://img5.mtime.cn/mg/2017/01/27/104825.83699710.jpg","length":18,"title":"建军大业 群星贺新春","url":"http://vfx.mtime.cn/Video/2017/01/27/mp4/170127104800421175.mp4","videoId":64403},{"hightUrl":"","image":"http://img31.mtime.cn/mg/2016/08/02/010955.43162565.jpg","length":105,"title":"建军大业 开机发布会","url":"http://vfx.mtime.cn/Video/2016/08/02/mp4/160802011042515239.mp4","videoId":61847},{"hightUrl":"","image":"http://img5.mtime.cn/mg/2017/04/16/213629.48713561.jpg","length":113,"title":"建军大业 北京发布会","url":"http://vfx.mtime.cn/Video/2017/04/16/mp4/170416213619149031.mp4","videoId":65327}]
     * wantedCount : 69
     */

    private List<MoviecomingsBean> moviecomings;

    public List<AttentionBean> getAttention() {
        return attention;
    }

    public void setAttention(List<AttentionBean> attention) {
        this.attention = attention;
    }

    public List<MoviecomingsBean> getMoviecomings() {
        return moviecomings;
    }

    public void setMoviecomings(List<MoviecomingsBean> moviecomings) {
        this.moviecomings = moviecomings;
    }

    public static class AttentionBean {
        private String actor1;
        private String actor2;
        private String director;
        private int id;
        private String image;
        private boolean isFilter;
        private boolean isTicket;
        private boolean isVideo;
        private String locationName;
        private int rDay;
        private int rMonth;
        private int rYear;
        private String releaseDate;
        private String title;
        private String type;
        private int videoCount;
        private int wantedCount;
        /**
         * hightUrl :
         * image : http://img5.mtime.cn/mg/2017/04/26/180822.29960666.jpg
         * length : 132
         * title : 加勒比海盗5：死无对证 中国版预告片
         * url : http://vfx.mtime.cn/Video/2017/04/26/mp4/170426180717935708.mp4
         * videoId : 65451
         */

        private List<VideosBean> videos;

        public String getActor1() {
            return actor1;
        }

        public void setActor1(String actor1) {
            this.actor1 = actor1;
        }

        public String getActor2() {
            return actor2;
        }

        public void setActor2(String actor2) {
            this.actor2 = actor2;
        }

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public boolean isIsFilter() {
            return isFilter;
        }

        public void setIsFilter(boolean isFilter) {
            this.isFilter = isFilter;
        }

        public boolean isIsTicket() {
            return isTicket;
        }

        public void setIsTicket(boolean isTicket) {
            this.isTicket = isTicket;
        }

        public boolean isIsVideo() {
            return isVideo;
        }

        public void setIsVideo(boolean isVideo) {
            this.isVideo = isVideo;
        }

        public String getLocationName() {
            return locationName;
        }

        public void setLocationName(String locationName) {
            this.locationName = locationName;
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

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
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

        public int getVideoCount() {
            return videoCount;
        }

        public void setVideoCount(int videoCount) {
            this.videoCount = videoCount;
        }

        public int getWantedCount() {
            return wantedCount;
        }

        public void setWantedCount(int wantedCount) {
            this.wantedCount = wantedCount;
        }

        public List<VideosBean> getVideos() {
            return videos;
        }

        public void setVideos(List<VideosBean> videos) {
            this.videos = videos;
        }

        public static class VideosBean {
            private String hightUrl;
            private String image;
            private int length;
            private String title;
            private String url;
            private int videoId;

            public String getHightUrl() {
                return hightUrl;
            }

            public void setHightUrl(String hightUrl) {
                this.hightUrl = hightUrl;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getLength() {
                return length;
            }

            public void setLength(int length) {
                this.length = length;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getVideoId() {
                return videoId;
            }

            public void setVideoId(int videoId) {
                this.videoId = videoId;
            }
        }
    }

    public static class MoviecomingsBean {
        private String actor1;
        private String actor2;
        private String director;
        private int id;
        private String image;
        private boolean isFilter;
        private boolean isTicket;
        private boolean isVideo;
        private String locationName;
        private int rDay;
        private int rMonth;
        private int rYear;
        private String releaseDate;
        private String title;
        private String type;
        private int videoCount;
        private int wantedCount;
        /**
         * hightUrl :
         * image : http://img5.mtime.cn/mg/2017/01/27/104825.83699710.jpg
         * length : 18
         * title : 建军大业 群星贺新春
         * url : http://vfx.mtime.cn/Video/2017/01/27/mp4/170127104800421175.mp4
         * videoId : 64403
         */

        private List<VideosBean> videos;

        public String getActor1() {
            return actor1;
        }

        public void setActor1(String actor1) {
            this.actor1 = actor1;
        }

        public String getActor2() {
            return actor2;
        }

        public void setActor2(String actor2) {
            this.actor2 = actor2;
        }

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public boolean isIsFilter() {
            return isFilter;
        }

        public void setIsFilter(boolean isFilter) {
            this.isFilter = isFilter;
        }

        public boolean isIsTicket() {
            return isTicket;
        }

        public void setIsTicket(boolean isTicket) {
            this.isTicket = isTicket;
        }

        public boolean isIsVideo() {
            return isVideo;
        }

        public void setIsVideo(boolean isVideo) {
            this.isVideo = isVideo;
        }

        public String getLocationName() {
            return locationName;
        }

        public void setLocationName(String locationName) {
            this.locationName = locationName;
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

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
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

        public int getVideoCount() {
            return videoCount;
        }

        public void setVideoCount(int videoCount) {
            this.videoCount = videoCount;
        }

        public int getWantedCount() {
            return wantedCount;
        }

        public void setWantedCount(int wantedCount) {
            this.wantedCount = wantedCount;
        }

        public List<VideosBean> getVideos() {
            return videos;
        }

        public void setVideos(List<VideosBean> videos) {
            this.videos = videos;
        }

        public static class VideosBean {
            private String hightUrl;
            private String image;
            private int length;
            private String title;
            private String url;
            private int videoId;

            public String getHightUrl() {
                return hightUrl;
            }

            public void setHightUrl(String hightUrl) {
                this.hightUrl = hightUrl;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getLength() {
                return length;
            }

            public void setLength(int length) {
                this.length = length;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getVideoId() {
                return videoId;
            }

            public void setVideoId(int videoId) {
                this.videoId = videoId;
            }
        }
    }
}
