package com.bxforce.hyperledger.fabric.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.nio.file.Path;

@ConfigurationProperties("hyperledger-fabric.gateway")
public class HyperledgerFabricGatewayBuilderProperties {
    private boolean discovery = true;
    private Path networkConfig;
    private String walletPath;
    private String identityId;

    public boolean isDiscovery() {
        return discovery;
    }

    public void setDiscovery(boolean discovery) {
        this.discovery = discovery;
    }

    public Path getNetworkConfig() {
        return networkConfig;
    }

    public void setNetworkConfig(Path networkConfig) {
        this.networkConfig = networkConfig;
    }

    public String getWalletPath() {
        return walletPath;
    }

    public void setWalletPath(String walletPath) {
        this.walletPath = walletPath;
    }

    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }
}
