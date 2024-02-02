package org.exampleJDBC.dao.dto.order;

import java.math.BigDecimal;

public class ProductOrder {
    private String code;
    private String name;
    private Integer size;
    private String variety;

    private BigDecimal price;

    public ProductOrder(String code, String name, Integer size, String variety, BigDecimal price) {
        this.code = code;
        this.name = name;
        this.size = size;
        this.variety = variety;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductOrder{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", variety='" + variety + '\'' +
                ", price=" + price +
                '}';
    }
}
