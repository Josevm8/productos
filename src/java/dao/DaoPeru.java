/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * @author Extension
 */
public interface DaoPeru {
    
    public List<Object[]> peruQry(int numpag, int filsXpag);
    
    public Integer peruCtasFils();
    
    public List<Object[]> depaQry(int numpag, int filsXpag);
    
    public Integer depaCtasFils();
}
