IndexController.$inject = ['$scope', '$location', '$http'];
function IndexController($scope, $location, $http) {
    $scope.loginData = {};
    $scope.login = function () {
        var response = $http({
            method: 'POST',
            url: '/api/session',
            data: $scope.loginData
        });
        response.success(function (data, status, headers, config) {
            location.href="./main.html";
        }).error(function (data, status, headers, config) {
            if (status === 400) {
                $scope.errores = data;
                alert(JSON.stringify($scope.errores));
                
            }else{
                alert("Ha fallado la petición HTTP. Estado: "+status);
                console.log($scope.loginData);
            }
        });
    };

}
loginApp.controller("IndexController", IndexController);