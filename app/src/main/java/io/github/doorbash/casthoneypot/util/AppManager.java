package io.github.doorbash.casthoneypot.util;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiManager;

import com.mindorks.nybus.NYBus;
import com.mindorks.nybus.annotation.Subscribe;

import java.lang.ref.WeakReference;
import java.net.DatagramPacket;

import io.github.doorbash.casthoneypot.net.HttpServer;
import io.github.doorbash.casthoneypot.net.impl.MulticastImpl;
import io.github.doorbash.casthoneypot.net.MulticastRecvRunnable;
import io.github.doorbash.casthoneypot.net.ServiceNotificationRunnable;
import io.github.doorbash.casthoneypot.net.impl.http.HttpPort7676Impl;
import io.github.doorbash.casthoneypot.net.impl.http.HttpPort7678Impl;
import io.github.doorbash.casthoneypot.net.impl.http.HttpPort9119Impl;
import io.github.doorbash.casthoneypot.net.impl.http.HttpPort9197Impl;

public class AppManager {

    public static final String TAG = "AppManager";

    private static AppManager instance;

    public static AppManager getInstance() {
        if (instance == null) {
            instance = new AppManager();
        }
        return instance;
    }

    private boolean initialized = false;
    private WifiManager wm = null;
    private WifiManager.MulticastLock multicastLock = null;
    private WeakReference<Activity> currentActivity;
    private MulticastImpl multicastImpl = new MulticastImpl("239.255.255.250", 1900, 30000);
    private MulticastRecvRunnable multicast = new MulticastRecvRunnable(multicastImpl);
    private HttpServer server9197, server9119, server7676, server7678;
    private ServiceNotificationRunnable serviceNotification = new ServiceNotificationRunnable(multicastImpl, "239.255.255.250", 1900, 3000);

    public void start(Activity activity) {
        this.currentActivity = new WeakReference<>(activity);
        if (!initialized) {
            registerEvents();
            server9197 = new HttpServer(9197,new HttpPort9197Impl());
            server9119 = new HttpServer(9119, new HttpPort9119Impl());
            server7676 = new HttpServer(7676, new HttpPort7676Impl());
            server7678 = new HttpServer(7678, new HttpPort7678Impl());
        }
        if (currentActivity.get() != null && !multicast.isRunning) { // TODO: && not in task queue
            accWifiMulticastLock(currentActivity.get());
            ThreadPoolHelper.getInstance().run(multicast);
        }
        if (!serviceNotification.isRunning) { // TODO: && not in task queue
            ThreadPoolHelper.getInstance().run(serviceNotification);
        }
    }

    public void stop() {
        ThreadPoolHelper.getInstance().shutdown();
        unregisterEvents();
        releaseWifiMulticastLock();
    }

    private void registerEvents() {
        NYBus.get().register(this, Consts.EVENT_MULTICAST_RECV);
    }

    private void unregisterEvents() {
        NYBus.get().unregister(this, Consts.EVENT_MULTICAST_RECV);
    }

    @Subscribe(channelId = Consts.EVENT_MULTICAST_RECV)
    public void onMulticastRecv(DatagramPacket packet) {
       // Log.d(TAG, "onMulticastRecv: " + new String(packet.getData(), 0, packet.getLength()));
    }

    private void accWifiMulticastLock(Context context) {
        if (wm == null)
            wm = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if (multicastLock == null) {
            multicastLock = wm.createMulticastLock(TAG);
            multicastLock.setReferenceCounted(true);
        }
        if (multicastLock != null && !multicastLock.isHeld()) multicastLock.acquire();
    }

    private void releaseWifiMulticastLock() {
        if (multicastLock != null && multicastLock.isHeld()) multicastLock.release();
    }
}
