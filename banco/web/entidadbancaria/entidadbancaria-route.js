app.config(['$routeProvider', function ($routeProvider) {
      $routeProvider.when('/entidadbancaria/list', {
            templateUrl: "./entidadbancaria/entidadbancaria-list.html",
            controller: "EntidadBancariaListController"
        });
        $routeProvider.when('/entidadbancaria/detail/:idEntidadBancaria', {
            templateUrl: "./entidadbancaria/entidadbancaria-detail.html",
            controller: "EntidadBancariaDetailController"
        });
         $routeProvider.when('/entidadbancaria/insert', {
            templateUrl: "./entidadbancaria/entidadbancaria-insert.html",
            controller: "EntidadBancariaInsertController"
        });
         $routeProvider.when('/entidadbancaria/delete/:idEntidadBancaria', {
            templateUrl: "./entidadbancaria/entidadbancaria-delete.html",
            controller: "EntidadBancariaDeleteController"
        });
         $routeProvider.when('/entidadbancaria/update/:idEntidadBancaria', {
            templateUrl: "./entidadbancaria/entidadbancaria-update.html",
            controller: "EntidadBancariaUpdateController"
        });
        
    }]);