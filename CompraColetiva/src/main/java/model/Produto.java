package model;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@Entity
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
	
	private BigDecimal preco;
	
	private boolean vendido;

	public Produto(String titulo, String caminhoImagem, byte[] imagem, String descricao,
			BigDecimal preco, boolean vendido) {
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

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
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
}