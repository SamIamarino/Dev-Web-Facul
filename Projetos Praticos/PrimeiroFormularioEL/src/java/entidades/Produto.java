
package entidades;

/**
 *
 * @author Samuel Iamarino
 */
public class Produto {
    private String codigoBarra;
    private String descricao;
    private String unidadeMedida;
    private int quantidadeEmbalagem = 0;

    
    //Construtor Padrao.
    public Produto() {
        
    }
    
    //Construtor Especificado.
    public Produto(String codigoBarra, String descricao, String unidadeMedida, String fabricante) {
        this.codigoBarra = codigoBarra;
        this.descricao = descricao;
        this.unidadeMedida = unidadeMedida;
        this.fabricante = fabricante;
    }
    
    private String fabricante;

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public int getQuantidadeEmbalagem() {
        return quantidadeEmbalagem;
    }

    public void setQuantidadeEmbalagem(int quantidadeEmbalagem) {
        this.quantidadeEmbalagem = quantidadeEmbalagem;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    
}
