EntidadBancariaDeleteController.$inject = ['$scope','$routeParams','entidadBancariaService','$location'];
function EntidadBancariaDeleteController($scope,$routeParams,entidadBancariaService,$location){
    
    var response = entidadBancariaService.detail($routeParams.idEntidadBancaria).success(function (data, status, headers, config) {
        $scope.entidadBancaria = data;
        var fechaCreacion = new Date(data.fechaCreacion);
        $scope.entidadBancaria.fechaCreacion = fechaCreacion.getFullYear() + "-" + (fechaCreacion.getMonth()+1) + "-" + fechaCreacion.getDate();
    }).error(function (data, status, headers, config) {
        alert("Ha fallado la petición HTTP. Estado: " + status);
    });
    $scope.delete = function(){
        response = entidadBancariaService.delete($routeParams.idEntidadBancaria).success(function (data, status, headers, config) {
        alert("Borrado correctamente.");
        $location.path("/entidadbancaria/list");
    }).error(function (data, status, headers, config) {
        alert("Ha fallado la petición HTTP. Estado: " + status);
    });
        
    }
}
app.controller("EntidadBancariaDeleteController",EntidadBancariaDeleteController);