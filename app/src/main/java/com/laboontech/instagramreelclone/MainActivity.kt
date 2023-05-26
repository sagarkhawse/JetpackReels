package com.laboontech.instagramreelclone

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.laboontech.instagramreelclone.presentation.VideoPlayerScreen
import com.laboontech.instagramreelclone.ui.theme.CosplayVideoStatusTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var requestMultiplePermission: ActivityResultLauncher<Array<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestMultiplePermission = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions(),
        ) {
            var isGranted = false
            it.forEach { (string, boolean) ->
                isGranted = boolean
            }

            if (!isGranted) {
            }
        }

        setContent {
            CosplayVideoStatusTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.black),
                ) {
                    requestMultiplePermission.launch(
                        arrayOf(
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        ),
                    )
                    VideoPlayerScreen()
                }
            }
        }
    }
}
