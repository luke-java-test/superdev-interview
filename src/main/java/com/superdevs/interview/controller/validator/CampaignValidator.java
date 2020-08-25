package com.superdevs.interview.controller.validator;

import com.superdevs.interview.controller.dto.CampaignStatisticsSearchDto;
import com.superdevs.interview.controller.dto.CampaignStatisticsSearchInput;
import com.superdevs.interview.controller.dto.search.FilterParam;
import com.superdevs.interview.controller.dto.search.FilterTypeEnum;
import com.superdevs.interview.controller.exception.BadRequestException;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Component
public class CampaignValidator {

    private final static String DATE_VALIDATION_EXCEPTION_TXT =
            "Start date should be before end date";
    private final static String DATE_VALIDATION_EXCEPTION_FORMAT =
            "Date format exception";

    public CampaignStatisticsSearchDto validateCampaignStatistics(
            CampaignStatisticsSearchInput campaignStatisticsSearchInput) {
        Map<FilterTypeEnum, String> filterParamsMap = new HashMap<>();
        if(nonNull(campaignStatisticsSearchInput.getFilterParams())) {
            filterParamsMap = campaignStatisticsSearchInput.getFilterParams()
                    .stream()
                    .collect(Collectors.toMap(FilterParam::getType, FilterParam::getValue));

            validateDates(filterParamsMap);
        }
        return CampaignStatisticsSearchDto.builder()
                .filterParamsMap(filterParamsMap)
                .metrics(campaignStatisticsSearchInput.getMetrics())
                .groupByDimensions(campaignStatisticsSearchInput.getGroupByDimensions())
                .build();
    }

    private void validateDates(Map<FilterTypeEnum, String> campaignStatisticsSearchInput) {
        Date startDate = null, endDate = null;

        if (campaignStatisticsSearchInput.containsKey(FilterTypeEnum.START_DATE)) {
            startDate = getAndValidateDate(campaignStatisticsSearchInput.get(FilterTypeEnum.START_DATE));
        }
        if (campaignStatisticsSearchInput.containsKey(FilterTypeEnum.END_DATE)) {
            endDate = getAndValidateDate(campaignStatisticsSearchInput.get(FilterTypeEnum.END_DATE));
        }
        if (nonNull(startDate) && nonNull(endDate)
            && startDate.after(endDate)) {
            throw new BadRequestException(DATE_VALIDATION_EXCEPTION_TXT);
        }
    }

    private Date getAndValidateDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            throw new BadRequestException(DATE_VALIDATION_EXCEPTION_FORMAT);
        }
    }

}
