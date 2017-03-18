app.controller('categoriaController', function($scope, categoriaService, $stateParams){
	
	var self = this;
		
	
	var idCategoria = $stateParams.idCategoria;
	
	self.submit = submit;
	self.alterar = alterar;
	self.listar = listar;
	self.listarTipoCategoria = listarTipoCategoria;
	self.buscarPorId = buscarPorId;
	
	listarTipoCategoria();
	listar();
	
	 function submit(categoria){
		 console.log("teste");
		 categoriaService.salvar(self.categoria).
			then(function(t){
				 Materialize.toast('Categoria Salva!', 10000); 
				self.categoria = null;
				}, function(errResponse){
					Materialize.toast(errResponse.data.message , 10000);
			});
	}
	 
	 function alterar(categoria){
		 categoriaService.alterar(self.categoria).
			then(function(t){
				self.categoria = null;
				}, function(errResponse){
			});
	 }
	 
	 
	 function listar(){
		 categoriaService.listar().
			then(function(t){
				self.listarCategorias = t;
				}, function(errResponse){
			});
		};
		
    function listarTipoCategoria(){
			 categoriaService.listarTipoCategoria().
				then(function(t){
					self.listarTipoCategoria = t;
					}, function(errResponse){
				});
			};
			
	 function buscarPorId(id){
			if(!id)return;
			categoriaService.buscarPorId(id).
			then(function(p){
				self.categoria = p;
				}, function(errResponse){
		});
		};
		
	
		if(idCategoria){
			buscarPorId(idCategoria);
		}
		
});