EntidadBancariaDetailController.$inject = ['$routeParams','$scope','entidadBancariaService'];
function EntidadBancariaDetailController($routeParams,$scope,entidadBancariaService){
    var response;
response = entidadBancariaService.detail($routeParams.idEntidadBancaria);


    response.success(function (data, status, headers, config) {
        $scope.entidadBancaria = data;
        var fechaCreacion = new Date(data.fechaCreacion);
        $scope.entidadBancaria.fechaCreacion = fechaCreacion.getFullYear() + "-" + (fechaCreacion.getMonth()+1) + "-" + fechaCreacion.getDate();
    }).error(function (data, status, headers, config) {
        alert("Detail HTTP request failed. Status: " + status);
        console.log(data);
    });
    
}
app.controller("EntidadBancariaDetailController",EntidadBancariaDetailController);
