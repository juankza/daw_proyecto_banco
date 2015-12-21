UsuarioUpdateController.$inject = ['$scope', '$location', 'usuarioService', '$routeParams'];
function UsuarioUpdateController($scope, $location, usuarioService, $routeParams) {
    var response = usuarioService.detail($routeParams.idUsuario).success(function (data, status, headers, config) {
        $scope.usuario = data;
    }).error(function (data, status, headers, config) {
        alert("HTTP request failed. Status: " + status);
    });
    $scope.update = function () {
        response = usuarioService.update($scope.usuario).success(function (data, status, headers, config) {
            alert("Actualizado correctamente.");
            $location.path('/usuario/detail/' + $scope.usuario.idUsuario);
        }).error(function (data, status, headers, config) {
            if (status === 400) {
                $scope.errors = data;
            } else {
                alert("HTTP request failed. Status: " + status);
            }
        });
    }
}
app.controller("UsuarioUpdateController", UsuarioUpdateController);
