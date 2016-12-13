package com.mlmishra.bhupendramishra.allelectronics;

/**
 * Created by bhupendramishra on 12/07/15.
 */



import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.view.GestureDetector;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.os.Environment;
import android.webkit.WebChromeClient;
import java.util.Random;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import java.io.File;
import android.view.MenuInflater;
import android.app.DownloadManager.Request;
import android.net.Uri;
import android.app.DownloadManager;
import android.webkit.DownloadListener;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation;
import android.view.KeyEvent;

public class WebViewActivity extends Activity {

    private WebView webView;
    private String url;
    private String searched=new String();
    private Button button;
    final Activity activity=this;
    private ProgressDialog mProgressDialog;
    private Random rand=new Random();
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);

        url="http://circuitscout.com/search.jsp?query="+Global.search_item+"&pd=0";

        webView = (WebView) findViewById(R.id.webView1);
        mProgressDialog=new ProgressDialog(this);;
        mProgressDialog.setTitle("Loading");
        mProgressDialog.setMessage("Searching...touch anywhere to dismiss or it will disappear by itself upon completion");
        mProgressDialog.setCancelable(true);
        mProgressDialog.show();
        webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                activity.setTitle("Loading...");
                activity.setProgress(progress * 100);

                if (progress == 100)
                    activity.setTitle("DATA LOADED");
            }
        });

        webView.setWebViewClient(new WebViewClient() {
            // load url
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                mProgressDialog.show();
                return true;
            }

            // when finish loading page
            public void onPageFinished(WebView view, String url) {

                mProgressDialog.hide();

            }


        });
        webView.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String url, String userAgent,
                                        String contentDisposition, String mimetype,
                                        long contentLength) {
                Request request = new Request(
                        Uri.parse(url));
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, Global.search_item + "datasheet");
                DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                dm.enqueue(request);

            }
        });
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);

            webView.loadUrl(Global.url_search);



        button = (Button) findViewById(R.id.webpage_save_button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String filename=Global.search_item.replace("+"," ")+"_"+rand.nextInt(80);
                File folder = new File(Environment.getExternalStorageDirectory() + "/AllElectronics");
                boolean success = true;
                if (!folder.exists()) {
                    success = folder.mkdir();
                }
                if (success) {
                   // Toast.makeText(WebViewActivity.this,"Folder :AllElectronics Created",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(WebViewActivity.this,"Folder :AllElectronics Creation failed",Toast.LENGTH_LONG).show();
                }
                String path = Environment.getExternalStorageDirectory().getPath() + File.separator +"AllElectronics"+File.separator+ filename + ".mht";
                webView.saveWebArchive(path);
                Global.write_file(filename + ".mht");
                Toast.makeText(WebViewActivity.this,"File Saved", Toast.LENGTH_LONG).show();
                //Intent intent = new Intent(WebViewActivity.this, Search_text.class);
                //startActivity(intent);

                //Global.delete_file(WebViewActivity.this);
            }

        });

    }




    @Override
    public void onBackPressed() {
        // your code.
        //Intent intent = new Intent(WebViewActivity.this, Search_text.class);
        //startActivity(intent);
        finish();

    }



}