UsuarioInsertController.$inject = ['usuarioService', '$location', '$scope'];
function UsuarioInsertController(usuarioService, $location, $scope) {
    $scope.usuario = {};

    $scope.insert = function () {
        $scope.usuario.rol = $scope.usuario.rol.toUpperCase();
        var response = usuarioService.insert($scope.usuario);
        response.success(function (data, status, headers, config) {
            alert("OK");
            $location.path('/usuario/list');
        }).error(function (data, status, headers, config) {
            if (status === 400) {
                $scope.errors = data;
            } else {
                alert("Ha fallado la petición HTTP. Estado HTTP: " + status);
            }
        });
    };
}
app.controller("UsuarioInsertController", UsuarioInsertController);