package com.superdevs.interview.mapper;

import com.superdevs.interview.controller.dto.CampaignStatisticsSearchDto;
import com.superdevs.interview.controller.dto.search.CampaignStatistics;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface CampaignMapper {

    @SelectProvider(type=CampaignSqlProvider.class, method="getStatistics")
    CampaignStatistics campaignStatistics(CampaignStatisticsSearchDto campaignStatisticsSearchDto);

    @SelectProvider(type=CampaignSqlProvider.class, method="getGroupedByStatistics")
    List<CampaignStatistics> campaignStatisticsGroupedBy(CampaignStatisticsSearchDto campaignStatisticsSearchDto);
}
