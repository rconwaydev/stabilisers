package com.rc.lock.activities.main;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.rc.lock.R;
import com.rc.lock.adapters.MainAdapter;
import com.rc.lock.base.BaseFragment;
import com.rc.lock.model.CommLockInfo;

import java.util.ArrayList;
import java.util.List;

public class SysAppFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    @Nullable
    private List<CommLockInfo> data, list;
    @Nullable
    private MainAdapter mMainAdapter;

    @NonNull
    public static SysAppFragment newInstance(List<CommLockInfo> list) {
        SysAppFragment sysAppFragment = new SysAppFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("data", (ArrayList<? extends Parcelable>) list);
        sysAppFragment.setArguments(bundle);
        return sysAppFragment;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_app_list;
    }

    @Override
    protected void init(View rootView) {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        data = getArguments().getParcelableArrayList("data");
        mMainAdapter = new MainAdapter(getContext());
        mRecyclerView.setAdapter(mMainAdapter);
        list = new ArrayList<>();
        for (CommLockInfo info : data) {
            if (info.isSysApp()) {
                list.add(info);
            }
        }
        mMainAdapter.setLockInfos(list);
    }
}
