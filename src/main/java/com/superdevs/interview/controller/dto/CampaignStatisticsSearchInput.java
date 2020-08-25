package com.superdevs.interview.controller.dto;

import com.superdevs.interview.controller.dto.search.FilterParam;
import lombok.Getter;

import java.util.Set;

@Getter
public class CampaignStatisticsSearchInput extends CampaignStatisticsSearchBase {

    private Set<FilterParam> filterParams;
}
