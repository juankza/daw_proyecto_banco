CuentaBancariaListController.$inject = ['cuentaBancariaService', '$scope', '$location'];
function CuentaBancariaListController(cuentaBancariaService, $scope, $location) {
    var response = cuentaBancariaService.list();

    response.success(function (data, status, headers, config) {
        $scope.cuentasBancarias = data;
    }).error(function (data, status, headers, config) {
        alert("Ha fallado la petición HTTP. Estado: " + status);
    });
    $scope.findByDni = function () {
        if ($scope.dni === undefined) {
            alert("DNI no puede estar vacío.");
        } else {
            var response = cuentaBancariaService.findByDni($scope.dni);
            response.success(function (data, status, headers, config) {
                $scope.cuentasBancarias = data;
                if ($scope.cuentasBancarias == []) {
                    alert("La búsqueda no ha obtenido resultados.");
                    var response = cuentaBancariaService.list();

                    response.success(function (data, status, headers, config) {
                        $scope.cuentasBancarias = data;
                    }).error(function (data, status, headers, config) {
                        alert("Ha fallado la petición HTTP. Estado: " + status);
                    });

                }
            }).error(function (data, status, headers, config) {
                alert("Ha fallado la petición HTTP. Estado: " + status);
            });
        }
    };
}
app.controller("CuentaBancariaListController", CuentaBancariaListController);