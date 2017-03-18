app.factory('postagemService', function($rootScope, $http,$q){
	
	
	return{
		salvar: function(postagem){
			return $http.post('rest/postagem',postagem)
			.then(function(response){
			return response.data;
			},function(errResponse){
				});
		},
		listar: function(){
			return $http.get('rest/postagem')
			.then(function(response){
				return response.data;
			},function(errResponse){
				});
		},
				
		buscarPorId: function(param){
			return $http.get('rest/postagem/'+param)
			.then(function(response){
				return response.data;
			},function(errResponse){
				return $q.reject(errResponse);
			});
		},
		
		alterar: function(categoria){
			return $http.put('rest/postagem', categoria)
			.then(function(response){
				return response.data;
			},function(errResponse){
				return $q.reject(errResponse);
			});
		},
		
	}
});