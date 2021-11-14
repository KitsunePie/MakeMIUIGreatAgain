package org.kitsunepie.makemiuigreatagain.hook

abstract class BaseHook {
    var inited = false

    var needReboot = false

    abstract val enabled: Boolean

    abstract fun initHook()
}