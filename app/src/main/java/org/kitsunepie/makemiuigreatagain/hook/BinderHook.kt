package org.kitsunepie.makemiuigreatagain.hook

import android.os.Binder
import android.os.Parcel
import com.github.kyuubiran.ezxhelper.utils.findMethodByCondition
import com.github.kyuubiran.ezxhelper.utils.hookBefore
import org.kitsunepie.makemiuigreatagain.service.MMGAService
import org.kitsunepie.makemiuigreatagain.util.BRIDGE_ACTION_GET_BINDER
import org.kitsunepie.makemiuigreatagain.util.BRIDGE_SERVICE_DESCRIPTOR
import org.kitsunepie.makemiuigreatagain.util.BRIDGE_TRANSACTION_CODE

object BinderHook : BaseHook() {
    private val serviceBinder by lazy { MMGAService().asBinder() }
    override val enabled = true

    override fun initHook() {
        findMethodByCondition(Binder::class.java) { "onTransact" == it.name }
            .hookBefore {
                val code = it.args[0] as Int
                val data = it.args[1] as Parcel
                val reply = it.args[2] as Parcel?
                val flags = it.args[3] as Int
                if (code != BRIDGE_TRANSACTION_CODE) return@hookBefore
                onTransact(code, data, reply, flags)
                it.result = true
            }
    }

    private fun onTransact(code: Int, data: Parcel, reply: Parcel?, flags: Int) {
        data.enforceInterface(BRIDGE_SERVICE_DESCRIPTOR)

        // action
        when (data.readInt()) {
            BRIDGE_ACTION_GET_BINDER -> {
                if (reply != null) {
                    reply.writeNoException()
                    reply.writeStrongBinder(serviceBinder)
                }
            }
        }
    }

}