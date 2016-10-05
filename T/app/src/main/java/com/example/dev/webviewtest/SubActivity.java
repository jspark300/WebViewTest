package com.example.dev.webviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        WebView webView = (WebView)findViewById(R.id.subWebView);
        webView.getSettings().setJavaScriptEnabled(true);
        // WebChromeClient webChromeClient = new WebChromeClient();
        webView.setWebChromeClient(new WebChromeClient() {
           @Override
           public void onHideCustomView() {
               Log.i("TAG","HIDE window");
               super.onHideCustomView();
               finish();
           }

           @Override
           public void onCloseWindow(WebView window) {
               Log.i("TAG","CLOSE window");
               super.onCloseWindow(window);
               finish();
           }
       }

        );
        webView.setWebViewClient(new WebViewClientClass());

        webView.loadUrl("http://allyall.co.kr/to.php");


    }
    private class WebViewClientClass extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            Toast.makeText(view.getContext(), url, Toast.LENGTH_SHORT).show();
            finish();
//            if(url.startsWith("http://allyall.co.kr/close"))
//            {
//                finish();
//
//                return false;
//            }
            return true;
//            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//            startActivity(intent);
//            return true;
        }
    }
}
