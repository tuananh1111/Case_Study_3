package model;

public class OrderDetail {
        private Order order;
        private Supplement supplement;
        private int quantity;
        private double price;

    public OrderDetail(Order order, Supplement supplement, int quantity, double price) {
        this.order = order;
        this.supplement = supplement;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderDetail() {
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Supplement getSupplement() {
        return supplement;
    }

    public void setSupplement(Supplement supplement) {
        this.supplement = supplement;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
