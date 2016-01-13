
EntidadBancariaListController.$inject = ['$scope','entidadBancariaService'];
function EntidadBancariaListController($scope,entidadBancariaService) {
    var response;
     response = entidadBancariaService.list();
    response.success(function (data, status, headers, config) {
        $scope.entidadesBancarias = data;
    }).error(function (data, status, headers, config) {
        alert("HTTP request failed. Status: " + status);    
    });
}
app.controller("EntidadBancariaListController", EntidadBancariaListController);