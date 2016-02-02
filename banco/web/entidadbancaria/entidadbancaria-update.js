EntidadBancariaUpdateController.$inject = ['$scope', '$location', 'entidadBancariaService', '$routeParams','messageService'];
function EntidadBancariaUpdateController($scope, $location, entidadBancariaService, $routeParams,messageService) {
    
    $('#datepicker').datepicker({dateFormat: 'yy-mm-dd'});
    var response = entidadBancariaService.detail($routeParams.idEntidadBancaria).success(function (data, status, headers, config) {
      
        $scope.entidadBancaria = data;
        var fechaCreacion = new Date(data.fechaCreacion);
        $scope.entidadBancaria.fechaCreacion = fechaCreacion.getFullYear() + "-" + (fechaCreacion.getMonth()+1) + "-" + fechaCreacion.getDate();
    }).error(function (data, status, headers, config) {
        alert("HTTP request failed. Status: " + status);
    });
    
    $scope.update = function () {
       var response = entidadBancariaService.update($scope.entidadBancaria).success(function (data, status, headers, config) {
            alert("Actualizado correctamente.");
            $location.path('/entidadbancaria/detail/' + $scope.entidadBancaria.idEntidadBancaria);
        }).error(function (data, status, headers, config) {
            if (status === 400) {
                $scope.$parent.errorMessages = data;
                messageService.showError("error");
            } else {
                alert("HTTP request failed. Status: " + status);
            }
        });
    }


}

app.controller("EntidadBancariaUpdateController", EntidadBancariaUpdateController);