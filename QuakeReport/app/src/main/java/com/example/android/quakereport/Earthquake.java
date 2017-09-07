package com.example.android.quakereport;

//import static com.example.android.quakereport.R.id.date;

/**
 * Created by Administrator on 7/6/2017.
 */

public class Earthquake {
    // properties
    private double mMagnitude;
    private String mLocation;
    private long mTimeInMilliseconds;
    /** Website URL of the earthquake */
    private String mUrl;


    // contructor
    public Earthquake(double magnitude, String location, long timeInMilliseconds, String url){
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
        mUrl = url;
    }

    // get
    public double getMagnitude() { return mMagnitude; }
    public String getLocation() { return mLocation; }
    public long getTimeInMilliseconds() { return mTimeInMilliseconds; }
    public String getUrl() { return mUrl; }
}
