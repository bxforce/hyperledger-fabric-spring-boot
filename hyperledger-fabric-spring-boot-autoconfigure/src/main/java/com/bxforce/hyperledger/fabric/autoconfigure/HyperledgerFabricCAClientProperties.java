package com.bxforce.hyperledger.fabric.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("hyperledger-fabric.ca-client")
public class HyperledgerFabricCAClientProperties {
    private String name;
    private String url;
    private String pemFile;
    private boolean allowAllHostNames;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPemFile() {
        return pemFile;
    }

    public void setPemFile(String pemFile) {
        this.pemFile = pemFile;
    }

    public boolean isAllowAllHostNames() {
        return allowAllHostNames;
    }

    public void setAllowAllHostNames(boolean allowAllHostNames) {
        this.allowAllHostNames = allowAllHostNames;
    }
}
