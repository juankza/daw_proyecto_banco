app.config(['$routeProvider', function ($routeProvider) {
      $routeProvider.when('/sucursalbancaria/detail/:idSucursalBancaria', {
            templateUrl: "./sucursalbancaria/sucursalbancaria-detail.html",
            controller: "SucursalBancariaDetailController"
        });

        
    }]);