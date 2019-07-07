package com.skhanov.geekbrainsspring.flows.order;

import java.io.Serializable;

/**
 * OrderModel
 */
public class OrderModel  implements Serializable {

    private static final long serialVersionUID = 1L;

    private ProductCart productCart;

    private DeliveryInfo deliveryInfo;

    private Payment payment;

    /**
     * @return ProductCart return the productCart
     */
    public ProductCart getProductCart() {
        return productCart;
    }

    /**
     * @param productCart the productCart to set
     */
    public void setProductCart(ProductCart productCart) {
        this.productCart = productCart;
    }

    /**
     * @return DeliveryInfo return the deliveryInfo
     */
    public DeliveryInfo getDeliveryInfo() {
        return deliveryInfo;
    }

    /**
     * @param deliveryInfo the deliveryInfo to set
     */
    public void setDeliveryInfo(DeliveryInfo deliveryInfo) {
        this.deliveryInfo = deliveryInfo;
    }

    /**
     * @return Payment return the payment
     */
    public Payment getPayment() {
        return payment;
    }

    /**
     * @param payment the payment to set
     */
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

}