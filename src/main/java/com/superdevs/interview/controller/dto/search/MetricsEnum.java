package com.superdevs.interview.controller.dto.search;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum MetricsEnum {
    CLICKS("sum(clicks) as clicks"),
    IMPRESSIONS("sum(impressions) as impressions"),
    CTR("sum(clicks)/sum(impressions)*100 as ctr");

    public String dbName;
}
