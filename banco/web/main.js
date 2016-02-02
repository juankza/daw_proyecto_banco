MainController.$inject = ['$scope', '$location', 'messageService', 'sessionService'];
function MainController($scope, $location, messageService, sessionService) {
    sessionService.logged().then(function(webSession) {
        
    }, function(errorMessages) {
        $scope.$parent.errorMessages = errorMessages;
        messageService.showError("error");
        $location.path("/login");
    });
    
    $scope.$parent.logout;
    
}
app.controller("MainController", MainController);
