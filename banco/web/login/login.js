LoginController.$inject = ['$scope', '$location', 'messageService', 'sessionService'];
function LoginController($scope, $location, messageService, sessionService) {
    $scope.loginData = {};
    
    $scope.login = function() {
        sessionService.login($scope.loginData).then(function(webSession) {
            sessionService.session = webSession;
            $scope.$parent.isLogged = true;
            $location.path("/");
        }, function(errorMessages) {
            $scope.$parent.errorMessages = errorMessages;
            messageService.showError("error");
        });
    };
    
}
app.controller("LoginController", LoginController);

/*

STATUS: 400
DATA:
[
  {
    "fieldName" : null ,
    "message" : "Sessión no iniciada"
  }
]

Solo puedo pasar con var. globales

*/