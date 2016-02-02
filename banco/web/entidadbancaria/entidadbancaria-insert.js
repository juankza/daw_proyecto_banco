EntidadBancariaInsertController.$inject = ['$scope', '$location', 'entidadBancariaService','messageService'];
function EntidadBancariaInsertController($scope, $location, entidadBancariaService,messageService) {
    $('#datepicker').datepicker({dateFormat: 'yy-mm-dd'});
    $scope.entidadBancaria = {};

    $scope.insert = function () {
     //   $scope.entidadBancaria.creationDate = new Date($scope.entidadBancaria.creationDate);
        $scope.entidadBancaria.cif = $scope.entidadBancaria.cif.toUpperCase();
        var response = entidadBancariaService.insert($scope.entidadBancaria);
        response.success(function (data, status, headers, config) {
            $location.path('/entidadbancaria/list');
            
        }).error(function (data, status, headers, config) {
            if (status === 400) {
                $scope.$parent.errorMessages = data;
                messageService.showError("error");
            } else {
                alert("Ha fallado la petición HTTP. Estado HTTP: " + status);
            }
        });
    };
}
app.controller("EntidadBancariaInsertController", EntidadBancariaInsertController);
