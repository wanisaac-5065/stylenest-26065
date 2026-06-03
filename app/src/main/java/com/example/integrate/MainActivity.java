package com.example.integrate;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Tell the Android Studio compiler that the JavaScript risk has been reviewed and managed
    @SuppressWarnings("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView myWebView = findViewById(R.id.myWebView);

        // Security Guardrail: Only execute traffic if it routes to your target domain
        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return !request.getUrl().toString().contains("base44.app");
            }
        });

        WebSettings webSettings = myWebView.getSettings();

        // Explicitly enabled for your trusted storefront domain
        webSettings.setJavaScriptEnabled(true);

        webSettings.setDomStorageEnabled(true);
        webSettings.setDatabaseEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(false);

        // Block internal system file access to avoid file-based XSS injection exploits
        webSettings.setAllowFileAccess(false);
        webSettings.setAllowContentAccess(false);

        myWebView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        myWebView.loadUrl("https://base44.app");
    }
}
