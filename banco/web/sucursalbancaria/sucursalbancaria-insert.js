SucursalBancariaInsertController.$inject = ['$scope', 'sucursalBancariaService', '$routeParams', 'entidadBancariaService'];
function SucursalBancariaInsertController($scope, sucursalBancariaService, $routeParams, entidadBancariaService) {
    $('#datepicker').datepicker({dateFormat: 'yy-mm-dd'});
    $scope.sucursalBancaria = {};


    var response = entidadBancariaService.detail($routeParams.idEntidadBancaria);
    response.success(function (data, status, headers, config) {
        $scope.entidadBancaria = data;
        $scope.sucursalBancaria.entidadBancaria = $scope.entidadBancaria;
    }).error(function (data, status, headers, config) {
        if (status === 400) {
                $scope.errors = data;
            } else {
                alert("Ha fallado la petición HTTP. Estado HTTP: " + status);
            }
    });

    $scope.insert = function () {
        var response = sucursalBancariaService.insert($scope.sucursalBancaria);
        response.success(function (data, status, headers, config) {
            alert("Insertado correctamente.");
        }).error(function (data, status, headers, config) {
            if (status === 400) {
                $scope.errors = data;
            } else {
                alert("Ha fallado la petición HTTP. Estado HTTP: " + status);
            }
        });

    };

}
app.controller("SucursalBancariaInsertController", SucursalBancariaInsertController);

