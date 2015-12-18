EntidadBancariaInsertController.$inject = ['$scope', '$location', 'entidadBancariaService'];
function EntidadBancariaInsertController($scope, $location, entidadBancariaService) {
    $('#datepicker').datepicker({dateFormat: 'yy-mm-dd'});
    $scope.entidadBancaria = {};

    $scope.insert = function () {
     //   $scope.entidadBancaria.creationDate = new Date($scope.entidadBancaria.creationDate);
        $scope.entidadBancaria.cif = $scope.entidadBancaria.cif.toUpperCase();
        var response = entidadBancariaService.insert($scope.entidadBancaria);
        response.success(function (data, status, headers, config) {
            alert("Insert successful");
            $location.path('/entidadbancaria/list');
            
        }).error(function (data, status, headers, config) {
            if (status === 400) {
                $scope.errors = data;
            } else {
                alert("Ha fallado la petición HTTP. Estado HTTP: " + status);
            }
        });
    };
}
app.controller("EntidadBancariaInsertController", EntidadBancariaInsertController);
