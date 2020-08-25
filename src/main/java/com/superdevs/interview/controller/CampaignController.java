package com.superdevs.interview.controller;

import com.superdevs.interview.controller.dto.CampaignStatisticsData;
import com.superdevs.interview.controller.dto.CampaignStatisticsSearchDto;
import com.superdevs.interview.controller.dto.CampaignStatisticsSearchInput;
import com.superdevs.interview.controller.validator.CampaignValidator;
import com.superdevs.interview.service.CampaignService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/campaign")
public class CampaignController {

    private final CampaignService campaignService;
    private final CampaignValidator campaignValidator;

    public CampaignController(CampaignService campaignService,
            CampaignValidator campaignValidator) {
        this.campaignService = campaignService;
        this.campaignValidator = campaignValidator;
    }

    @PutMapping("/statistics")
    public CampaignStatisticsData getCampaignStatistics(@RequestBody @Valid CampaignStatisticsSearchInput campaignStatisticsSearchInput) {

        CampaignStatisticsSearchDto campaignStatisticsSearchDto = campaignValidator.validateCampaignStatistics(
                campaignStatisticsSearchInput);

        return campaignService.getCampaignStatistics(campaignStatisticsSearchDto);
    }
}
