package com.example.webview;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.webview.databinding.ActivityWebviewBinding;
import com.example.webview.utils.Constants;

public class WebViewActivity extends AppCompatActivity {

    private ActivityWebviewBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_webview);
        binding.webview.getSettings().setJavaScriptEnabled(true);
        String url = getIntent().getExtras().getString(Constants.LOAD_URL);
        if (null != url){
            binding.webview.loadUrl(url);
        }
    }
}
