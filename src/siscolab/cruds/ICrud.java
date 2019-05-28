/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siscolab.cruds;

/**
 *
 * @author matheus.garcias
 * @param <Classe>
 */
public interface ICrud <Classe> {
    public void criar(Classe c);
    public Classe ler();
    public void atualizar();
    public void remover();
}
