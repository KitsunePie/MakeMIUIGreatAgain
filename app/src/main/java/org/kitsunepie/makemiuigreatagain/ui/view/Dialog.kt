package org.kitsunepie.makemiuigreatagain.ui.view

import androidx.annotation.StringRes
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.window.DialogProperties

@Composable
fun Dialog(
    @StringRes title: Int,
    @StringRes text: Int,
    @StringRes confirmBtnTitle: Int? = null,
    confirm: ((MutableState<Boolean>) -> Unit)? = null,
    @StringRes dismissBtnString: Int? = null,
    dismiss: ((MutableState<Boolean>) -> Unit)? = null,
    dismissRequest: ((MutableState<Boolean>) -> Unit)? = null,
    clickToDismiss: Boolean = true,
    properties: DialogProperties = DialogProperties()
) {
    Dialog(
        title = stringResource(id = title),
        text = stringResource(id = text),
        confirmBtnTitle = if (confirmBtnTitle != null) stringResource(id = confirmBtnTitle) else null,
        confirm = confirm,
        dismissBtnString = if (dismissBtnString != null) stringResource(id = dismissBtnString) else null,
        dismiss = dismiss,
        dismissRequest = dismissRequest,
        clickToDismiss = clickToDismiss,
        properties = properties
    )
}

@Composable
fun Dialog(
    title: String,
    text: String,
    confirmBtnTitle: String? = null,
    confirm: ((MutableState<Boolean>) -> Unit)? = null,
    dismissBtnString: String? = null,
    dismiss: ((MutableState<Boolean>) -> Unit)? = null,
    dismissRequest: ((MutableState<Boolean>) -> Unit)? = null,
    clickToDismiss: Boolean = true,
    properties: DialogProperties = DialogProperties()
) {
    val show = remember { mutableStateOf(true) }

    if (show.value) {
        AlertDialog(
            onDismissRequest = {
                dismissRequest?.invoke(show)
            },
            title = { Text(text = title, color = Color.Black) },
            text = { Text(text = text, color = Color.Black) },
            confirmButton = {
                confirmBtnTitle?.let {
                    Button(
                        onClick = {
                            confirm?.invoke(show)
                            if (clickToDismiss) show.value = false
                        }) {
                        Text(text = it, color = Color.Black)
                    }
                }
            },
            dismissButton = {
                dismissBtnString?.let {
                    Button(
                        onClick = {
                            dismiss?.invoke(show)
                            if (clickToDismiss) show.value = false
                        }) {
                        Text(text = it, color = Color.Black)
                    }
                }
            }, properties = properties
        )
    }
}
