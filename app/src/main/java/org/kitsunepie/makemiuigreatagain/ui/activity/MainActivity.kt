package org.kitsunepie.makemiuigreatagain.ui.activity

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.github.kyuubiran.ezxhelper.init.EzXHelperInit
import org.kitsunepie.makemiuigreatagain.R
import org.kitsunepie.makemiuigreatagain.ui.view.*
import org.kitsunepie.makemiuigreatagain.util.ConfigManager
import org.kitsunepie.makemiuigreatagain.util.jumpUri

class MainActivity : ComponentActivity() {

    @Composable
    fun MainUI() {
        val scroller = rememberScrollState()

        Column(
            modifier = Modifier.scrollable(
                state = scroller,
                orientation = Orientation.Vertical
            )
        ) {
            AppBar(text = stringResource(id = R.string.app_name))
            ModuleStatusBar(ConfigManager.successLoad)

            CardGroup(title = R.string.card_title_gallery) {
                SwitchItem(
                    title = R.string.gallery_function_unlimited_crop,
                    desc = R.string.gallery_function_unlimited_crop_desc
                )
            }

            CardGroup(title = R.string.card_title_about) {
                ClickableItem(
                    title = R.string.jump_to_github_title,
                    desc = R.string.jump_to_github_desc,
                    onClick = {
                        jumpUri("https://github.com/KitsunePie/MakeMIUIGreatAgain")
                    },
                    showArrow = true
                )
                ClickableItem(
                    title = R.string.jump_to_telegram_channel_title,
                    desc = R.string.jump_to_telegram_channel_desc,
                    onClick = {
                        jumpUri("https://t.me/MakeMIUIGreatAgain")
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
            MaterialTheme {
                MainUI()
                if (!ConfigManager.successLoad) {
                    Dialog(
                        title = R.string.warning,
                        text = R.string.config_load_failed_text,
                        dismissBtnString = R.string.got_it,
                    )
                }
            }
        }
    }
}