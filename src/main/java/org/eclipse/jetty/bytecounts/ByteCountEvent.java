//
//  ========================================================================
//  Copyright (c) 1995-2021 Mort Bay Consulting Pty Ltd and others.
//  ------------------------------------------------------------------------
//  All rights reserved. This program and the accompanying materials
//  are made available under the terms of the Eclipse Public License v1.0
//  and Apache License v2.0 which accompanies this distribution.
//
//      The Eclipse Public License is available at
//      http://www.eclipse.org/legal/epl-v10.html
//
//      The Apache License v2.0 is available at
//      http://www.opensource.org/licenses/apache2.0.php
//
//  You may elect to redistribute this code under either of these licenses.
//  ========================================================================
//

package org.eclipse.jetty.bytecounts;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Response;

public interface ByteCountEvent
{
    Request getRequest();

    Response getResponse();

    boolean hasFailure();

    Throwable getRequestFailure();

    Throwable getResponseFailure();

    // TODO: do we care about upgraded connections?
    // TODO: what about the TLS bytes? (SSLConnection bytesIn / bytesOut?)
    // TODO: what about HTTP/2 ?  (what about non-stream frames? settings, window-updates, reset, etc)

    interface HttpByteCount
    {
        long getHeaderCount();

        long getBodyCount();

        long getStreamAPICount();

        long getTrailerCount();
    }

    HttpByteCount getRequestCount();

    HttpByteCount getResponseCount();
}
