app.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/movimientobancario/insert/:idCuentaBancaria', {
        templateUrl: "./movimientobancario/movimientobancario-insert.html",
        controller: "MovimientoBancarioInsertController"
    });
}]);