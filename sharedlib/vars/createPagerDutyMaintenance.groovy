/*
 * Creates a PagerDuty Maintenance window
 *
 * Arguments
 *  - env: prod or staging
 *  - token: the PagerDuty API Token - optional (defaults to sandbox token)
 *  - minutes: minute duration of maintenance - optional (default to 5)
 *  - hours: hour duration of maintenance - optional (default to 0)
 *  - desc: a description of the reason for the window - optional (default to "Created by ansible")
*/

Boolean call(Map pagerDutyArgs){
    int hours = 0, minutes = 5
    String desc = "Created by ansible"
    String extras = ""

    //pagerduty sandbox API token
    String token = "u+vsHsxK7zNnqvPhP5LA"
    if (pagerDutyArgs.containsKey('token')) {
        token = pagerDutyArgs.token
    }
    extras += "api_token=${token}"

    if (!pagerDutyArgs.containsKey('env')) {
        return false
    }
    if (pagerDutyArgs.env == 'prod') {
        extras += ' service_id=000000'
        extras += ' requester_user_id=000000'
    } else {
        //pagerduty sandbox account IDs
        extras += ' service_id=PGRYLFN'
        extras += ' requester_user_id=PPM6MM3'
    }

    if (pagerDutyArgs.containsKey('hours')) {
        hours = pagerDutyArgs.hours
    }
    extras += " hours=${hours}"

    if (pagerDutyArgs.containsKey('minutes')) {
        minutes = pagerDutyArgs.minutes
    }
    extras += " minutes=${minutes}"

    if (pagerDutyArgs.containsKey('desc')) {
        desc = pagerDutyArgs.desc
    }
    extras += " desc=\"${desc}\""

    extras = "-e '${extras}'"

    // runAnsible(
    //         playbook: 'task-pagerduty-maintenance.yml',
    //         app: "ocean",
    //         env: pagerDutyArgs.env,
    //         extras: extras
    // )

    ansiblePlaybook(
        playbook: 'task-pagerduty-maintenance.yml',
        extras: extras
    )

    return true
}
