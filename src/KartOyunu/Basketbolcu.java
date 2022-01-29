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
public class Basketbolcu extends Sporcu {

    private int ikilik, ucluk, serbestAtis;
    private boolean kartKullanildiMi;
    private int tip = 0;

    public Basketbolcu() {

    }

    public Basketbolcu(int ikilik, int ucluk, int serbestAtis, boolean kartKullanildiMi, String sporcuIsim, String sporcuTakim, int sporcuId) {
        super(sporcuIsim, sporcuTakim, sporcuId);
        this.ikilik = ikilik;
        this.ucluk = ucluk;
        this.serbestAtis = serbestAtis;
        this.kartKullanildiMi = kartKullanildiMi;
    }

    @Override
    public int[] sporcuPuaniGoster() {
        int[] ozellikler = new int[3];
        ozellikler[0] = this.ikilik;
        ozellikler[1] = this.ucluk;
        ozellikler[2] = this.serbestAtis;

        return ozellikler;
    }

    public int getIkilik() {
        return ikilik;
    }

    public void setIkilik(int ikilik) {
        this.ikilik = ikilik;
    }

    public int getUcluk() {
        return ucluk;
    }

    public void setUcluk(int ucluk) {
        this.ucluk = ucluk;
    }

    public int getSerbestAtis() {
        return serbestAtis;
    }

    public void setSerbestAtis(int serbestAtis) {
        this.serbestAtis = serbestAtis;
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
