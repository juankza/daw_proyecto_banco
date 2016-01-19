CuentaBancariaInsertController.$inject = ['$scope', 'cuentaBancariaService', 'usuarioService','sucursalBancariaService','$location'];
function CuentaBancariaInsertController($scope, cuentaBancariaService, usuarioService,sucursalBancariaService,$location) {
    $('#datepicker').datepicker({dateFormat: 'yy-mm-dd'});

    var response = usuarioService.list();

    response.success(function (data, status, headers, config) {
        $scope.usuarios = data;
    }).error(function (data, status, headers, config) {
        alert("Ha fallado la petición HTTP. Estado: " + status);
    });

    var response = sucursalBancariaService.list();
    response.success(function (data, status, headers, config) {
        $scope.sucursalesBancarias = data;
    }).error(function (data, status, headers, config) {
        alert("Ha fallado la petición HTTP. Estado: " + status);
    });
    

    $scope.cuentaBancaria = {};

    $scope.insert = function () {
        
        var response = cuentaBancariaService.insert($scope.cuentaBancaria);
        response.success(function (data, status, headers, config) {
            alert("Insertado correctamente");
            $location.path('/cuentabancaria/list');

        }).error(function (data, status, headers, config) {
            if (status === 400) {
                $scope.errors = data;
            } else {
                alert("Ha fallado la petición HTTP. Estado HTTP: " + status);
            }
        });
    };
}
app.controller("CuentaBancariaInsertController", CuentaBancariaInsertController);