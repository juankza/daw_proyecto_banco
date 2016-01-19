CuentaBancariaDetailController.$inject = ['cuentaBancariaService','$scope','$routeParams'];
function CuentaBancariaDetailController(cuentaBancariaService,$scope,$routeParams){
    var response = cuentaBancariaService.detail($routeParams.idCuentaBancaria);
     response.success(function (data, status, headers, config) {
        $scope.cuentaBancaria = data;
        $scope.ccc = $scope.cuentaBancaria.sucursalBancaria.entidadBancaria.codigoEntidadBancaria + " " + $scope.cuentaBancaria.sucursalBancaria.codigoSucursalBancaria + " " + $scope.cuentaBancaria.digitoControl + " " + $scope.cuentaBancaria.numeroCuenta;
        $scope.sucursal = $scope.cuentaBancaria.sucursalBancaria.codigoSucursalBancaria + "  " + $scope.cuentaBancaria.sucursalBancaria.direccion;
        $scope.usuario = $scope.cuentaBancaria.usuario.nombre + " " + $scope.cuentaBancaria.usuario.apellidos;
    }).error(function (data, status, headers, config) {
        alert("Ha fallado la petición HTTP. Estado: " + status);    
    });
}
app.controller("CuentaBancariaDetailController",CuentaBancariaDetailController);