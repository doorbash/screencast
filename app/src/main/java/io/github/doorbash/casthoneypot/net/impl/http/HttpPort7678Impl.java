package io.github.doorbash.casthoneypot.net.impl.http;

import android.se.omapi.Session;
import android.util.Log;

import fi.iki.elonen.NanoHTTPD;
import io.github.doorbash.casthoneypot.net.impl.HttpServerImpl;
import io.github.doorbash.casthoneypot.util.Consts;

public class HttpPort7678Impl extends HttpServerImpl {

    public static final String TAG = "HttpServerImpl";

    String nservice = "<?xml version=\"1.0\"?>\n" +
            "<root xmlns=\"urn:schemas-upnp-org:device-1-0\" xmlns:sec=\"http://www.sec.co.kr/dlna\" xmlns:dlna=\"urn:schemas-dlna-org:device-1-0\">\n" +
            "  <specVersion>\n" +
            "    <major>1</major>\n" +
            "    <minor>0</minor>\n" +
            "  </specVersion>\n" +
            "  <device>\n" +
            "    <deviceType>urn:dial-multiscreen-org:device:dialreceiver:1</deviceType>\n" +
            "    <friendlyName>" + Consts.FRIENDLY_NAME + "</friendlyName>\n" +
            "    <manufacturer>Samsung Electronics</manufacturer>\n" +
            "    <manufacturerURL>http://www.samsung.com/sec</manufacturerURL>\n" +
            "    <modelDescription>Samsung DTV RCR</modelDescription>\n" +
            "    <modelName>UA55MU8500</modelName>\n" +
            "    <modelNumber>1.0</modelNumber>\n" +
            "    <modelURL>http://www.samsung.com/sec</modelURL>\n" +
            "    <serialNumber>20090804RCR</serialNumber>\n" +
            "    <UDN>uuid:" + Consts.UUID_4 + "</UDN>\n" +
            "    <sec:deviceID>NSNSC5ZTTO2RS</sec:deviceID>\n" +
            "    <sec:ProductCap>Resolution:1920X1080,Tizen,Y2017</sec:ProductCap>\n" +
            "    <serviceList>\n" +
            "      <service>\n" +
            "        <serviceType>urn:dial-multiscreen-org:service:dial:1</serviceType>\n" +
            "        <serviceId>urn:dial-multiscreen-org:serviceId:dial</serviceId>\n" +
            "        <controlURL>/RCR/control/dial</controlURL>\n" +
            "        <eventSubURL>/RCR/event/dial</eventSubURL>\n" +
            "        <SCPDURL>dial.xml</SCPDURL>\n" +
            "      </service>\n" +
            "    </serviceList>\n" +
            "    <sec:Capabilities>\n" +
            "        <sec:Capability name=\"samsung:multiscreen:1\" port=\"8001\" location=\"/ms/1.0/\"/>\n" +
            "    </sec:Capabilities>\n" +
            "  </device>\n" +
            "</root>\n";

    String nserviceDial = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "\n" +
            "<scpd xmlns=\"urn:schemas-upnp-org:service-1-0\">\n" +
            "\n" +
            "   <specVersion>\n" +
            "\n" +
            "      <major>1</major>\n" +
            "\n" +
            "      <minor>0</minor>\n" +
            "\n" +
            "   </specVersion>\n" +
            "\n" +
            "   <actionList>\n" +
            "\n" +
            "      <action>\t\t\n" +
            "\n" +
            "         <name>SendKeyCode</name>\n" +
            "\n" +
            "         <argumentList>\n" +
            "\n" +
            "            <argument>\n" +
            "\n" +
            "               <name>KeyCode</name>\n" +
            "\n" +
            "               <direction>in</direction>\n" +
            "\n" +
            "               <relatedStateVariable>A_ARG_TYPE_KeyCode</relatedStateVariable>\n" +
            "\n" +
            "            </argument>\n" +
            "\n" +
            "            <argument>\n" +
            "\n" +
            "               <name>KeyDescription</name>\n" +
            "\n" +
            "               <direction>in</direction>\n" +
            "\n" +
            "               <relatedStateVariable>A_ARG_TYPE_KeyDescription</relatedStateVariable>\n" +
            "\n" +
            "            </argument>\n" +
            "\n" +
            "         </argumentList>\n" +
            "\n" +
            "      </action>\n" +
            "\n" +
            "   </actionList>\n" +
            "\n" +
            "   <serviceStateTable>\n" +
            "\n" +
            "      <stateVariable sendEvents=\"no\">\n" +
            "\n" +
            "         <name>A_ARG_TYPE_KeyCode</name>\n" +
            "\n" +
            "         <dataType>ui4</dataType>\n" +
            "\n" +
            "      </stateVariable>\n" +
            "\n" +
            "      <stateVariable sendEvents=\"no\">\n" +
            "\n" +
            "         <name>A_ARG_TYPE_KeyDescription</name>\n" +
            "\n" +
            "         <dataType>string</dataType>\n" +
            "\n" +
            "      </stateVariable>\n" +
            "\n" +
            "   </serviceStateTable>\n" +
            "\n" +
            "</scpd>\n" +
            "\n";

    public NanoHTTPD.Response response(NanoHTTPD.IHTTPSession session) {
        if (session.getUri().equals("/nservice/")) {
            return NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.OK, "text/xml", nservice);
        } else if (session.getUri().equals("/nservice/dial.xml")) {
            return NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.OK, "text/xml", nserviceDial);
        }
        String msg = "[NOT HANDLED] " + session.getUri();
        Log.e(TAG, msg);
        return NanoHTTPD.newFixedLengthResponse(msg);
    }

}
