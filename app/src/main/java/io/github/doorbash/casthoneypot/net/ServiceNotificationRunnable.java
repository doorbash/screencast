package io.github.doorbash.casthoneypot.net;

import io.github.doorbash.casthoneypot.net.impl.MulticastImpl;
import io.github.doorbash.casthoneypot.util.Consts;

public class ServiceNotificationRunnable implements Runnable {

    private String DATA = "NOTIFY * HTTP/1.1\n" +
            "HOST: 239.255.255.250:1900\n" +
            "CACHE-CONTROL: max-age=1800\n" +
            "DATE: Wed, 24 Jun 2020 11:42:16 GMT\n" +
            "LOCATION: http://192.168.1.103:9197/dmr\n" +
            "NT: upnp:rootdevice\n" +
            "NTS: ssdp:alive\n" +
            "SERVER: SHP, UPnP/1.0, Samsung UPnP SDK/1.0\n" +
            "USN: uuid:" + Consts.UUID_1 + "::upnp:rootdevice\n" +
            "\n\n" +
            "NOTIFY * HTTP/1.1\n" +
            "HOST: 239.255.255.250:1900\n" +
            "CACHE-CONTROL: max-age=1800\n" +
            "DATE: Wed, 24 Jun 2020 11:42:16 GMT\n" +
            "LOCATION: http://192.168.1.103:9197/dmr\n" +
            "NT: uuid:" + Consts.UUID_1 + "\n" +
            "NTS: ssdp:alive\n" +
            "SERVER: SHP, UPnP/1.0, Samsung UPnP SDK/1.0\n" +
            "USN: uuid:" + Consts.UUID_1 + "\n" +
            "\n\n" +
            "NOTIFY * HTTP/1.1\n" +
            "HOST: 239.255.255.250:1900\n" +
            "CACHE-CONTROL: max-age=1800\n" +
            "DATE: Wed, 24 Jun 2020 11:42:16 GMT\n" +
            "LOCATION: http://192.168.1.103:9197/dmr\n" +
            "NT: urn:schemas-upnp-org:device:MediaRenderer:1\n" +
            "NTS: ssdp:alive\n" +
            "SERVER: SHP, UPnP/1.0, Samsung UPnP SDK/1.0\n" +
            "USN: uuid:" + Consts.UUID_1 + "::urn:schemas-upnp-org:device:MediaRenderer:1\n" +
            "\n\n" +
            "NOTIFY * HTTP/1.1\n" +
            "HOST: 239.255.255.250:1900\n" +
            "CACHE-CONTROL: max-age=1800\n" +
            "DATE: Wed, 24 Jun 2020 11:42:16 GMT\n" +
            "LOCATION: http://192.168.1.103:9197/dmr\n" +
            "NT: urn:schemas-upnp-org:service:RenderingControl:1\n" +
            "NTS: ssdp:alive\n" +
            "SERVER: SHP, UPnP/1.0, Samsung UPnP SDK/1.0\n" +
            "USN: uuid:" + Consts.UUID_1 + "::urn:schemas-upnp-org:service:RenderingControl:1\n" +
            "\n\n" +
            "NOTIFY * HTTP/1.1\n" +
            "HOST: 239.255.255.250:1900\n" +
            "CACHE-CONTROL: max-age=1800\n" +
            "DATE: Wed, 24 Jun 2020 11:42:16 GMT\n" +
            "LOCATION: http://192.168.1.103:9197/dmr\n" +
            "NT: urn:schemas-upnp-org:service:ConnectionManager:1\n" +
            "NTS: ssdp:alive\n" +
            "SERVER: SHP, UPnP/1.0, Samsung UPnP SDK/1.0\n" +
            "USN: uuid:" + Consts.UUID_1 + "::urn:schemas-upnp-org:service:ConnectionManager:1\n" +
            "\n\n" +
            "NOTIFY * HTTP/1.1\n" +
            "HOST: 239.255.255.250:1900\n" +
            "CACHE-CONTROL: max-age=1800\n" +
            "DATE: Wed, 24 Jun 2020 11:42:16 GMT\n" +
            "LOCATION: http://192.168.1.103:9197/dmr\n" +
            "NT: urn:schemas-upnp-org:service:AVTransport:1\n" +
            "NTS: ssdp:alive\n" +
            "SERVER: SHP, UPnP/1.0, Samsung UPnP SDK/1.0\n" +
            "USN: uuid:" + Consts.UUID_1 + "::urn:schemas-upnp-org:service:AVTransport:1\n" +
            "\n\n" +
            "NOTIFY * HTTP/1.1\n" +
            "HOST: 239.255.255.250:1900\n" +
            "CACHE-CONTROL: max-age=1800\n" +
            "DATE: Wed, 24 Jun 2020 11:42:16 GMT\n" +
            "LOCATION: http://192.168.1.103:9197/dmr\n" +
            "NT: urn:schemas-rvualliance-org:service:StreamSplicing:1\n" +
            "NTS: ssdp:alive\n" +
            "SERVER: SHP, UPnP/1.0, Samsung UPnP SDK/1.0\n" +
            "USN: uuid:" + Consts.UUID_1 + "::urn:schemas-rvualliance-org:service:StreamSplicing:1\n" +
            "\n\n" +
            "NOTIFY * HTTP/1.1\n" +
            "HOST: 239.255.255.250:1900\n" +
            "CACHE-CONTROL: max-age=1800\n" +
            "DATE: Wed, 24 Jun 2020 11:42:16 GMT\n" +
            "LOCATION: http://192.168.1.103:7678/nservice/\n" +
            "NT: upnp:rootdevice\n" +
            "NTS: ssdp:alive\n" +
            "SERVER: SHP, UPnP/1.0, Samsung UPnP SDK/1.0\n" +
            "USN: uuid:" + Consts.UUID_4 + "::upnp:rootdevice\n" +
            "\n\n" +
            "NOTIFY * HTTP/1.1\n" +
            "HOST: 239.255.255.250:1900\n" +
            "CACHE-CONTROL: max-age=1800\n" +
            "DATE: Wed, 24 Jun 2020 11:42:16 GMT\n" +
            "LOCATION: http://192.168.1.103:7678/nservice/\n" +
            "NT: uuid:" + Consts.UUID_4 + "\n" +
            "NTS: ssdp:alive\n" +
            "SERVER: SHP, UPnP/1.0, Samsung UPnP SDK/1.0\n" +
            "USN: uuid:" + Consts.UUID_4 + "\n" +
            "\n\n" +
            "NOTIFY * HTTP/1.1\n" +
            "HOST: 239.255.255.250:1900\n" +
            "CACHE-CONTROL: max-age=1800\n" +
            "DATE: Wed, 24 Jun 2020 11:42:16 GMT\n" +
            "LOCATION: http://192.168.1.103:7678/nservice/\n" +
            "NT: urn:dial-multiscreen-org:device:dialreceiver:1\n" +
            "NTS: ssdp:alive\n" +
            "SERVER: SHP, UPnP/1.0, Samsung UPnP SDK/1.0\n" +
            "USN: uuid:" + Consts.UUID_4 + "::urn:dial-multiscreen-org:device:dialreceiver:1\n" +
            "\n\n" +
            "NOTIFY * HTTP/1.1\n" +
            "HOST: 239.255.255.250:1900\n" +
            "CACHE-CONTROL: max-age=1800\n" +
            "DATE: Wed, 24 Jun 2020 11:42:16 GMT\n" +
            "LOCATION: http://192.168.1.103:7678/nservice/\n" +
            "NT: urn:dial-multiscreen-org:service:dial:1\n" +
            "NTS: ssdp:alive\n" +
            "SERVER: SHP, UPnP/1.0, Samsung UPnP SDK/1.0\n" +
            "USN: uuid:" + Consts.UUID_4 + "::urn:dial-multiscreen-org:service:dial:1\n" +
            "\n\n" +
            "NOTIFY * HTTP/1.1\n" +
            "HOST: 239.255.255.250:1900\n" +
            "CACHE-CONTROL: max-age=1800\n" +
            "DATE: Wed, 24 Jun 2020 11:42:16 GMT\n" +
            "LOCATION: http://192.168.1.103:7676/rcr/\n" +
            "NT: upnp:rootdevice\n" +
            "NTS: ssdp:alive\n" +
            "SERVER: SHP, UPnP/1.0, Samsung UPnP SDK/1.0\n" +
            "USN: uuid:" + Consts.UUID_3 + "::upnp:rootdevice\n" +
            "\n\n" +
            "NOTIFY * HTTP/1.1\n" +
            "HOST: 239.255.255.250:1900\n" +
            "CACHE-CONTROL: max-age=1800\n" +
            "DATE: Wed, 24 Jun 2020 11:42:16 GMT\n" +
            "LOCATION: http://192.168.1.103:7676/rcr/\n" +
            "NT: uuid:" + Consts.UUID_3 + "\n" +
            "NTS: ssdp:alive\n" +
            "SERVER: SHP, UPnP/1.0, Samsung UPnP SDK/1.0\n" +
            "USN: uuid:" + Consts.UUID_3 + "\n" +
            "\n\n" +
            "NOTIFY * HTTP/1.1\n" +
            "HOST: 239.255.255.250:1900\n" +
            "CACHE-CONTROL: max-age=1800\n" +
            "DATE: Wed, 24 Jun 2020 11:42:16 GMT\n" +
            "LOCATION: http://192.168.1.103:7676/rcr/\n" +
            "NT: urn:samsung.com:device:RemoteControlReceiver:1\n" +
            "NTS: ssdp:alive\n" +
            "SERVER: SHP, UPnP/1.0, Samsung UPnP SDK/1.0\n" +
            "USN: uuid:" + Consts.UUID_3 + "::urn:samsung.com:device:RemoteControlReceiver:1\n" +
            "\n\n" +
            "NOTIFY * HTTP/1.1\n" +
            "HOST: 239.255.255.250:1900\n" +
            "CACHE-CONTROL: max-age=1800\n" +
            "DATE: Wed, 24 Jun 2020 11:42:16 GMT\n" +
            "LOCATION: http://192.168.1.103:7676/rcr/\n" +
            "NT: urn:samsung.com:service:MultiScreenService:1\n" +
            "NTS: ssdp:alive\n" +
            "SERVER: SHP, UPnP/1.0, Samsung UPnP SDK/1.0\n" +
            "USN: uuid:" + Consts.UUID_3 + "::urn:samsung.com:service:MultiScreenService:1\n" +
            "\n\n" +
            "NOTIFY * HTTP/1.1\n" +
            "HOST: 239.255.255.250:1900\n" +
            "CACHE-CONTROL: max-age=1800\n" +
            "DATE: Wed, 24 Jun 2020 11:42:16 GMT\n" +
            "LOCATION: http://192.168.1.103:9119/screen_sharing\n" +
            "NT: upnp:rootdevice\n" +
            "NTS: ssdp:alive\n" +
            "SERVER: SHP, UPnP/1.0, Samsung UPnP SDK/1.0\n" +
            "USN: uuid:" + Consts.UUID_2 + "::upnp:rootdevice\n" +
            "\n\n" +
            "NOTIFY * HTTP/1.1\n" +
            "HOST: 239.255.255.250:1900\n" +
            "CACHE-CONTROL: max-age=1800\n" +
            "DATE: Wed, 24 Jun 2020 11:42:16 GMT\n" +
            "LOCATION: http://192.168.1.103:9119/screen_sharing\n" +
            "NT: uuid:" + Consts.UUID_2 + "\n" +
            "NTS: ssdp:alive\n" +
            "SERVER: SHP, UPnP/1.0, Samsung UPnP SDK/1.0\n" +
            "USN: uuid:" + Consts.UUID_2 + "\n" +
            "\n\n" +
            "NOTIFY * HTTP/1.1\n" +
            "HOST: 239.255.255.250:1900\n" +
            "CACHE-CONTROL: max-age=1800\n" +
            "DATE: Wed, 24 Jun 2020 11:42:16 GMT\n" +
            "LOCATION: http://192.168.1.103:9119/screen_sharing\n" +
            "NT: urn:samsung.com:service:ScreenSharingService:1\n" +
            "NTS: ssdp:alive\n" +
            "SERVER: SHP, UPnP/1.0, Samsung UPnP SDK/1.0\n" +
            "USN: uuid:" + Consts.UUID_2 + "::urn:samsung.com:service:ScreenSharingService:1\n" +
            "\n\n" +
            "NOTIFY * HTTP/1.1\n" +
            "HOST: 239.255.255.250:1900\n" +
            "CACHE-CONTROL: max-age=1800\n" +
            "DATE: Wed, 24 Jun 2020 11:42:16 GMT\n" +
            "LOCATION: http://192.168.1.103:9197/dmr\n" +
            "NT: upnp:rootdevice\n" +
            "NTS: ssdp:alive\n" +
            "SERVER: SHP, UPnP/1.0, Samsung UPnP SDK/1.0\n" +
            "USN: uuid:" + Consts.UUID_1 + "::upnp:rootdevice\n" +
            "\n\n" +
            "NOTIFY * HTTP/1.1\n" +
            "HOST: 239.255.255.250:1900\n" +
            "CACHE-CONTROL: max-age=1800\n" +
            "DATE: Wed, 24 Jun 2020 11:42:16 GMT\n" +
            "LOCATION: http://192.168.1.103:9197/dmr\n" +
            "NT: uuid:" + Consts.UUID_1 + "\n" +
            "NTS: ssdp:alive\n" +
            "SERVER: SHP, UPnP/1.0, Samsung UPnP SDK/1.0\n" +
            "USN: uuid:" + Consts.UUID_1 + "\n" +
            "\n\n" +
            "NOTIFY * HTTP/1.1\n" +
            "HOST: 239.255.255.250:1900\n" +
            "CACHE-CONTROL: max-age=1800\n" +
            "DATE: Wed, 24 Jun 2020 11:42:16 GMT\n" +
            "LOCATION: http://192.168.1.103:9197/dmr\n" +
            "NT: urn:schemas-upnp-org:device:MediaRenderer:1\n" +
            "NTS: ssdp:alive\n" +
            "SERVER: SHP, UPnP/1.0, Samsung UPnP SDK/1.0\n" +
            "USN: uuid:" + Consts.UUID_1 + "::urn:schemas-upnp-org:device:MediaRenderer:1\n" +
            "\n\n" +
            "NOTIFY * HTTP/1.1\n" +
            "HOST: 239.255.255.250:1900\n" +
            "CACHE-CONTROL: max-age=1800\n" +
            "DATE: Wed, 24 Jun 2020 11:42:16 GMT\n" +
            "LOCATION: http://192.168.1.103:7678/nservice/\n" +
            "NT: upnp:rootdevice\n" +
            "NTS: ssdp:alive\n" +
            "SERVER: SHP, UPnP/1.0, Samsung UPnP SDK/1.0\n" +
            "USN: uuid:" + Consts.UUID_4 + "::upnp:rootdevice\n" +
            "\n\n" +
            "NOTIFY * HTTP/1.1\n" +
            "HOST: 239.255.255.250:1900\n" +
            "CACHE-CONTROL: max-age=1800\n" +
            "DATE: Wed, 24 Jun 2020 11:42:16 GMT\n" +
            "LOCATION: http://192.168.1.103:7678/nservice/\n" +
            "NT: uuid:" + Consts.UUID_4 + "\n" +
            "NTS: ssdp:alive\n" +
            "SERVER: SHP, UPnP/1.0, Samsung UPnP SDK/1.0\n" +
            "USN: uuid:" + Consts.UUID_4 + "\n" +
            "\n\n" +
            "NOTIFY * HTTP/1.1\n" +
            "HOST: 239.255.255.250:1900\n" +
            "CACHE-CONTROL: max-age=1800\n" +
            "DATE: Wed, 24 Jun 2020 11:42:16 GMT\n" +
            "LOCATION: http://192.168.1.103:7678/nservice/\n" +
            "NT: urn:dial-multiscreen-org:device:dialreceiver:1\n" +
            "NTS: ssdp:alive\n" +
            "SERVER: SHP, UPnP/1.0, Samsung UPnP SDK/1.0\n" +
            "USN: uuid:" + Consts.UUID_4 + "::urn:dial-multiscreen-org:device:dialreceiver:1\n" +
            "\n\n" +
            "NOTIFY * HTTP/1.1\n" +
            "HOST: 239.255.255.250:1900\n" +
            "CACHE-CONTROL: max-age=1800\n" +
            "DATE: Wed, 24 Jun 2020 11:42:16 GMT\n" +
            "LOCATION: http://192.168.1.103:7678/nservice/\n" +
            "NT: urn:dial-multiscreen-org:service:dial:1\n" +
            "NTS: ssdp:alive\n" +
            "SERVER: SHP, UPnP/1.0, Samsung UPnP SDK/1.0\n" +
            "USN: uuid:" + Consts.UUID_4 + "::urn:dial-multiscreen-org:service:dial:1\n" +
            "\n\n" +
            "NOTIFY * HTTP/1.1\n" +
            "HOST: 239.255.255.250:1900\n" +
            "CACHE-CONTROL: max-age=1800\n" +
            "DATE: Wed, 24 Jun 2020 11:42:16 GMT\n" +
            "LOCATION: http://192.168.1.103:9197/dmr\n" +
            "NT: urn:schemas-upnp-org:service:RenderingControl:1\n" +
            "NTS: ssdp:alive\n" +
            "SERVER: SHP, UPnP/1.0, Samsung UPnP SDK/1.0\n" +
            "USN: uuid:" + Consts.UUID_1 + "::urn:schemas-upnp-org:service:RenderingControl:1\n" +
            "\n\n" +
            "NOTIFY * HTTP/1.1\n" +
            "HOST: 239.255.255.250:1900\n" +
            "CACHE-CONTROL: max-age=1800\n" +
            "DATE: Wed, 24 Jun 2020 11:42:16 GMT\n" +
            "LOCATION: http://192.168.1.103:9197/dmr\n" +
            "NT: urn:schemas-upnp-org:service:ConnectionManager:1\n" +
            "NTS: ssdp:alive\n" +
            "SERVER: SHP, UPnP/1.0, Samsung UPnP SDK/1.0\n" +
            "USN: uuid:" + Consts.UUID_1 + "::urn:schemas-upnp-org:service:ConnectionManager:1\n" +
            "\n\n" +
            "NOTIFY * HTTP/1.1\n" +
            "HOST: 239.255.255.250:1900\n" +
            "CACHE-CONTROL: max-age=1800\n" +
            "DATE: Wed, 24 Jun 2020 11:42:16 GMT\n" +
            "LOCATION: http://192.168.1.103:9197/dmr\n" +
            "NT: urn:schemas-upnp-org:service:AVTransport:1\n" +
            "NTS: ssdp:alive\n" +
            "SERVER: SHP, UPnP/1.0, Samsung UPnP SDK/1.0\n" +
            "USN: uuid:" + Consts.UUID_1 + "::urn:schemas-upnp-org:service:AVTransport:1\n" +
            "\n\n" +
            "NOTIFY * HTTP/1.1\n" +
            "HOST: 239.255.255.250:1900\n" +
            "CACHE-CONTROL: max-age=1800\n" +
            "DATE: Wed, 24 Jun 2020 11:42:16 GMT\n" +
            "LOCATION: http://192.168.1.103:9197/dmr\n" +
            "NT: urn:schemas-rvualliance-org:service:StreamSplicing:1\n" +
            "NTS: ssdp:alive\n" +
            "SERVER: SHP, UPnP/1.0, Samsung UPnP SDK/1.0\n" +
            "USN: uuid:" + Consts.UUID_1 + "::urn:schemas-rvualliance-org:service:StreamSplicing:1\n" +
            "\n\n" +
            "NOTIFY * HTTP/1.1\n" +
            "HOST: 239.255.255.250:1900\n" +
            "CACHE-CONTROL: max-age=1800\n" +
            "DATE: Wed, 24 Jun 2020 11:42:16 GMT\n" +
            "LOCATION: http://192.168.1.103:7676/rcr/\n" +
            "NT: upnp:rootdevice\n" +
            "NTS: ssdp:alive\n" +
            "SERVER: SHP, UPnP/1.0, Samsung UPnP SDK/1.0\n" +
            "USN: uuid:" + Consts.UUID_3 + "::upnp:rootdevice\n" +
            "\n\n" +
            "NOTIFY * HTTP/1.1\n" +
            "HOST: 239.255.255.250:1900\n" +
            "CACHE-CONTROL: max-age=1800\n" +
            "DATE: Wed, 24 Jun 2020 11:42:16 GMT\n" +
            "LOCATION: http://192.168.1.103:7676/rcr/\n" +
            "NT: uuid:" + Consts.UUID_3 + "\n" +
            "NTS: ssdp:alive\n" +
            "SERVER: SHP, UPnP/1.0, Samsung UPnP SDK/1.0\n" +
            "USN: uuid:" + Consts.UUID_3 + "\n" +
            "\n\n" +
            "NOTIFY * HTTP/1.1\n" +
            "HOST: 239.255.255.250:1900\n" +
            "CACHE-CONTROL: max-age=1800\n" +
            "DATE: Wed, 24 Jun 2020 11:42:16 GMT\n" +
            "LOCATION: http://192.168.1.103:9119/screen_sharing\n" +
            "NT: upnp:rootdevice\n" +
            "NTS: ssdp:alive\n" +
            "SERVER: SHP, UPnP/1.0, Samsung UPnP SDK/1.0\n" +
            "USN: uuid:" + Consts.UUID_2 + "::upnp:rootdevice\n" +
            "\n\n" +
            "NOTIFY * HTTP/1.1\n" +
            "HOST: 239.255.255.250:1900\n" +
            "CACHE-CONTROL: max-age=1800\n" +
            "DATE: Wed, 24 Jun 2020 11:42:16 GMT\n" +
            "LOCATION: http://192.168.1.103:9119/screen_sharing\n" +
            "NT: uuid:" + Consts.UUID_2 + "\n" +
            "NTS: ssdp:alive\n" +
            "SERVER: SHP, UPnP/1.0, Samsung UPnP SDK/1.0\n" +
            "USN: uuid:" + Consts.UUID_2 + "\n" +
            "\n\n" +
            "NOTIFY * HTTP/1.1\n" +
            "HOST: 239.255.255.250:1900\n" +
            "CACHE-CONTROL: max-age=1800\n" +
            "DATE: Wed, 24 Jun 2020 11:42:16 GMT\n" +
            "LOCATION: http://192.168.1.103:9119/screen_sharing\n" +
            "NT: urn:samsung.com:device:ScreenSharing:1\n" +
            "NTS: ssdp:alive\n" +
            "SERVER: SHP, UPnP/1.0, Samsung UPnP SDK/1.0\n" +
            "USN: uuid:" + Consts.UUID_2 + "::urn:samsung.com:device:ScreenSharing:1\n" +
            "\n\n" +
            "NOTIFY * HTTP/1.1\n" +
            "HOST: 239.255.255.250:1900\n" +
            "CACHE-CONTROL: max-age=1800\n" +
            "DATE: Wed, 24 Jun 2020 11:42:16 GMT\n" +
            "LOCATION: http://192.168.1.103:7676/rcr/\n" +
            "NT: urn:samsung.com:device:RemoteControlReceiver:1\n" +
            "NTS: ssdp:alive\n" +
            "SERVER: SHP, UPnP/1.0, Samsung UPnP SDK/1.0\n" +
            "USN: uuid:" + Consts.UUID_3 + "::urn:samsung.com:device:RemoteControlReceiver:1\n" +
            "\n\n" +
            "NOTIFY * HTTP/1.1\n" +
            "HOST: 239.255.255.250:1900\n" +
            "CACHE-CONTROL: max-age=1800\n" +
            "DATE: Wed, 24 Jun 2020 11:42:16 GMT\n" +
            "LOCATION: http://192.168.1.103:9119/screen_sharing\n" +
            "NT: urn:samsung.com:service:ScreenSharingService:1\n" +
            "NTS: ssdp:alive\n" +
            "SERVER: SHP, UPnP/1.0, Samsung UPnP SDK/1.0\n" +
            "USN: uuid:" + Consts.UUID_2 + "::urn:samsung.com:service:ScreenSharingService:1\n";

    private MulticastImpl multicast;
    private int interval;
    private String ip;
    private int port;
    public boolean isRunning;

    public ServiceNotificationRunnable(MulticastImpl multicast, String ip, int port, int interval) {
        this.interval = interval;
        this.multicast = multicast;
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void run() {
        isRunning = true;
        while (true) {
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String[] list = DATA.split("\n\n\n");
            for (String str : list) {
                str = str.replaceAll("\n", "\r\n");
                str += "\r\n\r\n";
                multicast.send(str.getBytes(), str.getBytes().length, ip, port);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
