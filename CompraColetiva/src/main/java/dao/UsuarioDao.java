package dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import util.jpa.transactional.Transactional;
import model.Usuario;

@Transactional
@RequestScoped
public class UsuarioDao {
	
	@Inject
	private EntityManager manager ;
	
	public Usuario porId(Long id){
		
		return manager.find(Usuario.class, id);
	}
	
	public Usuario porNome(String nome){
		String sql = "FROM Usuario u WHERE u.nome = '"+nome+"'";
		return manager.createQuery(sql,Usuario.class).setMaxResults(1).getSingleResult();
	}
	
	@Transactional
	public void remover(Usuario usuario){
		 manager.remove(manager.getReference(Usuario.class, usuario.getId()));	
	}

	public boolean loginDisponivel(Usuario usuario) {
		try{	
				manager
				.createQuery("FROM Usuario u WHERE u.login = :login", Usuario.class)
				.setParameter("login", usuario.getLogin())
				.getSingleResult();
			
			return false;
		}catch(NoResultException nre){
			return true;
		}
	}

	public List<Usuario> getTodos() {
		return this.manager.createQuery("FROM Usuario u", Usuario.class).getResultList();
	}
	
	@Transactional
	public void salvar(Usuario usuario){
		manager.merge(usuario);
	}
}
