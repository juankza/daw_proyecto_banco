function UsuarioService($http){
    this.list = function(){
        var response = $http(config = {
            method: 'GET',
            url: '/api/usuario'
        });
        return response;
    };
    this.detail = function(idUsuario){
       var response = $http({
            method: 'GET',
            url: '/api/usuario/' + idUsuario
        });
        return response;
    };
    this.insert = function(usuario){
          var response = $http({
            method: 'POST',
            url: '/api/usuario/',
            data: usuario
            
        });
        return response;
    };
     this.delete = function(idUsuario){
        var response = $http({
           method: 'DELETE',
           url: '/api/usuario/' + idUsuario
        });
        return response;
    };
    this.update = function(usuario){
        var response = $http({
           method: 'PUT',
           url: '/api/usuario/' + usuario.idUsuario,
           data: usuario
        });
        return response;
    };
}
UsuarioService.$inject = ['$http'];
app.service("usuarioService",UsuarioService);