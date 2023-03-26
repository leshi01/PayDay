package Model;

import java.util.Stack;

public class Player {

    private String name;
    private int player_month;
    private int player_day;
    private int money;
    private int bill;
    private int loan;
    private Stack<DealCards> d_cards;
    private Boolean turn;

    /**
     * <b> postcondition </b> Creates a new player with the given name,
     * also initialize some other variables like the month and the day
     * the player is at, also it initializes the players money, bill and
     * loan. The variable turn show us if it's time for the player to play.
     * @param name is the name of the player
     */
    public Player(String name){
        this.name = name;
        this.player_month = 1;
        this.player_day = 0;
        this.money = 3500;
        this.bill = 0;
        this.loan = 0;
        this.d_cards = new Stack<DealCards>();
        this.turn = false;
    }



    /**
     *<p><b>Postcondition:</b>the variable money can take
     * both positive and negative numbers and it is always
     * added at the total player's money. </p>
     * @param money is added to player's money
     */
    public void SetMoney(int money){
        this.money += money;
    }

    /**
     *<p><b>Postcondition:</b>the variable Bill can take
     * both positive and negative numbers and it is always
     * added at the total player's Bill. </p>
     * @param Bill is added to player's Bill.
     */
    public void SetBill(int Bill){
        this.bill += Bill;
    }

    /**
     *<p><b>Postcondition:</b>the variable loan can take
     * both positive and negative numbers and it is always
     * added at the total player's loan. Also it should always
     * be multiple of 1000. </p>
     * @param loan is added to player's loan.
     */
    public void SetLoan(int loan){
        this.loan +=loan;
    }

    /**
     *<p><b>Postcondition:</b> it puts another deal card to
     * player's collection. </p>
     * @param d_cards is added to player's d_cards.
     */
    public void SetD_Cards(DealCards d_cards){
        this.d_cards.push(d_cards);
    }


    /**
     *<p><b>Postcondition:</b> it sets player's turn
     * at true if it is his turn or false if it's not. </p>
     * @param turn is replaced at player's turn.
     */
    public void SetTurn(boolean turn){
        this.turn = turn;
    }

    /**
     *
     * @return the month the player is at.
     */
    public int GetPlayerMonth(){

        return this.player_month;
    }

    /**
     *
     * @return the day the player is at.
     */
    public int GetPlayerDay(){

        return this.player_day;
    }

    /**
     *
     * @return the amount of money the player has.
     */
    public int GetMoney(){

        return this.money;
    }

    /**
     *
     * @return the bill the player has to pay.
     */
    public int GetBill(){

        return this.bill;
    }

    /**
     *
     * @return the loan the player has taken.
     */
    public int GetLoan(){

        return this.loan;
    }

    /**
     *
     * @return the stack with the player's deal cards.
     */
    public Stack<DealCards> Get_dealCards_stuck(){

        return this.d_cards;
    }

    /**
     *
     * @return true if it is this player's turn or false
     * if it's not.
     */
    public boolean GetTurn(){

        return this.turn;
    }

    /**
     * @return true if the player has finished or false
     * if he's not.
     */
    public boolean HasThePlayerFinished(){

        return false;
    }

}
