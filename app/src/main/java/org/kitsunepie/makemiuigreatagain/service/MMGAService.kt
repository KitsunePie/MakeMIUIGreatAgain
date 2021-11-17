package org.kitsunepie.makemiuigreatagain.service

import org.kitsunepie.makemiuigreatagain.BuildConfig
import org.kitsunepie.makemiuigreatagain.binder.aidl.IMMGAService

class MMGAService : IMMGAService.Stub() {
    override fun getversionCode() = BuildConfig.VERSION_CODE

}