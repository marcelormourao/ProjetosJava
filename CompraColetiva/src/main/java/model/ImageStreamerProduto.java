package model;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.ProdutoDao;

@Named
@ApplicationScoped
public class ImageStreamerProduto {
	
	@Inject
	private ProdutoDao produtoDao;
	
    private Produto produto;

    public byte[] getImagem(Integer id) {
    	this.produto = produtoDao.porId(id);
        return produto.getImagem2();
    }

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
