package org.jhapps;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
public class StravaAuthenticatorConfiguration {

    private String clientID;
    private String clientSecret;
    private String applicationUri;
    private String stravaUri;

    public String getClientID() {
        return clientID;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getApplicationUri() {
        return applicationUri;
    }

    public String getStravaUri() {
        return stravaUri;
    }

    @Deprecated
    public void setStravaUri(String stravaUri) {
        this.stravaUri = stravaUri;
    }

    @Deprecated
    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    @Deprecated
    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    @Deprecated
    public void setApplicationUri(String applicationUri) {
        this.applicationUri = applicationUri;
    }
}
