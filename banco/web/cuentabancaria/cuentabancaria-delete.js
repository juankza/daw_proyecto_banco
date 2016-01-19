CuentaBancariaDeleteController.$inject = ['cuentaBancariaService', '$scope', '$routeParams', '$location'];
function CuentaBancariaDeleteController(cuentaBancariaService, $scope, $routeParams, $location) {
    var response = cuentaBancariaService.detail($routeParams.idCuentaBancaria).success(function (data, status, headers, config) {
        $scope.cuentaBancaria = data;
        var fechaCreacion = new Date(data.fechaCreacion);
        $scope.cuentaBancaria.fechaCreacion = fechaCreacion.getFullYear() + "-" + (fechaCreacion.getMonth() + 1) + "-" + fechaCreacion.getDate();
    }).error(function (data, status, headers, config) {
        alert("HTTP request failed. Status: " + status);
    });



    $scope.delete = function () {
        var response = cuentaBancariaService.delete($routeParams.idCuentaBancaria).success(function (data, status, headers, config) {
        alert("Borrado correctamente.");
        $location.path("/cuentabancaria/list");
    }).error(function (data, status, headers, config) {
        alert("Ha fallado la petición HTTP. Estado: " + status);
    });
    };
}
app.controller("CuentaBancariaDeleteController", CuentaBancariaDeleteController);