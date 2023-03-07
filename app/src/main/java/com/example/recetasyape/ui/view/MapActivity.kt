package com.example.recetasyape.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import com.example.recetasyape.R
import com.example.recetasyape.domain.model.Recipe
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map:GoogleMap

    private lateinit var lat:String
    private lateinit var lon:String
    private lateinit var name:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        val bundle = intent.extras
        lat = bundle?.getString("lat").toString()
        lon = bundle?.getString("lon").toString()
        name = bundle?.getString("name").toString()
        createFragment()
    }

    private fun createFragment() {
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        createMarker()
    }

    private fun createMarker() {
        val coordinates = LatLng(lat.toDouble(), lon.toDouble())
        val marker = MarkerOptions().position(coordinates).title(name)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 14f),
            2000,
            null
        )
    }


}