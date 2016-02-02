UsuarioDeleteController.$inject = ['usuarioService','$scope','$routeParams','$location','messageService'];
function UsuarioDeleteController(usuarioService,$scope,$routeParams,$location,messageService){
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
         if (status === 400) {
                $scope.$parent.errorMessages = data;
                messageService.showError("error");
            } else {
                alert("Ha fallado la petición HTTP. Estado HTTP: " + status);
            }
    });
        
    };
}
app.controller("UsuarioDeleteController",UsuarioDeleteController);