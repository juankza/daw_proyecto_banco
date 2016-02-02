IndexController.$inject = ['$scope', '$location', 'messageService', 'sessionService'];
function IndexController($scope, $location, messageService, sessionService) {
    $scope.errorMessages; $scope.infoMessages;
    $scope.session = sessionService.session;
    $scope.isLogged;
    
    $scope.logout = function() {
        $scope.isLogged = false;
        sessionService.logout().then(function(webSession) {
            $location.path("/login");
        }, function(errorMessages) {
            $scope.errorMessages = errorMessages;
            messageService.showError("error");
        });
    };
    
    sessionService.logged().then(function(webSession) {
        $scope.isLogged = true;
    }, function(errorMessages) {
        $scope.isLogged = false;
    });
    
    $scope.toggleText = true;
    $scope.$watch('toggleText', function() {
        $scope.menuText = $scope.toggleText ? "Mi cuenta" : "Menú";
    });
    
    $scope.$watch('isLogged', function() {
        jQuery("body").css({ 'background' : $scope.isLogged ? "none" : "url('img/background.png') no-repeat" });
    });
    
}
app.controller("IndexController", IndexController);

jQuery('#errorModal').modal({ show: false });
jQuery('#infoModal').modal({ show: false });
