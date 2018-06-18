package com.jwoolston.android.uvc.libusb;

import android.content.Context;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbManager;

import java.nio.ByteBuffer;

import timber.log.Timber;

/**
 * @author Jared Woolston (Jared.Woolston@gmail.com)
 */
public class UsbDeviceIsoConnection {

    static {
        System.loadLibrary("usb-runtime");
    }

    /**
     * The application context.
     */
    private static Context sContext;

    /**
     * The {@link UsbManager} for this application.
     */
    private static UsbManager sUsbManager;

    /**
     * Initializes the libusb JNI wrapper. This should be provided the Application
     * {@link Context}, though it will call {@link Context#getApplicationContext()}
     * to be sure.
     *
     * @param context {@link Context} The application context.
     */
    public UsbDeviceIsoConnection(Context context, int fd) {
        sContext = context.getApplicationContext();
        sUsbManager = (UsbManager) sContext.getSystemService(Context.USB_SERVICE);
        final int retval = initialize(fd);
        Timber.v("Initialization result: %s", retval);
    }

    private native int initialize(int fd);

    public native int deinitialize();

    public native int isochronousTransfer(UsbDeviceConnection connection, ByteBuffer buffer);

}
