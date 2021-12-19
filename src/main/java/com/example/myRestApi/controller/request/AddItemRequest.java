package com.example.myRestApi.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(setterPrefix = "with")
public class AddItemRequest {

    @NotNull
    private UUID uuid;

    @NotNull
    @Size(min = 1, max = 50)
    private String name;
}
