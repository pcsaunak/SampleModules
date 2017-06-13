package com.operamediaworks.googleplayadapter.demoapp;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.admarvel.android.ads.AdMarvelUtils;
import com.admarvel.android.ads.AdMarvelUtils.SDKAdNetwork;
import com.admarvel.android.ads.nativeads.AdMarvelNativeAd;
import com.admarvel.android.ads.nativeads.AdMarvelNativeMetadata;
import com.admarvel.android.ads.nativeads.AdMarvelNativeNotice;
import com.admarvel.android.ads.nativeads.AdMarvelNativeRating;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.operamediaworks.android.googleplayadapter.GADAdMarvelNativeAdView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity
    {

	private AdView admobView;
	private FrameLayout mAdBox;
	private InterstitialAd interstitial;

	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
	    super.onCreate( savedInstanceState );
	    setContentView( R.layout.activity_main );
	    mAdBox = ( FrameLayout ) findViewById( R.id.adBox );

	    initUI();
	    // requestAd();
	}

	public void getBanner( View view )
	{
	    requestAd();
	}

	public void getInterstitial( View view )
	{
	    requestInterstitial();
	}

	private void requestAd()
	{
	    if ( nativeAdContainer != null )
		{
		    nativeAdContainer.setVisibility( View.GONE );
		    nativeAdContainer.requestLayout();
		}
	    if(videoView != null)
		{
		    videoView.removeAllViews();
		    videoView.requestLayout();
		}
	    initUI();
	    
	    interstitial = null;
	    if ( admobView != null )
		{
		    mAdBox.removeAllViews();
		    admobView.destroy();
		    admobView = null;

		}

	    Builder adRequest = new AdRequest.Builder();
	    adRequest.addTestDevice( AdRequest.DEVICE_ID_EMULATOR );
	    Bundle adMobNetworkExtraBundle = new Bundle();

	    // Passing additional targetting for OperaMediaworks
	    adMobNetworkExtraBundle.putString( "bundleTest" , "TestValue" );

	    adRequest
		    .addCustomEventExtrasBundle(
			    com.operamediaworks.android.googleplayadapter.OperaMediaworksGooglePlayAdapter.class ,
			    adMobNetworkExtraBundle );

	    admobView = new AdView( this );
//	    admobView.setAdUnitId( "ca-app-pub-8460377781819484/1246215257" ); // test
	    admobView.setAdUnitId( "ca-app-pub-8460377781819484/2722948451" ); // test
									       // pub
									       // id

	    admobView.setAdSize( AdSize.BANNER );
	    admobView.setAdListener( new InternalAdListener() );

	    admobView.setLayoutParams( new FrameLayout.LayoutParams(
		    FrameLayout.LayoutParams.FILL_PARENT ,
		    FrameLayout.LayoutParams.WRAP_CONTENT ) );

	    admobView.loadAd( adRequest.build() );

	}

	private void requestInterstitial()
	{
	    interstitial = new InterstitialAd( this );
//	    interstitial.setAdUnitId( "ca-app-pub-8460377781819484/3178602859" );
	    interstitial.setAdUnitId( "ca-app-pub-7240756536023419/3012709263" );
	    interstitial.setAdListener( new InternalAdListener() );

	    // Create ad request.
	    Builder adRequest = new AdRequest.Builder();
	    Bundle adMobNetworkExtraBundle = new Bundle();
	    adMobNetworkExtraBundle.putString( "case" , "fb" );

	    adRequest
		    .addCustomEventExtrasBundle(
			    com.operamediaworks.android.googleplayadapter.OperaMediaworksGooglePlayAdapter.class ,
			    adMobNetworkExtraBundle );

	    // Begin loading your interstitial.
	    interstitial.loadAd( adRequest.build() );
	}

	public void displayInterstitial()
	{
	    if ( interstitial.isLoaded() )
		{
		    interstitial.show();
		}
	}

	@Override
	protected void onStart()
	{
	    // TODO Auto-generated method stub
	    super.onStart();
	}

	@Override
	protected void onPause()
	{
	    if ( admobView != null )
		{
		    Log.e( "admob test" , "@!@! pause" );
		    admobView.pause();
		}
	    super.onPause();
	}

	@Override
	protected void onStop()
	{
	    // TODO Auto-generated method stub
	    super.onStop();
	}

	@Override
	protected void onDestroy()
	{
	    if ( admobView != null )
		{
		    Log.e( "admob test" , "@!@! destroy" );
		    admobView.destroy();
		}
	    super.onDestroy();
	}

	@Override
	protected void onResume()
	{
	    if ( admobView != null )
		{
		    Log.e( "admob test" , "@!@! resume" );
		    admobView.resume();
		}
	    super.onResume();
	}

	class InternalAdListener extends AdListener
	    {
		@Override
		public void onAdClosed()
		{
		    Log.e( "admob test" , "@!@! onAdClosed" );
		    super.onAdClosed();
		}

		@Override
		public void onAdFailedToLoad( int errorCode )
		{
		    Log.e( "admob test" , "@!@! onAdFailedToLoad" + errorCode );
		    super.onAdFailedToLoad( errorCode );
		}

		@Override
		public void onAdLeftApplication()
		{
		    Log.e( "admob test" , "@!@! onAdLeftApplication" );
		    super.onAdLeftApplication();
		}

		@Override
		public void onAdLoaded()
		{
		    super.onAdLoaded();
		    
		    ViewGroup view = null;
		    View gadAdMarvelNativeView =null;
		    
		    if(admobView!=null){
		     view = ( ViewGroup ) admobView.getChildAt( 0 );
		     if(view!=null){
			  gadAdMarvelNativeView = view.getChildAt( 1 );
		     }
		    }
		    Log.e( "admob test" , "@!@! onAdLoaded" );
		    if ( interstitial != null )
			{
			    displayInterstitial();
			}
		    else if ( gadAdMarvelNativeView instanceof GADAdMarvelNativeAdView )
			{
			    Log.e( "admob test" ,
				    "@!@! in  admarvelNativeAd blcok" );
			    adMarvelNativeAd = ( ( GADAdMarvelNativeAdView ) gadAdMarvelNativeView )
				    .getAdMarvelNativeAd();

			    if ( adMarvelNativeAd != null )
				{
				    displayNativeAd();
				}
			    // call activity intent
			}
		    else if ( mAdBox != null )
			{mAdBox.removeAllViews();
			    mAdBox.addView( admobView );
			}

		}

		@Override
		public void onAdOpened()
		{
		    Log.e( "admob test" , "@!@! onAdOpened" );
		    super.onAdOpened();
		}
	    }
	
	
	private LinearLayout nativeAdContainer;
	private ImageView nativeAdIcon;
	private TextView nativeAdTitle;
	private TextView nativeAdBody;
	private ImageView nativeAdImage;

	private TextView nativeAdSponsoredMarker;
	private Button nativeAdCallToAction;
	private RatingBar nativeAdStarRating;
	private AdMarvelNativeAd adMarvelNativeAd;
	private TextView attribution_txt;
	private ImageView attribution_icon;
	private RelativeLayout videoView;

	
	private void initUI()
	{
	    nativeAdContainer = ( LinearLayout ) findViewById( R.id.nativeAdContainer );
	    nativeAdIcon = ( ImageView ) findViewById( R.id.nativeAdIcon );
	    nativeAdTitle = ( TextView ) findViewById( R.id.nativeAdTitle );
	    nativeAdBody = ( TextView ) findViewById( R.id.nativeAdBody );
	    nativeAdImage = ( ImageView ) findViewById( R.id.nativeAdImage );
	    nativeAdSponsoredMarker = ( TextView ) findViewById( R.id.nativeAdSponsoredMarker );
	    nativeAdCallToAction = ( Button ) findViewById( R.id.nativeAdCallToAction );
	    nativeAdStarRating = ( RatingBar ) findViewById( R.id.nativeAdStarRating );
	    attribution_txt = ( TextView ) findViewById( R.id.attribution_text );
	    attribution_icon = ( ImageView ) findViewById( R.id.attribution_icon );
	    videoView = ( RelativeLayout ) findViewById( R.id.videoView );
	    nativeAdCallToAction.setVisibility( View.GONE );
	}
	
	
	private void displayNativeAd()
	{
	    try
		{
		    new Handler( Looper.getMainLooper() ).post( new Runnable()
			{

			    @Override
			    public void run()
			    {
				// Setting the Text
				if(adMarvelNativeAd!=null){
				    nativeAdContainer.setVisibility( View.VISIBLE );
        				if ( adMarvelNativeAd.getDisplayName() != null )
        				    {
        					nativeAdTitle.setText( adMarvelNativeAd
        						.getDisplayName() );
        					nativeAdTitle
        						.setVisibility( View.VISIBLE );
        				    }
        				if ( adMarvelNativeAd.getShortMessage() != null )
        				    {
        					nativeAdBody.setText( adMarvelNativeAd
        						.getShortMessage() );
        				    }
        				if ( adMarvelNativeAd.getCta() != null
        					&& adMarvelNativeAd.getCta().getTitle() != null )
        				    {
        					nativeAdCallToAction.setVisibility( View.VISIBLE );
        					nativeAdCallToAction
        						.setText( adMarvelNativeAd
        							.getCta().getTitle() );
        				    }
        
        				if ( adMarvelNativeAd.getAdSponsoredMarker() != null )
        				    {
        					nativeAdSponsoredMarker.setText( adMarvelNativeAd
        						.getAdSponsoredMarker() );
        					nativeAdSponsoredMarker
        						.setVisibility( View.VISIBLE );
        				    }
        				else
        				    {
        					nativeAdSponsoredMarker
        						.setVisibility( View.GONE );
        				    }
        
        				// Downloading and setting the ad icon.
        				if ( adMarvelNativeAd.getIcon() != null )
        				    {
        					adMarvelNativeAd.getIcon()
        						.downloadAndDisplayImage(
        							nativeAdIcon );
        				    }
        
        				// setting video view
        				nativeAdImage.setVisibility( View.GONE );
        				videoView.setVisibility( View.GONE  );
        				nativeAdContainer.requestLayout();
        				if ( adMarvelNativeAd
        					.getAdMarvelNativeVideoView() != null )
        				    {
        					videoView.removeAllViews();
        					videoView.setVisibility( View.VISIBLE  );
        					videoView.addView( adMarvelNativeAd
        						.getAdMarvelNativeVideoView() );
        					
        				    }else if ( adMarvelNativeAd.getCampaignImage() != null
        					&& adMarvelNativeAd.getCampaignImage().length > 0 )
        				    {
        					adMarvelNativeAd.getCampaignImage()[0]
        						.downloadAndDisplayImage( nativeAdImage );
        					int bannerWidth = adMarvelNativeAd
        						.getCampaignImage()[0]
        						.getWidth();
        					int bannerHeight = adMarvelNativeAd
        						.getCampaignImage()[0]
        						.getHeight();
        
        					/*if ( bannerWidth > 0
        						&& bannerHeight > 0 )
        
        					    {
        
        						WindowManager wm = ( WindowManager ) getApplicationContext()
        							.getSystemService(
        								Context.WINDOW_SERVICE );
        						Display display = wm
        							.getDefaultDisplay();
        						DisplayMetrics metrics = new DisplayMetrics();
        						display.getMetrics( metrics );
        						int screenWidth = metrics.widthPixels;
        						nativeAdImage
        							.setLayoutParams( new LinearLayout.LayoutParams(
        								screenWidth ,
        								( int ) ( ( ( double ) screenWidth / ( double ) bannerWidth ) * bannerHeight ) ) );
        
        					    }
        			*/		nativeAdImage
        						.setVisibility( View.VISIBLE );
        
        				    }
        				else
        				    {
        					nativeAdImage.setVisibility( View.GONE );
        				    }
        
        				AdMarvelNativeRating rating = adMarvelNativeAd
        					.getRating();
        				if ( rating != null )
        				    {
        					try
        					    {
        						if ( rating.getBase() != null
        							&& rating.getValue() != null )
        						    {
        							double base = Double
        								.parseDouble( rating
        									.getBase() );
        							double value = Double
        								.parseDouble( rating
        									.getValue() );
        							nativeAdStarRating
        								.setNumStars( ( int ) base );
        							nativeAdStarRating
        								.setRating( ( float ) value );
        							nativeAdStarRating
        								.setVisibility( View.VISIBLE );
        
        						    }
        					    }
        					catch ( NumberFormatException e )
        					    {
        						// TODO Auto-generated catch
        						// block
        						e.printStackTrace();
        					    }
        				    }
        				else
        				    {
        					nativeAdStarRating
        						.setVisibility(View.GONE);
        				    }
        				

					adMarvelNativeAd.registerContainerView(nativeAdContainer);
					View[] handleClickViews = {nativeAdCallToAction};
					adMarvelNativeAd.registerClickableViews(handleClickViews,AdMarvelNativeAd.ADMARVEL_HANDLE_CLICK_EVENT );
        
        				Map < String , AdMarvelNativeMetadata > metadata = adMarvelNativeAd
        					.getMetadatas();
        				if ( metadata != null
        					&& metadata
        						.containsKey( "availabilityString" ) )
        				    {
        					/*String fbSocialContext = metadata.get(
        						"availabilityString" )
        						.getValue();
        					if ( fbSocialContext != null )
        					    {
        						nativeAdSocialContext
        							.setText( fbSocialContext );
        						nativeAdSocialContext
        							.setVisibility( View.VISIBLE );
        					    }
        
        					StringBuilder strBuilder = new StringBuilder();
        
        					Set < String > keys = metadata.keySet();
        					if ( keys != null )
        					    {
        						
        					    }*/
        				    }
        
        				// setting AD Notice text and Icon
        
        				AdMarvelNativeNotice notice = adMarvelNativeAd
        					.getNotice();
        				if ( notice != null )
        				    {
        					attribution_txt.setText( notice
        						.getTitle() );
        					attribution_txt
        						.setVisibility( View.VISIBLE );
        					notice.getImage()
        						.downloadAndDisplayImage(
        							attribution_icon );
        
        					attribution_icon
        						.setVisibility( View.VISIBLE );
        				    }
        
        				nativeAdContainer.invalidate();
        				nativeAdContainer.setVisibility(View.VISIBLE);


					View[] handleNoticeViews = {attribution_icon};
					adMarvelNativeAd.registerClickableViews(handleNoticeViews , AdMarvelNativeAd.ADMARVEL_HANDLE_NOTICE_CLICK_EVENT);
					}
        			}
			} );

		}
	    catch ( Exception e )
		{
		    e.printStackTrace();
		}

	}

    }
