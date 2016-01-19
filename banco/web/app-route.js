loginApp.config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/', {
            templateUrl : "login.html"
        });
        $routeProvider.otherwise({
            redirectTo : "/"
        });
        $routeProvider.when('/easter',{
            templateUrl : 'register.html'
        });    
        
    }
]);
