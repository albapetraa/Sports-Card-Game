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
public abstract class Oyuncu {

    private int oyuncuID, skor;
    private String oyuncuAdi;
    public Sporcu[] kartListesi = new Sporcu[8];

    public Oyuncu() {
        this.setOyuncuID(-1);
        this.setOyuncuAdi("PlayerUnknown");
        this.setSkor(0);

    }

    public Oyuncu(int oyuncuID, int skor, String oyuncuAdi) {
        this.oyuncuID = oyuncuID;
        this.skor = skor;
        this.oyuncuAdi = oyuncuAdi;
    }

    public int kartSayisi() {
        int tekrar = 0;
        for (Sporcu kart : this.kartListesi) {
            if (kart != null && !kart.isKartKullanildiMi()) {
                tekrar++;
            }
        }
        return tekrar;

    }

    public void kartKullan(Sporcu kullanilacakKart) {
        if (kartSayisi() == 0) {
            return;
        }
        for (Sporcu kart : this.kartListesi) {
            if (kart.getSporcuIsim() == kullanilacakKart.getSporcuIsim()) {

                System.out.println(this.getOyuncuAdi() + " " + kullanilacakKart.getSporcuIsim() + " kartını kullandı.");
                kart.setKartKullanildiMi(true);

                break;
            }
        }
    }

    public abstract Sporcu kartSec(Sporcu kart, int turTipi);

    public int getOyuncuID() {
        return oyuncuID;
    }

    public void setOyuncuID(int oyuncuID) {
        this.oyuncuID = oyuncuID;
    }

    public int getSkor() {
        return skor;
    }

    public void setSkor(int skor) {
        this.skor += skor;
    }

    public void resetSkor(int skor) {
        this.skor = 0;

    }

    public String getOyuncuAdi() {
        return oyuncuAdi;
    }

    public void setOyuncuAdi(String oyuncuAdi) {
        this.oyuncuAdi = oyuncuAdi;
    }

    public Sporcu[] getKartListesi() {
        return kartListesi;
    }

    public void setKartListesi(Sporcu[] kartListesi) {
        this.kartListesi = kartListesi;
    }

    public void addSkor(int score) {
        skor += score;
        System.out.println(this.getOyuncuAdi() + " " + score + " skor kazandı.");
    }
}
