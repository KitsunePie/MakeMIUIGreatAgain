package org.kitsunepie.makemiuigreatagain.ui.view

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.kitsunepie.makemiuigreatagain.ui.theme.Blue200

@Composable
fun SwitchItem(
    @StringRes title: Int,
    @StringRes desc: Int? = null,
    checked: MutableState<Boolean> = remember {
        mutableStateOf(false)
    },
    onChange: ((Boolean) -> Unit)? = null,
    onClick: (() -> Unit)? = null,
) {
    SwitchItem(
        title = LocalContext.current.getString(title),
        desc = if (desc != null) LocalContext.current.getString(desc) else null,
        checked = checked,
        onChange = onChange,
        onClick = onClick
    )
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
        Row(
            Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(13.dp))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.86f)
                    .height(50.dp)
                    .padding(horizontal = 18.dp),
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
                    checkedThumbColor = Blue200,
                    uncheckedTrackColor = Color.Gray
                )
            )
        }
    }
}
