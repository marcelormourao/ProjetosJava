package dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import util.jpa.transactional.Transactional;
import model.Produto;

@RequestScoped
public class ProdutoDao {
	
	@Inject
	private EntityManager manager ;
	
	@Transactional
	public void salvar(Produto produto){
		manager.merge(produto);
	}
	
	@Transactional
	public List<Produto> findAll(){
		return manager.createQuery("FROM Produto p", Produto.class).getResultList();
	}
	
}
