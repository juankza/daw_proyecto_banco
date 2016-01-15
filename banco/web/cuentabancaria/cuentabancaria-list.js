CuentaBancariaListController.$inject = ['cuentaBancariaService','$scope'];
function CuentaBancariaListController(cuentaBancariaService,$scope){
    var response = cuentaBancariaService.list(); 
    
    response.success(function (data, status, headers, config) {
        $scope.cuentasBancarias = data;
    }).error(function (data, status, headers, config) {
        alert("Ha fallado la petición HTTP. Estado: " + status);    
    });
    
}
app.controller("CuentaBancariaListController",CuentaBancariaListController);