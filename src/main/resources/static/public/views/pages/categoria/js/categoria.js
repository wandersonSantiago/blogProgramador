app.config(['$stateProvider', '$httpProvider' , '$urlRouterProvider' , function($stateProvider,  $httpProvider, $urlRouterProvider) {
		     
     $stateProvider
     
    .state('categoria', {
      url: '/categoria',
      templateUrl: 'public/views/pages/categoria/categoria.index.html',
      controller: 'categoriaController'
    })
    
     .state('categoriaCadastrar', {
      url: '/cadastrar',
      templateUrl: 'public/views/pages/categoria/categoria.form.html',
      controller: 'categoriaController as categoriaCtrl'
    })
    
     .state('categoriaListar', {
      url: '/lista',
      templateUrl: 'public/views/pages/categoria/categoria.list.html',
      controller: 'categoriaController as categoriaCtrl'
    })
    
    .state('categoriaEditar', {
      url: '/:idCategoria/editar',
      templateUrl: 'public/views/pages/categoria/categoria.form.html',
      controller: 'categoriaController as categoriaCtrl'
    })
    
}]);