package org.kitsunepie.makemiuigreatagain.hook.gallery

import com.github.kyuubiran.ezxhelper.utils.getMethodByDesc
import com.github.kyuubiran.ezxhelper.utils.hookBefore
import org.kitsunepie.makemiuigreatagain.hook.BaseHook

//无限裁剪
object CropSizeHook : BaseHook() {
    override val enabled: Boolean
        get() = true

    override fun initHook() {
        //截图裁剪
        getMethodByDesc("Lcom/miui/gallery/editor/photo/screen/crop/ScreenCropView\$ResizeDetector;->calculateMinSize()I").hookBefore {
            it.result = 0
        }
        //图库中裁剪
        getMethodByDesc("Lcom/miui/gallery/editor/photo/core/imports/obsoletes/Crop\$ResizeDetector;->calculateMinSize()I").hookBefore {
            it.result = 0
        }
    }
}