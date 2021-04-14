package com.reasonable.calendar.http;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpEntity;

@Data
@Builder
public class ReasonableResponse {
    private String data;
}
