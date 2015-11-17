
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import util.MessagesUtil;
import model.Produto;
import dao.ProdutoDao;
 
@Named
@RequestScoped
public class VendaProdutosBean implements Serializable {
	
	private static final long serialVersionUID = 7930666844267416194L;

	private List<Produto> produtos;
     
    private Produto produtoSelecionado;
    
    private @Inject ProdutoDao produtoDao;
    
    private String emailComprador;
    
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

	public String getEmailComprador() {
		return emailComprador;
	}

	public void setEmailComprador(String emailComprador) {
		this.emailComprador = emailComprador;
	}
    
	public void verificarEmail(){
		if(emailComprador == null || emailComprador.equals("") || emailComprador.length() <= 15){
			MessagesUtil.addErrorMessage("Por favor, digite uma email válido!");
		}else{
			MessagesUtil.addInformationMessage("Você receberá um email para confirmar sua compra!");
		}
	}
}
