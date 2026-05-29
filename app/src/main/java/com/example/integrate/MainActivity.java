package com.example.integrate;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 1. Initialize the modern web view platform container
        WebView myWebView = new WebView(this);

        // 2. Prevent redirect links from escaping out into Google Chrome
        myWebView.setWebViewClient(new WebViewClient());

        // 3. Configure advanced web features required by modern web platforms
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);        // Runs interactive scripts
        webSettings.setDomStorageEnabled(true);         // Loads web application frames
        webSettings.setDatabaseEnabled(true);           // Keeps product data active
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);

        // 4. Force premium hardware graphics rendering speeds
        myWebView.setLayerType(View.LAYER_TYPE_HARDWARE, null);

        // 5. Direct the browser container straight to your personal application storefront
        myWebView.loadUrl("https://style-nest-shop.base44.app/");

        // 6. Project the storefront clean onto the smartphone screen
        setContentView(myWebView);
    }
}
