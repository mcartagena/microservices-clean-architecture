package com.food.ordering.system.customer.service.domain.create;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Builder;
import lombok.NonNull;

import java.util.UUID;

@Getter
@Builder
public class CreateCustomerCommand {
    @NonNull
    @JsonProperty("customerId")
    private final UUID customerId;

    @NonNull
    @JsonProperty("username")
    private final String username;

    @NonNull
    @JsonProperty("firstName")
    private final String firstName;

    @NonNull
    @JsonProperty("lastName")
    private final String lastName;

    @JsonCreator
    public CreateCustomerCommand(
            @JsonProperty("customerId") UUID customerId,
            @JsonProperty("username") String username,
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName
    ) {
        this.customerId = customerId;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
