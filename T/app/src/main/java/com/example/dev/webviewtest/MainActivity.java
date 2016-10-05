package com.example.dev.webviewtest;

        import android.content.Intent;
        import android.os.Message;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.webkit.WebChromeClient;
        import android.webkit.WebView;
        import android.webkit.WebViewClient;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        WebView webView = (WebView)findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportMultipleWindows(true);


        webView.setWebChromeClient(new WebChromeClient() {

            @Override
            public boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {

                Log.i("TAG","create window");

                Intent intent=new Intent(MainActivity.this,SubActivity.class);
                startActivity(intent);

                return false;
                // return super.onCreateWindow(view, isDialog, isUserGesture, resultMsg);
            }

            @Override
            public void onCloseWindow(WebView window) {

                super.onCloseWindow(window);
                //
            }
        });
        webView.setWebViewClient(new WebViewClientClass());
        webView.loadUrl("http://allyall.co.kr/id.php");



    }


    private class WebViewClientClass extends WebViewClient {



        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Toast.makeText(view.getContext(), url, Toast.LENGTH_SHORT).show();
            if(url.startsWith("http://allyall.co.kr/to.php"))
            {






                //   Intent intent=new Intent(MainActivity.this,SubActivity.class);
                //   startActivity(intent);
                //   return true;
            }


            return false;

        }
    }

}
