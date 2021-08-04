package br.org.generation.Balaio.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;
@Entity
@Table(name = "tb_produto")
public class ProdutoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String nomeproduto;
    @NotNull
    private String descricaoproduto;
    @NotNull
    private BigDecimal valor;
    @NotNull
    @JsonFormat(pattern="dd-mm-yyyy")
    private Date dataFabricacao;
    @JsonFormat(pattern="dd-mm-yyyy")
    private Date dataValidade;
    @NotNull
    private int quantidade;
    
    @ManyToOne
    @JsonIgnoreProperties("produto")
    private CategoriaModel categoria;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomeproduto() {
		return nomeproduto;
	}
	public void setNomeproduto(String nomeproduto) {
		this.nomeproduto = nomeproduto;
	}
	public String getDescricaoproduto() {
		return descricaoproduto;
	}
	public void setDescricaoproduto(String descricaoproduto) {
		this.descricaoproduto = descricaoproduto;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Date getDataFabricacao() {
		return dataFabricacao;
	}
	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}
	public Date getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public CategoriaModel getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria;
	}
	

/*    @OneToOne
    @JsonIgnoreProperties("Usuario")
    private Usuario usuarioId;

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }
*/
}
