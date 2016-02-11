MainController.$inject = ['$scope', '$location', 'messageService', 'sessionService'];
var altura;
function MainController($scope, $location, messageService, sessionService) {
    sessionService.logged().then(function (webSession) {
        $("#landing > section").css("height", altura);
        $("#arriba").css("top", (altura + 120) / 1.08);
        $("#abajo").css("top", (altura + 120) / 1.08);
    }, function (errorMessages) {
        $scope.$parent.errorMessages = errorMessages;
        messageService.showError("error");
        $location.path("/login");
    });

    $scope.$parent.logout;

    // Marco es la página donde está (1,2,3)
    $scope.flechaArriba = function () {
        var marco = Math.floor($(window).scrollTop() / altura);
        marco = (marco - 1) * altura;
        $('body,html').animate({
            scrollTop: marco + "px"
        }, altura);
    }

    $scope.flechaAbajo = function () {
        var marco = Math.floor($(window).scrollTop() / altura);
        marco = (marco + 1) * altura;
        $('body,html').animate({
            scrollTop: marco + "px"
        }, altura);
    }
}
app.controller("MainController", MainController);


// ------------ SCROLL ------------

$(document).ready(function () {
    altura = $(window).height() - 120;//120 = tamaño del navbar+margen
    $("#landing > section").css({"height": altura, "background-color": "red"});

    // Recalcula la altura para colocar las flechas en su sitio.
    $(window).resize(function () {
        altura = $(window).height() - 120;
        $("#arriba").css("top", (altura + 120) / 1.08);
        $("#abajo").css("top", (altura + 120) / 1.08);
        $("#landing > section").css("height", altura);
    });

    // fade in #arriba
    $(function () {
        $(window).scroll(function () {
            if ($(this).scrollTop() > 100) {
                $('#arriba').fadeIn();
            } else {
                $('#arriba').fadeOut();
            }
            if (($(this).scrollTop() + ($(this).height() - 120)) === (altura * 3)) {
                $('#abajo').fadeOut();
            } else {
                $('#abajo').fadeIn();
            }
        });
    });
});
