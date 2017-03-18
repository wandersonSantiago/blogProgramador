app.factory('subCategoriaService', function($rootScope, $http,$q){
	
	
	return{
		salvar: function(categoria){
			return $http.post('rest/categoria/sub',categoria)
			.then(function(response){
			return response.data;
			},function(errResponse){
				});
		},
		listar: function(){
			return $http.get('rest/categoria/sub')
			.then(function(response){
				return response.data;
			},function(errResponse){
				});
		},
		listarCategorias: function(){
			return $http.get('rest/categoria')
			.then(function(response){
				return response.data;
			},function(errResponse){
				});
		},
		
		buscarPorId: function(param){
			return $http.get('rest/categoria/sub/'+param)
			.then(function(response){
				return response.data;
			},function(errResponse){
				return $q.reject(errResponse);
			});
		},
		
		alterar: function(categoria){
			return $http.put('rest/categoria/sub', categoria)
			.then(function(response){
				return response.data;
			},function(errResponse){
				return $q.reject(errResponse);
			});
		},
		
	}
});