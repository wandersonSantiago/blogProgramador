app.factory('categoriaService', function($rootScope, $http,$q){
	
	
	return{
		salvar: function(categoria){
			return $http.post('rest/categoria',categoria)
			.then(function(response){
			return response.data;
			},function(errResponse){
				});
		},
		listar: function(){
			return $http.get('rest/categoria')
			.then(function(response){
				return response.data;
			},function(errResponse){
				});
		},
		listarTipoCategoria: function(){
			return $http.get('rest/categoria/tipo')
			.then(function(response){
				return response.data;
			},function(errResponse){
				});
		},
		
		buscarPorId: function(param){
			return $http.get('rest/categoria/'+param)
			.then(function(response){
				return response.data;
			},function(errResponse){
				return $q.reject(errResponse);
			});
		},
		
		alterar: function(categoria){
			return $http.put('rest/categoria', categoria)
			.then(function(response){
				return response.data;
			},function(errResponse){
				return $q.reject(errResponse);
			});
		},
		
	}
});