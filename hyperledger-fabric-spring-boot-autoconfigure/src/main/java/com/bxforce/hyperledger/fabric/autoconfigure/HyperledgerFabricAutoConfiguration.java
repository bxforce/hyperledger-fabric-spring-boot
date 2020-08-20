package com.bxforce.hyperledger.fabric.autoconfigure;

import org.hyperledger.fabric.gateway.Gateway;
import org.hyperledger.fabric.gateway.Network;
import org.hyperledger.fabric.sdk.security.CryptoSuite;
import org.hyperledger.fabric_ca.sdk.HFCAClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Properties;

@EnableConfigurationProperties(HyperledgerFabricCAClientProperties.class)
@Configuration
public class HyperledgerFabricAutoConfiguration {
    @Autowired
    private HyperledgerFabricCAClientProperties hyperledgerFabricCAClientProperties;

    @Autowired
    private HyperledgerFabricGatewayBuilderProperties hyperledgerFabricGatewayBuilderProperties;

    @Bean
    public HFCAClient HFCAClientFactory() throws Exception {
        Properties props = new Properties();

        props.setProperty("pemFile", hyperledgerFabricCAClientProperties.getPemFile());
        props.put("allowAllHostNames", hyperledgerFabricCAClientProperties.isAllowAllHostNames());

        CryptoSuite cryptoSuite = CryptoSuite.Factory.getCryptoSuite();
        HFCAClient caClient = HFCAClient.createNewInstance(
                hyperledgerFabricCAClientProperties.getName(),
                hyperledgerFabricCAClientProperties.getUrl(),
                props
        );
        caClient.setCryptoSuite(cryptoSuite);

        return caClient;
    }

    @Bean
    public Gateway.Builder builderFactory() throws IOException {
        Gateway.Builder builder = Gateway.createBuilder();

        builder
                .discovery(hyperledgerFabricGatewayBuilderProperties.isDiscovery())
                .networkConfig(hyperledgerFabricGatewayBuilderProperties.getNetworkConfig());

        return builder;
    }
}