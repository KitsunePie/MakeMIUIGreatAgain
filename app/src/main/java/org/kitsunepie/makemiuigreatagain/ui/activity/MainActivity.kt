package org.kitsunepie.makemiuigreatagain.ui.activity

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.kyuubiran.ezxhelper.init.EzXHelperInit
import org.kitsunepie.makemiuigreatagain.ui.theme.Blue200
import org.kitsunepie.makemiuigreatagain.ui.theme.WhiteTheme

class MainActivity : ComponentActivity() {

    @Composable
    fun MainUI() {
        CardGroup("图库") {
            SwitchItem("无限裁剪", "移除截图/图片裁剪最小限制")
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

    @Composable
    fun SwitchItem(
        title: String,
        desc: String? = null,
        checked: MutableState<Boolean> = remember {
            mutableStateOf(false)
        },
        onChange: ((Boolean) -> Unit)? = null,
        onClick: (() -> Unit)? = null,
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .clickable {
                if (onClick == null) {
                    checked.value = !checked.value
                } else {
                    onClick()
                }
            }) {
            Row {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .height(50.dp)
                        .background(Color.White, RoundedCornerShape(13.dp))
                        .padding(horizontal = 15.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = title,
                        color = Color.Black,
                        fontSize = 18.sp
                    )
                    desc?.let {
                        Text(
                            text = desc,
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                    }
                }
                Switch(
                    checked = checked.value,
                    onCheckedChange = {
                        checked.value = it
                        onChange?.invoke(it)
                    },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Blue200
                    )
                )
            }
        }

    }

    @Composable
    fun CardGroup(title: String, content: @Composable () -> Unit) {
        Card(modifier = Modifier.padding(10.dp)) {
            Column {
                Text(
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp),
                    text = title,
                    color = Blue200,
                    fontSize = 20.sp
                )
                content()
            }
        }
    }
}