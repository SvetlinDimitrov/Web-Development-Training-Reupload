package couponsopsjava;

import java.util.Collection;

public interface ICouponOperation {

    void registerSite(Website w);

    void addCoupon(Website w, Coupon c);

    Website removeWebsite(String domain);

    Coupon removeCoupon(String code);

    boolean exist(Website w);

    boolean exist(Coupon c);

    Collection<Website> getSites();

    Collection<Coupon> getCouponsForWebsite(Website w);

    void useCoupon(Website w, Coupon c);

    Collection<Coupon> getCouponsOrderedByValidityDescAndDiscountPercentageDesc();

    Collection<Website> getWebsitesOrderedByUserCountAndCouponsCountDesc();
}
