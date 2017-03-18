app.config(['$stateProvider', '$httpProvider' , '$urlRouterProvider' , function($stateProvider,  $httpProvider, $urlRouterProvider) {
		     
     $stateProvider
     
    .state('postagem', {
      url: '/postagem',
      templateUrl: 'public/views/pages/postagem/postagem.index.html',
      controller: 'categoriaController'
    })
    
     .state('postagemCadastrar', {
      url: '/postagem/cadastrar',
      templateUrl: 'public/views/pages/postagem/postagem.form.html',
      controller: 'postagemController as postagemCtrl'
    })
    
     .state('postagemListar', {
      url: '/postagem/lista',
      templateUrl: 'public/views/pages/postagem/postagem.list.html',
      controller: 'postagemController as postagemCtrl'
    })
    
    .state('postagemEditar', {
      url: '/postagem/:idPostagem/editar',
      templateUrl: 'public/views/pages/postagem/postagem.form.html',
      controller: 'postagemController as postagemCtrl'
    })
    
}]);