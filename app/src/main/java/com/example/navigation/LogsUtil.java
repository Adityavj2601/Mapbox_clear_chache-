package com.example.navigation;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LogsUtil extends AppCompatActivity implements LocationListener {

    public float lat;
    public float lon;

    LocationManager locationManager;


    void getLocation() {
        try {


            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            final boolean gpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            Log.d("bol", String.valueOf(gpsEnabled));
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0,0, this);
            //Log.d("loc", String.valueOf(locationManager));


        }
        catch(SecurityException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        location.setAccuracy(2);

        Log.d("onlocationchanged","jd");
         lat = (float) location.getLatitude();
         lon = (float) location.getLongitude();



    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }
}