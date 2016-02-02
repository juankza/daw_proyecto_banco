SessionService.$inject = ['$http', '$q'];
function SessionService($http, $q) {
    this.session = noSession(),
    
    this.login = function(data) {
        var that = this;
        var defered = $q.defer();
        var promise = defered.promise;
        
        var response = $http({
            method: 'POST',
            url: '/api/session',
            data: data
        });
        
        response.then(function(response) {
            angular.merge(that.session, response.data);
            defered.resolve(that.session);
        }, function(response) {
            if(response.status === 400) {
                defered.reject(response.data);
            } else {
                throw Error(response.data);
            }
        });
        
        return promise;
    },
    
    this.logout = function() {
        var that = this;
        var defered = $q.defer();
        var promise = defered.promise;
        
        var response = $http({
            method: 'DELETE',
            url: '/api/session'
        });
        
        response.then(function(response) {
            angular.merge(that.session, noSession());
            defered.resolve(that.session);
        }, function(response) {
            if(response.status === 400) {
                defered.reject(response.data);
            } else {
                throw Error(response.data);
            }
        });
        
        return promise;
    },
    
    this.logged = function() {
        var that = this;
        var defered = $q.defer();
        var promise = defered.promise;
        
        var response = $http({
            method: 'GET',
            url: '/api/session'
        });
        
        response.then(function(response) {
            if(response.status === 200) {
                angular.merge(that.session, response.data);
            } else {
                angular.merge(that.session, noSession());
            }
            defered.resolve(that.session);
        }, function(response) {
            if(response.status === 400) {
                defered.reject(response.data);
                angular.merge(that.session, noSession());
            } else {
                throw Error(response.data);
            }
        });
        
        return promise;
    };
}
app.service("sessionService", SessionService);

function noSession() {
    return { 'usuario' : null , 'fecha' : (new Date()).getTime() };
}
