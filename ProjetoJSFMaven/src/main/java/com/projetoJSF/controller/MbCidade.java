package com.projetoJSF.controller;
import com.projetoJSF.model.dao.HibernateDAO;
import com.projetoJSF.model.dao.InterfaceDAO;
import com.projetoJSF.model.entity.Cidade;
import com.projetoJSF.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="mbCidade")
@SessionScoped
public class MbCidade implements Serializable{
     private static final long serialVersionUID = 1L;
     private Cidade cidade = new Cidade();
     private List<Cidade> cidades;

    public MbCidade() {
    }
     
     private InterfaceDAO<Cidade> cidadeDAO(){
         InterfaceDAO<Cidade> cidadeDAO = new HibernateDAO<Cidade>(Cidade.class,FacesContextUtil.getRequestSession());
         return cidadeDAO;
     }
     
     public String editCidade(){
         return "/restrict/cadastrarCidade.faces";
     }
     
     public String addCidade(){
        if(this.cidade.getIdCidade() == null || this.cidade.getIdCidade() == 0){
            insertCidade();
        }
        else{
            updateCidade();
        }
        limparCidade();
         return null;
     }

    private void insertCidade() {
        cidadeDAO().save(cidade);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Gravação efetuada com sucesso!",""));
    }

    private void updateCidade() {
        cidadeDAO().update(cidade);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Atualização efetuada com sucesso!",""));
    }

    public String limparCidade() {
        this.cidade = new Cidade();
        return "/restrict/cadastrarCidade.faces";
    }
    
    public void deleteCidade(){
        cidadeDAO().remove(cidade);
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Cidade> getCidades() {
        this.cidades = cidadeDAO().getEntities();
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }
}
