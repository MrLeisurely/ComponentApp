package com.example.webview;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.webview.databinding.FragmentWebviewBinding;
import com.example.webview.utils.Constants;
import com.example.webview.webviewclent.MyWebViewClient;

public class FragmentWebView extends Fragment implements WebViewCallback {
    private static final String TAG = FragmentWebView.class.getSimpleName();
    private String url;
    private FragmentWebviewBinding binding;

    public static FragmentWebView newInstance(String url){
        Bundle bundle = new Bundle();
        bundle.putString(Constants.LOAD_URL,url);
        FragmentWebView fragmentWebView = new FragmentWebView();
        fragmentWebView.setArguments(bundle);
        return fragmentWebView;
    }
    
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (null != getArguments()){
            url = getArguments().getString(Constants.LOAD_URL);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_webview,container,false);
        binding.webview.getSettings().setJavaScriptEnabled(true);
        binding.webview.setWebViewClient(new MyWebViewClient(this));
        if (null != url){
            binding.webview.loadUrl(url);
        }
        
        return binding.getRoot();
    }

    @Override
    public void onWebViewStart(String url) {
        Log.d(TAG,"onWebViewStart");
    }

    @Override
    public void onWebViewFinished(String url) {
        Log.d(TAG,"onWebViewFinished");
    }
}
