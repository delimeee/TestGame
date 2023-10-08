public final class Player extends Entity{
    private int heals = 4;

    public Player(int hp, IntScale damage, int attack, int protection){
        super(hp, damage, attack, protection);
    }

    public void heal(){
        if(this.heals > 0){
            this.hp.addCur( (int) (this.hp.getMax() * 0.3));
            this.heals--;
        }
        else System.out.println("Зелий исцеления больше нет...");
    }

    public void fullHP(){
        this.hp.putCur(this.hp.getMax());
    }

    public void bustHP(){
        this.hp.expandMax(5);
    }
    public void bustDamage(){
        this.damage.expand(5);
    }

    public void bustAttack(){
        this.attack.addCur(5);
    }

    public void bustProtection(){
        this.protection.addCur(5);
    }

    @Override
    public String toString(){
        return "\nHP: "+this.hp.toString()+"\nDamage: "+getDamage()
                +"\nAttack: "+this.attack+"\nProtection: "+this.protection +"\nHeals: "+heals;
    }
}
