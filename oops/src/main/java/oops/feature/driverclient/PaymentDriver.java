package oops.feature.driverclient;

import oops.feature.encapsulation.DebitCardPayment;
import oops.feature.encapsulation.PaymentRequest;
import oops.feature.enums.PaymentType;
import oops.feature.polymorphism.ProcessPayment;
import oops.feature.encapsulation.CreditCardPayment;
import oops.feature.encapsulation.UPIPayment;
import oops.feature.inheritance.PaymentInfo;

/*
* Client to send Payment request. In our case it is main method but in real world this request will be coming from
* Web UI or Android App where user gives input while doing payment*/
public class PaymentDriver
{
    public static void main(String [] args)
    {
        ProcessPayment processPayment = new ProcessPayment();

        //Initiating transaction with valid payment request 1
        processPayment.paymentProcess(creditCardPaymentRequest());

        //Initiating transaction with invalid payment request 2
        processPayment.paymentProcess(debitCardPaymentRequest());

        //Initiating transaction with valid payment request 3
        processPayment.paymentProcess(upiPaymentRequest());

        //Initiating transaction with invalid payment type request 4
        try
        {
            processPayment.paymentProcess(unSupportedPaymentRequest());
        }
        catch (Exception e)
        {
           System.out.println("Error: while processing payment: "+e.getMessage());
        }
    }

    // Creating valid credit card payment request
    public static PaymentRequest creditCardPaymentRequest()
    {
        CreditCardPayment creditCardPayment = new CreditCardPayment(123456789112345L,1,
                2020,"Test User1","123",2435);

        return new PaymentRequest(creditCardPayment, PaymentType.CC.name());
    }

    // Creating Invalid debit card payment request with wrong expiry year. It will make Payment unsuccessful
    public static PaymentRequest debitCardPaymentRequest()
    {
        DebitCardPayment debitCardPayment= new DebitCardPayment(123456789112345L,1,
                2019,"Test User1","123",2435);

        return new PaymentRequest(debitCardPayment, PaymentType.DC.name());
    }

    // Creating valid UPI payment request
    public static PaymentRequest upiPaymentRequest()
    {
        UPIPayment upiPayment = new UPIPayment("TestUser1@upi","123",2435);

        return new PaymentRequest(upiPayment, PaymentType.UPI.name());
    }

    // Creating invalid payment type request
    public static PaymentRequest unSupportedPaymentRequest()
    {
        PaymentInfo paymentInfo= new PaymentInfo();

        return new PaymentRequest(paymentInfo, "UNKNOWN");
    }
}
