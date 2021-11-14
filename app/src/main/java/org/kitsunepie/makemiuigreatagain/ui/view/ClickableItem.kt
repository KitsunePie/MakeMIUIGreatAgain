package org.kitsunepie.makemiuigreatagain.ui.view

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.kitsunepie.makemiuigreatagain.R

@Composable
fun ClickableItem(
    @StringRes title: Int,
    @StringRes desc: Int?,
    onClick: (() -> Unit)? = null,
    showArrow: Boolean = false
) {
    ClickableItem(
        title = stringResource(title),
        desc = if (desc != null) stringResource(desc) else null,
        onClick = onClick,
        showArrow = showArrow
    )
}

@Composable
fun ClickableItem(
    title: String,
    desc: String?,
    onClick: (() -> Unit)? = null,
    showArrow: Boolean = false
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(3.dp)
            .clickable {
                onClick?.invoke()
            }
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(13.dp))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.86f)
                    .height(46.dp)
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
            if (showArrow) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(45.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = Modifier.wrapContentSize(),
                        painter = painterResource(R.drawable.ic_baseline_arrow_forward_ios_12),
                        contentDescription = null,
                        alpha = 0.40f
                    )
                }
            }
        }
    }
}