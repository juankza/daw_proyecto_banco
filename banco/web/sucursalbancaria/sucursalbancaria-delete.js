SucursalBancariaDeleteController.$inject = ['sucursalBancariaService', '$scope', '$routeParams','$location','messageService'];
function SucursalBancariaDeleteController(sucursalBancariaService, $scope, $routeParams,$location,messageService) {

    var response = sucursalBancariaService.detail($routeParams.idSucursalBancaria);
    response.success(function (data, status, headers, config) {
        $scope.sucursalBancaria = data;
        var fechaCreacion = new Date($scope.sucursalBancaria.fechaCreacion);
        $scope.sucursalBancaria.fechaCreacion = fechaCreacion.getFullYear() + "-" + ("0" + (fechaCreacion.getMonth() + 1)).slice(-2) + "-" + ("0" + fechaCreacion.getDate()).slice(-2);
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
                $scope.$parent.errorMessages = data;
                messageService.showError("error");
            } else {
                alert("Ha fallado la petición HTTP. Estado HTTP: " + status);
            }
    });
    };
}
app.controller("SucursalBancariaDeleteController", SucursalBancariaDeleteController);
