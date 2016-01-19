EntidadBancariaGetSucursalesByEntidadController.$inject = ['$scope','entidadBancariaService','$routeParams'];
function EntidadBancariaGetSucursalesByEntidadController($scope, entidadBancariaService,$routeParams){
    var response = entidadBancariaService.getSucursalesByEntidad($routeParams.idEntidadBancaria);
    response.success(function (data, status, headers, config) {
        $scope.sucursalesBancarias = data;
        
    }).error(function (data, status, headers, config) {
        alert("Ha fallado la petición HTTP. Estado: " + status);    
    });
}
app.controller("EntidadBancariaGetSucursalesByEntidadController",EntidadBancariaGetSucursalesByEntidadController);