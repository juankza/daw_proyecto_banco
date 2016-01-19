SucursalBancariaListController.$inject = ['$scope', 'sucursalBancariaService'];
function SucursalBancariaListController($scope, sucursalBancariaService) {
    var response = sucursalBancariaService.list();

    response.success(function (data, status, headers, config) {
        $scope.sucursalesBancarias = data;
    }).error(function (data, status, headers, config) {
        alert("HTTP request failed. Status: " + status);
    });
}
app.controller("SucursalBancariaListController", SucursalBancariaListController);