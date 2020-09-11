package org.jhapps;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@Validated
@Component
@ConfigurationProperties
public class StravaAuthenticatorConfiguration {

    @NotEmpty
    private String clientID;

    @NotEmpty
    private String clientSecret;

    @NotEmpty
    private String applicationUri;

    @NotEmpty
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
