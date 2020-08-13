package com.example.componentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.base.autoservice.MyServiceLoader;
import com.example.common.autoservice.IWebViewService;
import com.example.componentapp.databinding.ActivityMainBinding;
import com.example.webview.WebViewActivity;

import java.util.ServiceLoader;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.tvStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //迭代器原则，获取IWebViewService的实现 这里可能会null
                IWebViewService service = MyServiceLoader.getService(IWebViewService.class);
                if (null != service){
                    service.loadWebUrl(MainActivity.this,"https://www.baidu.com","baidu",true);
//                startActivity(new Intent(MainActivity.this,WebViewActivity.class));
                }
            }
        });
    }
}