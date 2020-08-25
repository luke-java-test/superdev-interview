package com.superdevs.interview.controller.dto.search;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class FilterParam {

    @NotNull
    private FilterTypeEnum type;

    @NotNull
    @NotEmpty
    private String value;
}
