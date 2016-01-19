app.config(['$routeProvider', function ($routeProvider) {
      $routeProvider.when('/movimientobancario/detail/:idMovimientoBancario', {
            templateUrl: "./movimientobancario/movimientobancario-detail.html",
            controller: "MovimientoBancarioDetailController"
        });
        $routeProvider.when('/movimientobancario/insert/:idCuentaBancaria', {
            templateUrl: "./movimientobancario/movimientobancario-insert.html",
            controller: "MovimientoBancarioInsertController"
        });

        
    }]);