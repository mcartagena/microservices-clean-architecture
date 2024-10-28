package com.food.ordering.system.order.service.domain.dto.track;

import com.food.ordering.system.domain.valueobject.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class TrackOrderResponse {
    @NonNull
    private final UUID orderTrackingId;
    @NonNull
    private final OrderStatus orderStatus;
    @NonNull
    private final List<String> failureMessages;
}
