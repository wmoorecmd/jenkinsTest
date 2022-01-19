/*
 * Creates a PagerDuty Maintenance window
 *
 * Arguments
 *  - env: dev prod
 *  - token: the PagerDuty API Token
 *  - minutes: minute duration of maintenance - optional (default to 5)
 *  - hours: hour duration of maintenance - optional (default to 0)
 *  - desc: a description of the reason for the window - optional (default to "Created by ansible")
*/

Boolean call(Map pagerDutyArgs){
    //return false when any required argument is missing
    if(!(pagerDutyArgs.containsKey('env') && pagerDutyArgs.containsKey('token'))){
        return false
    }

    int hours = 0, minutes = 5
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

    //assign values for minutes and hours
    if(pagerDutyArgs.containsKey('hours')) hours = pagerDutyArgs.hours
    extras += " hours=${hours}"

    if(pagerDutyArgs.containsKey('minutes')) minutes = pagerDutyArgs.minutes
    extras += " minutes=${minutes}"

    if(pagerDutyArgs.containsKey('desc')) extras += " desc=${pagerDutyArgs.desc}"

    //add e flag, quotes
    extras = "-e '${extras}'"

    //run ansible
    ansiblePlaybook(
            playbook: 'task-pagerduty-maintenance.yml',
            extras: extras
    )
    
    return true
}