package com.ccuniverse9.appccdosto.Fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ccuniverse9.appccdosto.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class LocationFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_location_fragment, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.hide();

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);

        // Location marks by Latitude and Longitude
        LatLng T1 = new LatLng(21.855711, -102.290079);
        mMap.addMarker(new MarkerOptions().position(T1).draggable(true).snippet("This is your location").title("Test 1")
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
        );
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(T1, 19f));

        LatLng T2 = new LatLng(21.855651, -102.289921);
        mMap.addMarker(new MarkerOptions().position(T2).title("Test 2"));

        LatLng T3 = new LatLng(21.855703, -102.289757);
        mMap.addMarker(new MarkerOptions().position(T3).title("Test 3"));

        LatLng T4 = new LatLng(21.855780, -102.289808);
        mMap.addMarker(new MarkerOptions().position(T4).title("Test 4"));

        LatLng T5 = new LatLng(21.856104, -102.289830);
        mMap.addMarker(new MarkerOptions().position(T5).title("Test 5"));

        LatLng T6 = new LatLng(21.856276, -102.289790);
        mMap.addMarker(new MarkerOptions().position(T6).title("Test 6"));

        LatLng T7 = new LatLng(21.856300, -102.289800);
        mMap.addMarker(new MarkerOptions().position(T7).title("Test 7"));
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroyView() {

        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.show();

        super.onDestroyView();
    }
}