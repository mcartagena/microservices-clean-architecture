package com.food.ordering.system.order.service.domain.dto.create;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Builder
public class OrderItem {
    @NonNull
    private final UUID productId;
    @NonNull
    private final Integer quantity;
    @NonNull
    private final BigDecimal price;
    @NonNull
    private final BigDecimal subTotal;

    @JsonCreator
    public OrderItem(
            @JsonProperty("productId") @NonNull UUID productId,
            @JsonProperty("quantity") @NonNull Integer quantity,
            @JsonProperty("price") @NonNull BigDecimal price,
            @JsonProperty("subTotal") @NonNull BigDecimal subTotal) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.subTotal = subTotal;
    }

}
