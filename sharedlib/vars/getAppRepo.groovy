def getAppRepo(repo, v, location = '.') {
    def svn_url = "https://subversion.assembla.com/svn/CognisantMD"
    if (v?.equals('trunk')) {
        svn_url += "/app/${repo}"
    } else {
        svn_url += "/releases/app/${repo}"
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