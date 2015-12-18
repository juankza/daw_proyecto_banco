app.config(['$routeProvider', function ($routeProvider) {
      $routeProvider.when('/usuario/list', {
            templateUrl: "./usuario/usuario-list.html",
            controller: "UsuarioListController"
        });
         $routeProvider.when('/usuario/detail/:idUsuario', {
            templateUrl: "./usuario/usuario-detail.html",
            controller: "UsuarioDetailController"
        });
        $routeProvider.when('/usuario/insert', {
            templateUrl: "./usuario/usuario-insert.html",
            controller: "UsuarioInsertController"
        });
          $routeProvider.when('/usuario/delete/:idUsuario', {
            templateUrl: "./usuario/usuario-delete.html",
            controller: "UsuarioDeleteController"
        });
         $routeProvider.when('/usuario/update/:idUsuario', {
            templateUrl: "./usuario/usuario-update.html",
            controller: "UsuarioUpdateController"
        });
    }]);