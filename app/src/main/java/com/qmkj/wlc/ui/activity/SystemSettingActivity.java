package com.qmkj.wlc.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.qmkj.wlc.R;
import com.qmkj.wlc.model.AppUpdateModel;
import com.qmkj.wlc.ui.activity.base.BaseActivity;
import com.qmkj.wlc.ui.dialog.base.BaseDialog;
import com.qmkj.wlc.utils.ResourcesUtil;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * author：rongkui.xiao --2018/6/13
 * email：dovexiaoen@163.com
 * description:系统设置页面
 */

public class SystemSettingActivity extends BaseActivity {

    private BaseDialog alterNormalDialog;
    private ProgressBar updatePrgBarNormal;

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_system_setting;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.immediate_update_bt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.immediate_update_bt:
                normalUpdate(null);
                break;
        }
    }

    private void normalUpdate(AppUpdateModel appUpdateRes) {
        alterNormalDialog = new BaseDialog(mContext, R.style.common_dialog, R.layout.dialog_update_app);
        alterNormalDialog.setAlertDialogWidth((int) ResourcesUtil.getDimen(R.dimen.x330));
        alterNormalDialog.setCanceledOnTouchOutside(false);
        alterNormalDialog.setCancelable(false);
        Button update_immediately_bt = alterNormalDialog.getView(R.id.update_immediately_bt, Button.class);
        Button update_later_bt = alterNormalDialog.getView(R.id.update_later_bt, Button.class);
        TextView update_loading_tv = alterNormalDialog.getView(R.id.update_loading_tv, TextView.class);
        LinearLayout update_bt_ll = alterNormalDialog.getView(R.id.update_bt_ll, LinearLayout.class);
        updatePrgBarNormal = alterNormalDialog.getView(R.id.update_prg_bar, ProgressBar.class);

        update_immediately_bt.setOnClickListener(v -> {

        });
        update_later_bt.setOnClickListener(v -> {
            alterNormalDialog.dismiss();
        });
        alterNormalDialog.show();
    }
}
