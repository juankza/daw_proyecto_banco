UsuarioDeleteController.$inject = ['usuarioService','$scope','$routeParams','$location'];
function UsuarioDeleteController(usuarioService,$scope,$routeParams,$location){
    var response = usuarioService.detail($routeParams.idUsuario).success(function (data, status, headers, config) {
        $scope.usuario = data;
    }).error(function (data, status, headers, config) {
        alert("HTTP request failed. Status: " + status);
    });
    $scope.delete = function(){
        response = usuarioService.delete($routeParams.idUsuario).success(function (data, status, headers, config) {
        alert("Borrado correctamente.");
        $location.path("/usuario/list");
    }).error(function (data, status, headers, config) {
        alert("HTTP request failed. Status: " + status);
    });
        
    };
}
app.controller("UsuarioDeleteController",UsuarioDeleteController);