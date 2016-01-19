CuentaBancariaService.$inject = ['$http'];
function CuentaBancariaService($http) {
    this.list = function () {
        var response = $http({
            method: 'GET',
            url: '/api/cuentabancaria'
        });
        return response;
    };
    this.detail = function (idCuentaBancaria) {
        var response = $http({
            method: 'GET',
            url: '/api/cuentabancaria/' + idCuentaBancaria
        });
        return response;
    };

    this.insert = function (cuentaBancaria) {
        var response = $http({
            method: 'POST',
            url: '/api/cuentabancaria',
            data: cuentaBancaria
        });
        return response;
    };
    
    this.delete = function(idCuentaBancaria){
         var response = $http({
            method: 'DELETE',
            url: '/api/cuentabancaria/' + idCuentaBancaria
        });
        return response;
    };
    this.getMovimientosByCuenta = function(idCuentaBancaria){
        var response = $http({
            method: 'GET',
            url: '/api/cuentabancaria/' + idCuentaBancaria + "/movimientobancario"
        });
        return response;
    };
    this.findByDni = function(dni){
        var response = $http({
        method: 'GET',
        url: '/api/cuentabancaria/search',
        params: {dni: dni}
        });
        return response;
    };
}
app.service("cuentaBancariaService", CuentaBancariaService);