app.config(['$stateProvider', '$httpProvider' , '$urlRouterProvider' , function($stateProvider,  $httpProvider, $urlRouterProvider) {
		     
     $stateProvider
     
    .state('subCategoria', {
      url: '/sub/categoria',
      templateUrl: 'public/views/pages/categoria/subCategoria/sub_categoria.index.html',
      controller: 'subCategoriaController'
    })
    
     .state('subCategoriaCadastrar', {
      url: '/sub/cadastrar',
      templateUrl: 'public/views/pages/categoria/subCategoria/sub_categoria.form.html',
      controller: 'subCategoriaController as subCategoriaCtrl'
    })
    
     .state('subCategoriaListar', {
      url: '/sub/lista',
      templateUrl: 'public/views/pages/categoria/subCategoria/sub_categoria.list.html',
      controller: 'subCategoriaController as subCategoriaCtrl'
    })
    
    .state('subCategoriaEditar', {
      url: '/sub/:idSubCategoria/editar',
      templateUrl: 'public/views/pages/categoria/subCategoria/sub_categoria.form.html',
      controller: 'subCategoriaController as subCategoriaCtrl'
    })
    
}]);