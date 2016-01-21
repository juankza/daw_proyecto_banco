EntidadBancariaDetailController.$inject = ['$routeParams','$scope','entidadBancariaService'];
function EntidadBancariaDetailController($routeParams,$scope,entidadBancariaService){
    var response;
    
response = entidadBancariaService.detail($routeParams.idEntidadBancaria);


    response.success(function (data, status, headers, config) {
        $scope.entidadBancaria = data;
        var fechaCreacion = new Date(data.fechaCreacion);
        $scope.entidadBancaria.fechaCreacion = fechaCreacion.getFullYear() + "-" + (fechaCreacion.getMonth()+1) + "-" + fechaCreacion.getDate();
    }).error(function (data, status, headers, config) {
        alert("1Detail HTTP request failed. Status: " + status);
        console.log(data);
    });

 
    var response = entidadBancariaService.getSucursalesByEntidad($routeParams.idEntidadBancaria);
    response.success(function (data, status, headers, config) {
        $scope.sucursalesBancarias = data;
        
    }).error(function (data, status, headers, config) {
        alert("Ha fallado la petición HTTP. Estado: " + status);    
    });
}
app.controller("EntidadBancariaDetailController",EntidadBancariaDetailController);
