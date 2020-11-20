package com.jjh.android.mapdemo;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, OnMarkerClickListener {

    private static final String TAG = "MapsActivity";

    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate()");

        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        Log.d(TAG, "onMapReady()");

        map = googleMap;

        map.getUiSettings().setZoomControlsEnabled(true);
        map.getUiSettings().setCompassEnabled(true);

        // Add a marker in Sydney and move the camera
        //LatLng latAndLong = new LatLng(-33.852, 151.211);
        // This one is for London
        LatLng latAndLong = new LatLng(51.5074, 0.1278);
        Marker marker =
                map.addMarker(
                    new MarkerOptions()
                            .position(latAndLong)
                            .draggable(true)
                            .title("Marker in London")
                            .snippet("Capital City of UK"));
        map.moveCamera(CameraUpdateFactory.newLatLng(latAndLong));

        // Changing the Google View
        map.moveCamera(CameraUpdateFactory.newLatLng(latAndLong));
        map.animateCamera(CameraUpdateFactory.zoomIn());

        // Set up some data to use with the marker
        marker.setTag(0);
        // Set up a listener for marker clicks
        map.setOnMarkerClickListener(this);

        // Can make the marker visible or not - true is default
        // marker.setVisible(false);

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        Log.d(TAG, "onMarkerClick()");
        // Retrieve the data from the marker.
        int clickCount = (int)marker.getTag();

        // Check if a click count was set, then display the click count
        if (clickCount != 0) {
            int clicks = clickCount + 1;
            marker.setTag(clicks);
            Toast.makeText(this,
            "${marker.title} has been clicked $clicks times",
                    Toast.LENGTH_SHORT
            ).show();
        }

        // Return false to indicate that we have not consumed the event and that we wish
        // for the default behavior to occur (which is for the camera to move such that the
        // marker is centered and for the marker's info window to open, if it has one).
        return false;
    }
}