package com.coco.ssa.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Steve on 2018/1/23.
 */

public class Constants {
    //////////////////////////////////////////////////彩票168/////////////////////////////////
    public static final String BaseUrl_168 = "http://api.api68.com";
    public static final String BaseImageUrl_168 = "http://images.img861.com/";
    ///////////////////////////////// HOME//////////////////////////////////////////////////////////
    //北京pk10
    public static final String lottery_1 = "/pks/getLotteryPksInfo.do?issue=&lotCode=10001";
    //重庆时时彩
    public static final String lottery_2 = "/CQShiCai/getBaseCQShiCai.do?issue=&lotCode=10002";
    //天津时时彩
    public static final String lottery_3 = "/CQShiCai/getBaseCQShiCai.do?issue=&lotCode=10003";
    //新疆时时彩
    public static final String lottery_4 = "/CQShiCai/getBaseCQShiCai.do?issue=&lotCode=10004";
    //广东快乐十分
    public static final String lottery_5 = "/klsf/getLotteryInfo.do?issue=&lotCode=10005";
    //江苏快3
    public static final String lottery_6 = "/lotteryJSFastThree/getBaseJSFastThree.do?issue=&lotCode=10007";
    //广东11选5
    public static final String lottery_7 = "/ElevenFive/getElevenFiveInfo.do?issue=&lotCode=10006";
    //11运夺金
    public static final String lottery_8 = "/ElevenFive/getElevenFiveInfo.do?issue=&lotCode=10008";

    ///////////////////////////////////////////////走势//////////////////////////////////////////////////////
    //北京pk10
    public static final String trend_1 = "/pks/queryDrawCodeTrend.do?date=&periods=30&lotCode=10001";
    //重庆时时彩
    public static final String trend_2 = "/CQShiCai/getBaseCQShiCaiList.do?lotCode=10002";
    //天津时时彩
    public static final String trend_3 = "/CQShiCai/getBaseCQShiCaiList.do?lotCode=10003";
    //新疆时时彩
    public static final String trend_4 = "/CQShiCai/getBaseCQShiCaiList.do?lotCode=10004";
    public static final String trend_5 = "/CQShiCai/getBaseCQShiCaiList.do?lotCode=10003";
    public static final String trend_6 = "/lotteryJSFastThree/getJSFastThreeList.do?date=&lotCode=10007";
    public static final String trend_7 = "/CQShiCai/getBaseCQShiCaiList.do?lotCode=10004";
    public static final String trend_8 = "/CQShiCai/getBaseCQShiCaiList.do?lotCode=10003";

    //资讯
    public static final String information = "/news/findNewsByPIdForPage.do?";
    public static final String information_detail = "/news/findNewsParticularById.do?id=";

    //////////////////////////cp150网///////////////////////////////////////////////
    public static final String BaseUrl_606 = "https://www.cp606.com";
    //获取首页所有数据
    public static final String DataList_606 = "/game/hotGames.do";
    //https://www.cp606.com/getLotteryBases.do?gameCodes=jsft 后面截gameCode参数
    public static final String SingleData_606 = "/getLotteryBases.do?gameCodes=";


    ///pk10_historyr.php?date=2018-01-27
    public static String NAME = "";
    //北京时时彩
    public static final String history_bjpk10 = "/data/bjpk10/lotteryList/" + getCurrentDateJson(0);
    //重庆时时彩
    public static final String history_cqssc = "/data/cqssc/lotteryList/" + getCurrentDateJson(0);
    //江苏快3
    public static final String history_jsk3 = "/data/jsk3/lotteryList/" + getCurrentDateJson(0);
    //秒速飞艇
    public static final String history_xyft = "/data/jsft/lotteryList/" + getCurrentDateJson(0);
    //新疆时时彩
    public static final String history_xjssc = "/data/xjssc/lotteryList/" + getCurrentDateJson(0);
    //天津时时彩
    public static final String history_tjssc = "/data/tjssc/lotteryList/" + getCurrentDateJson(0);
    //广东快乐十分
    public static final String history_gdkl10 = "/data/gdkl10/lotteryList/" + getCurrentDateJson(0);
    //广东11选5
    public static final String history_gd11x5 = "/data/gd11x5/lotteryList/" + getCurrentDateJson(0);
    //秒速时时彩
    public static final String history_jsssc = "/data/jsssc/lotteryList/" + getCurrentDateJson(0);
    //极速赛车
    public static final String history_speed10 = "/data/jspk10/lotteryList/" + getCurrentDateJson(0);

    /**
     * 获取606网的历史诗句
     *
     * @param gamecode
     * @param page
     * @return
     */
    public static final String getHistroy(String gamecode, int page) {
        return BaseUrl_606 + "/data/" + gamecode + "/lotteryList/" + getCurrentDateJson(page);
    }

    //    首页数据
    public static final String HOME = "/game/hotGames.do";

    //SharePreference
    public static final String home_guanzhu = "home_guanzhu";

    /**
     * 获取日期
     *
     * @param page page=0，为当天，page=1，为上一天
     * @return
     */
    private static String getCurrentDateJson(int page) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -page);
        Date time = cal.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(time) + ".json";
    }

}
