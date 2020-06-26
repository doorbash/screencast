package io.github.doorbash.casthoneypot.net.impl;

import android.util.Log;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;

public class MulticastImpl {

    public static final String TAG = "MulticastImpl";

    private MulticastSocket socket;
    public boolean isRunning = false;

    public MulticastImpl(String ip, int port, int timeout) {
        try {
            socket = new MulticastSocket(port);
            socket.setLoopbackMode(true);
            socket.setSoTimeout(timeout);
            socket.joinGroup(InetAddress.getByName(ip));
        } catch (Exception e) {
            Log.d(TAG, e.getLocalizedMessage());
        }
    }

    public void send(byte[] data, int length, String ip, int port) {
        try {
            socket.send(new DatagramPacket(data, length, new InetSocketAddress(ip, port)));
        } catch (Exception e) {
            Log.e(TAG, e.getLocalizedMessage());
        }
    }

    public DatagramPacket recv() throws Exception {
        byte[] receiveData = new byte[2048];
        try {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);
//                System.out.println(new String(receivePacket.getData(), 0, receivePacket.getLength()));
            return receivePacket;
        } catch (NullPointerException e) {
            return null;
        }
    }

    public void close() {
        socket.close();
    }
}
