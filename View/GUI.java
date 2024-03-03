package View;

import Model.DealCards;
import Model.MessageCards;
import Model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends JFrame implements ActionListener {

    private final JButton p1RollDice,p1MyDealCards,p1GetLoan,p1EndTurn;
    private final JButton p2RollDice,p2MyDealCards,p2GetLoan,p2EndTurn;
    private JButton mailPanel,dealPanel;
    private final ImageIcon background = new ImageIcon("images\\bg_green.png");
    private final ImageIcon mailIcon = new ImageIcon("images\\mailCard.png");
    private final ImageIcon dealIcon = new ImageIcon("images\\dealCard.png");
    private final ImageIcon logoIcon = new ImageIcon("images\\logo.png");
    private final ImageIcon jackpotimage = new ImageIcon("images\\jackpot.png");
    private final ImageIcon pawnB = new ImageIcon("images\\pawn_blue.png");
    private final ImageIcon pawnY = new ImageIcon("images\\pawn_yellow.png");
    private final ImageIcon[] diceIcon = new ImageIcon[6];
    private int rand,pawnBplace = 0,pawnYplace = 0,pawnBx = 10,pawnBy = 35,pawnYx = 10,pawnYy = 35,months,mailCardCounter = 0, dealCardsCounter = 0;
    private final Player p1,p2;
    private Boolean p1RollToWin = false,p2RollToWin = false;
    private final MessageCards[] Mcards ;
    private final DealCards[] Dcards ;


    private JLabel backgroundLabel,messageboxLabel1,messageboxLabel2,messageboxLabel3,messageboxLabel4,logolabel,dicep1label,dicep2label,jackpotLabel,pawnBLabel,pawnYLabel,daysLabel,labelp1,labelp1M,labelp1L,labelp1B,labelp2,labelp2M,labelp2L,labelp2B;
    private JPanel p1Panel,p2Panel,messageboxPanel,logoPanel;
    private final JLabel[] DayLabel = new JLabel[32];
    private final JLabel[] tablecards;


    /**
     * Creates a new Window and initializes some buttons and panels
     * starting a new game.
     */
    public GUI(Player p1, Player p2, JLabel[] tableCards, int months, MessageCards[] MessageCards, DealCards[] Dcards){
        this.p1 = p1;
        this.p2 = p2;
        this.Mcards = MessageCards;
        this.Dcards = Dcards;
        this.tablecards = tableCards;
        MixTheCards(this.tablecards);
        MixMailCards(Mcards);
        MixDealCards(Dcards);
        this.months = months;

        pawnBLabel = new JLabel(pawnB);
        pawnYLabel = new JLabel(pawnY);

        pawnBLabel.setBounds(pawnBx,pawnBy,97,110);
        pawnYLabel.setBounds(pawnYx,pawnYy,97,110);


        diceIcon[0] = new ImageIcon("images\\dice-1.jpeg");
        diceIcon[1] = new ImageIcon("images\\dice-2.jpeg");
        diceIcon[2] = new ImageIcon("images\\dice-3.jpeg");
        diceIcon[3] = new ImageIcon("images\\dice-4.jpeg");
        diceIcon[4] = new ImageIcon("images\\dice-5.jpeg");
        diceIcon[5] = new ImageIcon("images\\dice-6.jpeg");


        p1RollDice = new JButton("Roll Dice");
        p1RollDice.setBounds(10,140,140, 25);
        p1RollDice.addActionListener(this);
        p1RollDice.setFocusable(false);

        p1MyDealCards = new JButton("My Deal Cards");
        p1MyDealCards.setBounds(10,170,140, 25);
        p1MyDealCards.addActionListener(this);
        p1MyDealCards.setFocusable(false);

        p1GetLoan = new JButton("Get Loan");
        p1GetLoan.setBounds(10,200,120, 25);
        p1GetLoan.addActionListener(this);
        p1GetLoan.setFocusable(false);

        p1EndTurn = new JButton("End Turn");
        p1EndTurn.setBounds(140,200,120, 25);
        p1EndTurn.addActionListener(this);
        p1EndTurn.setFocusable(false);

        p2RollDice = new JButton("Roll Dice");
        p2RollDice.setBounds(10,140,140, 25);
        p2RollDice.addActionListener(this);
        p2RollDice.setFocusable(false);

        p2MyDealCards = new JButton("My Deal Cards");
        p2MyDealCards.setBounds(10,170,140, 25);
        p2MyDealCards.addActionListener(this);
        p2MyDealCards.setFocusable(false);

        p2GetLoan = new JButton("Get Loan");
        p2GetLoan.setBounds(10,200,120, 25);
        p2GetLoan.addActionListener(this);
        p2GetLoan.setFocusable(false);

        p2EndTurn = new JButton("End Turn");
        p2EndTurn.setBounds(140,200,120, 25);
        p2EndTurn.addActionListener(this);
        p2EndTurn.setFocusable(false);

        setDicep1label();
        setDicep2label();
        setP1Panel();
        setP2Panel();
        setMailButton();
        setDealButton();
        setMessageboxPanel();
        setBackgroundLabel();


        this.add(backgroundLabel);

        mailPanel.addActionListener(this);
        dealPanel.addActionListener(this);



        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1200,800);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.pack();
        this.setLayout(null);
        this.setResizable(false);
    }

    /**
     * Set the background label and add every button and panels on it
     */
    public void setBackgroundLabel(){
        setlogoLabel();
        setLogoPanel();
        setDaysLabel();

        backgroundLabel = new JLabel(background);
        backgroundLabel.setLayout(null);
        this.setSize(1200,800);
        backgroundLabel.setVisible(true);
        backgroundLabel.add(p1Panel);
        backgroundLabel.add(p2Panel);
        backgroundLabel.add(messageboxPanel);
        backgroundLabel.add(mailPanel);
        backgroundLabel.add(dealPanel);
        backgroundLabel.add(logoPanel);
        backgroundLabel.add(daysLabel);
    }


    /**
     *  Set the panel with the informations of player one
     */
    public void setP1Panel(){

        labelp1 = new JLabel("Player1");
        labelp1.setFont(new Font("MV Boli",Font.PLAIN,20));
        labelp1.setBounds(10,10,100,30);

        labelp1M = new JLabel("Money: " + (p1.GetMoney()) + " Euros");
        labelp1M.setBounds(10,40, 150,30);

        labelp1L = new JLabel("Loan: " + (p1.GetLoan()) + " Euros");
        labelp1L.setBounds(10,60, 100,30);

        labelp1B = new JLabel("Bill: " + (p1.GetBill()) + " Euros");
        labelp1B.setBounds(10,80, 100,30);

        p1Panel = new JPanel();
        p1Panel.setLayout(null);
        p1Panel.setBackground(Color.WHITE);
        p1Panel.setBounds(700,10,300,250);

        p1Panel.add(labelp1);
        p1Panel.add(labelp1M);
        p1Panel.add(labelp1L);
        p1Panel.add(labelp1B);

        p1Panel.add(p1RollDice);
        p1Panel.add(p1MyDealCards);
        p1Panel.add(p1GetLoan);
        p1Panel.add(p1EndTurn);

        p1Panel.add(dicep1label);
    }

    /**
     * Set the panel with the informations of player two
     */
    public void setP2Panel(){
        labelp2 = new JLabel("Player2");
        labelp2.setFont(new Font("MV Boli",Font.PLAIN,20));
        labelp2.setBounds(10,10,100,30);

        labelp2M = new JLabel("Money: " + (p2.GetMoney()) + " Euros");
        labelp2M.setBounds(10,40, 150,30);

        labelp2L = new JLabel("Loan: " + (p2.GetLoan()) + " Euros");
        labelp2L.setBounds(10,60, 100,30);

        labelp2B = new JLabel("Bill: " + (p2.GetBill()) + " Euros");
        labelp2B.setBounds(10,80, 100,30);

        p2Panel = new JPanel();
        p2Panel.setBackground(Color.WHITE);
        p2Panel.setLayout(null);
        p2Panel.setBounds(700,510,300,250);

        p2Panel.add(labelp2);
        p2Panel.add(labelp2M);
        p2Panel.add(labelp2L);
        p2Panel.add(labelp2B);

        p2Panel.add(p2RollDice);
        p2Panel.add(p2MyDealCards);
        p2Panel.add(p2GetLoan);
        p2Panel.add(p2EndTurn);

        p2Panel.add(dicep2label);
    }

    /**
     * Set the panel "info box" where we place player's turn,
     * what the card says the player to do and how many
     * months are left.
     */
    public void setMessageboxPanel(){
        messageboxLabel1 = new JLabel("Info Box");
        messageboxLabel1.setBounds(0,0,50,20);

        messageboxLabel2 = new JLabel();
        if(months == 1)
            messageboxLabel2.setText((months) + " Month Left");
        else
            messageboxLabel2.setText((months) + " Months Left");
        messageboxLabel2.setBounds(0,20,250,20);

        messageboxLabel3 = new JLabel();
        if(p1.GetTurn())
            messageboxLabel3.setText("Turn: Player 1");
        else
            messageboxLabel3.setText("Turn: Player 2");
        messageboxLabel3.setBounds(0,40,250,20);

        messageboxLabel4 = new JLabel("Start");
        messageboxLabel4.setBounds(0,60,300,20);


        messageboxPanel = new JPanel();
        messageboxPanel.setLayout(null);
        messageboxPanel.setBackground(Color.white);
        messageboxPanel.setBounds(700,270,300,100);
        messageboxPanel.add(messageboxLabel1);
        messageboxPanel.add(messageboxLabel2);
        messageboxPanel.add(messageboxLabel3);
        messageboxPanel.add(messageboxLabel4);
    }

    /**
     * Set the button for the mail cards.
     */
    public void setMailButton(){
        mailPanel = new JButton();
        mailPanel.setBounds(700,390,140,100);
        mailPanel.setIcon(mailIcon);
        mailPanel.setFocusable(false);
    }

    /**
     * Set the button for the deal cards.
     */
    public void setDealButton(){
        dealPanel = new JButton();
        dealPanel.setBounds(850,390,140,100);
        dealPanel.setIcon(dealIcon);
        dealPanel.setFocusable(false);
    }

    /**
     * Set the label of game logo.
     */
    public void setlogoLabel(){
        logolabel = new JLabel();
        logolabel.setLayout(null);
        logolabel.setBounds(1,0,680,120);
        logolabel.setIcon(logoIcon);
    }

    /**
     * Set the panel where the logo label is placed.
     */
    public void setLogoPanel(){
        logoPanel = new JPanel();
        logoPanel.setLayout(null);
        logoPanel.add(logolabel);
        logoPanel.setBounds(0,10,680,120);
    }

    /**
     * Set the dice for the player one.
     */
    public void setDicep1label(){
        dicep1label = new JLabel();
        dicep1label.setIcon(diceIcon[1]);
        dicep1label.setBounds(170,120,60,60);
    }

    /**
     * Set the dice for the player two.
     */
    public void setDicep2label(){
        dicep2label = new JLabel();
        dicep2label.setIcon(diceIcon[4]);
        dicep2label.setBounds(170,120,60,60);
    }

    /**
     * Set some labels and add these tha
     * shows witch day we are and also these that
     * shows the cards on each place.
     */
    public void setDaysLabel(){

        daysLabel = new JLabel(background);
        daysLabel.setLayout(null);
        daysLabel.setBounds(0,113,680,680);

        DayLabelInitialization();

        pawnBLabel = new JLabel(pawnB);
        pawnYLabel = new JLabel(pawnY);

        pawnBLabel.setBounds(0,35,97,110);
        pawnYLabel.setBounds(10,35,97,110);

        jackpotLabel = new JLabel(jackpotimage);
        jackpotLabel.setBounds(380,530,300,120);

        daysLabel.add(pawnBLabel);
        daysLabel.add(pawnYLabel);
        daysLabel.add(jackpotLabel);

        for (int i = 0; i < 32; i++) {
            daysLabel.add(tablecards[i]);
            daysLabel.add(DayLabel[i]);
        }

    }

    /**
     * this method will initialize some labels.
     */
    public void DayLabelInitialization(){
        int j = 0;
        String Days[] = new String[7];
        Days[0] = "Monday ";
        Days[1] = "Tuesday ";
        Days[2] = "Wednes. ";
        Days[3] = "Thursday ";
        Days[4] = "Friday ";
        Days[5] = "Saturday ";
        Days[6] = "Sunday ";

        for (int i = 0; i < 32; i++) {

            if(i < 7)
                tablecards[i].setBounds(97 * j,35 ,97,110);
            else if(i<14)
                tablecards[i].setBounds(97 * j,166 ,97,110);
            else if(i<21)
                tablecards[i].setBounds(97 * j,297 ,97,105);
            else if(i<28)
                tablecards[i].setBounds(97 * j,420 ,97,105);
            else tablecards[i].setBounds(97 * j,544 ,97,110);

            if(j == 6)
                j = 0;
            else
                j++;
        }

        j = 0;

        for (int i = 0; i < 32; i++) {
            DayLabel[i] = new JLabel();
            DayLabel[i].setBackground(Color.YELLOW);
            DayLabel[i].setOpaque(true);

            if(i < 7)
                DayLabel[i].setBounds(97 * j,15 ,95,20);
            else if(i<14)
                DayLabel[i].setBounds(97 * j,146 ,95,20);
            else if(i<21)
                DayLabel[i].setBounds(97 * j,277 ,95,20);
            else if(i<28)
                DayLabel[i].setBounds(97 * j,400 ,95,20);
            else DayLabel[i].setBounds(97 * j,525 ,95,20);

            if(j == 6)
                j = 0;
            else
                j++;
        }


        DayLabel[0].setText("Start");
        j = 0;
        for (int i = 1; i < 32; i++) {
            DayLabel[i].setText(Days[j] + i);
            if(j == 6)
                j = 0;
            else
                j++;

        }
    }

    /**
     * These method gets a card label
     * of each day and tell us what to do.
     * @param card
     */
    public void whatThePlayerShouldDo(JLabel card) {
        String str = String.valueOf(card);
        if(str.contains("mc1.png")){
            messageboxLabel4.setText("-->Get 1 Mail Card");
        }
        if(str.contains("mc2.png")){
            messageboxLabel4.setText("-->Get 2 Mail Cards");
        }
        if(str.contains("deal.png")){
            messageboxLabel4.setText("-->Get 1 Deal Card");
        }
        if(str.contains("sweep.png")){
            messageboxLabel4.setText("-->Roll The Dice");
            if(p1.GetTurn()){
                p1RollToWin = true;
                p1RollDice.setEnabled(true);
            }else{
                p2RollToWin = true;
                p2RollDice.setEnabled(true);
            }
        }
        if(str.contains("lottery.png")){
            messageboxLabel4.setText("-->Each player pick a number from 1-6");
            if(p1.GetTurn()){
                int a,b;
                a = Integer.parseInt(JOptionPane.showInputDialog("Player 1 chose a number from 1-6"));
                b = Integer.parseInt(JOptionPane.showInputDialog("Player 2 chose a number from 1-6"));
                while(b == a) b = Integer.parseInt(JOptionPane.showInputDialog("Player 2 try to chose a different number from 1-6"));
                int r = (int)Math.floor(Math.random()*(6-1+1)+1);
                while(r != a && r != b)
                    r = (int)Math.floor(Math.random()*(6-1+1)+1);
                if (r == a){
                    JOptionPane.showMessageDialog(null,"Congratulation Player 1 you won 1000 Euros","Lottery",1,new ImageIcon("images\\lottery.png"));
                    p1.SetMoney(1000);
                    labelp1M.setText("Money: " + p1.GetMoney() + " Euros");
                }else{
                    JOptionPane.showMessageDialog(null,"Congratulation Player 2 you won 1000 Euros","Lottery",1,new ImageIcon("images\\lottery.png"));
                    p2.SetMoney(1000);
                    labelp2M.setText("Money: " + p2.GetMoney() + " Euros");
                }
            }else{
                int a,b;
                b = Integer.parseInt(JOptionPane.showInputDialog("Player 2 chose a number from 1-6"));
                a = Integer.parseInt(JOptionPane.showInputDialog("Player 1 chose a number from 1-6"));
                while(b == a) a = Integer.parseInt(JOptionPane.showInputDialog("Player 1 try to chose a different number from 1-6"));
                int r = (int)Math.floor(Math.random()*(6-1+1)+1);
                while(r != a && r != b)
                    r = (int)Math.floor(Math.random()*(6-1+1)+1);
                if (r == a){
                    JOptionPane.showMessageDialog(null,"Congratulation Player 1 you won 1000 Euros","Lottery",1,new ImageIcon("images\\lottery.png"));
                    p1.SetMoney(1000);
                    labelp1M.setText("Money: " + p1.GetMoney() + " Euros");
                }else{
                    JOptionPane.showMessageDialog(null,"Congratulation Player 2 you won 1000 Euros","Lottery",1,new ImageIcon("images\\lottery.png"));
                    p2.SetMoney(1000);
                    labelp2M.setText("Money: " + p2.GetMoney() + " Euros");
                }
            }
        }
        if(str.contains("radio.png")){
            messageboxLabel4.setText("-->Each player roll the dice");
        }
        if(str.contains("buyer.png")){
            messageboxLabel4.setText("-->Chose a card to sell");
        }
        if(str.contains("casino.png")){
            messageboxLabel4.setText("-->Casino Night");
        }
        if(str.contains("yard.png")){
            messageboxLabel4.setText("-->Roll the dice 'Yard Sale'");
        }
        if(str.contains("pay.png")){
            messageboxLabel4.setText("-->Pay Day");
            if(pawnBplace == 31 && pawnYplace == 31){
                months--;
                MixTheCards(tablecards);

                if (months > 0) {
                    p1.SetMoney(3500);
                    p2.SetMoney(3500);
                    p1.SetMoney((int) -(p1.GetLoan() + (p1.GetLoan() * 0.10)));
                    p1.SetLoan(-p1.GetLoan());
                    labelp1L.setText("Loan: " + (p1.GetLoan()) + " Euros");
                    p2.SetMoney((int) -(p2.GetLoan() + (p2.GetLoan() * 0.10)));
                    p2.SetMoney((int) -(p2.GetLoan() + (p2.GetLoan() * 0.10)));
                    p2.SetLoan(-p2.GetLoan());
                    labelp2L.setText("Loan: " + (p2.GetLoan()) + " Euros");
                    new GUI(p1,p2,tablecards,months,Mcards,Dcards);
                }
                else {
                    p1.SetMoney(3500);
                    p2.SetMoney(3500);
                    p1.SetMoney((int) -(p1.GetLoan() + (p1.GetLoan() * 0.10)));
                    p2.SetMoney((int) -(p2.GetLoan() + (p2.GetLoan() * 0.10)));
                    SetWinner();

                }
            }
        }
    }

    /**
     * this method will mix the cards on the table.
     */
    public void MixTheCards(JLabel[] array){
        for (int i = array.length - 2; i > 1; i--) {
            int j = (int) Math.floor(Math.random() * (i + 1));
            while(j == 0) j = (int) Math.floor(Math.random() * (i + 1));// The Start label will always stay at the index 0
            JLabel temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    /**
     * this method will mix the Mail cards.
     */
    public void MixMailCards(MessageCards[] array){
        for (int i = array.length - 1; i > 1; i--) {
            int j = (int) Math.floor(Math.random() * (i + 1));
            MessageCards temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    /**
     * this method will mix the Deal cards.
     */
    public void MixDealCards(DealCards[] array){
        for (int i = array.length - 1; i > 1; i--) {
            int j = (int) Math.floor(Math.random() * (i + 1));
            DealCards temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    /**
     * This method will show us who the winner is.
     */
    public void SetWinner(){
        if (p1.GetMoney()>p2.GetMoney())
            JOptionPane.showMessageDialog(null,"Player 1 WON!" , "Winner",1);
        else if (p1.GetMoney()<p2.GetMoney())
            JOptionPane.showMessageDialog(null,"Player 2 WON!" , "Winner",1);
        else JOptionPane.showMessageDialog(null,"Nobody WON!" , "Winner",1);
    }


    /**
     * If it is thursday you have the right to trade in crypto.
     * @param pawnplace is the place that the pawn is right now.
     * @param p is the player that plays.
     * @param label is the label that changes player's informations.
     */
    public void Crypto(int pawnplace,Player p,JLabel label){
        if(pawnplace == 4 || pawnplace == 11 || pawnplace == 18 || pawnplace == 25){
            String[] options = {"Πόνταρε στο κρυπτονόμισμα","Παράβλεψε το ποντάρισμα"};
            String[] ifLose = {"Έχασες 300 Ευρώ"};
            String[] ifEqual = {"Δεν κέρδισες τίποτα"};
            String[] ifWon = {"κέρδισες 600 Ευρώ"};
            int a = JOptionPane.showOptionDialog(null,"Ποντάρισμα σε κρυπτονομίσματα",
                    "Crypto Thursday",JOptionPane.YES_NO_OPTION,
                    1,
                    new ImageIcon("images\\crypto.jpeg",
                            "Πόνταρε σε κρυπτονόμισμα"),
                    options,
                    0);
            int r = (int)Math.floor(Math.random()*(6-1+1)+1);
            if(a == 0){
                if(r == 1 || r == 2){
                    JOptionPane.showOptionDialog(null,"Το κρυπτονόμισμα πτόχευσε",
                            "Crypto Thursday",JOptionPane.YES_OPTION,
                            1,
                            new ImageIcon("images\\crypto.jpeg",
                                    "Το κρυπτονόμισμα πτόχευσε"),
                            ifLose,
                            0);
                    p.SetMoney(-300);
                    label.setText("Money: " + (p.GetMoney()) + " Euros");
                }else if(r == 3 || r == 4){
                    JOptionPane.showOptionDialog(null,"Το κρυπτονόμισμα έμεινε σταθερό",
                            "Crypto Thursday",JOptionPane.YES_OPTION,
                            1,
                            new ImageIcon("images\\crypto.jpeg",
                                    "Πόνταρε σε κρυπτονόμισμα"),
                            ifEqual,
                            0);
                }else if(r == 5 || r == 6){
                    JOptionPane.showOptionDialog(null,"Το κρυπτονόμισμα εκτοξεύτηκε",
                            "Crypto Thursday",JOptionPane.YES_OPTION,
                            1,
                            new ImageIcon("images\\crypto.jpeg",
                                    "Πόνταρε σε κρυπτονόμισμα"),
                            ifWon,
                            0);
                    p.SetMoney(600);
                    label.setText("Money: " + (p.GetMoney()) + " Euros");
                }
            }
        }
    }

    /**
     *
     * @param p is the player that plays
     * @param label is the label that changes the informations of the player.
     */
    public void SundayBetHelper(Player p, JLabel label){
        String[] ifLose = {"Έχασες 500 Ευρώ"};
        JOptionPane.showOptionDialog(null,"Λάθος πρόβλεψη",
                "Crypto Thursday",JOptionPane.YES_OPTION,
                1,
                new ImageIcon("images\\Barcelona_Real.jpg",
                        null),
                ifLose,
                0);
        p.SetMoney(-500);
        label.setText("Money: " + (p.GetMoney()) + " Euros");
    }

    /**
     * If it is Sunday you have the right to bet in football.
     * @param pawnplace is the place that the pawn is right now.
     * @param p is the player that plays.
     * @param label is the label that changes player's informations.
     */
    public void SundayBet(int pawnplace,Player p,JLabel label){
        if(pawnplace == 7 || pawnplace == 14 || pawnplace == 21 || pawnplace == 28){
            String[] options = {"Νίκη Μπαρτσελόνα","Ισοπαλία","Νικη Ρεάλ","Δεν θέλω να κάνω πρόβλεψη"};
            String[] ifWon = {"κέρδισες 1000 Ευρώ"};
            int a = JOptionPane.showOptionDialog(null,"Στοιχιμάτισε 500 ευρώ για το ντέρμπι Barcelona-Real", "Crypto Thursday",JOptionPane.DEFAULT_OPTION, 1, new ImageIcon("images\\Barcelona_Real.jpg", null), options, 0);
            if (a == 3)return;
            int r = (int)Math.floor(Math.random()*(6-1+1)+1);
            if(r == 1 || r == 2){
                if (a == 0){
                    JOptionPane.showOptionDialog(null,"Σωστή πρόβλεψη!!! Barcelona-Real 1-0", "Crypto Thursday",JOptionPane.YES_OPTION, 1, new ImageIcon("images\\Barcelona_Real.jpg", null), ifWon, 0);
                    p.SetMoney(1000);
                    label.setText("Money: " + (p.GetMoney()) + " Euros");
                }else{
                    SundayBetHelper(p,label);
                }
            }else if(r == 3 || r == 4){
                if (a == 1){
                    JOptionPane.showOptionDialog(null,"Σωστή πρόβλεψη!!! Barcelona-Real 1-1", "Crypto Thursday",JOptionPane.YES_OPTION, 1, new ImageIcon("images\\Barcelona_Real.jpg", null), ifWon, 0);
                    p.SetMoney(1000);
                    label.setText("Money: " + (p.GetMoney()) + " Euros");
                }else{
                    SundayBetHelper(p,label);
                }
            }else if(r == 5 || r == 6){
                if (a == 2){
                    JOptionPane.showOptionDialog(null,"Σωστή πρόβλεψη!!! Barcelona-Real 0-1", "Crypto Thursday",JOptionPane.YES_OPTION, 1, new ImageIcon("images\\Barcelona_Real.jpg", null), ifWon, 0);
                    p.SetMoney(1000);
                    label.setText("Money: " + (p.GetMoney()) + " Euros");
                }else{
                    SundayBetHelper(p,label);
                }
            }
        }
    }


    /**
     * Shows the mail card when you place the button.
     */
    public void MailButtonHelper(){
        String[] options = {Mcards[mailCardCounter].ButtonString()};
        JOptionPane.showOptionDialog(null,Mcards[mailCardCounter].CardString(),
                Mcards[mailCardCounter].CardTitle(),JOptionPane.DEFAULT_OPTION,
                1,
                new ImageIcon(Mcards[mailCardCounter].CardIcon(),
                        null),
                options,
                0);

        mailCardCounter++;
    }

    /**
     * Shows the deal card when you place the button.
     */
    public void DealButtonHelper(){
        String[] options = {"Agorase", "Agnohse thn symfwnia"};
        JOptionPane.showOptionDialog(null,Dcards[dealCardsCounter].CardString(),
                Dcards[dealCardsCounter].CardTitle(),JOptionPane.DEFAULT_OPTION,
                1,
                new ImageIcon(Dcards[dealCardsCounter].CardIcon(),
                        null),
                options,
                0);

        dealCardsCounter++;
    }


    /**
     *  performs the buttons.
     */

    public void actionPerformed(ActionEvent e) {
        if (p1.GetTurn()) {

            String str = String.valueOf(tablecards[pawnBplace]);
            if (str.contains("mc1.png") || str.contains("mc2.png")) {
                MailButtonHelper();
            }
            if (str.contains("mc2.png")) {
                if (e.getSource() == mailPanel) {
                    MailButtonHelper();
                }
            }

            if(e.getSource() == dealPanel){
                String str1 = String.valueOf(tablecards[pawnBplace]);
                if (str1.contains("deal.png") ) {
                    DealButtonHelper();
                }
            }


            if (e.getSource() == p1RollDice) {
            if (!p1RollToWin) {
                p1RollDice.setEnabled(false);
                rand = (int) Math.floor(Math.random() * (5 + 1) + 0);
                dicep1label.setIcon(diceIcon[rand]);
                if (rand == 5)
                    JOptionPane.showMessageDialog(null, "Congratulations you won the Jackpot", "Jackpot", 1, jackpotimage);
                rand++;
                if (rand + pawnBplace < 7) {
                    pawnBx = 95 * (pawnBplace + rand);
                    pawnBy = 35;
                    pawnBLabel.setBounds(pawnBx, pawnBy, 97, 110);
                    pawnBplace += rand;
                } else if (rand + pawnBplace < 14) {
                    pawnBx = 95 * (rand + pawnBplace - 7);
                    pawnBy = 166;
                    pawnBLabel.setBounds(pawnBx, pawnBy, 97, 110);
                    pawnBplace += rand;
                } else if (rand + pawnBplace < 21) {
                    pawnBx = 95 * (rand + pawnBplace - 14);
                    pawnBy = 297;
                    pawnBLabel.setBounds(pawnBx, pawnBy, 97, 110);
                    pawnBplace += rand;
                } else if (rand + pawnBplace < 28) {
                    pawnBx = 95 * (rand + pawnBplace - 21);
                    pawnBy = 420;
                    pawnBLabel.setBounds(pawnBx, pawnBy, 97, 110);
                    pawnBplace += rand;
                } else if (rand + pawnBplace < 32) {
                    pawnBx = 95 * (rand + pawnBplace - 28);
                    pawnBy = 544;
                    pawnBLabel.setBounds(pawnBx, pawnBy, 97, 110);
                    pawnBplace += rand;
                } else {
                    pawnBx = 95 * 3;
                    pawnBy = 544;
                    pawnBLabel.setBounds(pawnBx, pawnBy, 97, 110);
                    pawnBplace = 31;
                }

                whatThePlayerShouldDo(tablecards[pawnBplace]);

                Crypto(pawnBplace, p1, labelp1M);

                SundayBet(pawnBplace, p1, labelp1M);
            } else {
                p1RollDice.setEnabled(false);
                int sweep = (int) Math.floor(Math.random() * (5 + 1) + 0);
                dicep1label.setIcon(diceIcon[sweep]);
                JOptionPane.showMessageDialog(null, "Congratulation you won " + (sweep + 1) * 1000 + "Euros", "Sweepstakes", 1);
                p1.SetMoney((sweep + 1) * 1000);
                labelp1M.setText("Money: " + p1.GetMoney() + " Euros");
                p1RollToWin = false;
            }
        }

        if (e.getSource() == p1GetLoan) {
            int loan = Integer.parseInt(JOptionPane.showInputDialog("Loan should be multiple of 1000"));
            while ((loan % 1000 != 0)) {
                loan = Integer.parseInt(JOptionPane.showInputDialog("Loan should be multiple of 1000"));
            }
            p1.SetLoan(loan);
            labelp1L.setText("Loan: " + p1.GetLoan() + " Euros");
        }
    }

        if(p2.GetTurn()){

            String str = String.valueOf(tablecards[pawnYplace]);
            if(str.contains("mc1.png") || str.contains("mc2.png")){
                if(e.getSource() == mailPanel){
                    MailButtonHelper();
                }
                if(str.contains("mc2.png")){
                    if(e.getSource() == mailPanel){
                        MailButtonHelper();
                    }
                }
            }

            if(e.getSource() == dealPanel){
                String str1 = String.valueOf(tablecards[pawnYplace]);
                if (str1.contains("deal.png") ) {
                    DealButtonHelper();
                }
            }

            if (e.getSource() == p2RollDice){
                if(!p2RollToWin){
                    p2RollDice.setEnabled(false);
                    rand = (int)Math.floor(Math.random()*(5+1)+0);
                    dicep2label.setIcon(diceIcon[rand]);
                    if(rand == 5)JOptionPane.showMessageDialog(null,"Congratulations you won the Jackpot","Jackpot",1,jackpotimage);
                    rand++;
                    if (rand + pawnYplace < 7){
                        pawnYx = 95*(pawnYplace+rand);
                        pawnYy = 35;
                        pawnYLabel.setBounds(pawnYx,pawnYy,97,110);
                        pawnYplace += rand;
                    }else if(rand + pawnYplace < 14){
                        pawnYx = 95*(rand+pawnYplace-7);
                        pawnYy = 166;
                        pawnYLabel.setBounds(pawnYx,pawnYy,97,110);
                        pawnYplace += rand;
                    }else if(rand + pawnYplace < 21){
                        pawnYx = 95*(rand+pawnYplace-14);
                        pawnYy = 297;
                        pawnYLabel.setBounds(pawnYx,pawnYy,97,110);
                        pawnYplace += rand;
                    }else if(rand + pawnYplace < 28){
                        pawnYx = 95*(rand+pawnYplace-21);
                        pawnYy = 420;
                        pawnYLabel.setBounds(pawnYx,pawnYy,97,110);
                        pawnYplace += rand;
                    }else if(rand + pawnYplace < 32){
                        pawnYx = 95*(rand+pawnYplace-28);
                        pawnYy = 544;
                        pawnYLabel.setBounds(pawnYx,pawnYy,97,110);
                        pawnYplace += rand;
                    }else{
                        pawnYx = 95*3;
                        pawnYy = 544;
                        pawnYLabel.setBounds(pawnYx,pawnYy,97,110);
                        pawnYplace = 31;
                    }

                    whatThePlayerShouldDo(tablecards[pawnYplace]);

                    Crypto(pawnYplace,p2,labelp2M);

                    SundayBet(pawnYplace,p2,labelp2M);
                }else{
                    p2RollDice.setEnabled(false);
                    int sweep = (int)Math.floor(Math.random()*(5+1)+0);
                    dicep2label.setIcon(diceIcon[sweep]);
                    JOptionPane.showMessageDialog(null,"Congratulation you won " + (sweep+1)*1000 +"Euros", "Sweepstakes",1);
                    p2.SetMoney((sweep+1)*1000);
                    labelp2M.setText("Money: " + p2.GetMoney() + " Euros");
                    p2RollToWin = false;
                }
            }
            if(e.getSource() == p2GetLoan){
                int loan = Integer.parseInt(JOptionPane.showInputDialog("Loan should be multiple of 1000"));
                while((loan%1000 != 0)){
                    loan = Integer.parseInt(JOptionPane.showInputDialog("Loan should be multiple of 1000"));
                }
                p2.SetLoan(loan);
                labelp2L.setText("Loan: " + p2.GetLoan() + " Euros");
            }
        }
        if(!p1RollDice.isEnabled()){
            if (e.getSource() == p1EndTurn){
                p1.SetTurn(false);
                p2.SetTurn(true);
                p2RollDice.setEnabled(true);
                messageboxLabel3.setText("Turn: Player 2");
            }
        }
        if(!p2RollDice.isEnabled()){
            if (e.getSource() == p2EndTurn) {
                p2.SetTurn(false);
                p1.SetTurn(true);
                p1RollDice.setEnabled(true);
                messageboxLabel3.setText("Turn: Player 1");
            }

        }

    }


}