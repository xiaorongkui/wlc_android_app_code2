package com.qmkj.wlc.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.qmkj.wlc.R;
import com.qmkj.wlc.model.HelpCustomerGoodsDetailsRes;
import com.qmkj.wlc.model.HelpCustomerGoodsNumberRes;
import com.qmkj.wlc.model.HelpCustomerGoodsTypeBean;
import com.qmkj.wlc.ui.activity.base.BaseActivity;
import com.qmkj.wlc.ui.adapter.HelpCustomerGoodsDetailsAdapter;
import com.qmkj.wlc.ui.adapter.HelpCustomerGoodsNumberAdapter;
import com.qmkj.wlc.ui.adapter.HelpCustomerGoodsTypeAdapter;
import com.qmkj.wlc.ui.view.XRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;

public class HelpCustomerOrderActivity extends BaseActivity {
    //点单已选商品信息
    @BindView(R.id.help_customer_order_rv)
    RecyclerView orderNameRecycle;
    //商品信息类别
    @BindView(R.id.help_customer_goods_type)
    XRecyclerView goodsType;
    //商品信息类别中商品列表
    @BindView(R.id.help_customer_goods_details)
    RecyclerView goodsDetails;

    //点单商品信息类别适配器
    private HelpCustomerGoodsTypeAdapter goodsTypeAdapter;
    //点单已选商品信息适配器
    private HelpCustomerGoodsNumberAdapter goodsNumberAdapter;
    //点单商品信息类别商品信息适配器
    private HelpCustomerGoodsDetailsAdapter goodsDetailsAdapter;

    //当前选择类别
    private int select_position =0;

    ArrayList<HelpCustomerGoodsDetailsRes> list_custom = new ArrayList<>();//定制产品
    ArrayList<HelpCustomerGoodsDetailsRes> list_grade = new ArrayList<>(); //高档产品
    ArrayList<HelpCustomerGoodsDetailsRes> list_normal = new ArrayList<>();//普通产品
    ArrayList<HelpCustomerGoodsDetailsRes> list_faster = new ArrayList<>();//快餐区
    ArrayList<HelpCustomerGoodsDetailsRes> list_water = new ArrayList<>();//酒水
    ArrayList<HelpCustomerGoodsDetailsRes> list_gift = new ArrayList<>();//赠送区

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_help_customer_order;
    }

    @Override
    protected void initView() {

        // 设置商品类别数据
        goodsTypeAdapter =new HelpCustomerGoodsTypeAdapter(mContext);
        goodsTypeAdapter.addData(new HelpCustomerGoodsTypeBean("定制产品",true));
        goodsTypeAdapter.addData(new HelpCustomerGoodsTypeBean("高档产品",false));
        goodsTypeAdapter.addData(new HelpCustomerGoodsTypeBean("普通产品",false));
        goodsTypeAdapter.addData(new HelpCustomerGoodsTypeBean("快餐区",false));
        goodsTypeAdapter.addData(new HelpCustomerGoodsTypeBean("酒水",false));
        goodsTypeAdapter.addData(new HelpCustomerGoodsTypeBean("赠送区",false));
        goodsType.setAdapter(goodsTypeAdapter);
        goodsTypeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if(select_position == position){
                    return;
                }
                goodsTypeAdapter.getData().get(select_position).setSelect(false);
                goodsTypeAdapter.getData().get(position).setSelect(true);
                select_position = position;
                goodsTypeAdapter.notifyDataSetChanged();
                switch (position){
                    case 0:
                        goodsDetailsAdapter.setNewData(list_custom);
                        break;
                    case 1:
                        goodsDetailsAdapter.setNewData(list_grade);
                        break;
                    case 2:
                        goodsDetailsAdapter.setNewData(list_normal);
                        break;
                    case 3:
                        goodsDetailsAdapter.setNewData(list_faster);
                        break;
                    case 4:
                        goodsDetailsAdapter.setNewData(list_water);
                        break;
                    case 5:
                        goodsDetailsAdapter.setNewData(list_gift);
                        break;
                }
                goodsDetailsAdapter.notifyDataSetChanged();
            }
        });

        //设置商品详情数据
        goodsDetailsAdapter = new HelpCustomerGoodsDetailsAdapter(mContext);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(mContext);
        layoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
        goodsDetails.setLayoutManager(layoutManager2);
        goodsDetails.setAdapter(goodsDetailsAdapter);
        goodsDetailsAdapter.setItemButtonClickListener(new HelpCustomerGoodsDetailsAdapter.ItemButtonClickListener() {
            @Override
            public void subtractClick(HelpCustomerGoodsDetailsRes item) {

            }
            @Override
            public void addClick(HelpCustomerGoodsDetailsRes item) {

            }
        });

        //设置购买商品数据
        goodsNumberAdapter = new HelpCustomerGoodsNumberAdapter(mContext);
        goodsNumberAdapter.addData(new HelpCustomerGoodsNumberRes());
        goodsNumberAdapter.addData(new HelpCustomerGoodsNumberRes());
        goodsNumberAdapter.addData(new HelpCustomerGoodsNumberRes());
        goodsNumberAdapter.addData(new HelpCustomerGoodsNumberRes());
        LinearLayoutManager layoutManager3 = new LinearLayoutManager(mContext);
        layoutManager3.setOrientation(LinearLayoutManager.VERTICAL);
        orderNameRecycle.setLayoutManager(layoutManager3);
        orderNameRecycle.setAdapter(goodsNumberAdapter);

    }

    @Override
    protected void initData() {
        //设置测试数据
        list_custom.add(new HelpCustomerGoodsDetailsRes());
        goodsDetailsAdapter.setNewData(list_custom);
        goodsDetailsAdapter.notifyDataSetChanged();

        list_grade.add(new HelpCustomerGoodsDetailsRes());
        list_grade.add(new HelpCustomerGoodsDetailsRes());

        list_normal.add(new HelpCustomerGoodsDetailsRes());
        list_normal.add(new HelpCustomerGoodsDetailsRes());
        list_normal.add(new HelpCustomerGoodsDetailsRes());

        list_faster.add(new HelpCustomerGoodsDetailsRes());
        list_faster.add(new HelpCustomerGoodsDetailsRes());
        list_faster.add(new HelpCustomerGoodsDetailsRes());
        list_faster.add(new HelpCustomerGoodsDetailsRes());

        list_water.add(new HelpCustomerGoodsDetailsRes());
        list_water.add(new HelpCustomerGoodsDetailsRes());
        list_water.add(new HelpCustomerGoodsDetailsRes());
        list_water.add(new HelpCustomerGoodsDetailsRes());
        list_water.add(new HelpCustomerGoodsDetailsRes());
        list_water.add(new HelpCustomerGoodsDetailsRes());

        list_gift.add(new HelpCustomerGoodsDetailsRes());
        list_gift.add(new HelpCustomerGoodsDetailsRes());
        list_gift.add(new HelpCustomerGoodsDetailsRes());
        list_gift.add(new HelpCustomerGoodsDetailsRes());
        list_gift.add(new HelpCustomerGoodsDetailsRes());
        list_gift.add(new HelpCustomerGoodsDetailsRes());
        list_gift.add(new HelpCustomerGoodsDetailsRes());


    }
}
