package hubjac1.mysmartshoppinglist;

import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class OverviewActivity extends FragmentActivity implements
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private GoogleApiClient mClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        buildGoogleApiClient();

        setUpMapIfNeeded();

    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {

        //mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));

        Location lastLocation = mMap.getMyLocation();
        double lat = lastLocation.getLatitude();
        double lng = lastLocation.getLongitude();
        Log.v("app", "lat " + lat);
        Log.v("app", "lon " + lng);
        mMap.addMarker(new MarkerOptions().position(new LatLng(lat, lng)).title("Marker"));
    }


    protected synchronized void buildGoogleApiClient() {
        Log.e("app", "call");
        mClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }

    @Override
    public void onConnected(Bundle bundle) {

        Log.e("app", "onConnected");
        Location lastLocation = LocationServices.FusedLocationApi.getLastLocation(mClient);
        double lat = lastLocation.getLatitude();
        double lng = lastLocation.getLongitude();
        Log.v("app", "lat " + lat);
        Log.v("app", "lon " + lng);
        mMap.addMarker(new MarkerOptions().position(new LatLng(lat, lng)).title("Marker"));
        lastLocation = mMap.getMyLocation();
        lat = lastLocation.getLatitude();
        lng = lastLocation.getLongitude();
        Log.v("app", "lat " + lat);
        Log.v("app", "lon " + lng);
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.e("app", "onConnectionSuspended");

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.e("app", "onConnectionFailed" + connectionResult.describeContents());

    }
}
