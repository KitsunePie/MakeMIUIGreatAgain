package org.kitsunepie.makemiuigreatagain

import com.github.kyuubiran.ezxhelper.init.EzXHelperInit
import com.github.kyuubiran.ezxhelper.utils.Log
import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.callbacks.XC_LoadPackage
import org.kitsunepie.makemiuigreatagain.hook.BaseHook
import org.kitsunepie.makemiuigreatagain.hook.gallery.CropSizeHook

class Entry : IXposedHookLoadPackage {

    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        when (lpparam.packageName) {
            "com.miui.gallery" -> {
                initUtils(lpparam)
                initHooks(CropSizeHook)
            }
        }
    }


    private fun initUtils(lpparam: XC_LoadPackage.LoadPackageParam) {
        EzXHelperInit.setToastTag("MakeMIUIGreatAgain")
        EzXHelperInit.setLogTag("MakeMIUIGreatAgain")
        EzXHelperInit.initHandleLoadPackage(lpparam)
    }

    private fun initHooks(vararg hooks: BaseHook) {
        hooks.forEach {
            try {
                if (it.inited) return
                it.initHook()
                it.inited = true
            } catch (thr: Throwable) {
                Log.e(thr)
            }
        }
    }
}