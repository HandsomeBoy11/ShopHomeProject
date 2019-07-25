package com.xrd.shophomeproject.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WJ on 2019/5/6.
 */

public class DataTestUtils {
    private static String bannerFirst = "https://img.zcool.cn/community/016c355652c7516ac7251c943f32da.jpg";
    private static String bannerSecond = "https://img.zcool.cn/community/01881a5652c7516ac7251c94522683.jpg";
    private static String bannerThird = "https://img.zcool.cn/community/01c35e5652c76e32f87512f6883563.jpg";
    private static String bannerFourth = "https://img.zcool.cn/community/0187da5652c76e32f87512f692d6d1.jpg";

    private static String bottomFirst = "https://img.zcool.cn/community/0192ef5548e0ba0000009e320ddbe1.jpg";
    private static String bottomSecond = "https://img.zcool.cn/community/0192b7563725ff32f87512f6e14db1.jpg";
    private static String bottomThird = "https://a.vpimg2.com/upload/merchandise/236513/AK-1102031400044411-1.jpg";
    private static String bottomFourth = "https://img001.hc360.cn/hb/MTQ3NDM5MDAzNjE1Mi0xODU1Njg5MjU4.jpg";

    public static HomeDataBean.TypeBanner getBannerData() {
        //轮播图链接
        List<String> banneUrl = new ArrayList<>();
        //轮播图标题
        List<String> banneTitle = new ArrayList<>();
        //轮播图
        HomeDataBean.TypeBanner banner = new HomeDataBean.TypeBanner();
        banneUrl.add(bannerFirst);
        banneUrl.add(bannerSecond);
        banneUrl.add(bannerThird);
        banneUrl.add(bannerFourth);
        banneTitle.add("凝心聚力，圆您星梦");
        banneTitle.add("直播综艺，精彩不断");
        banneTitle.add("酷炫礼物，互动不停");
        banneTitle.add("边看边买，抢先体验");
        banner.setUrls(banneUrl);
        banner.setTitles(banneTitle);
        return banner;
    }


    public static HomeDataBean.TypeBrand getBrandData() {

        HomeDataBean.TypeBrand brand = new HomeDataBean.TypeBrand();
        brand.setPicFirst(bottomFirst);
        brand.setPicSecond(bottomSecond);
        brand.setPicThird(bottomThird);
        brand.setFirstTitle("全新串标 首发");
        brand.setSecondTitle("周大福珠宝");
        brand.setThirdTitle("秋冬首发");
        brand.setFirstLable("串标");
        brand.setSecondLable("潮流经典");
        brand.setThirdLable("经典");
        brand.setFourthLable("全新系列");
        brand.setFifthLable("独家");
        brand.setSixthLable("顶尖时尚");
        return brand;
    }

    public static HomeDataBean.TypeFocus getFocusData() {

        HomeDataBean.TypeFocus focus = new HomeDataBean.TypeFocus();
        focus.setTitle("看球最佳音响榜");
        focus.setContent("卖爆16.8万件");
        focus.setPicFirst(bottomFirst);
        focus.setPicSecond(bottomSecond);
        focus.setPicThird(bottomThird);
        focus.setPicFourth(bottomFirst);
        focus.setPicFifth(bottomSecond);
        focus.setPicSixth(bottomThird);
        focus.setPicSeventh(bottomFourth);
        focus.setTitleFirst("家用美容仪榜");
        focus.setTitleSecond("卖爆6.1万件");
        focus.setTitleThird("高街精致裙子榜");
        focus.setTitleFourth("卖爆650件");
        focus.setTitleFifth("超值时尚机械榜");
        focus.setTitleSixth("卖爆106.8万件");
        focus.setTitleSeventh("时尚手表榜");
        focus.setTitleEighth("卖爆1.2万件");
        return focus;
    }

    public static HomeDataBean.TypeSelect getSelectData() {
        //横向滑动图片集合
        List<String> slideUrls = new ArrayList<>();
        HomeDataBean.TypeSelect select = new HomeDataBean.TypeSelect();
        select.setUrlFirst(bottomFirst);
        select.setUrlSecond(bottomSecond);
        select.setUrlThird(bottomThird);
        for (int i = 0; i < 10; i++) {
            slideUrls.add(bottomSecond);
        }
        select.setUrls(slideUrls);
        return select;
    }

    public static void getBottomData( List<Object> mObjects) {
        mObjects.add(new HomeDataBean.TypeBottom(bottomFirst, "劳力士集团新品帝舵手表男",
                "碧湾系列青铜型机械男表M79250BM-0001", 19999.9));
        mObjects.add(new HomeDataBean.TypeBottom(bottomSecond, "Hermes/爱马仕大地中性男士淡香水",
                "EDT 50/100ml 持久清新 成熟\n", 799.9));
        mObjects.add(new HomeDataBean.TypeBottom(bottomThird, "金盾夏季男士短袖衬衫",
                "商务休闲韩版修身白色衬衣半袖职业正装衬衣\n", 99.9));
        mObjects.add(new HomeDataBean.TypeBottom(bottomFourth, "黄金手链女款",
                "足金999简约圆珠佛珠光珠情侣手链七夕情人节礼物\n", 399.9));
        mObjects.add(new HomeDataBean.TypeBottom(bottomFirst, "超多维SuperD裸眼悬浮3d",
                "超多维SuperD裸眼悬浮3d", 699.9));
    }

}
