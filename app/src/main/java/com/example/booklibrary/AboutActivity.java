package com.example.booklibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.airbnb.lottie.LottieAnimationView;

public class AboutActivity extends AppCompatActivity {
    private WebView webView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        webView=findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.google.com/search?client=opera&q=google&sourceid=opera&ie=UTF-8&oe=UTF-8");
    }
    @Override
    public void onBackPressed() {
        if(webView.canGoBack())
        {
            webView.goBack();
        }
        else
        {
            super.onBackPressed();
        }
    }
}