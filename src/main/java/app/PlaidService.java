package app;

import com.plaid.client.PlaidClient;
import com.plaid.client.model.paymentinitiation.Address;
import com.plaid.client.model.paymentinitiation.Amount;
import com.plaid.client.request.LinkTokenCreateRequest;
import com.plaid.client.request.SandboxPublicTokenCreateRequest;
import com.plaid.client.request.common.Product;
import com.plaid.client.request.paymentinitiation.PaymentCreateRequest;
import com.plaid.client.request.paymentinitiation.PaymentTokenCreateRequest;
import com.plaid.client.request.paymentinitiation.RecipientCreateRequest;
import com.plaid.client.request.paymentinitiation.RecipientGetRequest;
import com.plaid.client.response.SandboxPublicTokenCreateResponse;
import com.plaid.client.response.paymentinitiation.PaymentCreateResponse;
import com.plaid.client.response.paymentinitiation.PaymentTokenCreateResponse;
import com.plaid.client.response.paymentinitiation.RecipientCreateResponse;
import com.plaid.client.response.paymentinitiation.RecipientGetResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

@Service
public class PlaidService {

    private String plaidSecret = "2122dcbde9b2bef2006c839f89995c";

    private String plaidPublicKey = "2";

    private String plaidEnv = "4";


    public PlaidClient plaidClient() {
        String plaidClientId = "5f16008048339d00117abbaa";
        PlaidClient.Builder clientBuilder = PlaidClient.newBuilder()
                .clientIdAndSecret(plaidClientId, plaidSecret);

        switch (plaidEnv.toLowerCase()) {
            case "sandbox":
                clientBuilder.sandboxBaseUrl();
                break;
            case "development":
                clientBuilder.developmentBaseUrl();
                break;
            case "production":
                clientBuilder.productionBaseUrl();
                break;
            default:
                clientBuilder.sandboxBaseUrl();
        }

        return clientBuilder.build();
    }
   public String getPublicToken(String institution) throws IOException {
       Response<SandboxPublicTokenCreateResponse> createItemResp =
               this.plaidClient().service()
                       .sandboxPublicTokenCreate
                               (new SandboxPublicTokenCreateRequest(institution, Collections.singletonList(Product.AUTH)))
                       .execute();
        return createItemResp.body().getPublicToken();
   }

   public String createRecipient(String name, String iBan, Address address) throws IOException {
       Response<RecipientCreateResponse> recipientCreateResponseResponse =
               plaidClient().service().
                       recipientCreate(new RecipientCreateRequest(name, iBan, address))
                       .execute();
        return recipientCreateResponseResponse.body().getRecipientId();
   }

   public String getRecipient(String recipientId) throws IOException {
       Response<RecipientGetResponse> recipientGetResponseResponse =
               plaidClient().service().
                       recipientGet(new RecipientGetRequest(recipientId))
                       .execute();
return recipientGetResponseResponse.body().getRecipientId();
   }

   public String createPayment(String recipientId, String reference, String currency, Double value) throws IOException {
       Response<PaymentCreateResponse> paymentCreateRequestResponse =
               plaidClient().service().
                       paymentCreate
                               (new PaymentCreateRequest(recipientId, reference, new Amount(currency, value)))
                       .execute();
return paymentCreateRequestResponse.body().getPaymentId();
   }

   public String getPayentToken(String paymentId) throws IOException {
       Response<PaymentTokenCreateResponse> paymentCreateResponseRespons =
               plaidClient().service().
                       paymentTokenCreate(new PaymentTokenCreateRequest(paymentId))
                       .execute();
return paymentCreateResponseRespons.body().getPaymentToken();
   }

   public void createLink(User user) throws IOException {
       Response response = plaidClient().service().linkTokenCreate(new LinkTokenCreateRequest(new LinkTokenCreateRequest.User(user.getId().toString()), "name", new ArrayList<String>(Collections.singleton("transactions")), new ArrayList<String>(Collections.singleton("US")), "en")).execute();
       System.out.println(response);
       System.out.println(response.raw());
       System.out.println(response.errorBody());
   }

}
