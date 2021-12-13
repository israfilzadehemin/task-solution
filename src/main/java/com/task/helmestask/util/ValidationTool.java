package com.task.helmestask.util;

import com.task.helmestask.dto.FormDto;
import com.task.helmestask.exception.InvalidDataException;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ValidationTool {

    public static void validateFormData(FormDto formDto) {
        if (Strings.isBlank(formDto.getName().trim())
                || formDto.getName().trim().length() > 255
                || Objects.isNull(formDto.getAgree())
                || Objects.isNull(formDto.getSelections())
                || formDto.getSelections().isEmpty()
                || formDto.getSelections().stream().anyMatch(s -> s.trim().length() > 255)) {
            throw new InvalidDataException("Please provide valid data for all mandatory fields!");
        }
    }
}
