package com.example.integrate;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 1. Create the container to display your website
        WebView myWebView = new WebView(this);

        // 2. Prevent the links from opening outside the app in Chrome
        myWebView.setWebViewClient(new WebViewClient());

        // 3. Enable JavaScript so your Base44 interactive elements work
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true); // Helps layout elements load cleanly

        // 4. Point it directly to your live Base44 web app
        myWebView.loadUrl("https://base44.app");

        // 5. Display it on the phone screen
        setContentView(myWebView);
    }
}
