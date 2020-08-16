package com.example.webview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;

import androidx.fragment.app.Fragment;

import com.example.common.autoservice.IWebViewService;
import com.example.webview.utils.Constants;
import com.google.auto.service.AutoService;

@AutoService({IWebViewService.class})
public class WebViewServiceImpl implements IWebViewService {
    @Override
    public void loadWebUrl(Context context, String url, String title,boolean isshowAction) {
        if (null != context){
            Intent intent = new Intent(context,WebViewActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString(Constants.LOAD_URL,url);
            bundle.putString(Constants.TITLE,title);
            bundle.putBoolean(Constants.SHOW_ACTION_BAR,isshowAction);
            intent.putExtras(bundle);
            context.startActivity(intent);
        }
    }

    @Override
    public Fragment getFragmentWebView(String url) {
        return FragmentWebView.newInstance(url);
    }
}
