/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oyuncular;

import KartOyunu.Oyuncu;
import KartOyunu.Sporcu;
import java.util.Random;

/**
 *
 * @author Hp
 */
public class BilgisayarOyuncu extends Oyuncu {

    private int tip = 0;

    public BilgisayarOyuncu() {
        super(1, 0, "Bilgisayar");
    }

    @Override
    public Sporcu kartSec(Sporcu kart, int turTipi) {

        Random rnd = new Random();
        int random = Math.abs(rnd.nextInt()) % 8;

        for (int i = 0; i < (this.kartListesi.length); i++) {

            if (this.kartListesi[i] == null || this.kartListesi[i].isKartKullanildiMi()) {
                continue;
            }

            if ((int) this.kartListesi[i].getTip() == turTipi && this.kartListesi[i].isKartKullanildiMi() == false) {
                this.kartKullan(this.kartListesi[i]);
                return this.kartListesi[i];
            }
            if ((int) this.kartListesi[random].getTip() == turTipi && this.kartListesi[random].isKartKullanildiMi() == false) {
                this.kartKullan(this.kartListesi[random]);
                return this.kartListesi[random];
            }
        }
        return null;

    }

}
