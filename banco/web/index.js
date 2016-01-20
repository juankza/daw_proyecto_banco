IndexController.$inject = ['$scope', '$location', '$http','baseApi'];
function IndexController($scope, $location, $http,baseApi) {
    $scope.loginData = {};
    $scope.login = function () {
        var response = $http({
            method: 'POST',
            url: baseApi + '/api/session',
            data: $scope.loginData,
            headers: {"Access-Control-Allow-Origin":"*"}
        });
        response.success(function (data, status, headers, config) {
            location.href="./main.html";
        }).error(function (data, status, headers, config) {
            if (status === 400) {
                $scope.errors = data;
                
            }else{
                alert("Ha fallado la petición HTTP. Estado: "+status);
                console.log($scope.loginData);
            }
        });
    };

}
loginApp.controller("IndexController", IndexController);