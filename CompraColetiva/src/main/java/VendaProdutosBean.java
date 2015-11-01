
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import model.Produto;

import org.omnifaces.cdi.ViewScoped;

import dao.ProdutoDao;
 
@Named
@ViewScoped
public class VendaProdutosBean implements Serializable {
	
	private static final long serialVersionUID = 7930666844267416194L;

	private List<Produto> produtos;
     
    private Produto produtoSelecionado;
    
    private @Inject ProdutoDao produtoDao;
    
    @PostConstruct
    public void carregarPagina(){
    	produtos = produtoDao.findAll();
    }
    
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}
    
//    @ManagedProperty("#{carService}")
//    private CarService service;
     
//    @PostConstruct
//    public void init() {
//        produtos = service.createCars(12);
//    }
}