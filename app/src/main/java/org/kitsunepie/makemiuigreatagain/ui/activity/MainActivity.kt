package org.kitsunepie.makemiuigreatagain.ui.activity

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.github.kyuubiran.ezxhelper.init.EzXHelperInit
import com.github.kyuubiran.ezxhelper.utils.Log
import com.github.kyuubiran.ezxhelper.utils.showToast
import org.kitsunepie.makemiuigreatagain.BuildConfig
import org.kitsunepie.makemiuigreatagain.R
import org.kitsunepie.makemiuigreatagain.ui.theme.WhiteTheme
import org.kitsunepie.makemiuigreatagain.ui.view.CardGroup
import org.kitsunepie.makemiuigreatagain.ui.view.ClickableItem
import org.kitsunepie.makemiuigreatagain.ui.view.SwitchItem
import org.kitsunepie.makemiuigreatagain.util.jumpUri

class MainActivity : ComponentActivity() {

    @Composable
    fun MainUI() {
        Column {
            CardGroup(title = R.string.card_title_gallery) {
                SwitchItem(
                    title = R.string.gallery_function_unlimited_crop,
                    desc = R.string.gallery_function_unlimited_crop_desc
                )
            }

            CardGroup(title = R.string.card_title_about) {
                ClickableItem(
                    title = getString(R.string.module_version_title),
                    desc = "${BuildConfig.VERSION_NAME}(${BuildConfig.VERSION_CODE})",
                )
                ClickableItem(
                    title = R.string.jump_to_github_title,
                    desc = R.string.jump_to_github_desc,
                    onClick = {
                        jumpUri("https://github.com/KitsunePie/MakeMIUIGreatAgain")
                    },
                    showArrow = true
                )
            }
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