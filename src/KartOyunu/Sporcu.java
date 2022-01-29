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
public class Sporcu {

    private String sporcuIsim;
    private String sporcuTakim;
    private int sporcuId = 999;
    private boolean kartKullanildiMi;

    public Sporcu() {
    }

    public int[] sporcuPuaniGoster() {
        int[] ozellik = new int[3];
        return ozellik;
    }

    public Sporcu(String sporcuIsim, String sporcuTakim, int sporcuId) {
        this.sporcuIsim = sporcuIsim;
        this.sporcuTakim = sporcuTakim;
        this.sporcuId = sporcuId;
    }

    public String getSporcuIsim() {
        return sporcuIsim;
    }

    public void setSporcuIsim(String sporcuIsim) {
        this.sporcuIsim = sporcuIsim;
    }

    public String getSporcuTakim() {
        return sporcuTakim;
    }

    public void setSporcuTakim(String sporcuTakim) {
        this.sporcuTakim = sporcuTakim;
    }

    public int getSporcuId() {
        return sporcuId;
    }

    public void setSporcuId(int sporcuId) {
        this.sporcuId = sporcuId;
    }

    public boolean isKartKullanildiMi() {
        return this.kartKullanildiMi;
    }

    public void setKartKullanildiMi(boolean kartKullanildiMi) {
        this.kartKullanildiMi = kartKullanildiMi;
    }

    public int getTip() {
        return this.getTip();
    }

    public void setTip(int tip) {
        this.setTip(tip);
    }

}
