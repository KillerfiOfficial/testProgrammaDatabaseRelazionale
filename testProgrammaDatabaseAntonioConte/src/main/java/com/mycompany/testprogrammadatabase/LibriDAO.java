/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testprogrammadatabase;

import java.util.List;

/**
 *
 * @author 39351
 */
public interface LibriDAO {
    
    List<Libri> trovaTutti();
    
    List trovaPerTitolo(String titolo);
    
}
