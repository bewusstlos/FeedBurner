package net.bewusstlos.feedburner.actvities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebView webView = new WebView(this);
        setContentView(webView);
        String url = getIntent().getStringExtra("Url");
        if(url != null){
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl(url);
        }
        else{
            Toast.makeText(this, "Url is null", Toast.LENGTH_SHORT).show();
        }
    }
}
