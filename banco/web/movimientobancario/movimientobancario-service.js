MovimientoBancarioService.$inject = ['$http'];
function MovimientoBancarioService($http){
    this.detail = function(idMovimientoBancario){
      var response = $http({
            method: 'GET',
            url: '/api/movimientobancario/' + idMovimientoBancario
        });
        return response;  
    };
}
app.service("movimientoBancarioService",MovimientoBancarioService);