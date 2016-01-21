SucursalBancariaService.$inject = ['$http'];
function SucursalBancariaService($http){
    this.list = function(){
      var response = $http({
            method: 'GET',
            url: '/api/sucursalbancaria'
        });
        return response;  
    };
    this.detail = function(idSucursalBancaria){
        var response = $http({
        method : 'GET',
        url: '/api/sucursalbancaria/' + idSucursalBancaria
        });
        return response;
    };
    this.insert = function(sucursalBancaria){
      var response = $http({
         method: 'POST',
         url: '/api/sucursalbancaria',
         data: sucursalBancaria
      }); 
      return response;
    };
    this.delete = function(idSucursalBancaria){
      var response = $http({
          method: 'DELETE',
          url: '/api/sucursalbancaria/' + idSucursalBancaria
      });
      return response;
    };
    this.update = function(sucursalBancaria){
        var response = $http({
           method: 'PUT',
           url: '/api/sucursalbancaria/' + sucursalBancaria.idSucursalBancaria,
           data: sucursalBancaria
        });
        return response;
    };
}
app.service("sucursalBancariaService",SucursalBancariaService);