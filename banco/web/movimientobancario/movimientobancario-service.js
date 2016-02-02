MovimientoBancarioService.$inject = ['$http'];
function MovimientoBancarioService($http){
    this.detail = function(idMovimientoBancario){
      var response = $http({
            method: 'GET',
            url: '/api/movimientobancario/' + idMovimientoBancario
        });
        return response;  
    };
    this.insert = function(movimientoBancario){
        var response = $http({
           method: 'POST',
           url: '/api/movimientobancario',
           data: movimientoBancario
        });
        return response;
    };
}
app.service("movimientoBancarioService",MovimientoBancarioService);