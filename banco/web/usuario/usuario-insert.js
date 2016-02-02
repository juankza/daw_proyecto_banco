UsuarioInsertController.$inject = ['usuarioService', '$location', '$scope','messageService'];
function UsuarioInsertController(usuarioService, $location, $scope,messageService) {
    $scope.usuario = {};

    $scope.insert = function () {
        
        var response = usuarioService.insert($scope.usuario);
        response.success(function (data, status, headers, config) {
            alert("Insertado correctamente.");
            $location.path('/usuario/list');
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
app.controller("UsuarioInsertController", UsuarioInsertController);