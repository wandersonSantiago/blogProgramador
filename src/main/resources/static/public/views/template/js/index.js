app.config(['$stateProvider', '$httpProvider' , '$urlRouterProvider' , function($stateProvider,  $httpProvider, $urlRouterProvider) {
	
	$urlRouterProvider.otherwise('/');
     
     $stateProvider
    .state('home', {
      url: '/',
      templateUrl: 'public/views/pages/home.html',
      controller: 'IndexController'
    })
    
}]);