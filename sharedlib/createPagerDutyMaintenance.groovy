/*
 * Creates a PagerDuty Maintenance window
 *
 * Arguments
 *  - env: dev or prod
 *  - token: the PagerDuty API Token
 *
*/

def call(Map pagerDutyArgs){
    def service_id = ""
    def requester_user_id = ""

    if(pagerDutyArgs.env == 'prod'){
        //prod pagerduty info goes here
    } else if(pagerDutyArgs.env == 'dev'){
        //dev pagerduty info goes here
        service_id = "P77YHJX"
        requester_user_id = "PYSN9IH"
    } else {
        // what
    }
}