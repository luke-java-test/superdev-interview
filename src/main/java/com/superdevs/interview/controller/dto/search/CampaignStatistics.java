package com.superdevs.interview.controller.dto.search;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CampaignStatistics implements Serializable {

    private static final long serialVersionUID = -6673532093586278058L;

    private String datasource;

    private String campaign;

    private Long clicks;

    private Double ctr;

    private Long impressions;
}
