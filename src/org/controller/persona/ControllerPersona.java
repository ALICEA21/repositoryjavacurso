package org.controller.persona;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.dao.persona.DaoPersona;
import org.modelo.persona.Persona;

@ManagedBean
@ViewScoped
public class ControllerPersona implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private Persona persona = null;
	private List<Persona> ListaPersonas = null;
	public ControllerPersona() {
		super();
		persona = new Persona();
	}
	//GETTERS AND SETTERS OF LISTAPERSONAS
	public List<Persona> getListaPersonas() {
		DaoPersona daoPersona = new DaoPersona();
		ListaPersonas = daoPersona.selectPersona();
		return ListaPersonas;
	}
	public void setListaPersonas(List<Persona> listaPersonas) {
		this.ListaPersonas = listaPersonas;
	}
	
	//getters and setters of persona
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	//METHODOS CRUD
	
	public void limpiarPersona() {
		 persona = new Persona();
	}
	
	public String agregarPersona() {
		DaoPersona dao = new DaoPersona();
		dao.addPersona(persona);
		return "/index.xhtml?faces-redirect=true";
	}
	
	public String modificarPersona() {
		DaoPersona dao = new DaoPersona();
		dao.updatePersona(persona);
		return "/index.xhtml?faces-redirect=true";
	}
	
	public String eliminarPersona() {
		DaoPersona dao = new DaoPersona();
		dao.deletePersona(persona);
		return "/index.xhtml?faces-redirect=true";
	}

}
