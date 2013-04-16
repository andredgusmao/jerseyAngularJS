package br.com.agendabelem.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;


/**
 *
 * @author andre
 */
@Entity
@Table(name = "festa")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Festa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int valor;

    public Festa(String nome, int valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public Festa() {}
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "[" + nome + " - R$" + valor + "]";
    }
    
}
