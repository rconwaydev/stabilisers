package com.rc.lock.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.rc.lock.base.AppConstants;
import com.rc.lock.services.BackgroundManager;
import com.rc.lock.services.LoadAppListService;
import com.rc.lock.services.LockService;
import com.rc.lock.utils.LogUtil;
import com.rc.lock.utils.SpUtil;


public class BootBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(@NonNull Context context, Intent intent) {
        LogUtil.i("Boot service....");
        //TODO: pie compatable done
       // context.startService(new Intent(context, LoadAppListService.class));
        BackgroundManager.getInstance().init(context).startService(LoadAppListService.class);
        if (SpUtil.getInstance().getBoolean(AppConstants.LOCK_STATE, false)) {
            BackgroundManager.getInstance().init(context).startService(LockService.class);
            BackgroundManager.getInstance().init(context).startAlarmManager();
        }
    }
}
