pipeline{
  agent any
  stages{
    stage("Create PagerDuty Maintenance Window"){
      environment{
        PAGERDUTY_API_KEY = credentials("PAGERDUTY_API_KEY")
        PAGERDUTY_SERVICE_ID = credentials("PAGERDUTY_SERVICE_ID")
        PAGERDUTY_USER_ID = credentials("PAGERDUTY_USER_ID")
      }

      steps{
        ansiColor('xterm'){
          ansiblePlaybook(
            playbook: 'task-pagerduty-maintenance.yml',
            colorized: true,
            extras: "-e api_token=${PAGERDUTY_API_KEY} service_id=${PAGERDUTY_SERVICE_ID} requester_user_id=${PAGERDUTY_USER_ID}"
          )
        }
      }
    }
  }
}
