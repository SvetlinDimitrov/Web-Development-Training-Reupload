package org.example;

public abstract class Style {
    private Product product;

    protected Style(Product product) {
        this.product = product;
    }

    public abstract void sell();

    public abstract void buy();

    protected Product getProduct() {
        return product;
    }
}
