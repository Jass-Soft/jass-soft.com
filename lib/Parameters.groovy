class Parameters implements Serializable {

    static final serialVersionUID = 1L

    String jobName;

    def setJobName(String jobName) {
        this.jobName =jobName;
    }
              
    def getEnvironmentType() {
                
        switch(this.jobName) {
            case JobName.DEV_TST:
                return [ 'DEV', 'TST']
            case JobName.MT_PPD:
                return [ 'MT', 'PPD']
            case JobName.PROD:
                return ['PROD']
            default:
                return [JobName.NOT_DEFINED]
        }
    }

    def getEnvironments() {
  
        switch(this.jobName) {
            case JobName.DEV_TST:
                return [ 'DEV1', 'DEV2', 'DEV3', 'DEV4', 'DEV5', 'DEV6', 'DEV7', 'DEV8', 'DEV9', 'DEV10', 'DEV11', 'DEV12', 'DEV13', 'DEV14', 'DEV15', 'TST1', 'TST2', 'TST3', 'TST4', 'TST5', 'TST6', 'TST7', 'TST8', 'TST9', 'TST10', 'TST11', 'TST12', 'TST13', 'TST14', 'TST15', 'TST16', 'TST17', 'UAT1', 'UAT2']
            case JobName.MT_PPD:
                return [ 'MTST', 'PPDL', 'PPDC' ]
            case JobName.PROD:
                return [ 'PRDL', 'PRDC' ]
            default:
                return [JobName.NOT_DEFINED]                        
        }
    }

    def getAgent() {
                
        switch(this.jobName) {
            case JobName.DEV_TST:
                return 'mduaux1'
            case JobName.MT_PPD:
                return 'mdsamx1'
            case JobName.PROD:
                return 'vx-0000002473'
            default:
                return [JobName.NOT_DEFINED]
        }
    }

    def getVaultName() {
                
        switch(this.jobName) {
            case JobName.DEV_TST:
                return 'mdsansibledev'
            case JobName.MT_PPD:
                return 'mdsansibledev'
            case JobName.PROD:
                return 'mdsansibleprod'
            default:
                return [JobName.NOT_DEFINED]
        }
    }

    interface JobName {
        final String DEV_TST="Test"
        final String MT_PPD="ACUAnsible/NON-PROD/MT PPD Jobs/MDS-ACU MT PPD Deploy"
        final String PROD="ACUAnsible/PROD/MDS-ACU Deploy"
        final NOT_DEFINED="Job not defined. Make sure the JOB_NAME matches values in JobName interface"
    }
}


