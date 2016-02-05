SucursalBancariaDetailController.$inject = ['sucursalBancariaService','$scope','$routeParams'];
function SucursalBancariaDetailController(sucursalBancariaService, $scope, $routeParams){
    var response = sucursalBancariaService.detail($routeParams.idSucursalBancaria);
    response.success(function (data, status, headers, config) {
        $scope.sucursalBancaria = data;
        var fechaCreacion = new Date($scope.sucursalBancaria.fechaCreacion);
        $scope.sucursalBancaria.fechaCreacion = fechaCreacion.getFullYear() + "-" + ("0" + (fechaCreacion.getMonth() + 1)).slice(-2) + "-" + ("0" + fechaCreacion.getDate()).slice(-2);
    }).error(function (data, status, headers, config) {
        alert("3Detail HTTP request failed. Status: " + status);
      
    });
}
app.controller("SucursalBancariaDetailController",SucursalBancariaDetailController);