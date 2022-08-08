def getOcean(v = null, location = '.') {
    return getInfraRepo('Ocean', v, location)
}

def getCloudConnect(v = null, location = '.') {
    return getInfraRepo('CloudConnect', v, location)
}

def getAppRepo(repo, v, location = '.') {
    def svn_url = "https://subversion.assembla.com/svn/CognisantMD"
    if (v?.equals('trunk')) {
        svn_url += "/${repo}"
    } else {
        svn_url += "/releases/${repo}"
    }
    return checkout([
            $class          : 'SubversionSCM',
            locations       : [[
                                       cancelProcessOnExternalsFail: true,
                                       credentialsId               : 'Assembla secret',
                                       depthOption                 : 'infinity',
                                       ignoreExternalsOption       : true,
                                       local                       : location,
                                       remote                      : svn_url
                               ]],
            quietOperation  : true,
            workspaceUpdater: [$class: 'UpdateUpdater']
    ])
}