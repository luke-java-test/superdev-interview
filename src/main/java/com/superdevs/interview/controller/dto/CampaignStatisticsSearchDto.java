package com.superdevs.interview.controller.dto;

import com.superdevs.interview.controller.dto.search.DimensionsEnum;
import com.superdevs.interview.controller.dto.search.FilterTypeEnum;
import com.superdevs.interview.controller.dto.search.MetricsEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.Set;

@Getter
@NoArgsConstructor
public class CampaignStatisticsSearchDto extends CampaignStatisticsSearchBase {

    private Map<FilterTypeEnum, String> filterParamsMap;

    @Builder
    public CampaignStatisticsSearchDto(
            @NotNull Set<MetricsEnum> metrics,
            Set<DimensionsEnum> groupByDimensions,
            Map<FilterTypeEnum, String> filterParamsMap) {
        super(metrics, groupByDimensions);
        this.filterParamsMap = filterParamsMap;
    }
}
