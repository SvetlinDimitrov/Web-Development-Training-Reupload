package couponsopsjava;

import java.util.*;
import java.util.stream.Collectors;


public class CouponOperation implements ICouponOperation {
    HashMap<String , Website> websiteHashMap;
    HashMap<String , Coupon> couponHashMap;
    HashMap<Website , List<Coupon>> list;
    public CouponOperation() {
        websiteHashMap = new LinkedHashMap<>();
        couponHashMap = new LinkedHashMap<>();
        list = new HashMap<>();
    }
    public void registerSite(Website w) {
        if(websiteHashMap.containsKey(w.domain)){
            throw new IllegalArgumentException();
        }
        websiteHashMap.put(w.domain , w);
        list.put(w , new ArrayList<>());
    }

    public void addCoupon(Website w, Coupon c) {
        if(couponHashMap.containsKey(c.code) || !websiteHashMap.containsKey(w.domain)){
            throw new IllegalArgumentException();
        }
        couponHashMap.put(c.code , c);
        c.website = w.domain;
        list.get(w).add(c);
    }

    public Website removeWebsite(String domain) {
        if(websiteHashMap.containsKey(domain)){
            Website websiteToRemove = websiteHashMap.get(domain);
            couponHashMap.values().removeIf(e->e.website.equals(domain));
            list.remove(websiteToRemove);
            return websiteHashMap.remove(domain);
        }
        throw new IllegalArgumentException();
    }

    public Coupon removeCoupon(String code) {
        if(couponHashMap.containsKey(code)){
            Website website = websiteHashMap.get(couponHashMap.get(code).website);
            Coupon couponToRemove = couponHashMap.get(code);
            list.get(website).remove(couponToRemove);
            return couponHashMap.remove(code);
        }
        throw new IllegalArgumentException();
    }

    public boolean exist(Website w) {
        return websiteHashMap.containsKey(w.domain);
    }

    public boolean exist(Coupon c) {
        return couponHashMap.containsKey(c.code);
    }

    public Collection<Website> getSites() {
        return websiteHashMap.values();
    }

    public Collection<Coupon> getCouponsForWebsite(Website w) {

        if(websiteHashMap.containsKey(w.domain)){
            return couponHashMap.values().stream()
                    .filter(e->e.website.equals(w.domain))
                    .collect(Collectors.toList());
        }
        throw new IllegalArgumentException();
    }

    public void useCoupon(Website w, Coupon c) {
        if(couponHashMap.containsKey(c.code) && websiteHashMap.containsKey(w.domain)){
            if(couponHashMap.get(c.code).website.equals(w.domain)){
                Website website = websiteHashMap.get(w.domain);
                Coupon coupon = couponHashMap.get(c.code);
                list.get(website).remove(coupon);
                couponHashMap.remove(c.code);
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    public Collection<Coupon> getCouponsOrderedByValidityDescAndDiscountPercentageDesc() {

        return couponHashMap.values().stream()
                .sorted(Comparator.comparing(Coupon::getValidity).reversed().thenComparing(Coupon::getDiscountPercentage).reversed())
                .collect(Collectors.toList());
    }

    public Collection<Website> getWebsitesOrderedByUserCountAndCouponsCountDesc() {
        return list.entrySet().stream()
                .sorted((f,s) -> {
                    boolean isEqual = Integer.compare(f.getKey().usersCount , s.getKey().usersCount) ==0;
                    if(isEqual){
                        return Integer.compare(s.getValue().size() , f.getValue().size());
                    }
                    return Integer.compare(f.getKey().usersCount , s.getKey().usersCount);
                })
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
