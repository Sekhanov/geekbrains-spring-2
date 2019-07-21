package com.skhanov.geekbrainsspring.flows.order;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

/**
 * InnerProductCartItem
 */
public class ProductCart implements Serializable {

    private static final long serialVersionUID = 1L;

    public static class ProductCartItem implements Serializable {

        private static final long serialVersionUID = 1L;
        private Long id;
        private MultipartFile mainPicture;
        private String productName;
        private String shortDescription;
        private Integer quantity;
        private Integer price;
        private Integer itemTotalPrice;

        /**
         * @return MultipartFile return the mainPicture
         */
        public MultipartFile getMainPicture() {
            return mainPicture;
        }

        /**
         * @param mainPicture the mainPicture to set
         */
        public void setMainPicture(MultipartFile mainPicture) {
            this.mainPicture = mainPicture;
        }

        /**
         * @return String return the productName
         */
        public String getProductName() {
            return productName;
        }

        /**
         * @param productName the productName to set
         */
        public void setProductName(String productName) {
            this.productName = productName;
        }

        /**
         * @return String return the shortDescription
         */
        public String getShortDescription() {
            return shortDescription;
        }

        /**
         * @param shortDescription the shortDescription to set
         */
        public void setShortDescription(String shortDescription) {
            this.shortDescription = shortDescription;
        }

        /**
         * @return Integer return the quantity
         */
        public Integer getQuantity() {
            return quantity;
        }

        /**
         * @param quantity the quantity to set
         */
        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        /**
         * @return Integer return the price
         */
        public Integer getPrice() {
            return price;
        }

        /**
         * @param price the price to set
         */
        public void setPrice(Integer price) {
            this.price = price;
        }

        /**
         * @return Long return the id
         */
        public Long getId() {
            return id;
        }

        /**
         * @param id the id to set
         */
        public void setId(Long id) {
            this.id = id;
        }

        /**
         * @return Integer return the itemTotalPrice
         */
        public Integer getItemTotalPrice() {
            return itemTotalPrice;
        }

        /**
         * @param itemTotalPrice the itemTotalPrice to set
         */
        public void setItemTotalPrice() {
            this.itemTotalPrice = price * quantity;
        }
    }

    private List<ProductCartItem> productCartItems;

    private Integer cartTotalPrice;

    /**
     * @return Set<ProductCartItem> return the productCartItems
     */
    public List<ProductCartItem> getProductCartItems() {
        return productCartItems;
    }

    /**
     * @param productCartItems the productCartItems to set
     */
    public void setProductCartItems(List<ProductCartItem> productCartItems) {
        this.productCartItems = productCartItems;
    }

    /**
     * @return Integer return the cartTotalPrice
     */
    public Integer getCartTotalPrice() {
        return cartTotalPrice;
    }

    /**
     * @param cartTotalPrice the cartTotalPrice to set
     */
    public void setCartTotalPrice() {
        this.cartTotalPrice = productCartItems.stream().mapToInt(i -> i.itemTotalPrice).sum();
    }

}