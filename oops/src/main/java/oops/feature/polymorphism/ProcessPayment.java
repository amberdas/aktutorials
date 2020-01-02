package oops.feature.polymorphism;

import oops.feature.encapsulation.PaymentRequest;
import oops.feature.abstraction.Payment;
import oops.feature.factory.PaymentFactory;

/* This represents Polymorphism feature as it process all payment types(Credit Card, Debit Card or UPI).
* Whatever the Payment Request it will process it.
* It is single entry point for all payment requests.
* */
public class ProcessPayment {

    public boolean paymentProcess(PaymentRequest paymentRequest)
    {
        Payment payment = PaymentFactory.getInstance(paymentRequest);
        return payment.doPayment(paymentRequest.getPaymentInfo());
    }
}
