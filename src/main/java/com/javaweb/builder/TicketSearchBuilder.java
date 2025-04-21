package com.javaweb.builder;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TicketSearchBuilder {
    private String origin;
    private String destination;
    private String airline;
    private String type;
    private String estimatedTime;
    private LocalDateTime departureTimeFrom;
    private LocalDateTime arriveTime;
    private Long priceFrom;
    private Long priceTo;

    private TicketSearchBuilder(Builder builder) {
        this.origin = builder.origin;
        this.destination = builder.destination;
        this.airline = builder.airline;
        this.type = builder.type;
        this.estimatedTime = builder.estimatedTime;
        this.departureTimeFrom = builder.departureTimeFrom;
        this.arriveTime = builder.arriveTime;
        this.priceFrom = builder.priceFrom;
        this.priceTo = builder.priceTo;
    }

    public static class Builder {
        private String origin;
        private String destination;
        private String airline;
        private String type;
        private String estimatedTime;
        private LocalDateTime departureTimeFrom;
        private LocalDateTime arriveTime;
        private Long priceFrom;
        private Long priceTo;

        public Builder setOrigin(String origin) {
            this.origin = origin;
            return this;
        }

        public Builder setDestination(String destination) {
            this.destination = destination;
            return this;
        }

        public Builder setAirline(String airline) {
            this.airline = airline;
            return this;
        }

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setEstimatedTime(String estimatedTime) {
            this.estimatedTime = estimatedTime;
            return this;
        }

        public Builder setDepartureTimeFrom(LocalDateTime departureTimeFrom) {
            this.departureTimeFrom = departureTimeFrom;
            return this;
        }

        public Builder setArriveTime(LocalDateTime arriveTime) {
            this.arriveTime = arriveTime;
            return this;
        }

        public Builder setPriceFrom(Long priceFrom) {
            this.priceFrom = priceFrom;
            return this;
        }

        public Builder setPriceTo(Long priceTo) {
            this.priceTo = priceTo;
            return this;
        }

        public TicketSearchBuilder build() {
            return new TicketSearchBuilder(this);
        }
    }
}
