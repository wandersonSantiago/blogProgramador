app.config(['$stateProvider', '$httpProvider' , '$urlRouterProvider' , function($stateProvider,  $httpProvider, $urlRouterProvider) {
    
    $stateProvider
    
   .state('admin', {
     url: '/admin',
     templateUrl: 'public/views/pages/admin/admin.index.html'
   })
   
  
}]);