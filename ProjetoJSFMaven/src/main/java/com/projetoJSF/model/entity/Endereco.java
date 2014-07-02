package com.projetoJSF.model.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author wanderson
 */
@Entity
@Table(name="endereco")
public class Endereco implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name="idEndereco",nullable=false)
    private Integer idEndereco;
    @Column(name="bairro",length = 80)
    private String bairro;
    @Column(name="nomeLogradouro",length = 80)
    private String nomeLogradouro;
    @Column(name="cep",length = 9)
    private String cep;
    @Column(name="numero")
    private Integer numero;
    @Column(name="complemento",length = 80)
    private String complemento;
    
    @OneToOne(optional = true,fetch = FetchType.LAZY)
    @ForeignKey(name="fk_endereco_pessoa")
    private Pessoa pessoa;
    

    public Endereco() {
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNomeLogradouro() {
        return nomeLogradouro;
    }

    public void setNomeLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.idEndereco);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Endereco other = (Endereco) obj;
        if (!Objects.equals(this.idEndereco, other.idEndereco)) {
            return false;
        }
        return true;
    }
}
