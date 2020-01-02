package oops.feature.encapsulation;

import oops.feature.abstraction.Payment;
import oops.feature.inheritance.PaymentInfo;


/* Inheritance and Encapsulation Example
* Child class importing properties from Parent PaymentInfo and giving implementation of Payment Module Design
* */
public class UPIPayment extends PaymentInfo implements Payment {

    public UPIPayment() {
    }

    public UPIPayment(String upiID, String pin, int otp) {
        super(upiID, pin, otp);
    }

    @Override
    public boolean doPayment(PaymentInfo paymentInfo) {
        System.out.println("doing Payment using Upi");
        if(paymentInfo.getUpiID().contains("@"))
        {
            System.out.println(paymentInfo);
            System.out.println("Payment Successful");
            return true;
        }
        System.out.println("Payment unsuccessful :(");
        return false;
    }


    @Override
    public String toString() {
        return "UPIPayment{" +
                "upiID='" + upiID + '\'' +
                ", pin='" + pin + '\'' +
                ", otp=" + otp +
                '}';
    }
}