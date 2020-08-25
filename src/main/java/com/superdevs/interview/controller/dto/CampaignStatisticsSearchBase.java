package com.superdevs.interview.controller.dto;

import com.superdevs.interview.controller.dto.search.DimensionsEnum;
import com.superdevs.interview.controller.dto.search.MetricsEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class CampaignStatisticsSearchBase {

    @NotNull
    private Set<MetricsEnum> metrics;

    private Set<DimensionsEnum> groupByDimensions;
}
