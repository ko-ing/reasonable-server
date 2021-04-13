package com.reasonable.calendar.http;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class ReasonableResponseEntity extends ResponseEntity<ReasonableResponse> {
    public ReasonableResponseEntity(HttpStatus status) {
        super(status);
    }

    public ReasonableResponseEntity(ReasonableResponse body, HttpStatus status) {
        super(body, status);
    }

    public ReasonableResponseEntity(MultiValueMap<String, String> headers, HttpStatus status) {
        super(headers, status);
    }

    public ReasonableResponseEntity(ReasonableResponse body, MultiValueMap<String, String> headers, HttpStatus status) {
        super(body, headers, status);
    }

    public ReasonableResponseEntity(ReasonableResponse body, MultiValueMap<String, String> headers, int rawStatus) {
        super(body, headers, HttpStatus.valueOf(rawStatus));
    }
}
