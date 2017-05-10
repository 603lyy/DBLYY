package com.dblyy.util;

import android.content.res.Resources;

import com.dblyy.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 作者：linyaye on 2017/4/26 11:50
 */

public class TimeUtil {

    /**
     * 时间戳转换为时间文本(只显示年月日 时分秒）
     *
     * @param time
     * @return
     */
    public static String timeStampTransformToMD(Resources resources, long time) {
        SimpleDateFormat format = new SimpleDateFormat(resources.getString(R.string.time_stamp_transform_md_format));
        time = time * 1000;
        String d = format.format(time);
        return d;
    }

    public static long MDTransformToTimeStamp(Resources resources, String timeString) {
        long timeStamp = 0;
        SimpleDateFormat format = new SimpleDateFormat(resources.getString(R.string.time_stamp_ymd_format));
        Date d;
        try {
            d = format.parse(timeString);
            timeStamp = d.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timeStamp;
    }
}
