package oops.feature.encapsulation;

import oops.feature.inheritance.PaymentInfo;

/*This is also example of Encapsulation, where we are packaging Payment information in Request
* and using it to pass to different services
*/
public class PaymentRequest
{
    private PaymentInfo paymentInfo;
    private String paymentType;

    public PaymentRequest(PaymentInfo paymentInfo, String paymentType) {
        this.paymentInfo = paymentInfo;
        this.paymentType = paymentType;
    }

    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}
