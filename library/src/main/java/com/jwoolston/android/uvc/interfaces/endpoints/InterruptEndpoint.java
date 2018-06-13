package com.jwoolston.android.uvc.interfaces.endpoints;

import android.hardware.usb.UsbInterface;

/**
 * @author Jared Woolston (Jared.Woolston@gmail.com)
 */
public class InterruptEndpoint extends Endpoint {

    protected InterruptEndpoint(UsbInterface usbInterface, byte[] descriptor) throws IllegalArgumentException {
        super(usbInterface, descriptor);
    }
}
