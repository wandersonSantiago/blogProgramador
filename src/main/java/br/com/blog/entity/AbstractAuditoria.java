package br.com.blog.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class AbstractAuditoria<PK extends Serializable> extends AbstractPersistable<PK> {
	
	@Column(name = "created_by")
	@CreatedBy
	private String createdBy;
	
	@Column(name = "dataCadastro")
	@CreatedDate
	private Date dataCadastro;
	
	@Column(name = "last_modified_by")
	@LastModifiedBy
	private String lastModifeidBy;
	
	@Column(name = "dataModificacao")
	@LastModifiedDate
	private Date dataModificacao;

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(Date dataModificacao) {
		this.dataModificacao = dataModificacao;
	}

	public String getLastModifeidBy() {
		return lastModifeidBy;
	}

	public void setLastModifeidBy(String lastModifeidBy) {
		this.lastModifeidBy = lastModifeidBy;
	}



	@Override
	public void setId(PK id) {		
		super.setId(id);
	}	
}
