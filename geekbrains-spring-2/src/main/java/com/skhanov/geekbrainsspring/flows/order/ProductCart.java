package com.skhanov.geekbrainsspring.flows.order;

import java.io.Serializable;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

/**
 * InnerProductCartItem
 */
public class ProductCart implements Serializable {

    private static final long serialVersionUID = 1L;

    public static class ProductCartItem implements Serializable {
        

        private static final long serialVersionUID = 1L;
        private MultipartFile mainPicture;
        private String productName;
        private String shortDescription;
        private Integer quantity;

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

    }

    private Set<ProductCartItem> productCartItems;


    /**
     * @return Set<ProductCartItem> return the productCartItems
     */
    public Set<ProductCartItem> getProductCartItems() {
        return productCartItems;
    }

    /**
     * @param productCartItems the productCartItems to set
     */
    public void setProductCartItems(Set<ProductCartItem> productCartItems) {
        this.productCartItems = productCartItems;
    }

}