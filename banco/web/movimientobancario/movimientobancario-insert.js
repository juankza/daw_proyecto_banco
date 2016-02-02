MovimientoBancarioInsertController.$inject = ['movimientoBancarioService', '$scope', '$routeParams', 'cuentaBancariaService'];
function MovimientoBancarioInsertController(movimientoBancarioService, $scope, $routeParams, cuentaBancariaService) {
    $('#datepicker').datepicker({dateFormat: 'yy-mm-dd'});
    $scope.movimientoBancario = {};
    //Obtenemos objeto cuenta que se pasa por ruta
    var response = cuentaBancariaService.detail($routeParams.idCuentaBancaria);
    response.success(function (data, status, headers, config) {
        $scope.cuentaBancaria = data;
        $scope.movimientoBancario.cuentaBancaria = $scope.cuentaBancaria;
        $scope.ccc = $scope.movimientoBancario.cuentaBancaria.sucursalBancaria.entidadBancaria.codigoEntidadBancaria + " " + $scope.movimientoBancario.cuentaBancaria.sucursalBancaria.codigoSucursalBancaria + " " + $scope.movimientoBancario.cuentaBancaria.digitoControl + " " + $scope.movimientoBancario.cuentaBancaria.numeroCuenta;
    }).error(function (data, status, headers, config) {
        alert("Ha fallado la petición HTTP. Estado: " + status);
    });
    //Función de insert
    $scope.insert = function(){
        $scope.movimientoBancario.tipoMovimientoBancario = $scope.tipoMovimientoBancario;
      var response = movimientoBancarioService.insert($scope.movimientoBancario);
      response.success(function (data, status, headers, config) {
        alert("Insertado correctamente.");
    }).error(function (data, status, headers, config) {
       if (status === 400) {
                $scope.errors = data;
            } else {
                alert("Ha fallado la petición HTTP. Estado HTTP: " + status);
            }
    });
    };

}
app.controller("MovimientoBancarioInsertController", MovimientoBancarioInsertController);