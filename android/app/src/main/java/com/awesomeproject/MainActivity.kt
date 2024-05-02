package com.awesomeproject

import android.app.PictureInPictureParams
import android.os.Build
import android.os.Bundle
import android.util.Rational
import androidx.annotation.RequiresApi
import com.facebook.react.ReactActivity
import com.facebook.react.ReactActivityDelegate
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint.fabricEnabled
import com.facebook.react.defaults.DefaultReactActivityDelegate

class MainActivity : ReactActivity() {

  /**
   * Returns the name of the main component registered from JavaScript. This is used to schedule
   * rendering of the component.
   */
  override fun getMainComponentName(): String = "AwesomeProject"

    // Callback when the activity enters PIP mode
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onUserLeaveHint() {
        //super.onUserLeaveHint()
        enterPIPMode()
    }

    // Callback when the activity is restored from PIP mode
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        //super.onRestoreInstanceState(savedInstanceState)
        exitPIPMode()
    }

    // Enter PIP mode
    @RequiresApi(Build.VERSION_CODES.O)
    private fun enterPIPMode() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val aspectRatio = Rational(16, 9) // Aspect ratio for PIP window
            val params = PictureInPictureParams.Builder()
                .setAspectRatio(aspectRatio)
                .build()
            enterPictureInPictureMode(params)
        }
    }

    // Exit PIP mode
    @RequiresApi(Build.VERSION_CODES.O)
    private fun exitPIPMode() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
////            if (isInPictureInPictureMode) {
////                // Handle exiting PIP mode, if necessary
////                //Toast.makeText(this, "Exiting PIP mode", Toast.LENGTH_SHORT).show()
////            }
//        }
    }

  /**
   * Returns the instance of the [ReactActivityDelegate]. We use [DefaultReactActivityDelegate]
   * which allows you to enable New Architecture with a single boolean flags [fabricEnabled]
   */
  override fun createReactActivityDelegate(): ReactActivityDelegate =
      DefaultReactActivityDelegate(this, mainComponentName, fabricEnabled)
}
