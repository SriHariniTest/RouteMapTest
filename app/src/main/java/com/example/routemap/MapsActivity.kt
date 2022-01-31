package com.example.routemap

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.routemap.databinding.ActivityMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
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
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val kochi = LatLng(9.931233, 76.267303)
        val coimbatore = LatLng(11.004556, 76.961632)
        val madurai = LatLng(9.939093, 78.121719)
        val munnar = LatLng(10.089167, 77.059723)
        val travellerLocationArray:ArrayList<LatLng> = arrayListOf()
        travellerLocationArray.add(kochi)
        travellerLocationArray.add(coimbatore)
        travellerLocationArray.add(madurai)
        travellerLocationArray.add(munnar)
        travellerLocationArray.add(kochi)
        displayDirection(travellerLocationArray)
        for (i in travellerLocationArray) {
            mMap.addMarker(MarkerOptions().position(i).title(i.toString()))
            mMap.moveCamera(CameraUpdateFactory.newLatLng(i))
        }
    }
    private fun displayDirection(poly: List<LatLng>) {
        val polylineOptions = PolylineOptions()
        polylineOptions.color(Color.RED)
        for (i in poly.indices) {
            polylineOptions.width(8f)
            polylineOptions.add(poly[i])
        }
        mMap.addPolyline(polylineOptions)
    }
}