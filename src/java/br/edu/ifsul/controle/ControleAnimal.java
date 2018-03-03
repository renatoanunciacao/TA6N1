/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.modelo.Animal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Renato
 */
@ManagedBean(name = "controleAnimal")
@SessionScoped
public class ControleAnimal implements Serializable {

    private List<Animal> lista = new ArrayList<>();
    private Animal objeto;
    private Boolean editando;

    public ControleAnimal() {
        editando = false;
        Animal a = new Animal();
        a.setId(1);
        a.setNome("Dinho");
        a.setRaca("Pitbull");
        a.setCor("Preto");
        a.setDescricao("Este cachorro tem 7 anos");
        a.setPeso(15.50);     
        lista.add(a);
    }

    public String listar() {
        return "/animal/listar?faces-redirect=true";
    }

    public void novo() {
        objeto = new Animal();
        editando = true;
    }

    public void alterar(Animal obj) {
        objeto = obj;
        editando = true;
    }

    public void excluir(Animal obj) {
        lista.remove(obj);
    }

    public void salvar() {
        if (objeto.getId() == null) {
            objeto.setId(lista.size() + 1);
            lista.add(objeto);
        }
        editando = false;
    }

    public List<Animal> getLista() {
        return lista;
    }

    public void setLista(List<Animal> lista) {
        this.lista = lista;
    }

    public Animal getObjeto() {
        return objeto;
    }

    public void setObjeto(Animal objeto) {
        this.objeto = objeto;
    }

    public Boolean getEditando() {
        return editando;
    }

    public void setEditando(Boolean editando) {
        this.editando = editando;
    }

}
