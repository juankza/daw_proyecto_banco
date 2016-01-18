MovimientoBancarioDetailController.$inject = ['$scope','movimientoBancarioService','$routeParams'];
function MovimientoBancarioDetailController($scope,movimientoBancarioService,$routeParams){
    var response = movimientoBancarioService.detail($routeParams.idMovimientoBancario);
    response.success(function (data, status, headers, config) {
        $scope.movimientoBancario = data;
        for (var i = 0; i < $scope.movimientosBancarios.length; i++) {
            var fecha = new Date($scope.movimientosBancarios[i].fecha);
           $scope.movimientosBancarios[i].fecha =  fecha.getFullYear() + "-" + (fecha.getMonth()+1) + "-" + fecha.getDate();
        }
    }).error(function (data, status, headers, config) {
        alert("Detail HTTP request failed. Status: " + status);
        console.log(data);
    });
}
app.controller("MovimientoBancarioDetailController",MovimientoBancarioDetailController);