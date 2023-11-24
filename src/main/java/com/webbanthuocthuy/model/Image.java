package com.webbanthuocthuy.model;

public class Image {
        private int id;
        private int productId;
        private int reviewId;
        private String imageUrl;

        // Constructor
    public Image(){

    }
        public Image(int id, int productId, int reviewId, String imageUrl) {
            this.id = id;
            this.productId = productId;
            this.reviewId = reviewId;
            this.imageUrl = imageUrl;
        }

        // Các phương thức getter và setter
        // ...

        @Override
        public String toString() {
            return "Image{" +
                    "id=" + id +
                    ", productId=" + productId +
                    ", reviewId=" + reviewId +
                    ", imageUrl='" + imageUrl + '\'' +
                    '}';
        }
    }


