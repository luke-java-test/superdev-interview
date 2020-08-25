Queries are fully customizable 
I've decide to move to default mysql date format - I could always check and transform it to my format i thought that it's not a point of "challenge" 

Example request body for call 
PUT http://localhost:8080/api/campaign/statistics
{
    "metrics" : ["CLICKS", "IMPRESSIONS", "CTR"],
    "filterParams" : [ {
        "type": "START_DATE",
        "value": "2019-11-12"
    },
    {
        "type": "END_DATE",
        "value": "2019-11-20"
    }, {
        "type": "DATASOURCE",
        "value": "Google Ads" 
    }],
    "groupByDimensions" : [
        "CAMPAIGN"]
}

Metrics deterime returned values;
FilterParams determine filters on fields.
GroupByDimensions determine on what fields we want to group by. It's automaticaly added to returned values.

It returns json 
{
    "statistics": T,
    "groupedStatistics": [T]
}

T it's object 
        {
            "datasource": null,
            "campaign": "Adventmarkt Touristik",
            "clicks": 867,
            "ctr": 0.2071,
            "impressions": 418652
        }
I've decided to move to one generic endpoint and it returns 2 values - statistics and It's single object. 2nd field its groupedStatistics it will be returned when groupByDimensions is not empty.

I've choose MySql as for interview solution, but normally I would decide to use some column store solution for this type of system. 
If you wanna add new field or group by you need to change only 4 objects and rest would be fully automatic:
3 enums in com.superdevs.interview.controller.dto.search and CampaignStatistics.class



