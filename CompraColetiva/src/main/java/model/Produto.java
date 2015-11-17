package model;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@Entity
@ApplicationScoped
public class Produto {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String titulo;
	
	private String fileName;
	
	private String telefoneVendedor;
	
	@Lob
	private byte[] imagem;
	
	private String descricao;
	
	private String preco = "";
	
	private boolean vendido;

	public Produto(String titulo, String caminhoImagem, byte[] imagem, String descricao,
			String preco, boolean vendido) {
		this.titulo = titulo;
		this.fileName = caminhoImagem;
		this.imagem = imagem;
		this.descricao = descricao;
		this.preco = preco;
		this.vendido = vendido;
	}

	public Produto() {
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public StreamedContent getImagem(){   
	   return new DefaultStreamedContent(new ByteArrayInputStream(this.imagem));	 
	}
	
	public byte[] getImagem2(){   
		return this.imagem;	 
	}
	
	public String getImagem3(){
		File file = null;
		FileOutputStream fos = null;
		
		try {
			file = new File(System.getProperty("D:\\images\\"+fileName));
			fos = new FileOutputStream(file);
			fos.write(this.imagem);
		} catch (IOException e1) {
			e1.printStackTrace();
		}finally{
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return "\\images\\"+fileName;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPreco() {
		return preco != null ? preco : "0,00";
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public boolean isVendido() {
		return vendido;
	}

	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getTelefoneVendedor() {
		return telefoneVendedor;
	}

	public void setTelefoneVendedor(String telefoneVendedor) {
		this.telefoneVendedor = telefoneVendedor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}	
}
