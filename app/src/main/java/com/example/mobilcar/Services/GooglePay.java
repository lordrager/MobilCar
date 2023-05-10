//package com.example.mobilcar.Services;
//
//import android.content.Context;
//
//import com.google.android.gms.common.internal.Constants;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.util.Optional;
//
//public class GooglePay {
//    private static JSONObject getBaseRequest() throws JSONException {
//        return new JSONObject().put("apiVersion", 2).put("apiVersionMinor", 0);
//    }
//
//    private static JSONObject getGatewayTokenizationSpecification() throws JSONException {
//        return new JSONObject() {{
//            put("type", "PAYMENT_GATEWAY");
//            put("parameters", new JSONObject() {{
//                put("gateway", "example");
//                put("gatewayMerchantId", "exampleGatewayMerchantId");
//            }});
//        }};
//    }
//
//    private static JSONArray getAllowedCardNetworks() {
//        return new JSONArray()
////                .put("AMEX")
////                .put("DISCOVER")
////                .put("INTERAC")
////                .put("JCB")
//                .put("MASTERCARD")
//                .put("VISA");
//    }
//
//    private static JSONArray getAllowedCardAuthMethods() {
//        return new JSONArray()
//                .put("PAN_ONLY")
//                .put("CRYPTOGRAM_3DS");
//    }
//
//    private static JSONObject getBaseCardPaymentMethod() throws JSONException {
//        JSONObject cardPaymentMethod = new JSONObject();
//        cardPaymentMethod.put("type", "CARD");
//
//        JSONObject parameters = new JSONObject();
//        parameters.put("allowedAuthMethods", getAllowedCardAuthMethods());
//        parameters.put("allowedCardNetworks", getAllowedCardNetworks());
//        // Optionally, you can add billing address/phone number associated with a CARD payment method.
//        parameters.put("billingAddressRequired", true);
//
//        JSONObject billingAddressParameters = new JSONObject();
//        billingAddressParameters.put("format", "FULL");
//
//        parameters.put("billingAddressParameters", billingAddressParameters);
//
//        cardPaymentMethod.put("parameters", parameters);
//
//        return cardPaymentMethod;
//    }
//
//    private static JSONObject getCardPaymentMethod() throws JSONException {
//        JSONObject cardPaymentMethod = getBaseCardPaymentMethod();
//        cardPaymentMethod.put("tokenizationSpecification", getGatewayTokenizationSpecification());
//
//        return cardPaymentMethod;
//    }
//
//    public static PaymentsClient createPaymentsClient(Context context) {
//        Wallet.WalletOptions walletOptions =
//                new Wallet.WalletOptions.Builder().setEnvironment(Constants.PAYMENTS_ENVIRONMENT).build();
//        return Wallet.getPaymentsClient(context, walletOptions);
//    }
//
//    public static Optional<JSONObject> getIsReadyToPayRequest() {
//        try {
//            JSONObject isReadyToPayRequest = getBaseRequest();
//            isReadyToPayRequest.put(
//                    "allowedPaymentMethods", new JSONArray().put(getBaseCardPaymentMethod()));
//
//            return Optional.of(isReadyToPayRequest);
//
//        } catch (JSONException e) {
//            return Optional.empty();
//        }
//    }
//
//    private void possiblyShowGooglePayButton() {
//
//        final Optional<JSONObject> isReadyToPayJson = PaymentsUtil.getIsReadyToPayRequest();
//        if (!isReadyToPayJson.isPresent()) {
//            return;
//        }
//
//        // The call to isReadyToPay is asynchronous and returns a Task. We need to provide an
//        // OnCompleteListener to be triggered when the result of the call is known.
//        IsReadyToPayRequest request = IsReadyToPayRequest.fromJson(isReadyToPayJson.get().toString());
//        Task<Boolean> task = paymentsClient.isReadyToPay(request);
//        task.addOnCompleteListener(this,
//                new OnCompleteListener<Boolean>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Boolean> task) {
//                        if (task.isSuccessful()) {
//                            setGooglePayAvailable(task.getResult());
//                        } else {
//                            Log.w("isReadyToPay failed", task.getException());
//                        }
//                    }
//                });
//    }
//
//    private static JSONObject getTransactionInfo(String price) throws JSONException {
//        JSONObject transactionInfo = new JSONObject();
//        transactionInfo.put("totalPrice", price);
//        transactionInfo.put("totalPriceStatus", "FINAL");
//        transactionInfo.put("countryCode", Constants.COUNTRY_CODE);
//        transactionInfo.put("currencyCode", Constants.CURRENCY_CODE);
//        transactionInfo.put("checkoutOption", "COMPLETE_IMMEDIATE_PURCHASE");
//
//        return transactionInfo;
//    }
//    private static JSONObject getMerchantInfo() throws JSONException {
//        return new JSONObject().put("merchantName", "Example Merchant");
//    }
//
//    public static Optional<JSONObject> getPaymentDataRequest(long priceCents) {
//
//        final String price = PaymentsUtil.centsToString(priceCents);
//
//        try {
//            JSONObject paymentDataRequest = PaymentsUtil.getBaseRequest();
//            paymentDataRequest.put(
//                    "allowedPaymentMethods", new JSONArray().put(PaymentsUtil.getCardPaymentMethod()));
//            paymentDataRequest.put("transactionInfo", PaymentsUtil.getTransactionInfo(price));
//            paymentDataRequest.put("merchantInfo", PaymentsUtil.getMerchantInfo());
//
//            paymentDataRequest.put("shippingAddressRequired", true);
//
//            JSONObject shippingAddressParameters = new JSONObject();
//            shippingAddressParameters.put("phoneNumberRequired", false);
//
//            JSONArray allowedCountryCodes = new JSONArray(Constants.SHIPPING_SUPPORTED_COUNTRIES);
//
//            shippingAddressParameters.put("allowedCountryCodes", allowedCountryCodes);
//            paymentDataRequest.put("shippingAddressParameters", shippingAddressParameters);
//            return Optional.of(paymentDataRequest);
//
//        } catch (JSONException e) {
//            return Optional.empty();
//        }
//    }
//
//    // Tova e za activity
//    googlePayButton.setOnClickListener(
//            new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            requestPayment(view);
//        }
//    });
//
//    // Tova e za activity
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        switch (requestCode) {
//            // value passed in AutoResolveHelper
//            case LOAD_PAYMENT_DATA_REQUEST_CODE:
//                switch (resultCode) {
//
//                    case Activity.RESULT_OK:
//                        PaymentData paymentData = PaymentData.getFromIntent(data);
//                        handlePaymentSuccess(paymentData);
//                        break;
//
//                    case Activity.RESULT_CANCELED:
//                        // The user cancelled the payment attempt
//                        break;
//
//                    case AutoResolveHelper.RESULT_ERROR:
//                        Status status = AutoResolveHelper.getStatusFromIntent(data);
//                        handleError(status.getStatusCode());
//                        break;
//                }
//
//                // Re-enables the Google Pay payment button.
//                googlePayButton.setClickable(true);
//        }
//    }
//
//}
