SucursalBancariaService.$inject = ['$http'];
function SucursalBancariaService($http){
    this.list = function(){
      var response = $http({
            method: 'GET',
            url: '/api/sucursalbancaria'
        });
        return response;  
    };
}
app.service("sucursalBancariaService",SucursalBancariaService);