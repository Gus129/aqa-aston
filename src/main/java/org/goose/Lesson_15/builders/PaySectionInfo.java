package org.goose.Lesson_15.builders;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PaySectionInfo {
    private final String paymentType;
    private final String numberField;
    private final String paymentSum;
    private final String email;
}
