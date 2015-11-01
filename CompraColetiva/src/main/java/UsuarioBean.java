import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.omnifaces.cdi.ViewScoped;

import util.jpa.transactional.Transactional;
import model.Usuario;

@Named(value="usuarioBean")
@ViewScoped
public class UsuarioBean implements Serializable{
	
	private Usuario usuario = new Usuario();
	
	@Inject
	private EntityManager manager ;
	
	private List<Usuario> todos = new ArrayList<Usuario>();
	
	@Transactional
	public void salvar(){
		
		manager.merge(usuario);
		
		usuario = new Usuario();
		
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo com sucesso!", "Salvo com sucesso!");
		
		FacesContext context =  FacesContext.getCurrentInstance();
		context.addMessage("salvo", msg);
		
	}
	
	public List<Usuario> getTodos(){
//		if(!FacesContext.getCurrentInstance().isPostback()){		
			this.todos = this.manager.createQuery("FROM Usuario u", Usuario.class).getResultList();
//		}
		return todos;
	}
	
	@Transactional
	public void remover(){
		 manager.remove(manager.getReference(Usuario.class, usuario.getId()));
//		 manager.remove(manager.find(Usuario.class, usuario.getId()));	
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario != null ? usuario : new Usuario();
	}
	
	public void validarNome(){
		if(this.usuario.getNome().equalsIgnoreCase("Mailson")){
			String msg = "Cara de rato não é aceito neste sistemas!";
			FacesMessage fmsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
			FacesContext.getCurrentInstance().addMessage("Rato detectado", fmsg);
		}else{
			String msg = "Login válido!";
			FacesMessage fmsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
			FacesContext.getCurrentInstance().addMessage("login_valido", fmsg);
		}
	}
	
	public void limparCampos(){
		this.usuario = new Usuario();
	}
}
