package com.bxforce.hyperledger.fabric.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.nio.file.Path;

@ConfigurationProperties("hyperledger-fabric.gateway")
public class HyperledgerFabricGatewayBuilderProperties {
    private boolean discovery;
    private Path networkConfig;

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
}
