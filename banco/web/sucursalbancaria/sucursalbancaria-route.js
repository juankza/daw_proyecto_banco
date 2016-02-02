app.config(['$routeProvider', function ($routeProvider) {
      $routeProvider.when('/sucursalbancaria/detail/:idSucursalBancaria', {
            templateUrl: "./sucursalbancaria/sucursalbancaria-detail.html",
            controller: "SucursalBancariaDetailController"
        });
        $routeProvider.when('/sucursalbancaria/insert/:idEntidadBancaria', {
            templateUrl: "./sucursalbancaria/sucursalbancaria-insert.html",
            controller: "SucursalBancariaInsertController"
        });
        $routeProvider.when('/sucursalbancaria/delete/:idSucursalBancaria', {
            templateUrl: "./sucursalbancaria/sucursalbancaria-delete.html",
            controller: "SucursalBancariaDeleteController"
        });
         $routeProvider.when('/sucursalbancaria/update/:idSucursalBancaria', {
            templateUrl: "./sucursalbancaria/sucursalbancaria-update.html",
            controller: "SucursalBancariaUpdateController"
        });

        
    }]);