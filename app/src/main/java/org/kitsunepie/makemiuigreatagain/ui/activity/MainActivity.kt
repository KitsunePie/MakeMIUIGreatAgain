package org.kitsunepie.makemiuigreatagain.ui.activity

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.github.kyuubiran.ezxhelper.init.EzXHelperInit
import org.kitsunepie.makemiuigreatagain.R
import org.kitsunepie.makemiuigreatagain.ui.theme.WhiteTheme
import org.kitsunepie.makemiuigreatagain.ui.view.CardGroup
import org.kitsunepie.makemiuigreatagain.ui.view.SwitchItem

class MainActivity : ComponentActivity() {

    @Composable
    fun MainUI() {
        CardGroup(title = R.string.card_title_gallery) {
            SwitchItem(
                title = R.string.gallery_function_unlimited_crop,
                desc = R.string.gallery_function_unlimited_crop_desc
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("Deprecation")
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        EzXHelperInit.initAppContext(applicationContext)
        setContent {
            WhiteTheme {
                MainUI()
            }
        }
    }
}