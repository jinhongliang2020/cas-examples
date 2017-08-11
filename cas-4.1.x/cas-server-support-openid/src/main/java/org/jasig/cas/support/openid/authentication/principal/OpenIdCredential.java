/*
 * Licensed to Apereo under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Apereo licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License.  You may obtain a
 * copy of the License at the following location:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jasig.cas.support.openid.authentication.principal;

import org.jasig.cas.authentication.Credential;

/**
 * @author Scott Battaglia
 * @since 3.1
 */
public final class OpenIdCredential implements Credential {

    private static final long serialVersionUID = -6535869729412406133L;

    private final String ticketGrantingTicketId;

    private final String username;

    /**
     * Instantiates a new OpenID credential.
     *
     * @param ticketGrantingTicketId the ticket granting ticket id
     * @param username the username
     */
    public OpenIdCredential(final String ticketGrantingTicketId, final String username) {
        this.ticketGrantingTicketId = ticketGrantingTicketId;
        this.username = username;
    }

    public String getTicketGrantingTicketId() {
        return this.ticketGrantingTicketId;
    }

    public String getUsername() {
        return this.username;
    }

    @Override
    public String getId() {
        return this.username;
    }

    @Override
    public String toString() {
        return this.username;
    }

}
