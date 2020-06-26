package io.github.doorbash.casthoneypot.net;

import android.util.Log;

import java.io.IOException;
import java.util.Map;

import fi.iki.elonen.NanoHTTPD;
import io.github.doorbash.casthoneypot.net.impl.HttpServerImpl;

public class HttpServer extends NanoHTTPD {

    public static final String TAG = "HttpServerRunnable";

    private int port;
    private HttpServerImpl impl;

    public HttpServer(int port, HttpServerImpl impl) {
        super(port);
        this.port = port;
        this.impl = impl;
        try {
            start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
        } catch (Exception e) {
            Log.d(TAG, e.getLocalizedMessage());
        }
        System.out.println("\nRunning! Point your browsers to http://localhost:" + port + "/ \n");
    }

    @Override
    public Response serve(IHTTPSession session) {
        Map<String, String> headers = session.getHeaders();
        String msg = headers.get("remote-addr") + ":" + port + session.getUri() + "\n\n";
        msg += "headers : \n\n " + session.getHeaders() + "\n\n";
        msg += "parms \n\n " + session.getParms().toString() + "\n\n";
        Log.d(TAG, msg);
        if (impl == null) return newFixedLengthResponse("no handler");
        return impl.response(session);
    }
}
