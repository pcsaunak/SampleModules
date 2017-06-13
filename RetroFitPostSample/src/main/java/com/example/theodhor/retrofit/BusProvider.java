package com.example.theodhor.retrofit;

import com.squareup.otto.Bus;

/**
 * Created by Dori on 3/10/2016.
 * Check the below URL for explanation on this
 * https://www.sitepoint.com/retrofit-a-simple-http-client-for-android-and-java/
 */
public class BusProvider {

    private static final Bus BUS = new Bus();

    public static Bus getInstance(){
        return BUS;
    }

    public BusProvider(){}
}
