app.controller('subCategoriaController', function($scope, subCategoriaService, $stateParams){
	
	var self = this;
		
	
	var idSubCategoria = $stateParams.idSubCategoria;
	
	self.submit = submit;
	self.alterar = alterar;
	self.listar = listar;
	self.listarCategorias = listarCategorias;
	self.buscarPorId = buscarPorId;
	
	listarCategorias();
	listar();
	
	 function submit(subCategoria){
		 subCategoriaService.salvar(self.subCategoria).
			then(function(t){
				 Materialize.toast('Categoria Salva!', 10000); 
				self.subCategoria = null;
				}, function(errResponse){
					Materialize.toast(errResponse.data.message , 10000);
			});
	}
	 
	 function alterar(subCategoria){
		 subCategoriaService.alterar(self.subCategoria).
			then(function(t){
				self.subCategoria = null;
				}, function(errResponse){
			});
	 }
	 
	 
	 function listar(){
		 subCategoriaService.listar().
			then(function(t){
				self.listarSubCategorias = t;
				}, function(errResponse){
			});
		};
		
	 function listarCategorias(){
		 subCategoriaService.listarCategorias().
			then(function(t){
				self.listarCategorias = t;
				}, function(errResponse){
			});
		};
		
    
			
	 function buscarPorId(id){
			if(!id)return;
			subCategoriaService.buscarPorId(id).
			then(function(p){
				self.subCategoria = p;
				}, function(errResponse){
		});
		};
		
	
		if(idSubCategoria){
			buscarPorId(idSubCategoria);
		}
		
});