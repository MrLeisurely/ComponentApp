package com.example.webview.webviewclent;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.webview.WebViewCallback;

/**
 * 还可按此套路自定义webchormclient
 */
public class MyWebViewClient extends WebViewClient {
    private WebViewCallback viewCallback;

    public MyWebViewClient(WebViewCallback viewCallback) {
        this.viewCallback = viewCallback;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        if (null != viewCallback){
            viewCallback.onWebViewStart(url);
        }
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        if (null != viewCallback){
            viewCallback.onWebViewFinished(url);
        }
    }
}
