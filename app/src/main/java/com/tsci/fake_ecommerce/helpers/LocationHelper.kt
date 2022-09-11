package com.tsci.fake_ecommerce.helpers

import android.annotation.SuppressLint
import android.content.Context
import android.location.Geocoder
import android.location.Location
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.*
import javax.inject.Inject

/**
 * Created by Burak Taşcı on 11.09.2022.
 */

class LocationHelper @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val geocoder = Geocoder(context, Locale.getDefault())

    private var mFusedLocationProviderClient: FusedLocationProviderClient? =
        LocationServices.getFusedLocationProviderClient(context)


    fun getAddressFromLocationLatLng(lat: Double, lng: Double) =
        geocoder.getFromLocation(lat, lng, MAX_RESULT)[0]

    @SuppressLint("MissingPermission")
    fun getLastKnownLocation(defaultLocationListener: DefaultLocationListener) {
        mFusedLocationProviderClient!!.lastLocation.addOnSuccessListener { location ->
            if (location != null) {
                defaultLocationListener.onLocationUpdate(location)
            } else {
                defaultLocationListener.onLocationNotFound()
            }
        }.addOnFailureListener {
            defaultLocationListener.onLocationNotFound()
        }
    }

    interface DefaultLocationListener {
        fun onLocationUpdate(location: Location)
        fun onLocationNotFound()
    }

    companion object {
        private const val MAX_RESULT = 1
    }
}
