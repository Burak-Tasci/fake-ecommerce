package com.tsci.fake_ecommerce.helpers

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener

/**
 * Created by Burak Taşcı on 11.09.2022.
 */
object PermissionHelper {

    fun requestAccessFineLocation(activity: Activity, permissionResponse: PermissionResponse){
        Dexter.withContext(activity)
            .withPermissions(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
            .withListener(object:MultiplePermissionsListener{
                override fun onPermissionsChecked(multiplePermissionReport: MultiplePermissionsReport?) {
                    multiplePermissionReport?.let {
                        if(multiplePermissionReport.areAllPermissionsGranted()){
                            permissionResponse.onPermissionAccepted()
                        }else{
                            permissionResponse.onPermissionDenied()
                        }
                    }
                }

                override fun onPermissionRationaleShouldBeShown(
                    permissionRequestList: MutableList<PermissionRequest>?,
                    permissionToken: PermissionToken?
                ) {
                    permissionToken?.continuePermissionRequest()
                }
            })
            .onSameThread()
            .check()
    }

    fun hasAccessFineLocation(activity: Activity) : Boolean{
        val permissionResultAccessFineLocation =
            ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION)
        val permissionResultAccessCoarseLocation =
            ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION)

        return permissionResultAccessFineLocation == PackageManager.PERMISSION_GRANTED && permissionResultAccessCoarseLocation == PackageManager.PERMISSION_GRANTED
    }



    interface PermissionResponse {
        fun onPermissionAccepted()
        fun onPermissionDenied()
    }
}