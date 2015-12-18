UsuarioUpdateController.$inject = ['$scope','usuarioService','$routeParams'];
function UsuarioUpdateController($scope,usuarioService,$routeParams){
       response = usuarioService.detail($routeParams.idUsuario).success(function (data, status, headers, config) {
        $scope.usuario = data;
    }).error(function (data, status, headers, config) {
        alert("HTTP request failed. Status: " + status);
        console.log(data);
    });
    $scope.update = function () {
        response = usuarioService.update($scope.usuario).success(function (data, status, headers, config) {
            alert("Update succeeded.");

        }).error(function (data, status, headers, config) {
            if (status === 400) {
                $scope.errors = data;
            } else {
                alert("HTTP request failed. Status: " + status);
            }
            console.log(data);
        });
    }
}
app.controller("UsuarioUpdateController",UsuarioUpdateController);
