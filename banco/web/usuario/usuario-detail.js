UsuarioDetailController.$inject = ['usuarioService', '$scope', '$routeParams']
function UsuarioDetailController(usuarioService, $scope, $routeParams) {
    var response;
    response = usuarioService.detail($routeParams.idUsuario);

    response.success(function (data, status, headers, config) {
        $scope.usuario = data;
    }).error(function (data, status, headers, config) {
        alert("4Detail HTTP request failed. Status: " + status);
        console.log(data);
    });
}
app.controller("UsuarioDetailController", UsuarioDetailController);