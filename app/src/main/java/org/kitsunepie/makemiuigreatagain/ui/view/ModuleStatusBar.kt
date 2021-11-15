package org.kitsunepie.makemiuigreatagain.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.kitsunepie.makemiuigreatagain.BuildConfig
import org.kitsunepie.makemiuigreatagain.R
import org.kitsunepie.makemiuigreatagain.ui.theme.Green
import org.kitsunepie.makemiuigreatagain.ui.theme.Red

@Composable
fun ModuleStatusBar(isActivated: Boolean) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(80.dp),
        shape = RoundedCornerShape(13.dp),
        backgroundColor = if (isActivated) Green else Red,
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .padding(start = 15.dp)
                    .wrapContentWidth()
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = if (isActivated) R.drawable.ic_baseline_done_30 else R.drawable.ic_baseline_close_30),
                    contentDescription = null,
                    modifier = Modifier.wrapContentSize(),
                    colorFilter = ColorFilter.tint(Color.White),
                )
            }
            Box(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .wrapContentWidth()
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                Column {
                    Text(
                        text = stringResource(id = if (isActivated) R.string.activated else R.string.inactivated),
                        color = Color.White
                    )
                    Text(
                        text = "${BuildConfig.VERSION_NAME}(${BuildConfig.VERSION_CODE})",
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun View() {
    ModuleStatusBar(isActivated = true)
}