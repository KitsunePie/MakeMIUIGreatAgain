package org.kitsunepie.makemiuigreatagain.util

import android.content.Context
import android.content.Intent
import android.net.Uri

fun Context.jumpUri(uriString: String) {
    this.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(uriString)))
}

fun Context.jumpUri(uri: Uri) {
    this.startActivity(Intent(Intent.ACTION_VIEW, uri))
}