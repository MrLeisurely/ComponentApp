package com.example.common.autoservice;

import android.content.Context;

import androidx.fragment.app.Fragment;

public interface IWebViewService {
    void loadWebUrl(Context context,String url,String title,boolean isshowAction);
    Fragment getFragmentWebView(String url);
}
