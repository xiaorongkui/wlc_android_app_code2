package com.qmkj.wlc.ui.activity;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.qmkj.wlc.R;
import com.qmkj.wlc.ui.activity.base.BaseActivity;
import com.qmkj.wlc.utils.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {
    @BindView(R.id.customer_order)
    Button customer_order;
    @BindView(R.id.help_customer_order)
    Button help_customer_order;
    @BindView(R.id.donate_record)
    Button donate_record;

    private static final long INTERVAL = 2000;  //2s间隔
    /**
     * 再按一次退出程序
     */
    private long exitTime = 0;  //退出时间

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.customer_order,R.id.help_customer_order,R.id.donate_record})
    public void onViewClick(View view){
        switch (view.getId()){
            case R.id.customer_order: //客人订单
                Intent intent = new Intent(MainActivity.this,CustomerOrderActivity.class);
                startActivity(intent);

            break;

            case R.id.help_customer_order: //助客点单
                Intent intent2 = new Intent(MainActivity.this,HelpCustomerOrderActivity.class);
                startActivity(intent2);

                break;
            case R.id.donate_record: //慈善捐赠记录
                Intent intent3 = new Intent(MainActivity.this,DonateRecordActivity.class);
                startActivity(intent3);
            break;


        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > INTERVAL) {
                exitTime = System.currentTimeMillis();
                ToastUtil.showShort(getString(R.string.exit_application_click_once_again));
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
