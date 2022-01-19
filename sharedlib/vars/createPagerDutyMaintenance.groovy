/*
 * Creates a PagerDuty Maintenance window
 *
 * Arguments
 *  - env: dev prod
 *  - token: the PagerDuty API Token
 *
*/

Boolean call(Map pagerDutyArgs){
    //return false when any argument is missing
    if(!(pagerDutyArgs.containsKey('env') && pagerDutyArgs.containsKey('token'))){
        return false
    }

    String extras = "api_token=${pagerDutyArgs.token}"

    //build the extra argument string
    if(pagerDutyArgs.env == 'prod'){
        //TODO use actual values here
        extras += ' service_id=000000'
        extras += ' requester_user_id=000000'
    } else if(pagerDutyArgs.env == 'dev'){
        extras += ' service_id=P77YHJX'
        extras += ' requester_user_id=PYSN9IH'
    } else {
        //TODO maybe create a class to get an error message back
        return false
    }

    //add e flag and quotes
    extras = "-e '${extras}'"
    
    //run ansible
    ansiblePlaybook(
            playbook: 'task-pagerduty-maintenance.yml',
            extras: extras
    )
    
    return true
}