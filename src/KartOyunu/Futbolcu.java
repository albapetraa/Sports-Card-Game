/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KartOyunu;

/**
 *
 * @author Hp
 */
public class Futbolcu extends Sporcu {

    private int Penalti, SerbestVurus, KKK;
    private boolean kartKullanildiMi;
    private int tip = 1;

    public Futbolcu() {

    }

    public Futbolcu(int Penalti, int SerbestVurus, int KKK, boolean kartKullanildiMi, String sporcuIsim, String sporcuTakim, int sporcuId) {
        super(sporcuIsim, sporcuTakim, sporcuId);
        this.Penalti = Penalti;
        this.SerbestVurus = SerbestVurus;
        this.KKK = KKK;
        this.kartKullanildiMi = kartKullanildiMi;
    }

    @Override
    public int[] sporcuPuaniGoster() {
        int[] ozellikler = new int[3];
        ozellikler[0] = this.Penalti;
        ozellikler[1] = this.SerbestVurus;
        ozellikler[2] = this.KKK;

        return ozellikler;
    }

    public int getPenalti() {
        return Penalti;
    }

    public void setPenalti(int Penalti) {
        this.Penalti = Penalti;
    }

    public int getSerbestVurus() {
        return SerbestVurus;
    }

    public void setSerbestVurus(int SerbestVurus) {
        this.SerbestVurus = SerbestVurus;
    }

    public int getKKK() {
        return KKK;
    }

    public void setKKK(int KKK) {
        this.KKK = KKK;
    }

    @Override
    public boolean isKartKullanildiMi() {
        return kartKullanildiMi;
    }

    @Override
    public void setKartKullanildiMi(boolean kartKullanildiMi) {
        this.kartKullanildiMi = kartKullanildiMi;
    }

    @Override
    public int getTip() {
        return tip;
    }

    @Override
    public void setTip(int tip) {
        this.tip = tip;
    }
    
}
