package Controller;

import Model.*;
import View.GUI;


import javax.swing.*;

public class Controller {

    private Player P1,P2;
    private final JLabel[] tableCards = new JLabel[32];
    private final MessageCards[] Mcards = new MessageCards[48];
    private final DealCards[] Dcards = new DealCards[20];


    public Controller(){
        PlayerInitialization();
        TableInitialization();
        FirstToPlay();
        initializeGameCards();
        new GUI(P1,P2,tableCards,Integer.parseInt(NoOfMonths()),Mcards,Dcards);
    }

    /**
     * Initialize two arrays, one that contains message cards and one with deal cards
     */
    public void initializeGameCards(){
        for (int i = 0; i < 8; i++) {
            Mcards[i] = new PayTheNeighbor();
        }
        for (int i = 8; i < 16; i++) {
            Mcards[i] = new GetFromNeighbor();
        }
        for (int i = 16; i < 24; i++) {
            Mcards[i] = new Charity();
        }
        for (int i = 24; i < 32; i++) {
            Mcards[i] = new PayBill();
        }
        for (int i = 32; i < 40; i++) {
            Mcards[i] = new MoveToCard();
        }
        for (int i = 40; i < 48; i++) {
            Mcards[i] = new Advertisement();
        }

        Dcards[0] = new DealCards("images\\tesla.jpg","Symfwnia","Agora Aftokinhtou se timh efkairias\nΤιμή Αγοράς: 7000 Ευρώ\nΤιμή Πώλησης: 1000 Ευρώ");
        Dcards[1] = new DealCards("images\\iphone.png","Symfwnia","Agora iphone-13 apo Iapwnia\nΤιμή Αγοράς: 500 Ευρώ\nΤιμή Πώλησης: 700 Ευρώ");
        Dcards[2] = new DealCards("images\\ethereum.png","Symfwnia","Agora ethereum \nΤιμή Αγοράς: 3000 Ευρώ\nΤιμή Πώλησης: 5000 Ευρώ");
        Dcards[3] = new DealCards("images\\Honda.jpg","Symfwnia","Agora Mhxanhs \nΤιμή Αγοράς: 4000 Ευρώ\nΤιμή Πώλησης: 7000 Ευρώ");
        Dcards[4] = new DealCards("images\\ps5.jpg","Symfwnia","Agora PlayStation 5 apo Korea\nΤιμή Αγοράς: 200 Ευρώ\nΤιμή Πώλησης: 400 Ευρώ");
        Dcards[5] = new DealCards("images\\taxyploo.jpg","Symfwnia","Agora taxyploou\nΤιμή Αγοράς: 5000 Ευρώ\nΤιμή Πώλησης: 9000 Ευρώ");
        Dcards[6] = new DealCards("images\\chl.jpg","Symfwnia","Agora Eisitiriou VIP gia ton teliko Chanpions League\nΤιμή Αγοράς: 700 Ευρώ\nΤιμή Πώλησης: 1400 Ευρώ");
        Dcards[7] = new DealCards("images\\maiden.jpg","Symfwnia","Agora Eisitiriou gia thn synavlia twn Iron Maiden\nΤιμή Αγοράς: 200 Ευρώ\nΤιμή Πώλησης: 500 Ευρώ");
        Dcards[8] = new DealCards("images\\laptop.jpg","Symfwnia","Agora Macbook apo to eBay\nΤιμή Αγοράς: 1000 Ευρώ\nΤιμή Πώλησης: 1700 Ευρώ");
        Dcards[9] = new DealCards("images\\watch.jpg","Symfwnia","Agora Crysou Rologiou\nΤιμή Αγοράς: 2000 Ευρώ\nΤιμή Πώλησης: 4000 Ευρώ");
        Dcards[10] = new DealCards("images\\camera.jpg","Symfwnia","Agora Epaggelmatikhs Fotografikhw Mixanhs\nΤιμή Αγοράς: 1200 Ευρώ\nΤιμή Πώλησης: 2000 Ευρώ");
        Dcards[11] = new DealCards("images\\elaiolado.jpg","Symfwnia","Agora Elaioladou\nΤιμή Αγοράς: 1500 Ευρώ\nΤιμή Πώλησης: 3000 Ευρώ");
        Dcards[12] = new DealCards("images\\terrier.jpg","Symfwnia","Agora Skylou Yorkshire Terrier\nΤιμή Αγοράς: 250 Ευρώ\nΤιμή Πώλησης: 550 Ευρώ");
        Dcards[13] = new DealCards("images\\facebook.jpg","Symfwnia","Agora Metoxwn sto Facebook\nΤιμή Αγοράς: 1000 Ευρώ\nΤιμή Πώλησης: 2000 Ευρώ");
        Dcards[14] = new DealCards("images\\elafonisi.jpg","Symfwnia","Agora Oikopedou sto elafonisi\nΤιμή Αγοράς: 12000 Ευρώ\nΤιμή Πώλησης: 21000 Ευρώ");
        Dcards[15] = new DealCards("images\\guitar.jpg","Symfwnia","Agora Syllektikhw kithras\nΤιμή Αγοράς: 3000 Ευρώ\nΤιμή Πώλησης: 6000 Ευρώ");
        Dcards[16] = new DealCards("images\\talos.jpg","Symfwnia","Agora Katasthmatos sto Talos Plaza\nΤιμή Αγοράς: 10000 Ευρώ\nΤιμή Πώλησης: 18000 Ευρώ");
        Dcards[17] = new DealCards("images\\nba.jpg","Symfwnia","Agora Eisitiriou gia ton teliko tou NBA\nΤιμή Αγοράς: 900 Ευρώ\nΤιμή Πώλησης: 1800 Ευρώ");
        Dcards[18] = new DealCards("images\\spania.jpeg","Symfwnia","Agora Spanias Gatas\nΤιμή Αγοράς: 700 Ευρώ\nΤιμή Πώλησης: 1200 Ευρώ");
        Dcards[19] = new DealCards("images\\zaxar.jpg","Symfwnia","Agora Zaxaroplasteiou\nΤιμή Αγοράς: 5000 Ευρώ\nΤιμή Πώλησης: 9500 Ευρώ");

    }


    /**
     * this method will decide randomly who will be the first player to play.
     */
    public void FirstToPlay(){
        int firstPlayer =  (int)Math.floor(Math.random()*(1+1)+0);
        if(firstPlayer == 0){
            P1.SetTurn(true);
        }else P2.SetTurn(true);
    }

    /**
     * it will decide randomly the number of months the game will stand,
     * the number should be between 1 to 3.
     * @return the number of months.
     */
    public String NoOfMonths(){
        return JOptionPane.showInputDialog("Enter the number of months");
    }


    /**
     * this method will initialize our two players.
     */
    public void PlayerInitialization(){
        P1 = new Player("P1");
        P2 = new Player("P2");
    }

    /**
     * this method will initialize the image on each day of the table.
     */
    public void TableInitialization(){
        ImageIcon image0 = new ImageIcon("images\\start.png");
        ImageIcon image1 = new ImageIcon("images\\mc1.png");
        ImageIcon image2 = new ImageIcon("images\\mc2.png");
        ImageIcon image3 = new ImageIcon("images\\deal.png");
        ImageIcon image4 = new ImageIcon("images\\sweep.png");
        ImageIcon image5 = new ImageIcon("images\\lottery.png");
        ImageIcon image6 = new ImageIcon("images\\radio.png");
        ImageIcon image7 = new ImageIcon("images\\buyer.png");
        ImageIcon image8 = new ImageIcon("images\\casino.png");
        ImageIcon image9 = new ImageIcon("images\\yard.png");
        ImageIcon image10 = new ImageIcon("images\\pay.png");

        for (int i = 0; i < 32; i++) {
            tableCards[i] = new JLabel();
        }

        tableCards[0].setIcon(image0);

        for (int i = 1; i < 5; i++) {
            tableCards[i].setIcon(image1);
        }

        for (int i = 5; i < 9; i++) {
            tableCards[i].setIcon(image2);
        }

        for (int i = 9; i < 14; i++) {
            tableCards[i].setIcon(image3);
        }

        for (int i = 14; i < 16; i++) {
            tableCards[i].setIcon(image4);
        }

        for (int i = 16; i < 19; i++) {
            tableCards[i].setIcon(image5);
        }

        for (int i = 19; i < 21; i++) {
            tableCards[i].setIcon(image6);
        }

        for (int i = 21; i < 27; i++) {
            tableCards[i].setIcon(image7);
        }

        for (int i = 27; i < 29; i++) {
            tableCards[i].setIcon(image8);
        }

        for (int i = 29; i < 31; i++) {
            tableCards[i].setIcon(image9);
        }
        tableCards[31].setIcon(image10);

    }

}
