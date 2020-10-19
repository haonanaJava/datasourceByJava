package com.heyutang.datastructure.Utils;

import com.heyutang.datastructure.SortAlgorithm.Bubble;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(Bubble.class);

    public static void before(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatData = simpleDateFormat.format(date);
        LOGGER.info("排序前" + formatData);
    }

    public static void after(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatData = simpleDateFormat.format(date);
        LOGGER.info("排序后" + formatData);
    }

}
