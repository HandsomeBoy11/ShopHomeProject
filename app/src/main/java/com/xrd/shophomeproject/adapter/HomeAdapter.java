package com.xrd.shophomeproject.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xrd.shophomeproject.R;
import com.xrd.shophomeproject.bean.HomeDataBean;
import com.xrd.shophomeproject.utils.image.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by WJ on 2019/5/6.
 */

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    //所有要展示的数据源object集合
    private List<Object> objects;
    private Context context;

    //加入标记作为区分
    private static final int TYPE_ITEM_BANNER = 0X120;
    private static final int TYPE_ITEM_BRAND = 0X121;
    private static final int TYPE_ITEM_FOCUS = 0X122;
    private static final int TYPE_ITEM_SELECT = 0X123;
    private static final int TYPE_ITEM_BOTTOM = 0X124;
    private View bannerView;

    public HomeAdapter(Context context, List<Object> objects) {
        this.objects = objects;
        this.context = context;
    }

    /**
     * 基于项不同的类型来获得不同的viewholder,关联对应的布局
     */
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;

        switch (viewType) {
            case TYPE_ITEM_BANNER:
                //View view1 = inflater.inflate(R.layout.item_bann, parent, false);
                //viewHolder = new BannerHolder(view1);
                if(bannerView!=null)
                    viewHolder=new BannerHolder(bannerView);
//                viewHolder = new BannerHolder(inflate(parent, R.layout.test_item_banner));
                break;
            case TYPE_ITEM_BRAND:
                viewHolder = new BrandHolder(inflate(parent, R.layout.test_item_brand));
                break;
            case TYPE_ITEM_FOCUS:
                viewHolder = new FocucsHolder(inflate(parent, R.layout.test_item_focus));
                break;
            case TYPE_ITEM_SELECT:
                viewHolder = new SelectHolder(inflate(parent, R.layout.test_item_select));
                break;
            case TYPE_ITEM_BOTTOM:
                viewHolder = new BottomHolder(inflate(parent, R.layout.test_item_bottom_item));
                break;
        }
        return viewHolder;
    }

    /**
     * 关联布局
     */
    private View inflate(ViewGroup parent, int resId) {
        return LayoutInflater.from(parent.getContext()).inflate(resId, parent, false);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Object object = objects.get(position);
        switch (holder.getItemViewType()) {
            case TYPE_ITEM_BANNER://轮播图
//                setTypeItemBanner((BannerHolder) holder, (HomeDataBean.TypeBanner) object);
                break;
            case TYPE_ITEM_BRAND://品牌
                setTypeItemBrand((BrandHolder) holder, (HomeDataBean.TypeBrand) object);
                break;
            case TYPE_ITEM_FOCUS://榜单
                setTypeItemFocucs((FocucsHolder) holder, (HomeDataBean.TypeFocus) object);
                break;
            case TYPE_ITEM_SELECT://精选
                setTypeItemSelect((SelectHolder) holder, (HomeDataBean.TypeSelect) object);
                break;
            case TYPE_ITEM_BOTTOM://底部商品列表
                setTypeItemBottom((BottomHolder) holder, (HomeDataBean.TypeBottom) object);
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        Object object = objects.get(position);
        //判断pposition是否属于该实例，加载不同的布局
        if (object instanceof HomeDataBean.TypeBanner) {
            return TYPE_ITEM_BANNER;
        } else if (object instanceof HomeDataBean.TypeBrand) {
            return TYPE_ITEM_BRAND;
        } else if (object instanceof HomeDataBean.TypeFocus) {
            return TYPE_ITEM_FOCUS;
        } else if (object instanceof HomeDataBean.TypeSelect) {
            return TYPE_ITEM_SELECT;
        } else if (object instanceof HomeDataBean.TypeBottom) {
            return TYPE_ITEM_BOTTOM;
        }
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return objects == null ? 0 : objects.size();
    }

    /**
     * 设置轮播
     *
     * @param holder BannerHolder
     * @param banner 实体
     */
    private void setTypeItemBanner(BannerHolder holder, HomeDataBean.TypeBanner banner) {

        //   Log.e("TAG",info.getUrl());
        //设置banner样式
        holder.banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        holder.banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        holder.banner.setImages(banner.getUrls());
        //设置指示器位置
        holder.banner.setIndicatorGravity(BannerConfig.RIGHT);
        //设置banner动画效果
        //holder.banner.setBannerAnimation(Transformer.Default);
        //设置标题集合（当banner样式有显示title时）
        //holder.banner.setBannerTitles(banner.getTitles());
        //设置自动轮播，默认为true
        //holder.banner.isAutoPlay(true);
        //设置轮播时间
        holder.banner.setDelayTime(3000);
        //设置指示器位置（当banner模式中有指示器时）
        //holder.banner.setIndicatorGravity(BannerConfig.CENTER);
        //点击事件
        holder.banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
            }
        });
        //banner设置方法全部调用完毕时最后调用
        holder.banner.start();
    }

    public void setBanner(View bannerView) {
        this.bannerView=bannerView;
    }

    class BannerHolder extends RecyclerView.ViewHolder {

        private Banner banner;

        public BannerHolder(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);
        }
    }

    /**
     * 设置品牌
     */
    private void setTypeItemBrand(BrandHolder holder, HomeDataBean.TypeBrand brand) {
        holder.homeTitle.setText("发现品牌");

        String picFirst = brand.getPicFirst();
        String firstTitle = brand.getFirstTitle();
        String firstLable = brand.getFirstLable();
        String secondLable = brand.getSecondLable();

        String picSecond = brand.getPicSecond();
        String secondTitle = brand.getSecondTitle();
        String thirdLable = brand.getThirdLable();
        String fourthLable = brand.getFourthLable();
        String picThird = brand.getPicThird();
        String thirdTitle = brand.getThirdTitle();
        String fifthLable = brand.getFifthLable();
        String sixthLable = brand.getSixthLable();

        Glide.with(context).load(picFirst).into(holder.brandPicFirst);
        Glide.with(context).load(picSecond).into(holder.brandPicSecond);
        Glide.with(context).load(picThird).into(holder.brandPicThird);

        holder.brandFirstTitle.setText(firstTitle);
        holder.brandFirstLable.setText(firstLable);
        holder.brandSecondLable.setText(secondLable);
        holder.brandSecondTitle.setText((secondTitle));
        holder.brandThirdLable.setText(thirdLable);
        holder.brandFourthLable.setText(fourthLable);
        holder.brandThirdTitle.setText(thirdTitle);
        holder.brandFifthLable.setText(fifthLable);
        holder.brandSixthLable.setText(sixthLable);
    }

    class BrandHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.home_title)
        TextView homeTitle;
        @BindView(R.id.brand_pic_first)
        ImageView brandPicFirst;
        @BindView(R.id.brand_first_title)
        TextView brandFirstTitle;
        @BindView(R.id.brand_first_lable)
        TextView brandFirstLable;
        @BindView(R.id.brand_second_lable)
        TextView brandSecondLable;
        @BindView(R.id.brand_pic_second)
        ImageView brandPicSecond;
        @BindView(R.id.brand_second_title)
        TextView brandSecondTitle;
        @BindView(R.id.brand_third_lable)
        TextView brandThirdLable;
        @BindView(R.id.brand_fourth_lable)
        TextView brandFourthLable;
        @BindView(R.id.brand_pic_third)
        ImageView brandPicThird;
        @BindView(R.id.brand_third_title)
        TextView brandThirdTitle;
        @BindView(R.id.brand_fifth_lable)
        TextView brandFifthLable;
        @BindView(R.id.brand_sixth_lable)
        TextView brandSixthLable;

        public BrandHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    /**
     * 设置榜单
     */
    private void setTypeItemFocucs(FocucsHolder holder, HomeDataBean.TypeFocus focus) {

        holder.homeTitle.setText("推荐榜单");

        String title = focus.getTitle();
        holder.foucesTitle.setText(title);
        String content = focus.getContent();
        holder.foucesContent.setText(content);
        String picFirst = focus.getPicFirst();
        String picSecond = focus.getPicSecond();
        String picThird = focus.getPicThird();
        String picFourth = focus.getPicFourth();
        String picFifth = focus.getPicFifth();
        String picSixth = focus.getPicSixth();
        String picSeventh = focus.getPicSeventh();

        Glide.with(context).load(picFirst).into(holder.foucesPicFirst);
        Glide.with(context).load(picSecond).into(holder.foucesPicSecond);
        Glide.with(context).load(picThird).into(holder.foucesPicThird);
        Glide.with(context).load(picFourth).into(holder.foucesPicFourth);
        Glide.with(context).load(picFifth).into(holder.foucesPicFifth);
        Glide.with(context).load(picSixth).into(holder.foucesPicSixth);
        Glide.with(context).load(picSeventh).into(holder.foucesPicSeventh);

        String first = focus.getTitleFirst();
        holder.foucesTitleFirst.setText(first);
        String second = focus.getTitleSecond();
        holder.foucesTitleSecond.setText(second);
        String third = focus.getTitleThird();
        holder.foucesTitleThird.setText(third);
        String fourth = focus.getTitleFourth();
        holder.foucesTitleFourth.setText(fourth);
        String fifith = focus.getTitleFifth();
        holder.foucesTitleFifth.setText(fifith);
        String sixth = focus.getTitleSixth();
        holder.foucesTitleSixth.setText(sixth);
        String seventh = focus.getTitleSeventh();
        holder.foucesTitleSeventh.setText(seventh);
        String eighth = focus.getTitleEighth();
        holder.foucesTitleEighth.setText(eighth);
    }

    class FocucsHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.home_title)
        TextView homeTitle;
        @BindView(R.id.fouces_title)
        TextView foucesTitle;
        @BindView(R.id.fouces_content)
        TextView foucesContent;

        @BindView(R.id.fouces_pic_first)
        ImageView foucesPicFirst;
        @BindView(R.id.fouces_pic_second)
        ImageView foucesPicSecond;
        @BindView(R.id.fouces_pic_third)
        ImageView foucesPicThird;
        @BindView(R.id.fouces_pic_fourth)
        ImageView foucesPicFourth;
        @BindView(R.id.fouces_pic_fifth)
        ImageView foucesPicFifth;
        @BindView(R.id.fouces_pic_sixth)
        ImageView foucesPicSixth;
        @BindView(R.id.fouces_pic_seventh)
        ImageView foucesPicSeventh;

        @BindView(R.id.fouces_title_first)
        TextView foucesTitleFirst;
        @BindView(R.id.fouces_title_second)
        TextView foucesTitleSecond;
        @BindView(R.id.fouces_title_third)
        TextView foucesTitleThird;
        @BindView(R.id.fouces_title_fourth)
        TextView foucesTitleFourth;
        @BindView(R.id.fouces_title_fifth)
        TextView foucesTitleFifth;
        @BindView(R.id.fouces_title_sixth)
        TextView foucesTitleSixth;
        @BindView(R.id.fouces_title_seventh)
        TextView foucesTitleSeventh;
        @BindView(R.id.fouces_title_eighth)
        TextView foucesTitleEighth;

        public FocucsHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    /**
     * 设置精选
     */
    private void setTypeItemSelect(SelectHolder holder, HomeDataBean.TypeSelect select) {

        holder.homeTitle.setText("精选");

        if (null != select.getUrls() && select.getUrls().size() > 0) {
            //防止重复显示
            holder.linearImage.removeAllViews();
            for (int i = 0; i < select.getUrls().size(); i++) {
                View view = LayoutInflater.from(context).inflate(R.layout.home_item_select_pic,
                        holder.linearImage, false);
                ImageView image = view.findViewById(R.id.item_detail_image);
                //展示图片
                Glide.with(context).load(select.getUrls().get(i)).into(image);
                //动态添加View
                holder.linearImage.addView(view);
            }
        }
        String first = select.getUrlFirst();
        String second = select.getUrlFirst();
        String third = select.getUrlFirst();

        Glide.with(context).load(first).into(holder.itemSelectFirst);
        Glide.with(context).load(second).into(holder.itemSelectSecond);
        Glide.with(context).load(third).into(holder.itemSelectThird);
    }

    class SelectHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.home_title)
        TextView homeTitle;
        @BindView(R.id.item_select_first)
        ImageView itemSelectFirst;
        @BindView(R.id.item_select_second)
        ImageView itemSelectSecond;
        @BindView(R.id.item_select_third)
        ImageView itemSelectThird;
        @BindView(R.id.linear_image)
        LinearLayout linearImage;

        public SelectHolder(View itemView) {
            super(itemView);
            //注意加上this,否者null指针异常
            ButterKnife.bind(this, itemView);
        }
    }

    /**
     * 底部商品；列表
     */
    private void setTypeItemBottom(BottomHolder holder, HomeDataBean.TypeBottom bottom) {
        //图片
        String url = bottom.getUrl();
        Glide.with(context).load(url).into(holder.itemUrl);
        //品牌
        String title = bottom.getTitle();
        holder.itemTitle.setText(title);
        //内容
        String content = bottom.getContent();
        holder.itemContent.setText(content);
        //价格
        double price = bottom.getPrice();
        holder.itemPrice.setText("¥"+price);
    }

    class BottomHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_url)
        ImageView itemUrl;
        @BindView(R.id.item_title)
        TextView itemTitle;
        @BindView(R.id.item_content)
        TextView itemContent;
        @BindView(R.id.item_price)
        TextView itemPrice;

        public BottomHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

