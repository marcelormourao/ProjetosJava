import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

//@Named(value="cadastroProdutoBean")
//@SessionScoped
//@ViewScoped
@ManagedBean
//@javax.faces.bean.ViewScoped
@SessionScoped
public class CadastroProdutoBean implements Serializable{
	
	private Produto produto = new Produto();
	
	private UploadedFile file;
	
	public void processFileUpload(FileUploadEvent uploadEvent) {
		 System.out.println("OLha as coisas melhorando!");
        try {
            produto.setImagem(uploadEvent.getFile().getContents());
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

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}
	
}
