UsuarioInsertController.$inject = ['usuarioService', '$scope'];
function UsuarioInsertController(usuarioService, $scope) {
    $scope.usuario = {};

    $scope.insert = function () {
        var response = usuarioService.insert($scope.usuario);
        response.success(function (data, status, headers, config) {
            alert("OK");
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