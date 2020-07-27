package app;

import com.plaid.client.request.*;
import com.plaid.client.request.common.Product;
import com.plaid.client.response.*;
import com.tcg.plaid.PlSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.plaid.client.PlaidClient;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import retrofit2.Response;

import java.util.*;


import java.io.IOException;

@RestController
public class PlaidController {

    @Autowired
    private Environment env;

    @Autowired
    private  PlSer authService;

    @Autowired
    private PlaidService plaidService;



    /**
     * Home page.
     */
    @RequestMapping(value="/123", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public String index() throws IOException {


        return "Done";
    }

//        PlaidClient plaidClient1 = PlaidClient.newBuilder()
//                .clientIdAndSecret("5f16008048339d00117abbaa", "f96ece607adec57a7c816b15acc932")
//                .sandboxBaseUrl() // or equivalent, depending on which environment you're calling into
//                .build();
//        System.out.println(plaidClient1.service().toString());


//        System.out.println(this.plaidClient.service().sandboxPublicTokenCreate(new SandboxPublicTokenCreateRequest("ins_3", Collections.singletonList(Product.AUTH))).request().toString());
//        Response<SandboxPublicTokenCreateResponse> createItemResp = this.plaidClient.service().sandboxPublicTokenCreate(new SandboxPublicTokenCreateRequest("ins_3", Collections.singletonList(Product.AUTH))).execute();
//        System.out.println(createItemResp.body().getPublicToken());
//
//        Response<RecipientCreateResponse> recipientCreateResponseResponse = plaidClient1.service().recipientCreate(new RecipientCreateRequest("name", "UA25234234", new Address(Collections.singletonList("wefwe"), "Frf", "12121", "RE"))).execute();
//        System.out.println(recipientCreateResponseResponse.errorBody().string());
//        Response<RecipientGetResponse> recipientGetResponseResponse = plaidClient1.service().recipientGet(new RecipientGetRequest("444444")).execute();
//
//        Response<PaymentCreateResponse> paymentCreateRequestResponse = plaidClient1.service().paymentCreate(new PaymentCreateRequest("123123", "money", new Amount("USD", 3.3))).execute();
//
//        Response<PaymentTokenCreateResponse> paymentCreateResponseRespons = plaidClient1.service().paymentTokenCreate(new PaymentTokenCreateRequest("123123")).execute();


        //        System.out.println(plaidClient.service().itemPublicTokenExchange(new ItemPublicTokenExchangeRequest(new SandboxPublicTokenCreateRequest("1", Collections.singletonList(Product.INCOME)).toString())).execute().toString());
//        model.addAttribute("PLAID_PUBLIC_KEY", env.getProperty("PLAID_PUBLIC_KEY"));
//        model.addAttribute("PLAID_ENV", env.getProperty("PLAID_ENV"));
        //System.out.println(new SandboxPublicTokenCreateRequest("ins_3", Collections.singletonList(Product.AUTH)).toString());
//        return createItemResp.body().getPublicToken();
//    }

//    @RequestMapping(value="/1", method = RequestMethod.GET)
//    public ItemCreateResponse getPublicToken(Model model) throws IOException {
//
//        Response<ItemPublicTokenCreateResponse> createItemResp =
//                plaidClient.service().itemPublicTokenCreate(new ItemPublicTokenCreateRequest(createItemCreateResponse(plaidClient).getAccessToken())).execute();
//
//        public ItemCreateResponse createItemCreateResponse (PlaidClient client) throws Exception {
//            Response<ItemGetRequest> response =
//                    this.plaidClient.service()
//                            .itemCreate(new ItemCreateRequest(
//                                    "ins_109511",
//                                    Arrays.asList(Product.INCOME))
//                                    .withCredentials("username", "user_good")
//                                    .withCredentials("password", "pass_good")).execute();
//            return response.body();
//        }
//    }

    /**
     * Exchange link public token for access token.
     */
//    @RequestMapping(value="/get_access_token", method=RequestMethod.POST)
//    public ResponseEntity getAccessToken() throws Exception {
//        String publicToken = index();
//        Response<ItemPublicTokenExchangeResponse> response = this.plaidClient.service()
//                .itemPublicTokenExchange(new ItemPublicTokenExchangeRequest(publicToken))
//                .execute();
//
//        this.plaidClient.service().sandboxPublicTokenCreate(new SandboxPublicTokenCreateRequest("1", Collections.singletonList(Product.INCOME)));
//        System.out.println(response.body().getAccessToken());
//        if (response.isSuccessful()) {
//            this.authService.setAccessToken(response.body().getAccessToken());
//            this.authService.setItemId(response.body().getItemId());
//
//            Map<String, Object> data = new HashMap<>();
//            data.put("error", false);
//
//            return ResponseEntity.ok(data);
//        } else {
//            return ResponseEntity.status(500).body(getErrorResponseData(response.errorBody().string()));
//        }
//    }
//
//
//    @RequestMapping(value="/accounts", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
//    public @ResponseBody ResponseEntity getAccount() throws Exception {
//        if (authService.getAccessToken() == null) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//                    .body(getErrorResponseData("Not authorized"));
//        }
//
//        Response<AuthGetResponse> response = this.plaidClient.service()
//                .authGet(new AuthGetRequest(this.authService.getAccessToken())).execute();
//
//        if (response.isSuccessful()) {
//            Map<String, Object> data = new HashMap<>();
//            data.put("error", false);
//            data.put("accounts", response.body().getAccounts());
//            data.put("numbers", response.body().getNumbers());
//
//            return ResponseEntity.ok(data);
//        } else {
//            Map<String, Object> data = new HashMap<>();
//            data.put("error", "Unable to pull accounts from the Plaid API.");
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(data);
//        }
//    }
//
//
//    @RequestMapping(value="/item", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
//    public @ResponseBody ResponseEntity getItem() throws Exception {
//        if (authService.getAccessToken() == null) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//                    .body(getErrorResponseData("Not authorized"));
//        }
//
//        Response<ItemGetResponse> itemResponse = this.plaidClient.service()
//                .itemGet(new ItemGetRequest(this.authService.getAccessToken()))
//                .execute();
//
//        if (!itemResponse.isSuccessful()) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body(getErrorResponseData("Unable to pull item information from the Plaid API."));
//        } else {
//            ItemStatus item = itemResponse.body().getItem();
//
//            Response<InstitutionsGetByIdResponse> institutionsResponse = this.plaidClient.service()
//                    .institutionsGetById(new InstitutionsGetByIdRequest(item.getInstitutionId()))
//                    .execute();
//
//            if (!institutionsResponse.isSuccessful()) {
//                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                        .body(getErrorResponseData("Unable to pull institution information from the Plaid API."));
//            } else {
//                Map<String, Object> data = new HashMap<>();
//                data.put("error", false);
//                data.put("item", item);
//                data.put("institution", institutionsResponse.body().getInstitution());
//                return ResponseEntity.ok(data);
//            }
//        }
//    }
//
//
//    @RequestMapping(value="/transactions", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
//    public @ResponseBody
//    ResponseEntity getTransactions() throws Exception {
//        if (authService.getAccessToken() == null) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//                    .body(getErrorResponseData("Not authorized"));
//        }
//
//        Calendar cal = Calendar.getInstance();
//        cal.add(Calendar.DATE, -30);
//        Date startDate = cal.getTime();
//        Date endDate = new Date();
//
//        Response<TransactionsGetResponse> response = this.plaidClient.service()
//                .transactionsGet(new TransactionsGetRequest(this.authService.getAccessToken(), startDate, endDate)
//                        .withCount(250)
//                        .withOffset(0))
//                .execute();
//        if (response.isSuccessful()) {
//            return ResponseEntity.ok(response.body());
//        } else {
//
//            ErrorResponse error = this.plaidClient.parseError(response);
//            Map<String, Object> data = new HashMap<>();
//            data.put("error", error);
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(data);
//        }
//    }
//
//    private Map<String, Object> getErrorResponseData(String message) {
//        Map<String, Object> data = new HashMap<>();
//        data.put("error", false);
//        data.put("message", message);
//        return data;
//    }

    @RequestMapping(value = "/get_balance", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void ggg() throws IOException {
//        plaidService.createLink(service.findById(6L));


    }




}