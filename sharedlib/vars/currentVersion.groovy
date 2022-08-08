/*
 * Grabs the current release version from s3
 *
 * Arguments
 *  - currentReleaseFile: the file to check the version of - defaults to 'current_release.txt'
*/

def call(String currentReleaseFile = 'current_release.txt') {
    String region = 'ca-central-1'

    withEnv(["AWS_DEFAULT_REGION=${region}"]) {
        withCredentials([string(credentialsId: 'tf_aws_poweruser_access_key_id', variable: 'AWS_ACCESS_KEY_ID'),
                         string(credentialsId: 'tf_aws_poweruser_access_secret', variable: 'AWS_SECRET_ACCESS_KEY')]) {
            def fileRet = sh script: "aws s3 ls s3://wmooretestbucket/${currentReleaseFile}", returnStatus: true
            if (fileRet == 0) {
                sh "aws s3 cp s3://wmooretestbucket/${currentReleaseFile} ."
                def val = sh script: "cat ${currentReleaseFile}", returnStdout: true
                println val
                return val
            } else {
                error("No existing current release found on S3")
            }
        }
    }
}