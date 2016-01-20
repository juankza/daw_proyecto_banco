MainController.$inject = ['$scope', 'sessionService'];
function MainController($scope, sessionService) {
    $scope.logout = function () {
        var response = sessionService.logout(); 
        response.success(function (data, status, headers, config) {
            location.href = "/";
        }).error(function (data, status, headers, config) {
            console.log("[+] LoginService: "+"Ha fallado la petición HTTP. Estado: " + status);
        });
    };

}
app.controller("MainController", MainController);