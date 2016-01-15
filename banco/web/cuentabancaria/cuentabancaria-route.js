app.config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/cuentabancaria/list', {
            templateUrl: "./cuentabancaria/cuentabancaria-list.html",
            controller: "CuentaBancariaListController"
        });
        $routeProvider.when('/cuentabancaria/detail/:idCuentaBancaria', {
            templateUrl: "./cuentabancaria/cuentabancaria-detail.html",
            controller: "CuentaBancariaDetailController"
        });
    }]);
