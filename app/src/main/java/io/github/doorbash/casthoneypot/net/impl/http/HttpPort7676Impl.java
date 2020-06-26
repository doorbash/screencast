package io.github.doorbash.casthoneypot.net.impl.http;

import android.util.Log;

import fi.iki.elonen.NanoHTTPD;
import io.github.doorbash.casthoneypot.net.impl.HttpServerImpl;
import io.github.doorbash.casthoneypot.util.Consts;

public class HttpPort7676Impl extends HttpServerImpl {

    public static final String TAG = "HttpServerImpl";

    String rcr = "<?xml version=\"1.0\"?>\n" +
            "<root xmlns=\"urn:schemas-upnp-org:device-1-0\" xmlns:sec=\"http://www.sec.co.kr/dlna\" xmlns:dlna=\"urn:schemas-dlna-org:device-1-0\">\n" +
            "  <specVersion>\n" +
            "    <major>1</major>\n" +
            "    <minor>0</minor>\n" +
            "  </specVersion>\n" +
            "  <device>\n" +
            "    <deviceType>urn:samsung.com:device:RemoteControlReceiver:1</deviceType>\n" +
            "    <friendlyName>" + Consts.FRIENDLY_NAME + "</friendlyName>\n" +
            "    <manufacturer>Samsung Electronics</manufacturer>\n" +
            "    <manufacturerURL>http://www.samsung.com/sec</manufacturerURL>\n" +
            "    <modelDescription>Samsung DTV RCR</modelDescription>\n" +
            "    <modelName>UA55MU8500</modelName>\n" +
            "    <modelNumber>1.0</modelNumber>\n" +
            "    <modelURL>http://www.samsung.com/sec</modelURL>\n" +
            "    <serialNumber>20090804RCR</serialNumber>\n" +
            "    <UDN>uuid:" + Consts.UUID_3 + "</UDN>\n" +
            "    <sec:deviceID>SHCHC5ZTTO2RS</sec:deviceID>\n" +
            "    <sec:ProductCap>Resolution:1920X1080,Tizen,Y2017</sec:ProductCap>\n" +
            "    <serviceList>\n" +
            "      <service>\n" +
            "        <serviceType>urn:samsung.com:service:MultiScreenService:1</serviceType>\n" +
            "        <serviceId>urn:samsung.com:serviceId:MultiScreenService</serviceId>\n" +
            "        <controlURL>/RCR/control/MultiScreenService</controlURL>\n" +
            "        <eventSubURL>/RCR/event/MultiScreenService</eventSubURL>\n" +
            "        <SCPDURL>MultiScreenService.xml</SCPDURL>\n" +
            "      </service>\n" +
            "    </serviceList>\n" +
            "    <sec:Capabilities>\n" +
            "        <sec:Capability name=\"samsung:multiscreen:1\" port=\"8001\" location=\"/ms/1.0/\"/>\n" +
            "    </sec:Capabilities>\n" +
            "  </device>\n" +
            "</root>";

    String rcrMultiscreenService = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<scpd xmlns=\"urn:schemas-upnp-org:service-1-0\">\n" +
            "   <specVersion>\n" +
            "      <major>1</major>\n" +
            "      <minor>0</minor>\n" +
            "   </specVersion>\n" +
            "   <actionList>\n" +
            "      <action>  \n" +
            "         <name>SendKeyCode</name>\n" +
            "         <argumentList>\n" +
            "            <argument>\n" +
            "               <name>KeyCode</name>\n" +
            "               <direction>in</direction>\n" +
            "               <relatedStateVariable>A_ARG_TYPE_KeyCode</relatedStateVariable>\n" +
            "            </argument>\n" +
            "            <argument>\n" +
            "               <name>KeyDescription</name>\n" +
            "               <direction>in</direction>\n" +
            "               <relatedStateVariable>A_ARG_TYPE_KeyDescription</relatedStateVariable>\n" +
            "            </argument>\n" +
            "         </argumentList>\n" +
            "      </action>\n" +
            "   </actionList>\n" +
            "   <serviceStateTable>\n" +
            "      <stateVariable sendEvents=\"no\">\n" +
            "         <name>A_ARG_TYPE_KeyCode</name>\n" +
            "         <dataType>ui4</dataType>\n" +
            "      </stateVariable>\n" +
            "      <stateVariable sendEvents=\"no\">\n" +
            "         <name>A_ARG_TYPE_KeyDescription</name>\n" +
            "         <dataType>string</dataType>\n" +
            "      </stateVariable>\n" +
            "   </serviceStateTable>\n" +
            "</scpd>";

    public NanoHTTPD.Response response(NanoHTTPD.IHTTPSession session) {
        if (session.getUri().equals("/rcr/")) {
            return NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.OK, "text/xml", rcr);
        } else if(session.getUri().equals("/rcr/MultiScreenService.xml")) {
            return NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.OK, "text/xml", rcrMultiscreenService);
        }
        String msg = "[NOT HANDLED] " + session.getUri();
        Log.e(TAG, msg);
        return NanoHTTPD.newFixedLengthResponse(msg);
    }

}
