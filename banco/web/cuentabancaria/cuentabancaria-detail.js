CuentaBancariaDetailController.$inject = ['cuentaBancariaService','$scope','$routeParams'];
function CuentaBancariaDetailController(cuentaBancariaService,$scope,$routeParams){
    var response = cuentaBancariaService.detail($routeParams.idCuentaBancaria);
     response.success(function (data, status, headers, config) {
        $scope.cuentaBancaria = data;
    }).error(function (data, status, headers, config) {
        alert("Ha fallado la petición HTTP. Estado: " + status);    
    });
}
app.controller("CuentaBancariaDetailController",CuentaBancariaDetailController);