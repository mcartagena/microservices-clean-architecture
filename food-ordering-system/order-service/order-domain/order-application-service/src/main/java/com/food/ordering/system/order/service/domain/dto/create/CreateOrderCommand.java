package com.food.ordering.system.order.service.domain.dto.create;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
public class CreateOrderCommand {
    @NonNull
    private final UUID customerId;
    @NonNull
    private final UUID restaurantId;
    @NonNull
    private final BigDecimal price;
    @NonNull
    private final List<OrderItem> items;
    @NonNull
    private final OrderAddress address;

    @JsonCreator
    public CreateOrderCommand(
            @JsonProperty("customerId") @NonNull UUID customerId,
            @JsonProperty("restaurantId") @NonNull UUID restaurantId,
            @JsonProperty("price") @NonNull BigDecimal price,
            @JsonProperty("items") @NonNull List<OrderItem> items,
            @JsonProperty("address") @NonNull OrderAddress address) {
        this.customerId = customerId;
        this.restaurantId = restaurantId;
        this.price = price;
        this.items = items;
        this.address = address;

    }
}
