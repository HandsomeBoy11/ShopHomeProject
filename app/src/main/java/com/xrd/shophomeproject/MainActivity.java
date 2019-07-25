package com.xrd.shophomeproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.jaeger.library.StatusBarUtil;
import com.xrd.shophomeproject.adapter.HomeAdapter;
import com.xrd.shophomeproject.bean.DataTestUtils;
import com.xrd.shophomeproject.bean.HomeDataBean;
import com.xrd.shophomeproject.utils.image.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler)
    RecyclerView recyclerView;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.view)
    View view;
    @BindView(R.id.rl_name)
    RelativeLayout rlName;
    //总数据源
    private List<Object> mObjects;
    private int height;
    private HomeAdapter adapter;
    private boolean isLight = false;//状态栏高亮
    private boolean isDark = true;//状态栏

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setTranslucent(this);
        StatusBarUtil.setDarkMode(MainActivity.this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
    }

    /**
     * 初始化数据源
     */
    private void initData() {
        if (mObjects == null) {
            mObjects = new ArrayList<>();
        }

        //设置轮播图数据
        mObjects.add(DataTestUtils.getBannerData());
        //设置品牌
        mObjects.add(DataTestUtils.getBrandData());
        //设置榜单
        mObjects.add(DataTestUtils.getFocusData());
        //设置榜单
        mObjects.add(DataTestUtils.getSelectData());
        //设置底部数据
        DataTestUtils.getBottomData(mObjects);

        adapter = new HomeAdapter(this, mObjects);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            private int totalDy = 0;

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                totalDy += dy;
                Log.e("打印", totalDy + "总偏移量");
                if (totalDy <= height) {
                    float alpha = (float) totalDy / height;
                    Log.e("打印", alpha + "透明度");
                    rlTitle.setAlpha(alpha);
                    if(alpha==0){
                        rlName.setVisibility(View.GONE);
                    }else{
                        rlName.setVisibility(View.VISIBLE);
                    }
                    if (alpha >= 0.5) {
                        isLight = false;
                        if (!isDark)
                            StatusBarUtil.setLightMode(MainActivity.this);
                    } else {
                        if (!isLight)
                            StatusBarUtil.setDarkMode(MainActivity.this);
                        isDark = false;
                    }

                } else {
                    Log.e("打印", "不透明");
                    rlTitle.setAlpha(1);
                }
            }
        });
        setBanner(DataTestUtils.getBannerData());
    }

    private void setBanner(HomeDataBean.TypeBanner bannerData) {
        List<String> urls = bannerData.getUrls();
        View bannerView = LayoutInflater.from(this).inflate(R.layout.test_item_banner, (ViewGroup) recyclerView.getParent(), false);
        Banner banner = (Banner) bannerView.findViewById(R.id.banner);

        int resourceId = getResources().getIdentifier("status_bar_height",
                "dimen", "android");
        int statusBarHeight = getResources().getDimensionPixelSize(resourceId);
        Log.e("打印", "状态栏的高度：" + statusBarHeight);
        ViewGroup.LayoutParams layoutParams = banner.getLayoutParams();
        int bannerHeight = layoutParams.height;
//        height = bannerHeight - statusBarHeight - (int)(getResources().getDisplayMetrics().density/40+0.5f);
        rlTitle.measure(0,0);
        int measuredHeight = rlTitle.getMeasuredHeight();
        height = bannerHeight - statusBarHeight - measuredHeight;

        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(urls);
        //设置指示器位置
        banner.setIndicatorGravity(BannerConfig.RIGHT);
        //设置banner动画效果
        //holder.banner.setBannerAnimation(Transformer.Default);
        //设置标题集合（当banner样式有显示title时）
        //holder.banner.setBannerTitles(banner.getTitles());
        //设置自动轮播，默认为true
        //holder.banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(3000);
        //设置指示器位置（当banner模式中有指示器时）
        //holder.banner.setIndicatorGravity(BannerConfig.CENTER);
        //点击事件
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
            }
        });
        //banner设置方法全部调用完毕时最后调用
        banner.start();
        adapter.setBanner(bannerView);
    }

    @OnClick(R.id.rl_name)
    public void onViewClicked() {
        Toast.makeText(this, "点击了项目名称", Toast.LENGTH_SHORT).show();
    }
}
