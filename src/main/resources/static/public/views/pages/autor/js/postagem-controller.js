app.controller('postagemController', function($scope, postagemService, $stateParams, subCategoriaService){
	
	var self = this;
		
	
	var idPostagem = $stateParams.idPostagem;
	
	self.submit = submit;
	self.alterar = alterar;
	self.listar = listar;
	self.buscarPorId = buscarPorId;
	
	listarSubCategorias();
	listar();
	
	 function submit(postagem){
		 postagemService.salvar(self.postagem).
			then(function(t){
				 Materialize.toast('postagem Salva!', 10000); 
				self.categoria = null;
				}, function(errResponse){
					Materialize.toast(errResponse.data.message , 10000);
			});
	}
	 
	 function alterar(postagem){
		 postagemService.alterar(self.postagem).
			then(function(t){
				self.categoria = null;
				}, function(errResponse){
			});
	 }
	 
	 function listarSubCategorias(){
		 subCategoriaService.listar().
			then(function(t){
				self.listarSubCategorias = t;
				}, function(errResponse){
			});
		};
	 
	 function listar(){
		 postagemService.listar().
			then(function(t){
				console.log(t);
				self.listarPostagens = t;
				}, function(errResponse){
			});
		};
		
   
	 function buscarPorId(id){
			if(!id)return;
			postagemService.buscarPorId(id).
			then(function(p){
				self.postagem = p;
				}, function(errResponse){
		});
		};
		
	
		if(idPostagem){
			buscarPorId(idPostagem);
		}
		
});