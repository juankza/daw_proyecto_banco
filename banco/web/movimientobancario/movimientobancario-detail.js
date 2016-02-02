MovimientoBancarioDetailController.$inject = ['$scope','movimientoBancarioService','$routeParams'];
function MovimientoBancarioDetailController($scope,movimientoBancarioService,$routeParams){
    var response = movimientoBancarioService.detail($routeParams.idMovimientoBancario);
    response.success(function (data, status, headers, config) {
        $scope.movimientoBancario = data;
        $scope.movimientoBancario.cantidad += "€";
        $scope.movimientoBancario.saldo += "€";
        $scope.movimientoBancario.fecha = new Date($scope.movimientoBancario.fecha);
        $scope.movimientoBancario.fecha = $scope.movimientoBancario.fecha.getFullYear() + "-" + ($scope.movimientoBancario.fecha.getMonth()+1) + "-" + $scope.movimientoBancario.fecha.getDate();
    }).error(function (data, status, headers, config) {
        alert("2Detail HTTP request failed. Status: " + status);
        console.log(data);
    });
}
app.controller("MovimientoBancarioDetailController",MovimientoBancarioDetailController);