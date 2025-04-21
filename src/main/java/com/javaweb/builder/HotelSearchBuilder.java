package com.javaweb.builder;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class HotelSearchBuilder {
    private String name;
    private String address;
    private BigDecimal ratingFrom;
    private BigDecimal ratingTo;
    private Long pricePerNightFrom;
    private Long pricePerNightTo;

    private HotelSearchBuilder (Builder build){
        this.name = build.name;
        this.address = build.address;
        this.ratingFrom = build.ratingFrom;
        this.ratingTo = build.ratingTo;
        this.pricePerNightFrom = build.pricePerNightFrom;
        this.pricePerNightTo = build.pricePerNightTo;

    }


    public static class Builder  {
        private String name;
        private String address;
        private BigDecimal ratingFrom;
        private BigDecimal ratingTo;
        private Long pricePerNightFrom;
        private Long pricePerNightTo;


        public Builder setName(String hotelName) {
            this.name = hotelName;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setRatingFrom(BigDecimal ratingFrom) {
            this.ratingFrom = ratingFrom;
            return this;
        }

        public Builder setRatingTo(BigDecimal ratingTo) {
            this.ratingTo = ratingTo;
            return this;
        }

        public Builder setPricePerNightFrom(Long pricePerNightFrom) {
            this.pricePerNightFrom = pricePerNightFrom;
            return this;
        }

        public Builder setPricePerNightTo(Long pricePerNightTo) {
            this.pricePerNightTo = pricePerNightTo;
            return this;
        }

        public HotelSearchBuilder build() {
            return new HotelSearchBuilder(this);
        }
    }
}
