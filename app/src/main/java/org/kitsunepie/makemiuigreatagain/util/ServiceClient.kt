package org.kitsunepie.makemiuigreatagain.util

import android.os.Binder
import android.os.IBinder
import android.os.IBinder.DeathRecipient
import android.os.Parcel
import android.os.ServiceManager
import org.kitsunepie.makemiuigreatagain.binder.aidl.IMMGAService

const val BRIDGE_TRANSACTION_CODE =
    '_'.code shl 24 or ('M'.code shl 16) or ('U'.code shl 8) or 'A'.code
const val BRIDGE_SERVICE_DESCRIPTOR = "android.hardware.input.IInputManager"
const val BRIDGE_SERVICE_NAME = "input"
const val BRIDGE_ACTION_GET_BINDER = 2

object ServiceClient {
    var binder: Binder? = null
    var service: IMMGAService? = null
        get() {
            if (field == null) {
                setBinder(requestBinderFromBridge())
            }
            return field
        }

    private val DEATH_RECIPIENT = DeathRecipient {
        binder = null
        service = null
    }

    private fun requestBinderFromBridge() : IBinder? {
        val binder = ServiceManager.getService(BRIDGE_SERVICE_NAME) ?: return null
        val data = Parcel.obtain()
        val reply = Parcel.obtain()
        try {
            data.writeInterfaceToken(BRIDGE_SERVICE_DESCRIPTOR)
            data.writeInt(BRIDGE_ACTION_GET_BINDER)
            binder.transact(BRIDGE_TRANSACTION_CODE, data, reply, 0)
            reply.readException()
            val received = reply.readStrongBinder()
            if (received != null) {
                return received
            }
        } catch (e: Throwable) {
            e.printStackTrace()
        } finally {
            data.recycle()
            reply.recycle()
        }
        return binder
    }

    private fun setBinder(binder: IBinder?) {
        if (ServiceClient.binder == binder) return
        ServiceClient.binder?.unlinkToDeath(DEATH_RECIPIENT, 0)

        if (binder == null) {
            ServiceClient.binder = null
            service = null
        } else {
            ServiceClient.binder = null
            service = IMMGAService.Stub.asInterface(binder)
            kotlin.runCatching {
                binder.linkToDeath(DEATH_RECIPIENT, 0)
            }
        }
    }
}