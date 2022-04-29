package com.rc.lock.mvp.contract;

import android.content.Context;

import com.rc.lock.base.BasePresenter;
import com.rc.lock.base.BaseView;
import com.rc.lock.model.CommLockInfo;

import java.util.List;

/**
 * Created by xian on 2017/2/17.
 */

public interface MainContract {
    interface View extends BaseView<Presenter> {
        void loadAppInfoSuccess(List<CommLockInfo> list);
    }

    interface Presenter extends BasePresenter {
        void loadAppInfo(Context context, boolean isSort);

        void loadLockAppInfo(Context context);

        void onDestroy();
    }
}
