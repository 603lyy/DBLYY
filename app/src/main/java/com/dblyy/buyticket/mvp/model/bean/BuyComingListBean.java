package com.dblyy.buyticket.mvp.model.bean;

import java.util.List;

/**
 * 作者：linyaye on 2017/5/2 16:06
 */

public class BuyComingListBean {


    /**
     * actor1 : 黄磊
     * actor2 : 海清
     * director : 黄磊
     * id : 237670
     * image : http://img5.mtime.cn/mt/2017/05/08/120900.48696365_1280X720X2.jpg
     * isFilter : false
     * isTicket : true
     * isVideo : true
     * locationName : 中国
     * rDay : 11
     * rMonth : 5
     * rYear : 2017
     * releaseDate : 5月11日上映
     * title : 麻烦家族
     * type : 喜剧
     * videoCount : 3
     * videos : [{"hightUrl":"","image":"http://img5.mtime.cn/mg/2017/05/05/092913.39317942.jpg","length":94,"title":"麻烦家族 终极预告片","url":"http://vfx.mtime.cn/Video/2017/05/05/mp4/170505093040801564.mp4","videoId":65561},{"hightUrl":"","image":"http://img5.mtime.cn/mg/2017/03/06/094418.31716681.jpg","length":68,"title":"麻烦家族 先导预告片","url":"http://vfx.mtime.cn/Video/2017/03/06/mp4/170306094704173638.mp4","videoId":64815},{"hightUrl":"","image":"http://img5.mtime.cn/mg/2017/03/24/100909.87922289.jpg","length":137,"title":"麻烦家族 \u201c家事版\u201d预告","url":"http://vfx.mtime.cn/Video/2017/03/24/mp4/170324100742085511.mp4","videoId":65041}]
     * wantedCount : 177
     */

    private List<AttentionBean> attention;
    /**
     * actor1 : 黄磊
     * actor2 : 海清
     * director : 黄磊
     * id : 237670
     * image : http://img5.mtime.cn/mt/2017/05/08/120900.48696365_1280X720X2.jpg
     * isFilter : false
     * isTicket : true
     * isVideo : true
     * locationName : 中国
     * rDay : 11
     * rMonth : 5
     * rYear : 2017
     * releaseDate : 5月11日上映
     * title : 麻烦家族
     * type : 喜剧
     * videoCount : 3
     * videos : [{"hightUrl":"","image":"http://img5.mtime.cn/mg/2017/05/05/092913.39317942.jpg","length":94,"title":"麻烦家族 终极预告片","url":"http://vfx.mtime.cn/Video/2017/05/05/mp4/170505093040801564.mp4","videoId":65561},{"hightUrl":"","image":"http://img5.mtime.cn/mg/2017/03/06/094418.31716681.jpg","length":68,"title":"麻烦家族 先导预告片","url":"http://vfx.mtime.cn/Video/2017/03/06/mp4/170306094704173638.mp4","videoId":64815},{"hightUrl":"","image":"http://img5.mtime.cn/mg/2017/03/24/100909.87922289.jpg","length":137,"title":"麻烦家族 \u201c家事版\u201d预告","url":"http://vfx.mtime.cn/Video/2017/03/24/mp4/170324100742085511.mp4","videoId":65041}]
     * wantedCount : 177
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
         * image : http://img5.mtime.cn/mg/2017/05/05/092913.39317942.jpg
         * length : 94
         * title : 麻烦家族 终极预告片
         * url : http://vfx.mtime.cn/Video/2017/05/05/mp4/170505093040801564.mp4
         * videoId : 65561
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
         * image : http://img5.mtime.cn/mg/2017/05/05/092913.39317942.jpg
         * length : 94
         * title : 麻烦家族 终极预告片
         * url : http://vfx.mtime.cn/Video/2017/05/05/mp4/170505093040801564.mp4
         * videoId : 65561
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
