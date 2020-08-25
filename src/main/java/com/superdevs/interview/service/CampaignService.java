package com.superdevs.interview.service;

import com.superdevs.interview.controller.dto.CampaignStatisticsData;
import com.superdevs.interview.controller.dto.CampaignStatisticsSearchDto;
import com.superdevs.interview.mapper.CampaignMapper;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class CampaignService {

    private final CampaignMapper campaignMapper;

    public CampaignService(CampaignMapper campaignMapper) {
        this.campaignMapper = campaignMapper;
    }

    public CampaignStatisticsData getCampaignStatistics(CampaignStatisticsSearchDto campaignStatisticsSearchInput) {
        if (isNull(campaignStatisticsSearchInput.getGroupByDimensions()) ||
            campaignStatisticsSearchInput.getGroupByDimensions().isEmpty()) {
            return new CampaignStatisticsData(campaignMapper.campaignStatistics(campaignStatisticsSearchInput));
        }

        return new CampaignStatisticsData(campaignMapper.campaignStatisticsGroupedBy(campaignStatisticsSearchInput));
    }
}
