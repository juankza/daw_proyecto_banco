MovimientoBancarioInsertController.$inject = ['movimientoBancarioService', '$scope', '$routeParams', 'cuentaBancariaService','messageService', '$location'];
function MovimientoBancarioInsertController(movimientoBancarioService, $scope, $routeParams, cuentaBancariaService,messageService, $location) {
    $('#datepicker').datepicker({dateFormat: 'yy-mm-dd'});
    $scope.movimientoBancario = {};
    
    var fecha = new Date();
    $scope.movimientoBancario.fecha = fecha.getFullYear() + "-" + ("0" + (fecha.getMonth() + 1)).slice(-2) + "-" + ("0" + fecha.getDate()).slice(-2);
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
        $location.path("cuentabancaria/detail/" + $scope.cuentaBancaria.idCuentaBancaria);
    }).error(function (data, status, headers, config) {
       if (status === 400) {
                $scope.$parent.errorMessages = data;
                messageService.showError("error");
            } else {
                alert("Ha fallado la petición HTTP. Estado HTTP: " + status);
            }
    });
    };

}
app.controller("MovimientoBancarioInsertController", MovimientoBancarioInsertController);