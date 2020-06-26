package io.github.doorbash.casthoneypot.net;

import com.mindorks.nybus.NYBus;

import java.net.DatagramPacket;

import io.github.doorbash.casthoneypot.net.impl.MulticastImpl;

import static io.github.doorbash.casthoneypot.util.Consts.EVENT_MULTICAST_RECV;

public class MulticastRecvRunnable implements Runnable {
    public boolean isRunning;
    private MulticastImpl impl;

    public MulticastRecvRunnable(MulticastImpl impl) {
        this.impl = impl;
    }

    @Override
    public void run() {
        isRunning = true;
        while (true) {
            try {
                DatagramPacket packet = impl.recv();
                if (packet == null) break;
                NYBus.get().post(packet, EVENT_MULTICAST_RECV);
            } catch (Exception e) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ee) {
                    e.printStackTrace();
                }
            }
        }
        impl.close();
        isRunning = false;
    }
}
