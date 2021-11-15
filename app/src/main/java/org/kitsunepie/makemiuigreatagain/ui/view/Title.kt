package org.kitsunepie.makemiuigreatagain.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.kitsunepie.makemiuigreatagain.R

@Composable
fun Title(
    text: String
) {
    Column(
        modifier = Modifier
            .padding(13.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = text,
            fontSize = 23.sp,
            color = Color.Black
        )
    }
}

@Preview
@Composable
private fun View() {
    Title(text = stringResource(id = R.string.app_name))
}