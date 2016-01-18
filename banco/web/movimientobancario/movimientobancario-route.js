app.config(['$routeProvider', function ($routeProvider) {
      $routeProvider.when('/movimientobancario/detail/:idMovimientoBancario', {
            templateUrl: "./movimientobancario/movimientobancario-detail.html",
            controller: "MovimientoBancarioDetailController"
        });

        
    }]);