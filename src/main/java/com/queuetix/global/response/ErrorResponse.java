package com.queuetix.global.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import org.springframework.validation.FieldError;

import java.util.List;

@Builder
public record ErrorResponse(String code, String message, @JsonInclude(Include.NON_NULL) List<ValidationErrors> errors) {
    @Builder
    public record ValidationErrors(String field, String message) {
        public static ValidationErrors of(FieldError fieldError) {
            return ValidationErrors.builder()
                    .field(fieldError.getField())
                    .message(fieldError.getDefaultMessage())
                    .build();
        }
    }


}
