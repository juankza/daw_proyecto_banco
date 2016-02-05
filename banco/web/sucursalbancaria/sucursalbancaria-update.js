SucursalBancariaUpdateController.$inject = ['$scope', 'sucursalBancariaService', '$routeParams','$location','messageService'];
function SucursalBancariaUpdateController($scope, sucursalBancariaService, $routeParams,$location,messageService) {
    var response = sucursalBancariaService.detail($routeParams.idSucursalBancaria);
    response.success(function (data, status, headers, config) {
        $scope.sucursalBancaria = data;
        var fechaCreacion = new Date($scope.sucursalBancaria.fechaCreacion);
        $scope.sucursalBancaria.fechaCreacion = fechaCreacion.getFullYear() + "-" + ("0" + (fechaCreacion.getMonth() + 1)).slice(-2) + "-" + ("0" + fechaCreacion.getDate()).slice(-2);
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
                $scope.$parent.errorMessages = data;
                messageService.showError("error");
            } else {
                alert(" HTTP request failed. Status: " + status);

            }

        });
    };




}
app.controller("SucursalBancariaUpdateController", SucursalBancariaUpdateController);