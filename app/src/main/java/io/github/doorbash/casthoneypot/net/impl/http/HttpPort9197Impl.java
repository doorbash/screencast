package io.github.doorbash.casthoneypot.net.impl.http;

import android.util.Log;

import fi.iki.elonen.NanoHTTPD;
import io.github.doorbash.casthoneypot.net.impl.HttpServerImpl;
import io.github.doorbash.casthoneypot.util.Consts;

public class HttpPort9197Impl extends HttpServerImpl {

    public static final String TAG = "HttpServerImpl";

    String dmr = "<?xml version=\"1.0\"?>\n" +
            "<root xmlns=\"urn:schemas-upnp-org:device-1-0\" xmlns:pnpx=\"http://schemas.microsoft.com/windows/pnpx/2005/11\" xmlns:df=\"http://schemas.microsoft.com/windows/2008/09/devicefoundation\" xmlns:sec=\"http://www.sec.co.kr/dlna\">\n" +
            "  <specVersion>\n" +
            "    <major>1</major>\n" +
            "    <minor>0</minor>\n" +
            "  </specVersion>\n" +
            "  <device>\n" +
            "    <deviceType>urn:schemas-upnp-org:device:MediaRenderer:1</deviceType>\n" +
            "    <pnpx:X_compatibleId>MS_DigitalMediaDeviceClass_DMR_V001</pnpx:X_compatibleId>\n" +
            "    <df:X_deviceCategory>Display.TV.LCD Multimedia.DMR</df:X_deviceCategory>\n" +
            "    <dlna:X_DLNADOC xmlns:dlna=\"urn:schemas-dlna-org:device-1-0\">DMR-1.50</dlna:X_DLNADOC>\n" +
            "    <friendlyName>" + Consts.FRIENDLY_NAME + "</friendlyName>\n" +
            "    <manufacturer>Samsung Electronics</manufacturer>\n" +
            "    <manufacturerURL>http://www.samsung.com/sec</manufacturerURL>\n" +
            "    <modelDescription>Samsung TV DMR</modelDescription>\n" +
            "    <modelName>UA55MU8500</modelName>\n" +
            "    <modelNumber>AllShare1.0</modelNumber>\n" +
            "    <modelURL>http://www.samsung.com/sec</modelURL>\n" +
            "    <serialNumber>20161219DMR</serialNumber>\n" +
            "    <UDN>uuid:" + Consts.UUID_1 + "</UDN>\n" +
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
            "        <serviceType>urn:schemas-upnp-org:service:RenderingControl:1</serviceType>\n" +
            "        <serviceId>urn:upnp-org:serviceId:RenderingControl</serviceId>\n" +
            "        <controlURL>/upnp/control/RenderingControl1</controlURL>\n" +
            "        <eventSubURL>/upnp/event/RenderingControl1</eventSubURL>\n" +
            "        <SCPDURL>/RenderingControl_1.xml</SCPDURL>\n" +
            "      </service>\n" +
            "      <service>\n" +
            "        <serviceType>urn:schemas-upnp-org:service:ConnectionManager:1</serviceType>\n" +
            "        <serviceId>urn:upnp-org:serviceId:ConnectionManager</serviceId>\n" +
            "        <controlURL>/upnp/control/ConnectionManager1</controlURL>\n" +
            "        <eventSubURL>/upnp/event/ConnectionManager1</eventSubURL>\n" +
            "        <SCPDURL>/ConnectionManager_1.xml</SCPDURL>\n" +
            "      </service>\n" +
            "      <service>\n" +
            "        <serviceType>urn:schemas-upnp-org:service:AVTransport:1</serviceType>\n" +
            "        <serviceId>urn:upnp-org:serviceId:AVTransport</serviceId>\n" +
            "        <controlURL>/upnp/control/AVTransport1</controlURL>\n" +
            "        <eventSubURL>/upnp/event/AVTransport1</eventSubURL>\n" +
            "        <SCPDURL>/AVTransport_1.xml</SCPDURL>\n" +
            "      </service>\n" +
            "      <service>\n" +
            "        <serviceType>urn:schemas-rvualliance-org:service:StreamSplicing:1</serviceType>\n" +
            "        <serviceId>urn:upnp-org:serviceId:StreamSplicing</serviceId>\n" +
            "        <controlURL>/upnp/control/StreamSplicing1</controlURL>\n" +
            "        <eventSubURL>/upnp/event/StreamSplicing1</eventSubURL>\n" +
            "        <SCPDURL>/StreamSplicing_1.xml</SCPDURL>\n" +
            "      </service>\n" +
            "    </serviceList>\n" +
            "    <sec:ProductCap>Tizen,Y2017,WebURIPlayable,NavigateInPause,ScreenMirroringP2PMAC=7e:64:56:39:5e:66,UHD_SCREEN,vdProductType=TV,OCF=1</sec:ProductCap>\n" +
            "    <pnpx:X_hardwareId>VEN_0105&amp;DEV_VD0001</pnpx:X_hardwareId>\n" +
            "  </device>\n" +
            "</root>\n";

    String renderingControl = "<?xml version=\"1.0\"?>\n" +
            "<scpd xmlns=\"urn:schemas-upnp-org:service-1-0\">\n" +
            "  <specVersion>\n" +
            "    <major>1</major>\n" +
            "    <minor>0</minor>\n" +
            "  </specVersion>\n" +
            "  <actionList>\n" +
            "    <action>  \n" +
            "      <name>ListPresets</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>InstanceID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>CurrentPresetNameList</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>PresetNameList</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "    <action>\n" +
            "      <name>SelectPreset</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>InstanceID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>PresetName</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_PresetName</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "    <action> \n" +
            "      <name>GetMute</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>InstanceID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>Channel</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_Channel</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>CurrentMute</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>Mute</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "    <action> \n" +
            "      <name>SetMute</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>InstanceID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>Channel</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_Channel</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>DesiredMute</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>Mute</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "    <action> \n" +
            "      <name>GetVolume</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>InstanceID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>Channel</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_Channel</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>CurrentVolume</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>Volume</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "    <action> \n" +
            "      <name>SetVolume</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>InstanceID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>Channel</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_Channel</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>DesiredVolume</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>Volume</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "\n" +
            "    <action> \n" +
            "      <name>X_GetAspectRatio</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>InstanceID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>AspectRatio</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>X_AspectRatio</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "    <action> \n" +
            "      <name>X_SetAspectRatio</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>InstanceID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>AspectRatio</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>X_AspectRatio</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "    <action> \n" +
            "      <name>X_Move360View</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>InstanceID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>LatitudeOffset</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>X_ARG_TYPE_ArcDegreeOffset</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>LongitudeOffset</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>X_ARG_TYPE_ArcDegreeOffset</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "    <action> \n" +
            "      <name>X_Zoom360View</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>InstanceID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>ScaleFactorOffset</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>X_ARG_TYPE_ScaleFactorOffset</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "    <action> \n" +
            "      <name>X_Origin360View</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>InstanceID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "    <action> \n" +
            "      <name>X_ControlCaption</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>InstanceID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>Operation</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>X_ARG_TYPE_CaptionOperation</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>Name</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>X_ARG_TYPE_CaptionName</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>ResourceURI</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>X_ARG_TYPE_ResourceURI</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>CaptionURI</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>X_ARG_TYPE_CaptionURI</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>CaptionType</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>X_ARG_TYPE_CaptionType</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>Language</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>X_ARG_TYPE_Language</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>Encoding</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>X_ARG_TYPE_Encoding</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "    <action> \n" +
            "      <name>X_GetCaptionState</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>InstanceID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>Captions</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>X_Captions</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>EnabledCaptions</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>X_EnabledCaptions</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "    <action> \n" +
            "      <name>X_GetServiceCapabilities</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>InstanceID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>ServiceCapabilities</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>X_ServiceCapabilities</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "\n" +
            "    \n" +
            "    <action>\n" +
            "      <name>X_UpdateAudioSelection</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>InstanceID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>AudioPID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>X_AudioPID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>AudioEncoding</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>X_AudioEncoding</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "    <action>\n" +
            "      <name>X_GetAudioSelection</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>InstanceID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>AudioPID</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>X_AudioPID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>AudioEncoding</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>X_AudioEncoding</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "    <action>\n" +
            "      <name>X_UpdateVideoSelection</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>InstanceID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>VideoPID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>X_VideoPID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>VideoEncoding</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>X_VideoEncoding</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "    <action>\n" +
            "      <name>X_GetVideoSelection</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>InstanceID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>VideoPID</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>X_VideoPID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>VideoEncoding</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>X_VideoEncoding</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "\n" +
            "    <action>\n" +
            "      <name>X_SetZoom</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>InstanceID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>x</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_Coordinate</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>y</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_Coordinate</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>w</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_Coordinate</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>h</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_Coordinate</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "\n" +
            "    <action>\n" +
            "      <name>X_GetTVSlideShow</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>InstanceID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>CurrentShowState</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_SlideShowState</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>CurrentThemeId</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_ThemeId</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>TotalThemeNumber</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_TotalThemeNumber</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "    <action>\n" +
            "      <name>X_SetTVSlideShow</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>InstanceID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>CurrentShowState</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_SlideShowState</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>CurrentShowTheme</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_ThemeId</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "\n" +
            "  </actionList>\n" +
            "  <serviceStateTable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>PresetNameList</name> \n" +
            "      <dataType>string</dataType>\n" +
            "      <defaultValue>FactoryDefaults</defaultValue>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"yes\"> \n" +
            "      <name>LastChange</name> \n" +
            "      <dataType>string</dataType>\n" +
            "    </stateVariable>\n" +
            "    \n" +
            "    <stateVariable sendEvents=\"no\"> \n" +
            "      <name>Mute</name>  \n" +
            "      <dataType>boolean</dataType>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\"> \n" +
            "      <name>Volume</name>  \n" +
            "      <dataType>ui2</dataType>\n" +
            "      <allowedValueRange>\n" +
            "        <minimum>0</minimum>\n" +
            "        <maximum>100</maximum>\n" +
            "        <step>1</step>\n" +
            "      </allowedValueRange>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\"> \n" +
            "      <name>A_ARG_TYPE_Channel</name>  \n" +
            "      <dataType>string</dataType>\n" +
            "      <allowedValueList>\n" +
            "        <allowedValue>Master</allowedValue>\n" +
            "      </allowedValueList>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\"> \n" +
            "      <name>A_ARG_TYPE_InstanceID</name>  \n" +
            "      <dataType>ui4</dataType>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>A_ARG_TYPE_PresetName</name>  \n" +
            "      <dataType>string</dataType>\n" +
            "      <allowedValueList>\n" +
            "        <allowedValue>FactoryDefaults</allowedValue>\n" +
            "      </allowedValueList>\n" +
            "    </stateVariable>\n" +
            "\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>X_AspectRatio</name>  \n" +
            "      <dataType>string</dataType>\n" +
            "      <defaultValue>Default</defaultValue>\n" +
            "      <allowedValueList>\n" +
            "        <allowedValue>Default</allowedValue>\n" +
            "        <allowedValue>FitScreen</allowedValue>\n" +
            "      </allowedValueList>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>X_ARG_TYPE_ArcDegreeOffset</name>\n" +
            "      <defaultValue>0.0</defaultValue>\n" +
            "      <dataType>float</dataType>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>X_ARG_TYPE_ScaleFactorOffset</name>\n" +
            "      <dataType>float</dataType>\n" +
            "      <defaultValue>1.0</defaultValue>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>X_ARG_TYPE_CaptionOperation</name>  \n" +
            "      <dataType>string</dataType>\n" +
            "      <allowedValueList>\n" +
            "        <allowedValue>Enable</allowedValue>\n" +
            "        <allowedValue>Disable</allowedValue>\n" +
            "      </allowedValueList>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>X_ARG_TYPE_CaptionName</name>  \n" +
            "      <dataType>string</dataType>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>X_ARG_TYPE_ResourceURI</name>  \n" +
            "      <dataType>string</dataType>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>X_ARG_TYPE_CaptionURI</name>  \n" +
            "      <dataType>string</dataType>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>X_ARG_TYPE_CaptionType</name>  \n" +
            "      <dataType>string</dataType>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>X_ARG_TYPE_Language</name>  \n" +
            "      <dataType>string</dataType>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>X_ARG_TYPE_Encoding</name>  \n" +
            "      <dataType>string</dataType>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>X_Captions</name>  \n" +
            "      <dataType>string</dataType>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>X_EnabledCaptions</name>  \n" +
            "      <dataType>string</dataType>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>X_ServiceCapabilities</name>  \n" +
            "      <dataType>string</dataType>\n" +
            "    </stateVariable>\n" +
            "    \n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>X_AudioPID</name>\n" +
            "      <dataType>ui2</dataType>\n" +
            "      <defaultValue>0</defaultValue>\n" +
            "      <allowedValueRange>\n" +
            "        <minimum>0</minimum>\n" +
            "        <maximum>65535</maximum>\n" +
            "        <step>1</step>\n" +
            "      </allowedValueRange>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>X_AudioEncoding</name>\n" +
            "      <dataType>string</dataType>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>X_VideoPID</name>\n" +
            "      <dataType>ui2</dataType>\n" +
            "      <defaultValue>0</defaultValue>\n" +
            "      <allowedValueRange>\n" +
            "        <minimum>0</minimum>\n" +
            "        <maximum>65535</maximum>\n" +
            "        <step>1</step>\n" +
            "      </allowedValueRange>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>X_VideoEncoding</name>\n" +
            "      <dataType>string</dataType>\n" +
            "    </stateVariable>\n" +
            "\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>A_ARG_TYPE_Coordinate</name>\n" +
            "      <dataType>ui4</dataType>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>A_ARG_TYPE_SlideShowState</name>\n" +
            "      <dataType>boolean</dataType>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>A_ARG_TYPE_ThemeId</name>\n" +
            "      <dataType>ui4</dataType>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>A_ARG_TYPE_TotalThemeNumber</name>\n" +
            "      <dataType>ui4</dataType>\n" +
            "    </stateVariable>\n" +
            "\n" +
            "  </serviceStateTable>\n" +
            "</scpd>\n";

    String connectionManager = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<scpd xmlns=\"urn:schemas-upnp-org:service-1-0\">\n" +
            "  <specVersion>\n" +
            "    <major>1</major>\n" +
            "    <minor>0</minor>\n" +
            "  </specVersion>\n" +
            "  <actionList>\n" +
            "    <action>\n" +
            "      <name>GetCurrentConnectionInfo</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>ConnectionID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_ConnectionID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>RcsID</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_RcsID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>AVTransportID</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_AVTransportID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>ProtocolInfo</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_ProtocolInfo</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>PeerConnectionManager</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_ConnectionManager</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>PeerConnectionID</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_ConnectionID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>Direction</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_Direction</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>Status</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_ConnectionStatus</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "    <action>\n" +
            "      <name>GetProtocolInfo</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>Source</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>SourceProtocolInfo</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>Sink</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>SinkProtocolInfo</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "    <action>\n" +
            "      <name>GetCurrentConnectionIDs</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>ConnectionIDs</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>CurrentConnectionIDs</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "    <action>\n" +
            "      <name>PrepareForConnection</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>RemoteProtocolInfo</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_ProtocolInfo</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>PeerConnectionManager</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_ConnectionManager</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>PeerConnectionID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_ConnectionID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>Direction</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_Direction</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>ConnectionID</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_ConnectionID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>AVTransportID</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_AVTransportID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>RcsID</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_RcsID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "    <action>\n" +
            "      <name>ConnectionComplete</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>ConnectionID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_ConnectionID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "  </actionList>\n" +
            "  <serviceStateTable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>A_ARG_TYPE_ProtocolInfo</name>\n" +
            "      <dataType>string</dataType>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>A_ARG_TYPE_ConnectionStatus</name>\n" +
            "      <dataType>string</dataType>\n" +
            "      <allowedValueList>\n" +
            "        <allowedValue>OK</allowedValue>\n" +
            "        <allowedValue>ContentFormatMismatch</allowedValue>\n" +
            "        <allowedValue>InsufficientBandwidth</allowedValue>\n" +
            "        <allowedValue>UnreliableChannel</allowedValue>\n" +
            "        <allowedValue>Unknown</allowedValue>\n" +
            "      </allowedValueList>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>A_ARG_TYPE_AVTransportID</name>\n" +
            "      <dataType>i4</dataType>\n" +
            "      <defaultValue>0</defaultValue>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>A_ARG_TYPE_RcsID</name>\n" +
            "      <dataType>i4</dataType>\n" +
            "      <defaultValue>0</defaultValue>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>A_ARG_TYPE_ConnectionID</name>\n" +
            "      <dataType>i4</dataType>\n" +
            "      <defaultValue>0</defaultValue>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>A_ARG_TYPE_ConnectionManager</name>\n" +
            "      <dataType>string</dataType>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"yes\">\n" +
            "      <name>SourceProtocolInfo</name>\n" +
            "      <dataType>string</dataType>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"yes\">\n" +
            "      <name>SinkProtocolInfo</name>\n" +
            "      <dataType>string</dataType>\n" +
            "      <defaultValue></defaultValue>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>A_ARG_TYPE_Direction</name>\n" +
            "      <dataType>string</dataType>\n" +
            "      <allowedValueList>\n" +
            "        <allowedValue>Input</allowedValue>\n" +
            "        <allowedValue>Output</allowedValue>\n" +
            "      </allowedValueList>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"yes\">\n" +
            "      <name>CurrentConnectionIDs</name>\n" +
            "      <dataType>string</dataType>\n" +
            "      <defaultValue>0</defaultValue>\n" +
            "    </stateVariable>\n" +
            "  </serviceStateTable>\n" +
            "</scpd>\n";

    public String avtransport = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<scpd xmlns=\"urn:schemas-upnp-org:service-1-0\">\n" +
            "  <specVersion>\n" +
            "    <major>1</major>\n" +
            "    <minor>0</minor>\n" +
            "  </specVersion>\n" +
            "  <actionList>\n" +
            "    <action>\n" +
            "      <name>Play</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>InstanceID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>Speed</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>TransportPlaySpeed</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "    <action>\n" +
            "      <name>Stop</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>InstanceID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "    <action>\n" +
            "      <name>Next</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>InstanceID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "    <action>\n" +
            "      <name>Previous</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>InstanceID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "    <action>\n" +
            "      <name>SetPlayMode</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>InstanceID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>NewPlayMode</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>CurrentPlayMode</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "    <action>\n" +
            "      <name>GetMediaInfo</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>InstanceID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>NrTracks</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>NumberOfTracks</relatedStateVariable>\n" +
            "          <defaultValue>0</defaultValue>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>MediaDuration</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>CurrentMediaDuration</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>CurrentURI</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>AVTransportURI</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>CurrentURIMetaData</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>AVTransportURIMetaData</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>NextURI</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>NextAVTransportURI</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>NextURIMetaData</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>NextAVTransportURIMetaData</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>PlayMedium</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>PlaybackStorageMedium</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>RecordMedium</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>RecordStorageMedium</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>WriteStatus</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>RecordMediumWriteStatus</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "    <action>\n" +
            "      <name>GetDeviceCapabilities</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>InstanceID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>PlayMedia</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>PossiblePlaybackStorageMedia</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>RecMedia</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>PossibleRecordStorageMedia</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>RecQualityModes</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>PossibleRecordQualityModes</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "    <action>\n" +
            "      <name>SetAVTransportURI</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>InstanceID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>CurrentURI</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>AVTransportURI</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>CurrentURIMetaData</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>AVTransportURIMetaData</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "    <action>\n" +
            "      <name>SetNextAVTransportURI</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>InstanceID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>NextURI</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>NextAVTransportURI</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>NextURIMetaData</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>NextAVTransportURIMetaData</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "\n" +
            "    <action>\n" +
            "      <name>X_PrefetchURI</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>InstanceID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>PrefetchURI</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_PrefetchURI</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>PrefetchURIMetaData</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_PrefetchURIMetaData</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "\n" +
            "    <action>\n" +
            "      <name>GetTransportSettings</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>InstanceID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>PlayMode</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>CurrentPlayMode</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>RecQualityMode</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>CurrentRecordQualityMode</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "    <action>\n" +
            "      <name>GetTransportInfo</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>InstanceID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>CurrentTransportState</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>TransportState</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>CurrentTransportStatus</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>TransportStatus</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>CurrentSpeed</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>TransportPlaySpeed</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "    <action>\n" +
            "      <name>Pause</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>InstanceID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "    <action>\n" +
            "      <name>Seek</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>InstanceID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>Unit</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_SeekMode</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>Target</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_SeekTarget</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "    <action>\n" +
            "      <name>GetPositionInfo</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>InstanceID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>Track</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>CurrentTrack</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>TrackDuration</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>CurrentTrackDuration</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>TrackMetaData</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>CurrentTrackMetaData</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>TrackURI</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>CurrentTrackURI</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>RelTime</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>RelativeTimePosition</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>AbsTime</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>AbsoluteTimePosition</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>RelCount</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>RelativeCounterPosition</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>AbsCount</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>AbsoluteCounterPosition</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "    \n" +
            "    <action>\n" +
            "      <name>GetCurrentTransportActions</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>InstanceID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>Actions</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>CurrentTransportActions</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "    <action>\n" +
            "      <name>X_DLNA_GetBytePositionInfo</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>InstanceID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>TrackSize</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>X_DLNA_CurrentTrackSize</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>RelByte</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>X_DLNA_RelativeBytePosition</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>AbsByte</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>X_DLNA_AbsoluteBytePosition</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "    <action>\n" +
            "      <name>X_GetStoppedReason</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>InstanceID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>StoppedReason</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_StoppedReason</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>StoppedReasonData</name>\n" +
            "          <direction>out</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_StoppedReasonData</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "\n" +
            "    <action>\n" +
            "      <name>X_PlayerAppHint</name>\n" +
            "      <argumentList>\n" +
            "        <argument>\n" +
            "          <name>InstanceID</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>UpnpClass</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>X_ARG_TYPE_UpnpClass</relatedStateVariable>\n" +
            "        </argument>\n" +
            "        <argument>\n" +
            "          <name>PlayerHint</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>X_ARG_TYPE_PlayerHint</relatedStateVariable>\n" +
            "        </argument>\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "\n" +
            "  </actionList>\n" +
            "   \n" +
            "  <serviceStateTable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>TransportState</name>\n" +
            "      <dataType>string</dataType>\n" +
            "      <allowedValueList>\n" +
            "        <allowedValue>STOPPED</allowedValue>\n" +
            "        <allowedValue>PAUSED_PLAYBACK</allowedValue>\n" +
            "        <allowedValue>PLAYING</allowedValue>\n" +
            "        <allowedValue>TRANSITIONING</allowedValue>\n" +
            "        <allowedValue>NO_MEDIA_PRESENT</allowedValue>\n" +
            "      </allowedValueList>\n" +
            "      <defaultValue>NO_MEDIA_PRESENT</defaultValue>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>TransportStatus</name>\n" +
            "      <dataType>string</dataType>\n" +
            "      <allowedValueList>\n" +
            "        <allowedValue>OK</allowedValue>\n" +
            "        <allowedValue>ERROR_OCCURRED</allowedValue>\n" +
            "      </allowedValueList>\n" +
            "      <defaultValue>OK</defaultValue>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>TransportPlaySpeed</name>\n" +
            "      <dataType>string</dataType>\n" +
            "      <defaultValue>1</defaultValue>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>NumberOfTracks</name>\n" +
            "      <dataType>ui4</dataType>\n" +
            "      <allowedValueRange>\n" +
            "        <minimum>0</minimum>\n" +
            "        <maximum>4294967295</maximum>\n" +
            "      </allowedValueRange>\n" +
            "      <defaultValue>0</defaultValue>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>CurrentMediaDuration</name>\n" +
            "      <dataType>string</dataType>\n" +
            "      <defaultValue>00:00:00</defaultValue>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>AVTransportURI</name>\n" +
            "      <dataType>string</dataType>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>AVTransportURIMetaData</name>\n" +
            "      <dataType>string</dataType>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>PlaybackStorageMedium</name>\n" +
            "      <dataType>string</dataType>\n" +
            "      <allowedValueList>\n" +
            "        <allowedValue>NONE</allowedValue>\n" +
            "        <allowedValue>NETWORK</allowedValue>\n" +
            "      </allowedValueList>\n" +
            "      <defaultValue>NONE</defaultValue>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>CurrentTrack</name>\n" +
            "      <dataType>ui4</dataType>\n" +
            "      <allowedValueRange>\n" +
            "        <minimum>0</minimum>\n" +
            "        <maximum>4294967295</maximum>\n" +
            "        <step>1</step>\n" +
            "      </allowedValueRange>\n" +
            "      <defaultValue>0</defaultValue>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>CurrentTrackDuration</name>\n" +
            "      <dataType>string</dataType>\n" +
            "      <defaultValue>00:00:00</defaultValue>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>CurrentTrackMetaData</name>\n" +
            "      <dataType>string</dataType>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>CurrentTrackURI</name>\n" +
            "      <dataType>string</dataType>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>RelativeTimePosition</name>\n" +
            "      <dataType>string</dataType>\n" +
            "      <defaultValue>00:00:00</defaultValue>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>AbsoluteTimePosition</name>\n" +
            "      <dataType>string</dataType>\n" +
            "      <defaultValue>00:00:00</defaultValue>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>NextAVTransportURI</name>\n" +
            "      <dataType>string</dataType>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>NextAVTransportURIMetaData</name>\n" +
            "      <dataType>string</dataType>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>CurrentTransportActions</name>\n" +
            "      <dataType>string</dataType>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>RecordStorageMedium</name>\n" +
            "      <dataType>string</dataType>\n" +
            "      <allowedValueList>\n" +
            "        <allowedValue>NOT_IMPLEMENTED</allowedValue>\n" +
            "      </allowedValueList>\n" +
            "      <defaultValue>NOT_IMPLEMENTED</defaultValue>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>RecordMediumWriteStatus</name>\n" +
            "      <dataType>string</dataType>\n" +
            "      <allowedValueList>\n" +
            "        <allowedValue>NOT_IMPLEMENTED</allowedValue>\n" +
            "      </allowedValueList>\n" +
            "      <defaultValue>NOT_IMPLEMENTED</defaultValue>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>RelativeCounterPosition</name>\n" +
            "      <dataType>i4</dataType>\n" +
            "      <defaultValue>2147483647</defaultValue>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>AbsoluteCounterPosition</name>\n" +
            "      <dataType>i4</dataType>\n" +
            "      <defaultValue>2147483647</defaultValue>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>PossiblePlaybackStorageMedia</name>\n" +
            "      <dataType>string</dataType>\n" +
            "      <defaultValue>NETWORK</defaultValue>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>PossibleRecordStorageMedia</name>\n" +
            "      <dataType>string</dataType>\n" +
            "      <defaultValue>NOT_IMPLEMENTED</defaultValue>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>PossibleRecordQualityModes</name>\n" +
            "      <dataType>string</dataType>\n" +
            "      <defaultValue>NOT_IMPLEMENTED</defaultValue>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>CurrentPlayMode</name>\n" +
            "      <dataType>string</dataType>\n" +
            "      <allowedValueList>\n" +
            "        <allowedValue>NORMAL</allowedValue>\n" +
            "      </allowedValueList>\n" +
            "      <defaultValue>NORMAL</defaultValue>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>CurrentRecordQualityMode</name>\n" +
            "      <dataType>string</dataType>\n" +
            "      <allowedValueList>\n" +
            "        <allowedValue>NOT_IMPLEMENTED</allowedValue>\n" +
            "      </allowedValueList>\n" +
            "      <defaultValue>NOT_IMPLEMENTED</defaultValue>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"yes\">\n" +
            "      <name>LastChange</name>\n" +
            "      <dataType>string</dataType>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>A_ARG_TYPE_InstanceID</name>\n" +
            "      <dataType>ui4</dataType>\n" +
            "    </stateVariable>\n" +
            "\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>A_ARG_TYPE_PrefetchURI</name>\n" +
            "      <dataType>string</dataType>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>A_ARG_TYPE_PrefetchURIMetaData</name>\n" +
            "      <dataType>string</dataType>\n" +
            "    </stateVariable>\n" +
            " \n" +
            "   <stateVariable sendEvents=\"no\">\n" +
            "      <name>A_ARG_TYPE_SeekMode</name>\n" +
            "      <dataType>string</dataType>\n" +
            "      <allowedValueList>\n" +
            "        <allowedValue>TRACK_NR</allowedValue>\n" +
            "        <allowedValue>REL_TIME</allowedValue>\n" +
            "        <allowedValue>ABS_TIME</allowedValue>\n" +
            "        <allowedValue>ABS_COUNT</allowedValue>\n" +
            "        <allowedValue>REL_COUNT</allowedValue>\n" +
            "        <allowedValue>X_DLNA_REL_BYTE</allowedValue>\n" +
            "        <allowedValue>FRAME</allowedValue>\n" +
            "      </allowedValueList>\n" +
            "      <defaultValue>REL_TIME</defaultValue>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>A_ARG_TYPE_SeekTarget</name>\n" +
            "      <dataType>string</dataType>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>X_DLNA_RelativeBytePosition</name>\n" +
            "      <dataType>string</dataType>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>X_DLNA_AbsoluteBytePosition</name>\n" +
            "      <dataType>string</dataType>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>X_DLNA_CurrentTrackSize</name>\n" +
            "      <dataType>string</dataType>\n" +
            "    </stateVariable>\n" +
            "\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>A_ARG_TYPE_StoppedReason</name>\n" +
            "      <dataType>string</dataType>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>A_ARG_TYPE_StoppedReasonData</name>\n" +
            "      <dataType>string</dataType>\n" +
            "    </stateVariable>\n" +
            "\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>X_ARG_TYPE_UpnpClass</name>\n" +
            "      <dataType>string</dataType>\n" +
            "      <allowedValueList>\n" +
            "        <allowedValue>object.item.imageItem</allowedValue>\n" +
            "        <allowedValue>object.item.audioItem</allowedValue>\n" +
            "        <allowedValue>object.item.videoItem</allowedValue>\n" +
            "      </allowedValueList>\n" +
            "    </stateVariable>\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>X_ARG_TYPE_PlayerHint</name>\n" +
            "      <dataType>string</dataType>\n" +
            "      <allowedValueList>\n" +
            "        <allowedValue>load</allowedValue>\n" +
            "        <allowedValue>unload</allowedValue>\n" +
            "      </allowedValueList>\n" +
            "    </stateVariable>\n" +
            "\n" +
            "  </serviceStateTable>\n" +
            "</scpd>\n";

    public String streamSplicing = "<?xml version=\"1.0\"?>\n" +
            "<scpd xmlns=\"urn:schemas-upnp-org:service-1-0\">\n" +
            "  <specVersion>\n" +
            "    <major>1</major>\n" +
            "    <minor>0</minor>\n" +
            "  </specVersion>\n" +
            "  <actionList>\n" +
            "    <action>  \n" +
            "      <name>SetBreakAuxStreamPlaylist</name>\n" +
            "      <argumentList>\n" +
            "\n" +
            "        <argument>\n" +
            "          <name>BreakId</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_Int</relatedStateVariable>\n" +
            "        </argument>\n" +
            "\n" +
            "        <argument>\n" +
            "          <name>BreakSpliceOutPosition</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_String</relatedStateVariable>\n" +
            "        </argument>\n" +
            "\n" +
            "        <argument>\n" +
            "          <name>ExpirationTime</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_String</relatedStateVariable>\n" +
            "        </argument>\n" +
            "\n" +
            "        <argument>\n" +
            "          <name>AuxStreamPlaylist</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_String</relatedStateVariable>\n" +
            "        </argument>\n" +
            "\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "\n" +
            "    <action>\n" +
            "      <name>SetBreakAuxStreamTrigger</name>\n" +
            "      <argumentList>\n" +
            "\n" +
            "        <argument>\n" +
            "          <name>BreakId</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_Int</relatedStateVariable>\n" +
            "        </argument>\n" +
            "\n" +
            "        <argument>\n" +
            "          <name>BreakTriggerHigh</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_Int</relatedStateVariable>\n" +
            "        </argument>\n" +
            "\n" +
            "        <argument>\n" +
            "          <name>BreakTriggerLow</name>\n" +
            "          <direction>in</direction>\n" +
            "          <relatedStateVariable>A_ARG_TYPE_Int</relatedStateVariable>\n" +
            "        </argument>\n" +
            "\n" +
            "      </argumentList>\n" +
            "    </action>\n" +
            "\n" +
            "  </actionList>\n" +
            "\n" +
            "  <serviceStateTable>\n" +
            "\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>A_ARG_TYPE_Int</name>  \n" +
            "      <dataType>ui4</dataType>\n" +
            "      <defaultValue>0</defaultValue>\n" +
            "    </stateVariable>\n" +
            "\n" +
            "    <stateVariable sendEvents=\"no\">\n" +
            "      <name>A_ARG_TYPE_String</name>  \n" +
            "      <dataType>string</dataType>\n" +
            "    </stateVariable>\n" +
            "\n" +
            "    <stateVariable sendEvents=\"yes\">\n" +
            "      <name>NewSpliceActivity</name>\n" +
            "      <dataType>string</dataType>\n" +
            "    </stateVariable>\n" +
            "\n" +
            "  </serviceStateTable>\n" +
            "</scpd>\n";

    public String upnpControlConnectoinManager = "<?xml version=\"1.0\"?><s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\" s:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\"><s:Body><s:Fault><faultcode>s:Client</faultcode><faultstring>UPnPError</faultstring><detail><UPnPError xmlns=\"urn:schemas-upnp-org:control-1-0\"><errorCode>402</errorCode><errorDescription>Invalid Args</errorDescription></UPnPError></detail></s:Fault></s:Body></s:Envelope>";

    public NanoHTTPD.Response response(NanoHTTPD.IHTTPSession session) {
        if (session.getUri().equals("/dmr")) {
            return NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.OK, "text/xml", dmr);
        } else if (session.getUri().equals("/RenderingControl_1.xml")) {
            return NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.OK, "text/xml", renderingControl);
        } else if (session.getUri().equals("/ConnectionManager_1.xml")) {
            return NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.OK, "text/xml", connectionManager);
        } else if (session.getUri().equals("/AVTransport_1.xml")) {
            return NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.OK, "text/xml", avtransport);
        } else if (session.getUri().equals("/StreamSplicing_1.xml")) {
            return NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.OK, "text/xml", streamSplicing);
        } else if (session.getUri().equals("/upnp/control/ConnectionManager1")) {
            return NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.OK, "text/xml", upnpControlConnectoinManager);
        }
        String msg = "[NOT HANDLED] " + session.getUri();
        Log.e(TAG, msg);
        return NanoHTTPD.newFixedLengthResponse(msg);
    }

}
