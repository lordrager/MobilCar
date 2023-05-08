package com.example.mobilcar;

import static android.content.ContentValues.TAG;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.model.Place;
//import com.google.android.libraries.places.api.Places;
//import com.google.android.libraries.places.api.model.Place;
//import com.google.android.libraries.places.api.net.PlacesClient;
//import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
//import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class GoogleMapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        Toast.makeText(this, "Map is Ready", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onMapReady: map is ready");
        mMap = googleMap;
        if (mLocationPermissionGranted) {
            getDeviceLocation();

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            mMap.setMyLocationEnabled(true);
            init();
        }
    }

    private GoogleMap mMap;
    private PlaceAutocompleteFragment placeAutocompleteFragment;

    private Boolean mLocationPermissionGranted = false;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final int LOCATION_REQUEST_CODE = 1234;
    private static final float DEFAULT_ZOOM = 15f;

    private EditText mSearchText;
    private ImageView mGps;
    double latitude, longitude;
    private int proximityRadius = 1000;
    private ImageButton gas, services;


//    PlacesClient placesClient;
//    private List<AutocompletePrediction> predictionList;
//    private Location mLastKnownLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_googlemaps);
        mSearchText = (EditText) findViewById(R.id.input_search);
        mGps = (ImageView) findViewById(R.id.icon_gps);
        gas = (ImageButton) findViewById(R.id.gasStations);
        services = (ImageButton) findViewById(R.id.services);


        String apiPlaces = "AIzaSyAHqc3yk88de8jp3nJ0apb1rsmEHh2UNg0";
//        if (!Places.isInitialized()) {
//            Places.initialize(getApplicationContext(), apiPlaces);
//        }
//        placesClient = Places.createClient(this);


        // placeAutocompleteFragment = (PlaceAutocompleteFragment) getFragmentManager().findFragmentById(R.id.place_autocomplete);


//        placeAutocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
//            @Override
//            public void onPlaceSelected(Place place) {
//                Log.d("Maps", "onPlaceSelected: " + place.getName() + place.getId());
//            }
//
//            @Override
//            public void onError(Status status) {
//                Log.d(TAG, "onError: " + status);
//            }
//        });

        getLocationPermission();
        getDeviceLocation();
        initMap();
        init();
    }

    private void init() {
        Log.d(TAG, "init: initializing");

        mSearchText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH
                        || actionId == EditorInfo.IME_ACTION_DONE
                        || event.getAction() == KeyEvent.ACTION_DOWN
                        || event.getAction() == KeyEvent.KEYCODE_ENTER) {

                    geoLocate();
                }
                return false;
            }
        });

        mGps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked gps icon");
                getDeviceLocation();
            }
        });
        hideKeyboard();
    }

    private void geoLocate() {
        Log.d(TAG, "geoLocate: geolocation");

        String searchString = mSearchText.getText().toString();
        Geocoder geocoder = new Geocoder(GoogleMapsActivity.this);
        List<Address> list = new ArrayList<>();
        try {

            list = geocoder.getFromLocationName(searchString, 1);
        } catch (IOException e) {
            Log.e(TAG, "geoLocate: IOException" + e.getMessage());
        }

        if (list.size() > 0) {
            Address address = list.get(0);

            Log.d(TAG, "geoLocate: found a location: " + address.toString());
            //Toast.makeText(this, address.toString(), Toast.LENGTH_SHORT).show();

            moveCamera(new LatLng(address.getLatitude(), address.getLongitude()), DEFAULT_ZOOM, address.getAddressLine(0));
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        getDeviceLocation();
    }

    private void getDeviceLocation() {
        Log.d(TAG, "getDeviceLocation: getting current location");

        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        try {
            if (mLocationPermissionGranted) {
                Task<Location> location = mFusedLocationProviderClient.getLastLocation();
                location.addOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "onComplete: found location!");
                            Location currLocation = (Location) task.getResult();

                            moveCamera(new LatLng(currLocation.getLatitude(), currLocation.getLongitude()),
                                    DEFAULT_ZOOM, "My Location");
                        } else {
                            Log.d(TAG, "onComplete: location is null");
                            Toast.makeText(GoogleMapsActivity.this, "unable to get current location", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

        } catch (SecurityException e) {
            Log.e(TAG, "getDeviceLocation: SecurityException: " + e.getMessage());
        }
    }

    private void moveCamera(LatLng latLng, float zoom, String title) {
        Log.d(TAG, "moveCamera: moving the camera to: lat:" + latLng.latitude + ", lng:" + latLng.longitude);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom));

        MarkerOptions options = new MarkerOptions().position(latLng).title(title);
        mMap.addMarker(options);
        hideKeyboard();
    }

    private void initMap() {
        Log.d(TAG, "initMap: initializing map");
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(GoogleMapsActivity.this);
    }

    private void getLocationPermission() {
        Log.d(TAG, "getLocationPermission: getting location");
        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};

        if (ContextCompat.checkSelfPermission(this.getApplicationContext(), FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            if ((ContextCompat.checkSelfPermission(this.getApplicationContext(), COARSE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED)) {
                mLocationPermissionGranted = true;
                initMap();
            } else {
                ActivityCompat.requestPermissions(this, permissions,
                        LOCATION_REQUEST_CODE);
            }
        } else {
            ActivityCompat.requestPermissions(this, permissions,
                    LOCATION_REQUEST_CODE);
        }
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.d(TAG, "onRequestPermissionsResult: called.");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        mLocationPermissionGranted = false;

        if (requestCode == LOCATION_REQUEST_CODE) {
            if (grantResults.length > 0) {
                for (int i = 0; i < grantResults.length; i++) {
                    if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                        mLocationPermissionGranted = false;
                        Log.d(TAG, "onRequestPermissionsResult: permission failed");
                        return;
                    }
                }
                Log.d(TAG, "onRequestPermissionsResult: permission granted");
                mLocationPermissionGranted = true;
                initMap();
            }
        }
    }

    private void hideKeyboard() {
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    public void onClick(View v) {
        int id = v.getId();

        String gasStations = "gasStations", services = "services";
        Object[] transferData = new Object[2];
        GetNearbyPlaces getNearbyPlaces = new GetNearbyPlaces();


        if (id == R.id.ic_magnify) {
            EditText addressField = (EditText) findViewById(R.id.input_search);
            String address = addressField.getText().toString();

            List<Address> addressList = new ArrayList<>();
            MarkerOptions userMarkerOptions = new MarkerOptions();

            if (!TextUtils.isEmpty(address)) {
                Geocoder geocoder = new Geocoder(this);
                try {
                    addressList = geocoder.getFromLocationName(address, 6);
                    if (addressList != null) {
                        for (int i = 0; i < addressList.size(); i++) {

                            Address userAddress = addressList.get(i);
                            LatLng latLng = new LatLng(userAddress.getLatitude(), userAddress.getLongitude());

                            userMarkerOptions.position(latLng);
                            userMarkerOptions.title(address);
                            userMarkerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
                            mMap.addMarker(userMarkerOptions);
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                            mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
                        }
                    } else {
                        Toast.makeText(this, "Location not found...", Toast.LENGTH_SHORT).show();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                Toast.makeText(this, "please enter location", Toast.LENGTH_SHORT).show();
            }
        } else if (id == R.id.gasStations) {
            mMap.clear();
            String url = getUrl(Place.Type.GAS_STATION);
            transferData[0] = mMap;
            transferData[1] = url;

            getNearbyPlaces.execute(transferData);
            Toast.makeText(this, "Searching for gas stations", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Showing gas stations", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.services) {

            mMap.clear();
            String url = getUrl(Place.Type.CAR_REPAIR);
            transferData[0] = mMap;
            transferData[1] = url;

            getNearbyPlaces.execute(transferData);
            Toast.makeText(this, "Searching for services", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Showing services", Toast.LENGTH_SHORT).show();
        }
    }

    private String getUrl(Place.Type nearbyPlace) {
        StringBuilder googleURL = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
        googleURL.append("location=" + 42.654601 + "," + 23.376340);
        googleURL.append("&radius=" + proximityRadius);
        googleURL.append("&type=" + nearbyPlace);
        googleURL.append("&sensor=true");
        googleURL.append("&key=" + "AIzaSyDPgu8CsDRzb-X9rhYA9v5_S-Iyx60Vntk");

        Log.d(TAG, "getUrl: " + googleURL.toString());

        return googleURL.toString();
    }
}
