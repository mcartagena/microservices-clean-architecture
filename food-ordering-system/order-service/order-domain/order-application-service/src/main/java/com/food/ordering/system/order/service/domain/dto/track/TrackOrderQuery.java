package com.food.ordering.system.order.service.domain.dto.track;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class TrackOrderQuery {
    @NonNull
    private final UUID orderTrackingId;
}
