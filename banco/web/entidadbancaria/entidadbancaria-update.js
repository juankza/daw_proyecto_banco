EntidadBancariaUpdateController.$inject = ['$scope', '$location', 'entidadBancariaService', '$routeParams','messageService'];
function EntidadBancariaUpdateController($scope, $location, entidadBancariaService, $routeParams,messageService) {
    
    $('#datepicker').datepicker({dateFormat: 'yy-mm-dd'});
    var response = entidadBancariaService.detail($routeParams.idEntidadBancaria).success(function (data, status, headers, config) {
      
        $scope.entidadBancaria = data;
        var fechaCreacion = new Date(data.fechaCreacion);
        $scope.entidadBancaria.fechaCreacion = fechaCreacion.getFullYear() + "-" + ("0" + (fechaCreacion.getMonth() + 1)).slice(-2) + "-" + ("0" + fechaCreacion.getDate()).slice(-2);
    }).error(function (data, status, headers, config) {
        alert("HTTP request failed. Status: " + status);
    });
    
    $scope.update = function () {
        var form = $scope.entidadBancariaForm;
        var error = [];
        
        if(form.$invalid) {
            for(var prop in form) {
                if(typeof(prop) === "string" && prop.charAt(0) !== "$") {
                    if(form[prop].$error) {
                        for(var errorType in form[prop].$error) {
                            if(form[prop].$error[errorType] === true) {
                                error.push({ "fieldName" : prop.capitalize() , "message" : "Inválido o requerido" });
                            }
                        }
                    }
                }
            }
            if(error.length !== 0) {
                $scope.$parent.errorMessages = error;
                messageService.showError("error");
            }
            
        } else {
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


}

app.controller("EntidadBancariaUpdateController", EntidadBancariaUpdateController);