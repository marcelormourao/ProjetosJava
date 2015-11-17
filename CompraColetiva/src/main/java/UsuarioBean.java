import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Usuario;
import util.MessagesUtil;
import dao.UsuarioDao;

@Named(value="usuarioBean")
@org.omnifaces.cdi.ViewScoped
public class UsuarioBean implements Serializable{
	
	private static final long serialVersionUID = -4176584480398173213L;

	private Usuario usuario = new Usuario();
	
	private List<Usuario> todos = new ArrayList<Usuario>();
	
	@Inject
	private UsuarioDao usuarioDao;
	
	public void salvar(){
		
		/*Se Cadastrando novo usuário*/
		if(usuario.getId() == null){
			/*Se login não Disponível*/
			if(!loginDisponivel()){
				MessagesUtil.addErrorMessage("Login já está em uso!");
				return;
			}
		}
		
		usuarioDao.salvar(usuario);
		
		usuario = new Usuario();
		
		MessagesUtil.addInformationMessage("Salvo com sucesso!");
			
//		return "usuario.xhtml?faces-redirect=true";
//		return "usuario.xhtml";
//		return "";
	}
	
	public List<Usuario> getTodos(){
		return usuarioDao.getTodos();
	}
	
	public boolean loginDisponivel(){
		return usuarioDao.loginDisponivel(usuario);
	}
	
	public void remover(){
		 usuarioDao.remover(this.usuario);	
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
