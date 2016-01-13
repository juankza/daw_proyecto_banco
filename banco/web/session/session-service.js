SessionService.$inject = ['$http'];
function SessionService($http){
    this.logout = function(){
        var response = $http({
            method: 'DELETE',
            url: '/api/session'
        });
        return response;
    };
}
app.service("sessionService",SessionService);