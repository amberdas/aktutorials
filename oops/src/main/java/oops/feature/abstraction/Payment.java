package oops.feature.abstraction;

import oops.feature.inheritance.PaymentInfo;

/**
 * Abstract Design of payment Module. Now This design will be implemented by different Payment Modules
 */
public interface Payment
{
    boolean doPayment(PaymentInfo paymentInfo);
}
