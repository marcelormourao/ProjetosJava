package dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import model.Usuario;

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
}
