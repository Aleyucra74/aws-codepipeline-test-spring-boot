package br.com.bandtec.projetojpa05;

import javax.persistence.*;

@Entity
public class Esporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @ManyToOne
    private CategoriaEsporte categoria;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CategoriaEsporte getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEsporte categoria) {
        this.categoria = categoria;
    }
}