import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Produto;

import org.omnifaces.cdi.ViewScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import dao.ProdutoDao;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable{
	
	private static final long serialVersionUID = 8611854415913452658L;

	private Produto produto = new Produto();
	
	@Inject
	private ProdutoDao produtoDao;
	
	public void processFileUpload(FileUploadEvent uploadEvent) {
        try {
            produto.setImagem(uploadEvent.getFile().getContents());
            produto.setFileName(uploadEvent.getFile().getFileName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public String salvar(){
		produtoDao.salvar(produto);
		this.produto = new Produto();
		return "";
	}
}
