package com.example.learn.SampleOct;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private WebView myWebView;
    private Context mContext;
    private WebView mWebviewPop;
    private FrameLayout mContainer;
    private Button _btnLoadWebView;
//    private static final String target_url=
//            "https://adclick.g.doubleclick.net/pcs/click?xai=AKAOjstCgN3zYGEOTRnmDcifbfVy654utXcN5RF4ELdaizdUXSrT9nf_ilica490xrY77WnQBcchlzs&sig=Cg0ArKJSzPu-9ytCQGQpEAE&urlfix=1&adurl=https://www.youtube.com/hnsarabia";
    private static final String target_url_prefix="mp.vibescm.com";
    private static final String target_url="https://www.youtube.com/hnsarabia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        setContentView(R.layout.activity_main);

        _btnLoadWebView=(Button)findViewById(R.id.btn_LoadWebView);

        _btnLoadWebView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                WebView childWebView = new WebView(getApplicationContext());
                childWebView.setWebChromeClient(new WebChromeClient());
                Log.d("URL",target_url);
                childWebView.loadUrl(target_url);
            }
        });
        myWebView=(WebView)findViewById(R.id.myWebView);
//        mContainer =(FrameLayout) findViewById(R.id.webview_frame);





      /*  CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setSupportMultipleWindows(true);
        myWebView.setWebViewClient(new UriWebViewClient());
        myWebView.setWebChromeClient(new UriChromeClient());
        myWebView.loadUrl(target_url);

*/

//        String customHtml= "<div style=\"display:none; position:absolute;\" id=\"im_7495_clickTarget\"></div> <script type=\"text/javascript\"> (function() {var f=window,g=encodeURIComponent,h=document,k='appendChild',l='setAttribute',p='createElement',q='',r='&',s='0',t='2',u='=',v='?',w='Events',x='_blank',y='a',z='click',A='clickCallback',B='clickTarget',C='error',D='event',F='function',G='height',H='href',I='iatSendClick',J='iframe',K='img',L='impressionCallback',M='m=',N='onclick',O='openLandingPage',P='recordEvent',Q='seamless',R='src',S='target',T='width';f.inmobi=f.inmobi||{};var U=f.inmobi;U.d=U.d||[]; U.c=function(a,b){for(var c=U.d,d=0;d<c.length;d++)c[d].call(this,a,b)};U.recordEvent=U.c; function V(a){function b(a,b){c.c(a,b)}this.j=a.lp;this.k=a.lps;this.b=a.ct;this.f=a.tc;this.h=a.bcu;this.a=a.ns;this.l=a.ws;this.g=a.sc;a=this.a;var c=this;f[a+O]=function(){var a=V.e(c.j),b=f.mraid;'undefined'!==typeof b&&'undefined'!==typeof b.openExternal?b.openExternal(a):(a=V.e(c.k),b=h[p](y),b[l](S,x),b[l](H,a),h.body[k](b),V.i(b))};f[a+A]=function(a){W(c,a)};f[a+L]=function(){X(c)};f[a+P]=b;this.g&&U.d.push(b)}U.Bolt=V; V.i=function(a){if(typeof a.click==F)a.click.call(a);else if(a.fireEvent)a.fireEvent(N);else if(a.dispatchEvent){var b=h.createEvent(w);b.initEvent(z,!1,!0);a.dispatchEvent(b)}};V.e=function(a){return a.replace(/\\$TS/g,q+(new Date).getTime())};function Y(a,b){var c=h.getElementById(a.a+B),d=h[p](J);d[l](R,b);d[l](Q,Q);d[l](G,s);d[l](T,t);c[k](d)} function W(a,b){var c=f[a.a+I];c&&c();if(null!=a.b)for(var c=a.b.length,d=0;d<c;d++)Y(a,V.e(a.b[d]));a.l&&(b=b||eval(D),'undefined'!==typeof b&&(c=void 0!=b.touches?b.touches[0]:b,f.external.notify(JSON.stringify({m:c.clientX,n:c.clientY}))))}function X(a){if(null!=a.f)try{var b=h.getElementById(a.a+B),c=a.f,d=h[p](J);d[l](Q,Q);d[l](G,s);d[l](T,t);b[k](d);var e=d.contentWindow;e&&(e.document.write(c),e.document.close())}catch(n){}} V.prototype.c=function(a,b){function c(a,b,e){if(!(0>=e)){var n=h.getElementById(d.a+B),m=h[p](K);m[l](R,a);m[l](G,s);m[l](T,t);void 0!=m.addEventListener&&m.addEventListener(C,function(){f.setTimeout(function(){3E5<b&&(b=3E5);c(a,2*b,e-1)},b*Math.random())},!1);n[k](m)}}var d=this,e=this.h,n=v;0<=e.indexOf(v)&&(n=r);e+=n+M+a;if(b)for(var E in b)e+=r+g(E)+u+g(b[E]);c(e,1E3,5);18==a&&X(this);8==a&&W(this,null)};})(); (function() {var a=window,c='handleClick',e='handleTouchEnd',f='handleTouchStart';a.inmobi=a.inmobi||{};function g(b,h){this.b=h;this.a=this.c=!1;var d=this;a[b+c]=function(){d.click()};a[b+f]=function(){d.start(a.event)};a[b+e]=function(){d.end()}}a.inmobi.OldTap=g;g.prototype.click=function(){this.c||this.b()};g.prototype.start=function(b){this.a=this.c=!0;b&&b.preventDefault()};g.prototype.end=function(){this.a&&(this.a=!1,this.b())};})(); new window.inmobi.Bolt({\"lp\":\"https://itunes.apple.com/app/id517729226?mt\\u003d8\",\"lps\":\"https://itunes.apple.com/app/id517729226?mt\\u003d8\",\"ct\":[\"https://c.w.inmobi.com/c.asm/C/t/eitz85qupm/1nts/w/2m/mo/u/0/0/0/eyJVSUQiOiI1QkFFMDQzMC1CODY3LTRFRDYtQkIxNS0xQTEyMzcwQjEwNDYiLCJJREEiOiI1QkFFMDQzMC1CODY3LTRFRDYtQkIxNS0xQTEyMzcwQjEwNDYifQ~~/679d0943-015a-1000-c350-01d2718000d1/-1/4606/14/1/0/x/14151410/NW/2t/0/api/2.0.0/s_admarvel/eA~~/FvqNARaAyNAHFqa-ibj0VTf8m69IjJtSPxQcFwAAAAAAAPA_F_ybr0iMm4I_FwAAAAAAAAAAFAQSGDg0S3BxVmIzZGJzV1d2Y0hXdnYrWUprZXdSb3lQMGsvTjFrNDBna2s5ZlNOU05uQUU5S2dTUGc9PRgGQkFOTkVSHBQAFAIcHBaAwNCV4NCEnc8BFt2E6c3Ii_-KeQAW_OGE9JPblsXpARUAEgAAOQUhFAAWluSql_xTKClwZXJmLWFkcG9vbDEwMTlfcGVyZl91aDFfcGVyZi1hZHBvb2xfcHJvZBQEEibM3RccFQIALBUCAFMBJvqNARUAEhgUMC4wMDkwODU3NDY3MzQ4MDk3NjcA/-1/AA\\u003d\\u003d/7/574e6c97?at\\u003d1\\u0026am\\u003d0\"],\"tc\":\"\\u003cimg src\\u003d\\\"https://view.adjust.com/impression/4awyf6?idfa\\u003d5BAE0430-B867-4ED6-BB15-1A12370B1046\\u0026amp;inmobi_click_id\\u003d679d0943-015a-1000-c350-01d2718000d1\\u0026amp;campaign\\u003dEAT24_iOS_USA\\u0026amp;adgroup\\u003dDH4NABZN\\u0026amp;creative\\u003dB-Retargeting_300x250_breakfast--7\\\" style\\u003d\\\"display:none;\\\" /\\u003e\",\"bcu\":\"https://et.w.inmobi.com/c.asm/C/t/eitz85qupm/1nts/w/2m/mo/u/0/0/0/eyJVSUQiOiI1QkFFMDQzMC1CODY3LTRFRDYtQkIxNS0xQTEyMzcwQjEwNDYiLCJJREEiOiI1QkFFMDQzMC1CODY3LTRFRDYtQkIxNS0xQTEyMzcwQjEwNDYifQ~~/679d0943-015a-1000-c350-01d2718000d1/-1/4606/14/0/0/x/14151410/NW/2t/0/api/2.0.0/s_admarvel/eA~~/FvqNARaAyNAHFqa-ibj0VTf8m69IjJtSPxQcFwAAAAAAAPA_F_ybr0iMm4I_FwAAAAAAAAAAFAQSGDg0S3BxVmIzZGJzV1d2Y0hXdnYrWUprZXdSb3lQMGsvTjFrNDBna2s5ZlNOU05uQUU5S2dTUGc9PRgGQkFOTkVSHBQAFAIcHBaAwNCV4NCEnc8BFt2E6c3Ii_-KeQAW_OGE9JPblsXpARUAEgAAOQUhFAAWluSql_xTKClwZXJmLWFkcG9vbDEwMTlfcGVyZl91aDFfcGVyZi1hZHBvb2xfcHJvZBQEEibM3RccFQIALBUCAFMBJvqNARUAEhgUMC4wMDkwODU3NDY3MzQ4MDk3NjcA/-1/AA\\u003d\\u003d/7/e0f72a70\",\"ws\":false,\"ns\":\"im_7495_\",\"sc\":true}); new window.inmobi.OldTap(\"im_7495_\", function() { window['im_7495_openLandingPage'](); window['im_7495_recordEvent'](8); }); </script> <style> .inmC { margin-left: auto; margin-right: auto; display: block; }</style> <div onclick=\"im_7495_handleClick()\" ontouchstart=\"im_7495_handleTouchStart()\" ontouchend=\"im_7495_handleTouchEnd()\"> <img border=\"0\" class=\"inmC\" src=\"https://i.l.inmobicdn.net/banners/FileData/5c65b208-0cd2-4c97-b847-1d2d2c5873fc.jpeg\" alt=\"Yelp Eat24 - Order Food D\" height=\"250\" width=\"300\" /> </div> <style>body{margin:0}</style> <script type=\"text/javascript\"> im_7495_recordEvent(18); </script>";
        String customHtml= "<SCRIPT SRC=\"http://direct.adsrvr.org/bid/bidhelper.js \" TYPE=\"text/javascript\"></SCRIPT><SCRIPT TYPE=\"text/javascript\"> var noFlash = 0; if (typeof BidHelper === 'function') { var bidHelper = new BidHelper(); noFlash = !bidHelper.isFlashSupported();} var iframeSrc = '<IFRAME SRC=\"' + 'http://direct.adsrvr.org/bid/bidder/publisherdirect/?w=300&h=250&did=ttdd-61xvezz-zzfwy27&ord={timestamp}&noflash=' + noFlash + '\" WIDTH=\"300\" HEIGHT=\"250\" MARGINWIDTH=0 MARGINHEIGHT=0 HSPACE=0 VSPACE=0 FRAMEBORDER=0 SCROLLING=no BORDERCOLOR=\"#000000\"></IFRAME>'; document.write(iframeSrc);</SCRIPT>";
        myWebView.loadData(customHtml, "text/html", "UTF-8");
        mContext=this.getApplicationContext();
//        startWebView("https://mp.vibescm.com/c/ce6103");

    }




    private class UriWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            String host = Uri.parse(url).getHost();
            //Log.d("shouldOverrideUrlLoading", url);
            if (host.equals(target_url_prefix))
            {
                // This is my web site, so do not override; let my WebView load
                // the page
                if(mWebviewPop!=null)
                {
                    mWebviewPop.setVisibility(View.GONE);
                    mContainer.removeView(mWebviewPop);
                    mWebviewPop=null;
                }
                return false;
            }

            if(host.equals("mp.vibescm.com"))
            {
                return false;
            }
            // Otherwise, the link is not for a page on my site, so launch
            // another Activity that handles URLs
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
            return true;
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler,
                                       SslError error) {
            Log.d("onReceivedSslError", "onReceivedSslError");
            //super.onReceivedSslError(view, handler, error);
        }
    }

    class UriChromeClient extends WebChromeClient {

        @Override
        public boolean onCreateWindow(WebView view, boolean isDialog,
                                      boolean isUserGesture, Message resultMsg) {
            mWebviewPop = new WebView(mContext);
            mWebviewPop.setVerticalScrollBarEnabled(false);
            mWebviewPop.setHorizontalScrollBarEnabled(false);
            mWebviewPop.setWebViewClient(new UriWebViewClient());
            mWebviewPop.getSettings().setJavaScriptEnabled(true);
            mWebviewPop.getSettings().setSavePassword(false);
            mWebviewPop.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));
            mContainer.addView(mWebviewPop);
            WebView.WebViewTransport transport = (WebView.WebViewTransport) resultMsg.obj;
            transport.setWebView(mWebviewPop);
            resultMsg.sendToTarget();

            return true;
        }

        @Override
        public void onCloseWindow(WebView window) {
            Log.d("onCloseWindow", "called");
        }

    }


    private void startWebView(String url) {

        //Create new webview Client to show progress dialog
        //When opening a url or click on link

        myWebView.setWebViewClient(new WebViewClient() {
            ProgressDialog progressDialog;

            //If you will not use this method url links are opeen in new brower not in webview
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }



            //Show loader on url load
//            public void onLoadResource (WebView view, String url) {
//                Log.d("Example","Inside On Load Resource");
//                if (progressDialog == null) {
//                    // in standard case YourActivity.this
//                    progressDialog = new ProgressDialog(MainActivity.this);
//                    progressDialog.setMessage("Loading...");
//                    progressDialog.show();
//                }
//            }



//            public void onPageFinished(WebView view, String url) {
//
//                Log.d("Example","Inside On Finish PageLoad");
//                try{
//                    if (progressDialog.isShowing()) {
//                        progressDialog.dismiss();
//                        progressDialog = null;
//                    }
//                }catch(Exception exception){
//                    exception.printStackTrace();
//                }
//            }

        });

        // Javascript inabled on webview
//        myWebView.getSettings().setJavaScriptEnabled(true);

        // Other webview options
	    /*
	    webView.getSettings().setLoadWithOverviewMode(true);
	    webView.getSettings().setUseWideViewPort(true);
	    webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
	    webView.setScrollbarFadingEnabled(false);
	    webView.getSettings().setBuiltInZoomControls(true);
	    */

	    /*
	     String summary = "<html><body>You scored <b>192</b> points.</body></html>";
         webview.loadData(summary, "text/html", null);
	     */

        //Load url in webview
        myWebView.loadUrl(url);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(myWebView.canGoBack()) {
            myWebView.goBack();
        } else {
            // Let the system handle the back button
            super.onBackPressed();
        }
    }
}
