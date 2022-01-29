/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KartOyunu;

import Oyuncular.*;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Hp
 */
public class Test extends javax.swing.JFrame {

    Futbolcu LionelMessi = new Futbolcu(97, 89, 90, false, "Lionel Messi", "Barcelona", 1);
    Futbolcu CristianoRonaldo = new Futbolcu(95, 80, 90, false, "Cristiano Ronaldo", "Juventus", 2);
    Futbolcu EdenHazard = new Futbolcu(90, 90, 95, false, "Eden Hazard", "Real Madrid", 3);
    Futbolcu SergioRamos = new Futbolcu(70, 50, 60, false, "Sergio Ramos", "Real Madrid", 4);
    Futbolcu SergioBusquets = new Futbolcu(73, 60, 65, false, "Sergio Busquets", "Barcelona", 5);
    Futbolcu LeroySane = new Futbolcu(84, 82, 81, false, "Leroy Sane", "Bayern Münih", 6);
    Futbolcu JulianBrandt = new Futbolcu(77, 86, 88, false, "Julian Brandt", "Borussia Dortmund", 7);
    Futbolcu BreelEmbolo = new Futbolcu(78, 70, 92, false, "Breel Embolo", "Borussia Mönchengladbach", 8);

    Basketbolcu LebronJames = new Basketbolcu(85, 90, 95, false, "Lebron James", "Los Angeles Lakers", 9);
    Basketbolcu StephenCurry = new Basketbolcu(90, 95, 100, false, "Stephen Curry", "Golden State Warriors", 10);
    Basketbolcu KlayThompson = new Basketbolcu(86, 93, 92, false, "Klay Thompson", "Golden State Warriors", 11);
    Basketbolcu JamesHarden = new Basketbolcu(88, 91, 91, false, "James Harden", "Houston Rockets", 12);
    Basketbolcu RusselWestbrook = new Basketbolcu(82, 83, 83, false, "Russel Westbrook", "Houston Rockets", 13);
    Basketbolcu BrandonIngram = new Basketbolcu(74, 77, 75, false, "Brandon Ingram", "New Orleans Pelicans", 14);
    Basketbolcu AnthonyDavis = new Basketbolcu(72, 79, 76, false, "Anthony Davis", "Los Angeles Lakers", 15);
    Basketbolcu KevinDurant = new Basketbolcu(92, 92, 90, false, "Kevin Durant", "Brooklyn Nets", 16);

    Sporcu[] futbolcular = new Sporcu[]{LionelMessi, CristianoRonaldo, EdenHazard, SergioRamos, SergioBusquets,
        LeroySane, JulianBrandt, BreelEmbolo};
    Sporcu[] basketbolcular = new Sporcu[]{LebronJames, StephenCurry, KlayThompson, JamesHarden,
        RusselWestbrook, BrandonIngram, AnthonyDavis, KevinDurant};

    ArrayList<JButton> kartButonları = new ArrayList<JButton>();
    ArrayList<JButton> kartButonları2 = new ArrayList<JButton>();

    Oyuncu liste = new InsanOyuncu();
    Oyuncu liste2 = new BilgisayarOyuncu();
    static int tur = 1;
    Sporcu userSecilenKart = new Sporcu();
    Sporcu pcSecilenKart = new Sporcu();
    Sporcu pcSonSecilenKart = new Sporcu();
    int basılanSonButon;
    int o;
    int i2 = 0;
    int[] userSecilenKartOzellikler = new int[3];
    int[] pcSecilenKartOzellikler = new int[3];

    public static int ozellikSecim() {
        int a;
        Random random = new Random();
        a = random.nextInt(2);

        if (a == 0 && tur % 2 != 0) {
            secilenOzellik.setText("Penaltı");
        } else if (a == 1 && tur % 2 != 0) {
            secilenOzellik.setText("Serbest Vurus");
        } else if (a == 2 && tur % 2 != 0) {
            secilenOzellik.setText("Kaleciyle Karsı Karsıya");
        } else if (a == 0 && tur % 2 == 0) {
            secilenOzellik.setText("Ikilik");
        } else if (a == 1 && tur % 2 == 0) {
            secilenOzellik.setText("Üçlük");
        } else if (a == 2 && tur % 2 == 0) {
            secilenOzellik.setText("Serbest Atıs");
        }
        return a;

    }

    public static void listeKaristir(Oyuncu a) {
        int n = a.kartSayisi();
        Random random = new Random();
        random.nextInt();
        for (int i = 0; i < n; i++) {
            int rsayi = random.nextInt(8);
            Sporcu gecici = a.kartListesi[i];

            a.kartListesi[i] = a.kartListesi[rsayi];
            a.kartListesi[rsayi] = gecici;

        }
    }

    public static void kartlariAyir(Oyuncu a, Oyuncu b) {

        for (int i = 0; i < 4; i++) {
            Sporcu gecici = a.kartListesi[i];

            a.kartListesi[i] = b.kartListesi[i];
            b.kartListesi[i] = gecici;

        }
    }

    public void kartButonIconAt() {
        int q2 = liste2.kartListesi[0].getSporcuId();
        kartButonları2.get(0).setIcon(new ImageIcon(getClass().getResource("Resimler/cardback.png")));

        for (int i = 0; i < kartButonları.size(); i++) {

            int q = liste.kartListesi[i].getSporcuId();
            int[] tooltip = new int[3];
            tooltip = liste.kartListesi[i].sporcuPuaniGoster();
            kartButonları.get(i).setToolTipText("Sırasıyla özellikleri: " + tooltip[0] + " " + tooltip[1] + " " + tooltip[2]);
            kartButonları.get(i).setIcon(new ImageIcon(getClass().getResource("Resimler/" + q + ".png")));

        }
    }

    public void kartlariButonlaraAt() {
        kartButonları.add(kart1);
        kartButonları.add(kart2);
        kartButonları.add(kart3);
        kartButonları.add(kart4);
        kartButonları.add(kart5);
        kartButonları.add(kart6);
        kartButonları.add(kart7);
        kartButonları.add(kart8);
        kartButonları2.add(pcSecilenKartButton);
    }

    public void nullGeldiginde() {
        int i = 0;
        do {
            if (liste2.kartListesi[i].isKartKullanildiMi() != false) {
                pcSecilenKart = liste2.kartListesi[i];
                pcSonSecilenKart = pcSecilenKart;
            }
            i++;
        } while (i < liste2.kartSayisi());

    }

    /**
     * Creates new form dene
     */
    public Test() {
        initComponents();
        JLabel background;
        ImageIcon backgroundImg = new ImageIcon(getClass().getResource("Resimler/background.jpg"));
        background = new JLabel("", backgroundImg, JLabel.CENTER);
        background.setBounds(0, 0, 1368, 768);
        add(background);

        liste.setKartListesi(futbolcular);
        liste2.setKartListesi(basketbolcular);

        listeKaristir(liste);
        listeKaristir(liste2);
        for (int i = 0; i < futbolcular.length; i++) {
            System.out.println(liste.kartListesi[i].getSporcuIsim());

        }
        System.out.println("*********");
        for (int i = 0; i < basketbolcular.length; i++) {
            System.out.println(liste2.kartListesi[i].getSporcuIsim());

        }
        kartlariAyir(liste, liste2);
        kartlariButonlaraAt();
        kartButonIconAt();

        userSkor.setText("" + liste.getSkor());
        pcSkor.setText("" + liste.getSkor());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        kart1 = new javax.swing.JButton();
        kart2 = new javax.swing.JButton();
        kart3 = new javax.swing.JButton();
        kart4 = new javax.swing.JButton();
        kart5 = new javax.swing.JButton();
        kart6 = new javax.swing.JButton();
        kart7 = new javax.swing.JButton();
        kart8 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        userSkor = new javax.swing.JLabel();
        pcSecilenKartButton = new javax.swing.JButton();
        userSecilenKartButton = new javax.swing.JButton();
        onayla = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        secilenOzellik = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pcOzellik = new javax.swing.JLabel();
        userOzellik = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pcSkor = new javax.swing.JLabel();
        kazanan = new javax.swing.JLabel();
        kapistir = new javax.swing.JButton();
        turKazanani = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kart Oyunu");
        setPreferredSize(new java.awt.Dimension(1368, 768));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Big Space", 1, 18)); // NOI18N
        jLabel1.setText("Oyuncunun Kartları");

        kart1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kart1ActionPerformed(evt);
            }
        });

        kart2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kart2ActionPerformed(evt);
            }
        });

        kart3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kart3ActionPerformed(evt);
            }
        });

        kart4.setPreferredSize(new java.awt.Dimension(11, 23));
        kart4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kart4ActionPerformed(evt);
            }
        });

        kart5.setContentAreaFilled(false);
        kart5.setFocusPainted(false);
        kart5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kart5ActionPerformed(evt);
            }
        });

        kart6.setContentAreaFilled(false);
        kart6.setFocusPainted(false);
        kart6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kart6ActionPerformed(evt);
            }
        });

        kart7.setContentAreaFilled(false);
        kart7.setFocusPainted(false);
        kart7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kart7ActionPerformed(evt);
            }
        });

        kart8.setContentAreaFilled(false);
        kart8.setFocusPainted(false);
        kart8.setPreferredSize(new java.awt.Dimension(11, 23));
        kart8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kart8ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Big Space", 0, 24)); // NOI18N
        jLabel2.setText("Kullanıcının Puanı");

        userSkor.setFont(new java.awt.Font("Big Space", 0, 48)); // NOI18N
        userSkor.setText("jLabel3");

        pcSecilenKartButton.setContentAreaFilled(false);
        pcSecilenKartButton.setFocusPainted(false);

        userSecilenKartButton.setContentAreaFilled(false);
        userSecilenKartButton.setFocusPainted(false);

        onayla.setFont(new java.awt.Font("Donjonikons", 1, 80)); // NOI18N
        onayla.setText("B");
        onayla.setToolTipText("");
        onayla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onaylaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Big Space", 0, 18)); // NOI18N
        jLabel3.setText("Seçilen Özellik");

        secilenOzellik.setFont(new java.awt.Font("Big Space", 0, 24)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Big Space", 0, 18)); // NOI18N
        jLabel4.setText("Bilgisayar Kartının Puanı");

        jLabel5.setFont(new java.awt.Font("Big Space", 0, 18)); // NOI18N
        jLabel5.setText("Kullanıcı Kartının Puanı");

        pcOzellik.setFont(new java.awt.Font("Big Space", 0, 48)); // NOI18N

        userOzellik.setFont(new java.awt.Font("Big Space", 0, 48)); // NOI18N
        userOzellik.setText("  ");

        jLabel6.setFont(new java.awt.Font("Big Space", 0, 24)); // NOI18N
        jLabel6.setText("Bilgisayarın Puanı");

        pcSkor.setFont(new java.awt.Font("Big Space", 0, 48)); // NOI18N
        pcSkor.setText("jLabel7");

        kazanan.setFont(new java.awt.Font("Big Space", 0, 36)); // NOI18N

        kapistir.setFont(new java.awt.Font("Donjonikons", 1, 80)); // NOI18N
        kapistir.setText("A");
        kapistir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kapistirActionPerformed(evt);
            }
        });

        turKazanani.setFont(new java.awt.Font("Big Space", 0, 18)); // NOI18N
        turKazanani.setText("tur kazanan");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(kart1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(kart2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(111, 111, 111)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(onayla, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kapistir, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pcSecilenKartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(userSecilenKartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(secilenOzellik, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(75, 75, 75)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(pcOzellik, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(userOzellik, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(56, 56, 56)
                                                .addComponent(jLabel6))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(77, 77, 77)
                                                .addComponent(pcSkor, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(turKazanani, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                                            .addComponent(kazanan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel2))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(43, 43, 43)
                                                .addComponent(userSkor, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(250, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(kart3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kart4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kart5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kart6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kart7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kart8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(pcSecilenKartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(kapistir, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(onayla, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(userSecilenKartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(112, 112, 112)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(secilenOzellik, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pcOzellik, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(userOzellik))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(turKazanani)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pcSkor)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(kazanan))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(userSkor)))
                        .addGap(103, 103, 103)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kart2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kart3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kart4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(kart1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kart6, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kart7, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kart8, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(kart5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58))
        );

        kart1.getAccessibleContext().setAccessibleDescription("");

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kart1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kart1ActionPerformed
        userSecilenKart = liste.kartListesi[0];

        if (userSecilenKart.getTip() != tur % 2) {
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Bu tur bu kartı Seçemezsiniz.", "Alert", JOptionPane.WARNING_MESSAGE);
            userSecilenKart = null;
            userSecilenKartButton.setIcon(null);
        } else {
            userSecilenKartButton.setIcon(kart1.getIcon());

            basılanSonButon = 1;
        }
    }//GEN-LAST:event_kart1ActionPerformed

    private void kart2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kart2ActionPerformed
        userSecilenKart = liste.kartListesi[1];

        if ((int) userSecilenKart.getTip() != tur % 2) {

            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Bu tur bu kartı Seçemezsiniz.", "Alert", JOptionPane.WARNING_MESSAGE);
            userSecilenKart = null;
            userSecilenKartButton.setIcon(null);
        } else {
            userSecilenKartButton.setIcon(kart2.getIcon());

            basılanSonButon = 2;
        }
    }//GEN-LAST:event_kart2ActionPerformed

    private void kart3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kart3ActionPerformed
        userSecilenKart = liste.kartListesi[2];

        if ((int) userSecilenKart.getTip() != tur % 2) {
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Bu tur bu kartı Seçemezsiniz.", "Alert", JOptionPane.WARNING_MESSAGE);
            userSecilenKart = null;
            userSecilenKartButton.setIcon(null);
        } else {
            userSecilenKartButton.setIcon(kart3.getIcon());

            basılanSonButon = 3;
        }
    }//GEN-LAST:event_kart3ActionPerformed

    private void kart4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kart4ActionPerformed
        userSecilenKart = liste.kartListesi[3];

        if ((int) userSecilenKart.getTip() != tur % 2) {
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Bu tur bu kartı Seçemezsiniz.", "Alert", JOptionPane.WARNING_MESSAGE);
            userSecilenKart = null;
            userSecilenKartButton.setIcon(null);
        } else {
            userSecilenKartButton.setIcon(kart4.getIcon());
            basılanSonButon = 4;
        }
    }//GEN-LAST:event_kart4ActionPerformed

    private void kart5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kart5ActionPerformed
        userSecilenKart = liste.kartListesi[4];

        if ((int) userSecilenKart.getTip() != tur % 2) {
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Bu tur bu kartı Seçemezsiniz.", "Alert", JOptionPane.WARNING_MESSAGE);
            userSecilenKart = null;
            userSecilenKartButton.setIcon(null);
        } else {
            userSecilenKartButton.setIcon(kart5.getIcon());
            basılanSonButon = 5;
        }
    }//GEN-LAST:event_kart5ActionPerformed

    private void kart6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kart6ActionPerformed
        userSecilenKart = liste.kartListesi[5];

        if ((int) userSecilenKart.getTip() != tur % 2) {
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Bu tur bu kartı Seçemezsiniz.", "Alert", JOptionPane.WARNING_MESSAGE);
            userSecilenKart = null;
            userSecilenKartButton.setIcon(null);
        } else {
            userSecilenKartButton.setIcon(kart6.getIcon());
            basılanSonButon = 6;
        }
    }//GEN-LAST:event_kart6ActionPerformed

    private void kart7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kart7ActionPerformed
        userSecilenKart = liste.kartListesi[6];

        if ((int) userSecilenKart.getTip() != tur % 2) {
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Bu tur bu kartı Seçemezsiniz.", "Alert", JOptionPane.WARNING_MESSAGE);
            userSecilenKart = null;
            userSecilenKartButton.setIcon(null);
        } else {
            userSecilenKartButton.setIcon(kart7.getIcon());
            basılanSonButon = 7;
        }
    }//GEN-LAST:event_kart7ActionPerformed

    private void kart8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kart8ActionPerformed
        userSecilenKart = liste.kartListesi[7];

        if ((int) userSecilenKart.getTip() != tur % 2) {
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Bu tur bu kartı Seçemezsiniz.", "Alert", JOptionPane.WARNING_MESSAGE);
            userSecilenKart = null;
            userSecilenKartButton.setIcon(null);
        } else {
            userSecilenKartButton.setIcon(kart8.getIcon());
            basılanSonButon = 8;
        }
    }//GEN-LAST:event_kart8ActionPerformed

    private void onaylaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onaylaActionPerformed

        if (userSecilenKart == null) {
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Önce Kart Seçin.", "Alert", JOptionPane.WARNING_MESSAGE);
        }

        pcSecilenKartButton.setIcon(new ImageIcon(getClass().getResource("Resimler/cardback.png")));

        tur++;
        userSecilenKartButton.setIcon(null);
        kapistir.setEnabled(true);
        if (tur > 8) {
            if (liste.getSkor() > liste2.getSkor()) {
                System.out.println("Kullanıcı Kazandı");
                kazanan.setText("Kullanıcı " + liste.getSkor() + " Skorla Kazandı.");
            } else if (liste.getSkor() < liste2.getSkor()) {
                System.out.println("Bilgisayar Kazandı");
                kazanan.setText("Bilgisayar " + liste2.getSkor() + " Skorla Kazandı.");
            } else {
                System.out.println("Berabere Kalındı");
                kazanan.setText("Durum Berabere");
                do {

                    userSecilenKart = liste.kartListesi[basılanSonButon];
                    userSecilenKartOzellikler = userSecilenKart.sporcuPuaniGoster();
                    pcSecilenKartOzellikler = pcSonSecilenKart.sporcuPuaniGoster();
                    if (userSecilenKartOzellikler[i2] > pcSecilenKartOzellikler[i2]) {
                        System.out.println("Berabere Kalındığı için son kartlar tekrar oynandı.");
                        kazanan.setFont(new Font("Big Space", Font.PLAIN, 18));
                        kazanan.setText("Berabere kalındı.Kartlar Tekrar Oynandı.Kullanıcı kazandı.");
                    } else if (userSecilenKartOzellikler[i2] < pcSecilenKartOzellikler[i2]) {
                        System.out.println("Berabere Kalındığı için son kartlar tekrar oynandı.");
                        kazanan.setFont(new Font("Big Space", Font.PLAIN, 18));
                        kazanan.setText("Berabere kalındı.Kartlar Tekrar Oynandı.Bilgisayar kazandı.");
                    }

                    i2++;
                } while (liste.getSkor() != liste2.getSkor());

            }
            kapistir.setEnabled(false);
            onayla.setEnabled(false);
        }
        userOzellik.setText("   ");
        pcOzellik.setText("   ");
        secilenOzellik.setText("   ");


    }//GEN-LAST:event_onaylaActionPerformed

    private void kapistirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kapistirActionPerformed
        if (userSecilenKart == null) {
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Önce Kart Seçin.", "Alert", JOptionPane.WARNING_MESSAGE);
        }

        liste.kartSec(userSecilenKart, tur % 2);
        pcSecilenKart = liste2.kartSec(pcSecilenKart, tur % 2);
        pcSonSecilenKart = pcSecilenKart;
        while (pcSecilenKart == null) {
            nullGeldiginde();
        }
        pcSecilenKartButton.setIcon(new ImageIcon(getClass().getResource("Resimler/" + pcSecilenKart.getSporcuId() + ".png")));
        userSecilenKart.setKartKullanildiMi(true);
        pcSecilenKart.setKartKullanildiMi(true);
        kartButonları.get(basılanSonButon - 1).setEnabled(false);

        o = ozellikSecim();
        userSecilenKartOzellikler = userSecilenKart.sporcuPuaniGoster();
        pcSecilenKartOzellikler = pcSecilenKart.sporcuPuaniGoster();
        userOzellik.setText("" + userSecilenKartOzellikler[o]);
        pcOzellik.setText("" + pcSecilenKartOzellikler[o]);
        if (userSecilenKartOzellikler[o] > pcSecilenKartOzellikler[o]) {
            liste.addSkor(10);
            userSkor.setText("" + liste.getSkor());
            turKazanani.setText(tur + ". turun kazananı Kullanıcı");
        } else if (userSecilenKartOzellikler[o] < pcSecilenKartOzellikler[o]) {
            liste2.addSkor(10);
            pcSkor.setText("" + liste2.getSkor());
            turKazanani.setText(tur + ". turun kazananı Bilgisayar");
        }
        kapistir.setEnabled(false);

    }//GEN-LAST:event_kapistirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Test().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton kapistir;
    private javax.swing.JButton kart1;
    private javax.swing.JButton kart2;
    private javax.swing.JButton kart3;
    private javax.swing.JButton kart4;
    private javax.swing.JButton kart5;
    private javax.swing.JButton kart6;
    private javax.swing.JButton kart7;
    private javax.swing.JButton kart8;
    private javax.swing.JLabel kazanan;
    private javax.swing.JButton onayla;
    private javax.swing.JLabel pcOzellik;
    private javax.swing.JButton pcSecilenKartButton;
    private javax.swing.JLabel pcSkor;
    private static javax.swing.JLabel secilenOzellik;
    private javax.swing.JLabel turKazanani;
    private javax.swing.JLabel userOzellik;
    private javax.swing.JButton userSecilenKartButton;
    private javax.swing.JLabel userSkor;
    // End of variables declaration//GEN-END:variables
}
