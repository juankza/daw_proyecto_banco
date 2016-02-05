CuentaBancariaDetailController.$inject = ['cuentaBancariaService','$scope','$routeParams'];
function CuentaBancariaDetailController(cuentaBancariaService,$scope,$routeParams){
    var response = cuentaBancariaService.detail($routeParams.idCuentaBancaria);
     response.success(function (data, status, headers, config) {
        $scope.cuentaBancaria = data;
        $scope.ccc = $scope.cuentaBancaria.sucursalBancaria.entidadBancaria.codigoEntidadBancaria + " " + $scope.cuentaBancaria.sucursalBancaria.codigoSucursalBancaria + " " + $scope.cuentaBancaria.digitoControl + " " + $scope.cuentaBancaria.numeroCuenta;
        $scope.sucursal = $scope.cuentaBancaria.sucursalBancaria.codigoSucursalBancaria + " " + $scope.cuentaBancaria.sucursalBancaria.direccion;
        $scope.usuario = $scope.cuentaBancaria.usuario.nombre + " " + $scope.cuentaBancaria.usuario.apellidos;
    }).error(function (data, status, headers, config) {
        alert("Ha fallado la petición HTTP. Estado: " + status);
    });
   
    var response = cuentaBancariaService.getMovimientosByCuenta($routeParams.idCuentaBancaria);
   response.success(function (data, status, headers, config) {
        $scope.movimientosBancarios = data;
        for (var i = 0; i < $scope.movimientosBancarios.length; i++) {
            var movimiento = $scope.movimientosBancarios[i];
            
            var fecha = new Date(movimiento.fecha);
            $scope.movimientosBancarios[i].fecha = fecha.getFullYear() + "-" + ("0" + (fecha.getMonth() + 1)).slice(-2) + "-" + ("0" + fecha.getDate()).slice(-2);

            if(movimiento.tipoMovimientoBancario === "DEBER") {
                $scope.movimientosBancarios[i].cantidad = -movimiento.cantidad;
            }
        }
    }).error(function (data, status, headers, config) {
        alert("Ha fallado la petición HTTP. Estado: " + status);
    });
    
}
app.controller("CuentaBancariaDetailController",CuentaBancariaDetailController);