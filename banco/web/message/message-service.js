MessageService.$inject = ['$log'];
function MessageService($log) {
    this.errorMessages = [],      // [ { 'fieldName' : '' , 'message' : '' } , { ... } ]
    this.infoMessages = [],       // [ { 'fieldName' : '' , 'message' : '' } , { ... } ]
    
    this.console = function(messages, level) {
        switch(level.toUpperCase()) {
            case 'LOG' : {
                $log.log(messages);
                break;
            }
            case 'DEBUG' : {
                $log.debug(messages);
                break;
            }
            case 'WARN' : {
                $log.warn(messages);
                break;
            }
            case 'ERROR' : {
                $log.error(messages);
                break;
            }
            default : {
                $log.log(messages);
                break;
            }
        }
    },
    
    this.showError = function(level) {
        // div --> ng-class="{ warning: businessMessage.type==='WARNING',error: " ...
        switch(level.toUpperCase()) {
            default : {
                jQuery('#errorModal').modal('show');
                break;
            }
        }
    },
    
    this.showInfo = function() {
        jQuery('#infoModal').modal('show');
    };
}
app.service("messageService", MessageService);
