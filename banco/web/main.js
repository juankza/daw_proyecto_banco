MainController.$inject = ['$scope', 'sessionService'];
function MainController($scope, sessionService) {
    $scope.logout = function () {
        var response = sessionService.logout(); 
        response.success(function (data, status, headers, config) {
            location.href = "/banco";
        }).error(function (data, status, headers, config) {
            alert("Ha fallado la petición HTTP. Estado: " + status);
        });
    };

}
app.controller("MainController", MainController);