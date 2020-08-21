package com.bxforce.hyperledger.fabric.autoconfigure;

import org.hyperledger.fabric.gateway.Gateway;
import org.hyperledger.fabric.gateway.Network;
import org.hyperledger.fabric.sdk.security.CryptoSuite;
import org.hyperledger.fabric_ca.sdk.HFCAClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Properties;

@EnableConfigurationProperties({HyperledgerFabricCAClientProperties.class, HyperledgerFabricGatewayBuilderProperties.class})
@Configuration
public class HyperledgerFabricAutoConfiguration {
    @Autowired
    private HyperledgerFabricCAClientProperties hyperledgerFabricCAClientProperties;

    @Autowired
    private HyperledgerFabricGatewayBuilderProperties hyperledgerFabricGatewayBuilderProperties;

    @Bean
    @ConditionalOnProperty(prefix = "hyperledger-fabric.ca-client", name = {"name", "url", "pemFile", "allowAllHostNames"})
    public HFCAClient HFCAClientFactory() throws Exception {
        Properties properties = new Properties();

        properties.setProperty("pemFile", hyperledgerFabricCAClientProperties.getPemFile());
        properties.put("allowAllHostNames", hyperledgerFabricCAClientProperties.isAllowAllHostNames());

        CryptoSuite cryptoSuite = CryptoSuite.Factory.getCryptoSuite();
        HFCAClient caClient = HFCAClient.createNewInstance(
                hyperledgerFabricCAClientProperties.getName(),
                hyperledgerFabricCAClientProperties.getUrl(),
                properties
        );
        caClient.setCryptoSuite(cryptoSuite);

        return caClient;
    }

    @Bean
    @ConditionalOnProperty(prefix = "hyperledger-fabric.gateway", name = {"discovery", "networkConfig"})
    public Gateway.Builder gatewayBuilderFactory() throws IOException {
        Gateway.Builder builder = Gateway.createBuilder();

        builder
                .discovery(hyperledgerFabricGatewayBuilderProperties.isDiscovery())
                .networkConfig(hyperledgerFabricGatewayBuilderProperties.getNetworkConfig());

        return builder;
    }
}