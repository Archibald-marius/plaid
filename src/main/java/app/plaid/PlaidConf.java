//package com.tcg.plaid;
//
//import com.plaid.client.PlaidClient;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class PlaidConf {
//
//    @Value("${PLAID_CLIENT_ID}")
//    private String plaidClientId;
//
//    @Value("${PLAID_SECRET}")
//    private String plaidSecret;
//
//    @Value("${PLAID_PUBLIC_KEY}")
//    private String plaidPublicKey = "2";
//
//    @Value("#{systemProperties['PLAID_ENV'] ?: 'sandbox'}")
//    private String plaidEnv = "4";
//
//
//    @Bean
//    public PlaidClient plaidClient() {
//        PlaidClient.Builder clientBuilder = PlaidClient.newBuilder()
//                .clientIdAndSecret(plaidClientId, plaidSecret);
//
//        switch (plaidEnv.toLowerCase()) {
//            case "sandbox":
//                clientBuilder.sandboxBaseUrl();
//                break;
//            case "development":
//                clientBuilder.developmentBaseUrl();
//                break;
//            case "production":
//                clientBuilder.productionBaseUrl();
//                break;
//            default:
//                clientBuilder.sandboxBaseUrl();
//        }
//
//        return clientBuilder.build();
//    }
//}
//
