package oops.feature.enums;

/**
 * Enum to define Payment Types supported by Application
 */
public enum PaymentType
{
    CC("credit card"),
    DC("debit card"),
    UPI("upi");

    private String type;

    PaymentType(String type)
    {
        this.type=type;
    }

    public String getType() {
        return type;
    }
}
