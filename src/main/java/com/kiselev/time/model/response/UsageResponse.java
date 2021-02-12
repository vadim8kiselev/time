package com.kiselev.time.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsageResponse {

    private Long timeToBuy;

    private Long timeToUse;
}
