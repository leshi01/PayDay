package Model;

public class Jackpot {
    private int money;

    /**
     * initialize the jackpot amount of money.
     */
    public Jackpot(){
        this.money = 0;
    }

    /**
     * increase the jackpot's money.
     */
    public void setMoney(int jackpot){
        this.money += jackpot;
    }

    /**
     * when someone take the Jackpot it should be again at 0 euros.
     */
    public void setJackpotToZero(){
        this.money = 0;
    }

    /**
     *
     * @return the variable money.
     */
    public int getMoney(){
        return this.money;
    }
}
