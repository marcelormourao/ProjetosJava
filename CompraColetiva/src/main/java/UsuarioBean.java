import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import model.Usuario;
import util.MessagesUtil;
import util.jpa.transactional.Transactional;

@Named(value="usuarioBean")
//@ViewScoped
@ViewScoped
public class UsuarioBean implements Serializable{
	
	private Usuario usuario = new Usuario();
	
	@Inject
	private EntityManager manager ;
	
	private List<Usuario> todos = new ArrayList<Usuario>();
	
	@Transactional
	public String salvar(){
		
		/*Se Cadastrando novo usuário*/
		if(usuario.getId() == null){
			/*Se login não Disponível*/
			if(!loginDisponivel()){
				MessagesUtil.addErrorMessage("Login já está em uso!");
				return null;
			}
		}
		
		manager.merge(usuario);
		
		usuario = new Usuario();
		
		MessagesUtil.addInformationMessage("Salvo com sucesso!");
			
//		return "usuario.xhtml?faces-redirect=true";
		return "";
	}
	
	public List<Usuario> getTodos(){
		
		this.todos = this.manager.createQuery("FROM Usuario u", Usuario.class).getResultList();

		return todos;
	}
	
	public boolean loginDisponivel(){
		try{	
			Usuario login = manager
				.createQuery("FROM Usuario u WHERE u.login = :login", Usuario.class)
				.setParameter("login", usuario.getLogin())
				.getSingleResult();
			
			return false;
		}catch(NoResultException nre){
			return true;
		}
	}
	
	@Transactional
	public void remover(){
		 manager.remove(manager.getReference(Usuario.class, usuario.getId()));	
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario != null ? usuario : new Usuario();
	}
	
	public void validarLogin(){
		if(!loginDisponivel()){
			MessagesUtil.addErrorMessage("Login não está disponível!");
		}else{
			MessagesUtil.addInformationMessage("Login Disponível!");
		}
	}
	
	public void limparCampos(){
		this.usuario = new Usuario();
	}
}
