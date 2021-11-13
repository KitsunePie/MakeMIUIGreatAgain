package org.kitsunepie.helper.hook

abstract class BaseHook {
    var inited = false
    abstract fun initHook()
}