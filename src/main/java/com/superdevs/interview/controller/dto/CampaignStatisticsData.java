package com.superdevs.interview.controller.dto;

import com.superdevs.interview.controller.dto.search.CampaignStatistics;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CampaignStatisticsData {

    public CampaignStatistics statistics;

    public List<CampaignStatistics> groupedStatistics;

    public CampaignStatisticsData(CampaignStatistics statistics) {
        this.statistics = statistics;
    }

    public CampaignStatisticsData(List<CampaignStatistics> groupedStatistics) {
        this.groupedStatistics = groupedStatistics;
    }
}
