package io.github.doorbash.casthoneypot.net.impl;

import fi.iki.elonen.NanoHTTPD;

public abstract class HttpServerImpl {
    public abstract NanoHTTPD.Response response(NanoHTTPD.IHTTPSession session);
}
