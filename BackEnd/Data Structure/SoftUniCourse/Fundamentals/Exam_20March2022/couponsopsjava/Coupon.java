package couponsopsjava;

public class Coupon {

    public String code;
    public int discountPercentage;
    public int validity;
	
	public String website;

    public Coupon(String code, int discountPercentage, int validity) {
        this.code = code;
        this.discountPercentage = discountPercentage;
        this.validity = validity;
    }

    public String getCode() {
        return code;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public int getValidity() {
        return validity;
    }

    public String getWebsite() {
        return website;
    }
}
