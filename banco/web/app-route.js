app.config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/', {
            templateUrl : "main.html",
            controller : "MainController"
        });
        $routeProvider.when('/login', {
            templateUrl : "login/login.html",
            controller : "LoginController"
        });
        $routeProvider.otherwise({
            redirectTo : "/"
        });
    }
]);
