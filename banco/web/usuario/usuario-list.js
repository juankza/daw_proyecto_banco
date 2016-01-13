
UsuarioListController.$inject = ['usuarioService', '$scope'];
function UsuarioListController(usuarioService, $scope) {
    var response;
    response = usuarioService.list();
    response.success(function (data, status, headers, config) {
        $scope.usuarios = data;
    }).error(function (data, status, headers, config) {
        alert("Ha fallado la petición HTTP. Estado: " + status);
    });
}
app.controller("UsuarioListController", UsuarioListController);