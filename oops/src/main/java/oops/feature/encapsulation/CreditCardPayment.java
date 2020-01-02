package oops.feature.encapsulation;

import oops.feature.abstraction.Payment;
import oops.feature.inheritance.PaymentInfo;

import java.time.LocalDate;

/* Inheritance and Encapsulation Example
* Child class importing properties from Parent PaymentInfo and giving implementation of Payment Module Design
* */
public class CreditCardPayment extends PaymentInfo implements Payment {

    public CreditCardPayment() {
    }

    public CreditCardPayment(Long cardNumber, int expiryMonth, int expiryYear, String nameOnCard, String pin, int otp) {
        super(cardNumber, expiryMonth, expiryYear, nameOnCard, pin, otp);
    }
    @Override
    public boolean doPayment(PaymentInfo paymentInfo) {
        System.out.println("doing Payment using credit card");
        LocalDate date = LocalDate.now();

        int year = date.getYear();
        int month = date.getMonthValue();

        if(paymentInfo.getExpiryYear()>=year && paymentInfo.getExpiryMonth() >=month)
        {
            System.out.println(paymentInfo);
            System.out.println("Payment done successfully");
            return  true;
        }
        System.out.println("Payment unsuccessful :(");
        return false;
    }

    @Override
    public String toString() {
        return "CreditCardPayment{" +
                "cardNumber=" + cardNumber +
                ", expiryMonth=" + expiryMonth +
                ", expiryYear=" + expiryYear +
                ", nameOnCard='" + nameOnCard + '\'' +
                ", pin='" + pin + '\'' +
                ", otp=" + otp +
                '}';
    }
}
