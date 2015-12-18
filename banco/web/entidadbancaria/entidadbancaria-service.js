function EntidadBancariaService($http){
    this.list = function(){
          var response = $http(config = {
            method: 'GET',
            url: '/api/entidadbancaria'
        });
        return response;
    };
    
    this.detail = function(idEntidadBancaria){
        var response = $http({
            method: 'GET',
            url: '/api/entidadbancaria/' + idEntidadBancaria
        });
        return response;
    };
    this.insert = function(entidadBancaria){
        var response = $http({
            method: 'POST',
            url: '/api/entidadbancaria/',
            data: entidadBancaria
            
        });
        return response;
    };
    this.delete = function(idEntidadBancaria){
        var response = $http({
           method: 'DELETE',
           url: '/api/entidadbancaria/' + idEntidadBancaria
        });
        return response;
    };
    this.update = function(entidadBancaria){
        var response = $http({
           method: 'PUT',
           url: '/api/entidadbancaria/' + entidadBancaria.idEntidadBancaria,
           data: entidadBancaria
        });
        return response;
    };
}
EntidadBancariaService.$inject = ['$http'];
app.service("entidadBancariaService",EntidadBancariaService);