package com.projetoJSF.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author wanderson
 */
@Entity
@Table(name="pessoa")
public class Pessoa implements Serializable{
   private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name="idPessoa",nullable=false)
    private Integer idPessoa;
    @Column(name="nome",nullable=false,length = 80)
    private String nome;
    @Column(name="email",nullable=false,length = 80)
    private String email;
    @Column(name="telefone",nullable=false,length = 20)
    private String telefone;
    @Column(name="cpf",nullable=false,length = 15)
    private String cpf;
    @Temporal(TemporalType.DATE)
    @Column(name="dataNascimento",nullable=false)
    private Date dataNascimento;
    @Temporal(TemporalType.DATE)
    @Column(name="dataCadastro",nullable=false)
    private Date dataCadastro;
    
    @OneToOne(mappedBy="pessoa",fetch = FetchType.LAZY)
    @ForeignKey(name="fk_endereco_pessoa")
    private Endereco endereco;
    
    @ManyToOne(optional=false)
    @ForeignKey(name="fk_pessoa_sexo")
    @JoinColumn(name="idSexo",referencedColumnName = "idSexo")
    private Sexo sexo;
    
    public Pessoa() {
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.idPessoa);
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
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.idPessoa, other.idPessoa)) {
            return false;
        }
        return true;
    }
}
