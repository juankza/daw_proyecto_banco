EntidadBancariaUpdateController.$inject = ['$scope', '$location', 'entidadBancariaService', '$routeParams'];
function EntidadBancariaUpdateController($scope, $location, entidadBancariaService, $routeParams) {
    
    $('#datepicker').datepicker({dateFormat: 'yy-mm-dd'});
    var response = entidadBancariaService.detail($routeParams.idEntidadBancaria).success(function (data, status, headers, config) {
      
        $scope.entidadBancaria = data;
        console.log(JSON.stringify($scope.entidadBancaria));
        var fechaCreacion = new Date(data.fechaCreacion);
        $scope.entidadBancaria.fechaCreacion = fechaCreacion.getFullYear() + "-" + (fechaCreacion.getMonth()+1) + "-" + fechaCreacion.getDate();
    }).error(function (data, status, headers, config) {
        alert("HTTP request failed. Status: " + status);
    });
    
    $scope.update = function () {
       var response = entidadBancariaService.update($scope.entidadBancaria).success(function (data, status, headers, config) {
            alert("Update successful.");
            $location.path('/entidadbancaria/detail/' + $scope.entidadBancaria.idEntidadBancaria);
        }).error(function (data, status, headers, config) {
            if (status === 400) {
                $scope.errors = data;
            } else {
                alert("HTTP request failed. Status: " + status);
            }
            console.log(data);
        });
    }


}

app.controller("EntidadBancariaUpdateController", EntidadBancariaUpdateController);