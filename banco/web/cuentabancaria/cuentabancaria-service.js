CuentaBancariaService.$inject = ['$http'];
function CuentaBancariaService($http){
    this.list = function(){
          var response = $http({
            method: 'GET',
            url: '/api/cuentabancaria'
        });
        return response;
    };
    this.detail = function(idCuentaBancaria){
          var response = $http({
            method: 'GET',
            url: '/api/cuentabancaria/' + idCuentaBancaria
        });
        return response;
    };
}
app.service("cuentaBancariaService",CuentaBancariaService);