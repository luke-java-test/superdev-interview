package com.superdevs.interview.controller.dto.search;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum DimensionsEnum {

    CAMPAIGN("campaign"),
    DATASOURCE("datasource");

    public String dbName;
}
