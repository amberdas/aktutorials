package oops.feature.factory;

import oops.feature.abstraction.Payment;
import oops.feature.encapsulation.DebitCardPayment;
import oops.feature.encapsulation.PaymentRequest;
import oops.feature.enums.PaymentType;
import oops.feature.encapsulation.CreditCardPayment;
import oops.feature.encapsulation.UPIPayment;
import oops.feature.inheritance.PaymentInfo;

/*Object Factory Class to build and return Payment Object depending on Payment Type
* */
public class PaymentFactory {

    public static Payment getInstance(PaymentRequest paymentRequest)
    {
        PaymentInfo paymentInfo=paymentRequest.getPaymentInfo();
        String paymentType=paymentRequest.getPaymentType();
        if(PaymentType.CC.name().equalsIgnoreCase(paymentType))
        {
            return new CreditCardPayment(paymentInfo.getCardNumber(),paymentInfo.getExpiryMonth(),paymentInfo.getExpiryYear(),
                    paymentInfo.getNameOnCard(),paymentInfo.getPin(),paymentInfo.getOtp());
        }
        else if(PaymentType.DC.name().equalsIgnoreCase(paymentType))
        {
            return new DebitCardPayment(paymentInfo.getCardNumber(),paymentInfo.getExpiryMonth(),paymentInfo.getExpiryYear(),
                    paymentInfo.getNameOnCard(),paymentInfo.getPin(),paymentInfo.getOtp());
        }
        else if(PaymentType.UPI.name().equalsIgnoreCase(paymentType))
        {
            return new UPIPayment(paymentInfo.getUpiID(),paymentInfo.getPin(),paymentInfo.getOtp());
        }

        throw new UnsupportedOperationException("Payment type: "+paymentType+" not supported");
    }
}
