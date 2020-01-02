package oops.feature.inheritance;

/**
 * Parent class with common Payment property packaged as Payment Info,
 * so now any subclass can extend and use it accordingly
 */
public class PaymentInfo {
    protected Long cardNumber;
    protected int expiryMonth;
    protected int expiryYear;
    protected String upiID;
    protected String nameOnCard;
    protected String pin;
    protected int otp;

    public PaymentInfo() {
    }

    public PaymentInfo(String upiID, String pin, int otp) {
        this.upiID = upiID;
        this.pin = pin;
        this.otp = otp;
    }

    public PaymentInfo(Long cardNumber, int expiryMonth, int expiryYear, String nameOnCard, String pin, int otp) {
        this.cardNumber = cardNumber;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
        this.nameOnCard = nameOnCard;
        this.pin = pin;
        this.otp = otp;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(int expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public int getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(int expiryYear) {
        this.expiryYear = expiryYear;
    }

    public String getUpiID() {
        return upiID;
    }

    public void setUpiID(String upiID) {
        this.upiID = upiID;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }
}
