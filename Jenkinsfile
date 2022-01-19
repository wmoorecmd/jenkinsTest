pipeline{
  agent any
  stages{
    @Library('sharedlib@main')_
    stage('Create PagerDuty Maintenance Window'){
      environment{
        PAGERDUTY_API_KEY = credentials("PAGERDUTY_API_KEY")
      }

      steps{
        script{
          createPagerDutyMaintenance(
            env: 'dev',
            token: '$PAGERDUTY_API_KEY'
          )
        }
        // ansiColor('xterm'){
        //   ansiblePlaybook(
        //     playbook: 'task-pagerduty-maintenance.yml',
        //     colorized: true,
        //     extras: '-e "api_token=$PAGERDUTY_API_KEY service_id=$PAGERDUTY_SERVICE_ID requester_user_id=$PAGERDUTY_USER_ID"'
        //   )
        // }
      }
    }
  }
}
