/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.projetoJSF.controller;

import com.projetoJSF.model.dao.HibernateDAO;
import com.projetoJSF.model.dao.InterfaceDAO;
import com.projetoJSF.model.entity.Endereco;
import com.projetoJSF.model.entity.Pessoa;
import com.projetoJSF.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author wanderson
 */
@ManagedBean
@SessionScoped
public class MbPessoa implements Serializable{
    private static final long serialVersionUID = 1L;
    private Pessoa pessoa = new Pessoa();
    private Endereco endereco = new Endereco();
    private List<Pessoa> pessoas;
    private List<Endereco> enderecos;

    public MbPessoa() {
    }
    
    private InterfaceDAO<Pessoa> pessoaDAO(){
        InterfaceDAO<Pessoa> pessoaDAO = new HibernateDAO<Pessoa>(Pessoa.class,FacesContextUtil.getRequestSession());
        return pessoaDAO;
    }
    
     private InterfaceDAO<Endereco> enderecoDAO(){
        InterfaceDAO<Endereco> enderecoDAO = new HibernateDAO<Endereco>(Endereco.class,FacesContextUtil.getRequestSession());
        return enderecoDAO;
    }
     
     public String limparPessoa(){
         this.pessoa = new Pessoa();
         this.endereco = new Endereco();
         return "/restrict/cadastrarpessoa.faces";
     }
     
      public String editPessoa(){
         return "/restrict/cadastrarpessoa.faces";
     }
    
      public String addPessoa(){
          if(this.pessoa.getIdPessoa() == null || this.pessoa.getIdPessoa() == null){
             insertPessoa(); 
          }
          else
          {
              updatePessoa();
          }
          return null;
      }

    private void insertPessoa() {
        pessoaDAO().save(pessoa);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Gravação efetuada com sucesso!",""));
    }

    private void updatePessoa() {
        pessoaDAO().update(pessoa);
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Atualização efetuada com sucesso!",""));
    }
    
    public String deletePessoa(){
        pessoaDAO().remove(pessoa);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro excluido com sucesso!",""));
        return null;
    }
}
