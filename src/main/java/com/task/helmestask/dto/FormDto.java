package com.task.helmestask.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class FormDto {
    private String name;
    private List<String> selections;
    private Boolean agree;
}
