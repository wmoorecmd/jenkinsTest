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
    int hours = 0, minutes = 5
    String desc = "Created by ansible"
    String extras = "api_token=${pagerDutyArgs.token}"

    //return false when any required argument is missing
    if(!(pagerDutyArgs.containsKey('env') && pagerDutyArgs.containsKey('token'))){
        return false
    }

    //assign values based off of required parameters
    if(pagerDutyArgs.env == 'prod'){
        //TODO use actual values here
        extras += ' service_id=000000'
        extras += ' requester_user_id=000000'
    } else if(pagerDutyArgs.env == 'dev'){
        extras += ' service_id=P77YHJX'
        extras += ' requester_user_id=PYSN9IH'
    } else {
        //TODO some sort of error handling for an invalid choice
        return false
    }

    //assign values for optional parameters
    if(pagerDutyArgs.containsKey('hours')) hours = pagerDutyArgs.hours
    extras += " hours=${hours}"

    if(pagerDutyArgs.containsKey('minutes')) minutes = pagerDutyArgs.minutes
    extras += " minutes=${minutes}"

    if(pagerDutyArgs.containsKey('desc')) desc = pagerDutyArgs.desc
    extras += " desc=\"${desc}\""

    //add e flag, quotes
    extras = "-e '${extras}'"

    //run ansible
    ansiblePlaybook(
            playbook: 'task-pagerduty-maintenance.yml',
            extras: extras
    )
    
    return true
}