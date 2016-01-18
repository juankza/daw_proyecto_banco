app.config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/cuentabancaria/list', {
            templateUrl: "./cuentabancaria/cuentabancaria-list.html",
            controller: "CuentaBancariaListController"
        });
        $routeProvider.when('/cuentabancaria/detail/:idCuentaBancaria', {
            templateUrl: "./cuentabancaria/cuentabancaria-detail.html",
            controller: "CuentaBancariaDetailController"
        });
        $routeProvider.when('/cuentabancaria/insert', {
            templateUrl: "./cuentabancaria/cuentabancaria-insert.html",
            controller: "CuentaBancariaInsertController"
        });
        $routeProvider.when('/cuentabancaria/delete/:idCuentaBancaria', {
            templateUrl: "./cuentabancaria/cuentabancaria-delete.html",
            controller: "CuentaBancariaDeleteController"
        });
        $routeProvider.when('/cuentabancaria/:idCuentaBancaria/movimientos', {
            templateUrl: "./cuentabancaria/cuentabancaria-getmovimientosbycuenta.html",
            controller: "CuentaBancariaGetMovimientosByCuentaController"
        });
    }]);
