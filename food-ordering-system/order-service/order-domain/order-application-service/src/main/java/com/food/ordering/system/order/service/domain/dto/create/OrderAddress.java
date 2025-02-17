package com.food.ordering.system.order.service.domain.dto.create;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Builder
public class OrderAddress {
    @NonNull
    @Max(value = 50)
    private final String street;
    @NonNull
    @Max(value = 10)
    private final String postalCode;
    @NonNull
    @Max(value = 50)
    private final String city;

    @JsonCreator
    public OrderAddress(
            @JsonProperty("street") @NonNull String street,
            @JsonProperty("postalCode") @NonNull String postalCode,
            @JsonProperty("city") @NonNull String city) {
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
    }
}
