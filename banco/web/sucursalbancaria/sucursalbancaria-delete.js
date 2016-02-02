SucursalBancariaDeleteController.$inject = ['sucursalBancariaService', '$scope', '$routeParams','$location'];
function SucursalBancariaDeleteController(sucursalBancariaService, $scope, $routeParams,$location) {

    var response = sucursalBancariaService.detail($routeParams.idSucursalBancaria);
    response.success(function (data, status, headers, config) {
        $scope.sucursalBancaria = data;
        var fechaCreacion = new Date($scope.sucursalBancaria.fechaCreacion);
        $scope.sucursalBancaria.fechaCreacion = fechaCreacion.getFullYear() + "-" + (fechaCreacion.getMonth() + 1) + "-" + fechaCreacion.getDate();
    }).error(function (data, status, headers, config) {
        alert("3Detail HTTP request failed. Status: " + status);

    });
    $scope.delete = function () {
        var response = sucursalBancariaService.delete($routeParams.idSucursalBancaria);
        response.success(function (data, status, headers, config) {
        alert("Borrado correctamente.");
        $location.path("/entidadbancaria/list");
    }).error(function (data, status, headers, config) {
         if (status === 400) {
                $scope.errors = data;
            } else {
                alert("Ha fallado la petición HTTP. Estado HTTP: " + status);
            }
    });
    };
}
app.controller("SucursalBancariaDeleteController", SucursalBancariaDeleteController);
