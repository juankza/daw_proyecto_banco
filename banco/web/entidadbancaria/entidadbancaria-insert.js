EntidadBancariaInsertController.$inject = ['$scope', '$location', 'entidadBancariaService','messageService'];
function EntidadBancariaInsertController($scope, $location, entidadBancariaService,messageService) {
    $('#datepicker').datepicker({dateFormat: 'yy-mm-dd'});
    $scope.entidadBancaria = {};

    $scope.insert = function () {
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
                    //$scope.$parent.infoMessages = [{ "fieldName" : "Estado HTTP" , "message" : status }];
                    //messageService.showInfo("error");
                }
            });
        }
    };
}
app.controller("EntidadBancariaInsertController", EntidadBancariaInsertController);
