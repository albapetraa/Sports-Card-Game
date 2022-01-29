/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oyuncular;

import KartOyunu.Oyuncu;
import KartOyunu.Sporcu;

/**
 *
 * @author Hp
 */
public class InsanOyuncu extends Oyuncu {

    private int tip = 1;

    public InsanOyuncu() {
        super(0, 0, "Oyuncu");
    }

    public InsanOyuncu(int oyuncuId, int skor, String oyuncuAdi) {
        super(oyuncuId, skor, oyuncuAdi);
    }

    @Override
    public Sporcu kartSec(Sporcu kart, int turTipi) {
        this.kartKullan(kart);
        return kart;
    }

}
