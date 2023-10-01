package x;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.x.R;

/**
 * @Author Cheese
 * @Date 2023/10/01 16:58
 */
public class Browser extends Activity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.getActionBar().hide();
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_browser);
		getWindow().setStatusBarColor(0xFF80C269);
		WebView web=findViewById(R.id.web);
		WebSettings webSettings = web.getSettings();
		webSettings.setJavaScriptEnabled(true);
		web.setWebViewClient(new WebViewClient() {
				@Override
				public boolean shouldOverrideUrlLoading(WebView view, String url) {
					view.loadUrl(url);
					return true;
				}
			});
		
		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
			String url = bundle.getString("url");
			web.loadUrl(url);
		}
		findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					finish();
				}
			});
    }
}
