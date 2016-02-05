EntidadBancariaDeleteController.$inject = ['$scope','$routeParams','entidadBancariaService','$location','messageService'];
function EntidadBancariaDeleteController($scope,$routeParams,entidadBancariaService,$location,messageService) {
    
    var response = entidadBancariaService.detail($routeParams.idEntidadBancaria).success(function (data, status, headers, config) {
        $scope.entidadBancaria = data;
        var fechaCreacion = new Date(data.fechaCreacion);
        $scope.entidadBancaria.fechaCreacion = fechaCreacion.getFullYear() + "-" + ("0" + (fechaCreacion.getMonth() + 1)).slice(-2) + "-" + ("0" + fechaCreacion.getDate()).slice(-2);
    }).error(function (data, status, headers, config) {
        alert("Ha fallado la petición HTTP. Estado: " + status);
    });
    $scope.delete = function(){
        response = entidadBancariaService.delete($routeParams.idEntidadBancaria).success(function (data, status, headers, config) {
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
        
    }
}
app.controller("EntidadBancariaDeleteController",EntidadBancariaDeleteController);