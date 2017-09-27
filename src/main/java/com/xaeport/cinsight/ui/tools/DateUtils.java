package com.xaeport.cinsight.ui.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xcp on 2017/5/25.
 */
public class DateUtils {

    /**
     * 日期格式字符串转时间戳
     *
     * @param dateStr
     * @return
     * @throws ParseException
     */
    public static long dateStrToTimestamp(String dateStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(dateStr);
        long timestamp = date.getTime();
        return timestamp;
    }

    /**
     * 时间格式字符串转时间戳
     *
     * @param dateTimeStr
     * @return
     * @throws ParseException
     */
    public static long dateTimeStrToTimestamp(String dateTimeStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = sdf.parse(dateTimeStr);
        long timestamp = date.getTime();
        return timestamp;
    }
}
