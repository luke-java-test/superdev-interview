package com.superdevs.interview.mapper;

import com.superdevs.interview.controller.dto.CampaignStatisticsSearchDto;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Service;

@Service
public class CampaignSqlProvider {

    public String getStatistics(CampaignStatisticsSearchDto campaignStatisticsSearchDto) {
        return new SQL() {
            {
                StringBuffer stringBuffer = new StringBuffer();
                campaignStatisticsSearchDto.getMetrics()
                        .stream()
                        .forEach(metricsEnum -> {
                            if (stringBuffer.length() != 0) {
                                stringBuffer.append(", ");
                            }
                            stringBuffer.append(metricsEnum.dbName);
                        });
                SELECT(stringBuffer.toString());

                FROM("campaign_statistics");

                campaignStatisticsSearchDto.getFilterParamsMap()
                        .entrySet()
                        .stream()
                        .forEach(filterTypeStringEntry -> WHERE(String.format(filterTypeStringEntry.getKey().dbFilter,
                                filterTypeStringEntry.getValue())));
            }
        }.toString();
    }

    public String getGroupedByStatistics(CampaignStatisticsSearchDto campaignStatisticsSearchDto) {
        return new SQL() {
            {
                StringBuffer stringBuffer = new StringBuffer();
                campaignStatisticsSearchDto.getMetrics()
                        .stream()
                        .forEach(metricsEnum -> {
                            if (stringBuffer.length() != 0) {
                                stringBuffer.append(", ");
                            }
                            stringBuffer.append(metricsEnum.dbName);
                        });
                SELECT(stringBuffer.toString());
                campaignStatisticsSearchDto.getGroupByDimensions()
                        .forEach(dimensionsEnum -> {
                            SELECT(dimensionsEnum.dbName);
                            GROUP_BY(dimensionsEnum.dbName);
                        });
                FROM("campaign_statistics");

                campaignStatisticsSearchDto.getFilterParamsMap()
                        .entrySet()
                        .stream()
                        .forEach(filterTypeStringEntry -> WHERE(String.format(filterTypeStringEntry.getKey().dbFilter,
                                filterTypeStringEntry.getValue())));
            }
        }.toString();
    }
}
