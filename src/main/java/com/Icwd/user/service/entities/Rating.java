package com.Icwd.user.service.entities;

public class Rating {

        private String ratingId;
        private String userId;
        private String hotelId;
        private String rating;
        private String feedback;
        private hotel hotel;

        // No-argument constructor
        public Rating() {
        }

        // All-argument constructor (with feedback)
        public Rating(String ratingId, String userId, String hotelId, String rating, String feedback, hotel hotel) {
                this.ratingId = ratingId;
                this.userId = userId;
                this.hotelId = hotelId;
                this.rating = rating;
                this.feedback = feedback;
                this.hotel = hotel;
        }

        // Static Builder Class
        public static class Builder {
                private String ratingId;
                private String userId;
                private String hotelId;
                private String rating;
                private String feedback;
                private hotel hotel;

                public Builder() {
                }

                public Builder ratingId(String ratingId) {
                        this.ratingId = ratingId;
                        return this;
                }

                public Builder userId(String userId) {
                        this.userId = userId;
                        return this;
                }

                public Builder hotelId(String hotelId) {
                        this.hotelId = hotelId;
                        return this;
                }

                public Builder rating(String rating) {
                        this.rating = rating;
                        return this;
                }

                public Builder feedback(String feedback) {
                        this.feedback = feedback;
                        return this;
                }

                public Builder hotel(hotel hotel) {
                        this.hotel = hotel;
                        return this;
                }

                public Rating build() {
                        return new Rating(ratingId, userId, hotelId, rating, feedback, hotel);
                }
        }

        // Getter and Setter for ratingId
        public String getRatingId() {
                return ratingId;
        }

        public void setRatingId(String ratingId) {
                this.ratingId = ratingId;
        }

        // Getter and Setter for userId
        public String getUserId() {
                return userId;
        }

        public void setUserId(String userId) {
                this.userId = userId;
        }

        // Getter and Setter for hotelId
        public String getHotelId() {
                return hotelId;
        }

        public void setHotelId(String hotelId) {
                this.hotelId = hotelId;
        }

        // Getter and Setter for rating
        public String getRating() {
                return rating;
        }

        public void setRating(String rating) {
                this.rating = rating;
        }

        // Getter and Setter for feedback
        public String getFeedback() {
                return feedback;
        }

        public void setFeedback(String feedback) {
                this.feedback = feedback;
        }

        // Getter and Setter for hotel
        public hotel getHotel() {
                return hotel;
        }

        public void setHotel(hotel hotel) {
                this.hotel = hotel;
        }
}
