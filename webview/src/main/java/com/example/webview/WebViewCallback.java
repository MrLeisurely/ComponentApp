package com.example.webview;

public interface WebViewCallback {
    void onWebViewStart(String url);
    void onWebViewFinished(String url);
}
