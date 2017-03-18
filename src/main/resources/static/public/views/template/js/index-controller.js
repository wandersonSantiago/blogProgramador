 app.controller('IndexController', ['$rootScope', '$scope', '$mdSidenav', 'postagemService', function($rootScope , $scope, $mdSidenav, postagemService) {
	  $rootScope.toggleSidenav = function(left) {
      $mdSidenav(left).toggle();
    };

   listarPostagens();
   
   $('.carousel.carousel-slider').carousel({fullWidth: true});
   
   $(document).ready(function(){  $('.carousel').carousel();   });
   
   $(document).ready(function(){
	      $('.parallax').parallax();
	    });
   
    function listarPostagens(){
		 postagemService.listar().
			then(function(t){
				$scope.listarPostagens = t;
				}, function(errResponse){
			});
		};
		
  }]);