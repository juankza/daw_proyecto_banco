CuentaBancariaGetMovimientosByCuentaController.$inject = ['cuentaBancariaService','$scope','$routeParams'];
function CuentaBancariaGetMovimientosByCuentaController(cuentaBancariaService,$scope,$routeParams){
    
    var response = cuentaBancariaService.detail($routeParams.idCuentaBancaria);
    response.success(function (data, status, headers, config) {
        $scope.cuentaBancaria = data;
    }).error(function (data, status, headers, config) {
        alert("Ha fallado la petición HTTP. Estado: " + status);    
    });
    
    
    
    
    
    
    var response = cuentaBancariaService.getMovimientosByCuenta($routeParams.idCuentaBancaria);
   response.success(function (data, status, headers, config) {
        $scope.movimientosBancarios = data;
        for (var i = 0; i < $scope.movimientosBancarios.length; i++) {
            var fecha = new Date($scope.movimientosBancarios[i].fecha);
           $scope.movimientosBancarios[i].fecha =  fecha.getFullYear() + "-" + (fecha.getMonth()+1) + "-" + fecha.getDate();
        }
    }).error(function (data, status, headers, config) {
        alert("Ha fallado la petición HTTP. Estado: " + status);    
    });
}
app.controller("CuentaBancariaGetMovimientosByCuentaController",CuentaBancariaGetMovimientosByCuentaController);