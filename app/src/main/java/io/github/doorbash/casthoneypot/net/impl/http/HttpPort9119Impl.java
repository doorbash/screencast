package io.github.doorbash.casthoneypot.net.impl.http;

import android.util.Log;

import fi.iki.elonen.NanoHTTPD;
import io.github.doorbash.casthoneypot.net.impl.HttpServerImpl;
import io.github.doorbash.casthoneypot.util.Consts;

public class HttpPort9119Impl extends HttpServerImpl {

    public static final String TAG = "HttpServerImpl";

    String screen_sharing = "<?xml version=\"1.0\"?>\n" +
            "<root xmlns=\"urn:samsung.com:device-1-0\" xmlns:sec=\"http://www.sec.co.kr/dlna\">\n" +
            "  <specVersion>\n" +
            "    <major>1</major>\n" +
            "    <minor>0</minor>\n" +
            "  </specVersion>\n" +
            "  <device>\n" +
            "    <deviceType>urn:samsung.com:device:ScreenSharing:1</deviceType>\n" +
            "    <friendlyName>" + Consts.FRIENDLY_NAME + "</friendlyName>\n" +
            "    <manufacturer>Samsung Electronics</manufacturer>\n" +
            "    <manufacturerURL>http://www.samsung.com/sec</manufacturerURL>\n" +
            "    <modelDescription>Samsung TV ScreenSharing</modelDescription>\n" +
            "    <modelName>UA55MU8500</modelName>\n" +
            "    <modelNumber>AllShare1.0</modelNumber>\n" +
            "    <modelURL>http://www.samsung.com/sec</modelURL>\n" +
            "    <serialNumber>ScreenSharing2017</serialNumber>\n" +
            "    <UDN>uuid:" + Consts.UUID_2 + "</UDN>\n" +
            "    <iconList>\n" +
            "      <icon>\n" +
            "        <mimetype>image/jpeg</mimetype>\n" +
            "        <width>48</width>\n" +
            "        <height>48</height>\n" +
            "        <depth>24</depth>\n" +
            "        <url>/icon_SML.jpg</url>\n" +
            "      </icon>\n" +
            "      <icon>\n" +
            "        <mimetype>image/jpeg</mimetype>\n" +
            "        <width>120</width>\n" +
            "        <height>120</height>\n" +
            "        <depth>24</depth>\n" +
            "        <url>/icon_LRG.jpg</url>\n" +
            "      </icon>\n" +
            "      <icon>\n" +
            "        <mimetype>image/png</mimetype>\n" +
            "        <width>48</width>\n" +
            "        <height>48</height>\n" +
            "        <depth>24</depth>\n" +
            "        <url>/icon_SML.png</url>\n" +
            "      </icon>\n" +
            "      <icon>\n" +
            "        <mimetype>image/png</mimetype>\n" +
            "        <width>120</width>\n" +
            "        <height>120</height>\n" +
            "        <depth>24</depth>\n" +
            "        <url>/icon_LRG.png</url>\n" +
            "      </icon>\n" +
            "    </iconList>\n" +
            "    <serviceList>\n" +
            "      <service>\n" +
            "        <serviceType>urn:samsung.com:service:ScreenSharingService:1</serviceType>\n" +
            "        <serviceId>urn:samsung.com:serviceId:ScreenSharingService</serviceId>\n" +
            "        <controlURL>/upnp/control/ScreenSharingService1</controlURL>\n" +
            "        <eventSubURL>/upnp/event/ScreenSharingService1</eventSubURL>\n" +
            "        <SCPDURL>/ScreenSharingService1_1.xml</SCPDURL>\n" +
            "      </service>\n" +
            "    </serviceList>\n" +
            "    <sec:X_ScreenSharing>wlanMacAddress:7c:64:56:39:5e:66,eth0MacAddress:cc:6e:a4:3c:c7:c6,p2pDeviceAddress:7e:64:56:39:5e:66,BluetoothMacAddress:7C:64:56:39:5E:67,BLEMacAddress:7C:64:56:39:5E:67,supportTDLS:1,supportDMR:1,WFDRole:PrimarySink,supportP2PHandover:1,DMR_UDN:uuid:" + Consts.UUID_1 + ",listenFrequency:2412,wlanFrequency:0,bssid:00:00:00:00:00:00,vdProductType:TV</sec:X_ScreenSharing>\n" +
            "  </device>\n" +
            "</root>\n";

    String screenSharingService = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<scpd xmlns=\"urn:samsung.com:service-1-0\">\n" +
            "  <specVersion>\n" +
            "    <major>1</major>\n" +
            "    <minor>0</minor>\n" +
            "  </specVersion>\n" +
            "  <actionList>\n" +
            "    <action>\n" +
            "      <name>X_ConnectScreenSharingM2TV</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>mWlanMacAddress</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_mWlanMacAddress</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>mP2pDeviceAddress</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_mP2pDeviceAddress</relatedStateVariable>\n" +
            "        </argument> \n" +
            "        <argument>\n" +
            "          <name>mBluetoothMacAddress</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_mBluetoothMacAddress</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>mWFDSourcePort</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_mWFDSourcePort</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>tBSSID</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_tBSSID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "         <argument>\n" +
            "          <name>tWlanFreq</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_tWlanFreq</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>tListenFreq</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_tListenFreq</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "    <action>\n" +
            "      <name>X_ConnectScreenSharingTV2M</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>mWlanMacAddress</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_mWlanMacAddress</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>mP2pDeviceAddress</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_mP2pDeviceAddress</relatedStateVariable>\n" +
            "        </argument> \n" +
            "        <argument>\n" +
            "          <name>mBluetoothMacAddress</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_mBluetoothMacAddress</relatedStateVariable>\n" +
            "        </argument> \n" +
            "          <argument>\n" +
            "          <name>tBSSID</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_tBSSID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>tWlanFreq</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_tWlanFreq</relatedStateVariable>\n" +
            "        </argument>\n" +
            "         <argument>\n" +
            "          <name>tListenFreq</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_tListenFreq</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>tWFDSourcePort</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_tWFDSourcePort</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "  </actionList>  \n" +
            "  <serviceStateTable>\n" +
            "  <stateVariable sendEvents=\"no\">\n" +
            "   <name>A_ARG_TYPE_mWlanMacAddress</name> \n" +
            "   <dataType>string</dataType> \n" +
            "  </stateVariable>\n" +
            "  <stateVariable sendEvents=\"no\">\n" +
            "   <name>A_ARG_TYPE_mP2pDeviceAddress</name> \n" +
            "   <dataType>string</dataType> \n" +
            "  </stateVariable>\n" +
            "  <stateVariable sendEvents=\"no\">\n" +
            "   <name>A_ARG_TYPE_mBluetoothMacAddress</name> \n" +
            "   <dataType>string</dataType> \n" +
            "  </stateVariable>\n" +
            "  <stateVariable sendEvents=\"no\">\n" +
            "   <name>A_ARG_TYPE_mWFDSourcePort</name> \n" +
            "   <dataType>string</dataType> \n" +
            "  </stateVariable>\n" +
            "  <stateVariable sendEvents=\"no\">\n" +
            "   <name>A_ARG_TYPE_tBSSID</name> \n" +
            "   <dataType>string</dataType> \n" +
            "  </stateVariable>\n" +
            "  <stateVariable sendEvents=\"no\">\n" +
            "   <name>A_ARG_TYPE_tWlanFreq</name> \n" +
            "   <dataType>string</dataType> \n" +
            "  </stateVariable>\n" +
            "  <stateVariable sendEvents=\"no\">\n" +
            "   <name>A_ARG_TYPE_tListenFreq</name> \n" +
            "   <dataType>string</dataType> \n" +
            "  </stateVariable>\n" +
            "  <stateVariable sendEvents=\"no\">\n" +
            "   <name>A_ARG_TYPE_tWFDSourcePort</name> \n" +
            "   <dataType>string</dataType> \n" +
            "  </stateVariable>\n" +
            "  <stateVariable sendEvents=\"yes\">\n" +
            "  <name>ScreenSharingState</name>\n" +
            "  <dataType>string</dataType>\n" +
            "  <allowedValueList>\n" +
            "    <allowedValue>RUNNING</allowedValue>\n" +
            "    <allowedValue>CHECKING_ACL</allowedValue>\n" +
            "  </allowedValueList>\n" +
            "  <defaultValue>RUNNING</defaultValue>\n" +
            "</stateVariable>\n" +
            " </serviceStateTable>\n" +
            "</scpd>\n";

    public NanoHTTPD.Response response(NanoHTTPD.IHTTPSession session) {
        if (session.getUri().equals("/screen_sharing")) {
            return NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.OK, "text/xml", screen_sharing);
        } else if (session.getUri().equals("/ScreenSharingService1_1.xml")) {
            return NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.OK, "text/xml", screenSharingService);
        }
        String msg = "[NOT HANDLED] " + session.getUri();
        Log.e(TAG, msg);
        return NanoHTTPD.newFixedLengthResponse(msg);
    }

}
