package com.example.theodhor.retrofit;

/**
 * Created by Dori on 3/10/2016.
 * Check the below URL for understanding the code
 * https://www.sitepoint.com/retrofit-a-simple-http-client-for-android-and-java/
 *
 */
public class ErrorEvent {
    private int errorCode;
    private String errorMsg;

    public ErrorEvent(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
