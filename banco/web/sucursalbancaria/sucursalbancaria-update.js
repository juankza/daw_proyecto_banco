SucursalBancariaUpdateController.$inject = ['$scope', 'sucursalBancariaService', '$routeParams','$location'];
function SucursalBancariaUpdateController($scope, sucursalBancariaService, $routeParams,$location) {
    var response = sucursalBancariaService.detail($routeParams.idSucursalBancaria);
    response.success(function (data, status, headers, config) {
        $scope.sucursalBancaria = data;
        var fechaCreacion = new Date($scope.sucursalBancaria.fechaCreacion);
        $scope.sucursalBancaria.fechaCreacion = fechaCreacion.getFullYear() + "-" + (fechaCreacion.getMonth() + 1) + "-" + fechaCreacion.getDate();
    }).error(function (data, status, headers, config) {
        alert("3Detail HTTP request failed. Status: " + status);

    });
    $scope.update = function () {
        var response = sucursalBancariaService.update($scope.sucursalBancaria);
        response.success(function (data, status, headers, config) {
            alert("Actualizado correctamente.");
            $location.path("/sucursalbancaria/detail/"+$scope.sucursalBancaria.idSucursalBancaria);
        }).error(function (data, status, headers, config) {
            if (status === 400) {
                $scope.errors = data;
                
            } else {
                alert(" HTTP request failed. Status: " + status);

            }

        });
    };




}
app.controller("SucursalBancariaUpdateController", SucursalBancariaUpdateController);