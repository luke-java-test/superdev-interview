package com.superdevs.interview.controller.dto.search;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum FilterTypeEnum {

    START_DATE("daily >= '%s'"),
    END_DATE("daily <= '%s'"),
    CAMPAIGN("campaign = '%s'"),
    DATASOURCE("datasource = '%s'");

    public String dbFilter;

}
