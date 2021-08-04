package br.org.generation.Balaio.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tb_usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String nome;
    @NotNull
    private String senha;
    @NotNull
    private int cep;
    @NotNull
    private int numcasa;
    @NotNull
    private String complemento;
    @NotNull
    private long telefone;
    @NotNull
    private long cpf;
    @NotNull
    private String descricaouser;
    @NotNull
    private String tipo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public int getNumcasa() {
        return numcasa;
    }

    public void setNumcasa(int numcasa) {
        this.numcasa = numcasa;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getDescricaouser() {
        return descricaouser;
    }

    public void setDescricaouser(String descricaouser) {
        this.descricaouser = descricaouser;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @OneToMany(mappedBy ="usuario", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("usuario")
    private List<ProdutoModel> produto;

    public List<ProdutoModel> getProduto() {
        return produto;
    }

    public void setProduto(List<ProdutoModel> produto) {
        this.produto = produto;
    }
}
