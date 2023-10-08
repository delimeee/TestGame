
import java.util.Random;
import java.util.Date;

public class Entity {

    protected IntScale hp;

    protected IntScale damage;

    protected IntScale attack;

    protected IntScale protection;

    public Entity(int hp, IntScale damage, int attack, int protection){
        boolean hpStatement = hp > 0;
        boolean damageStatement = damage.getMin() > 0;
        boolean attackStatement = attack > 0 && attack < 31;
        boolean protectionStatement = protection > 0 && protection < 31;
        if(hpStatement && damageStatement && attackStatement && protectionStatement){
            this.hp = new IntScale(hp + 1);
            this.damage = damage;
            this.attack = new IntScale(1, 30, attack);
            this.protection = new IntScale(1, 30, protection);
        }
        else System.out.println("Wrong arguments!");
    }

    public boolean hit(Entity enemy){
        boolean success = false;
        int modifier = this.attack.getCur() - enemy.protection.getCur() + 1;
        if(modifier < 1) modifier = 1;
        Date date = new Date();
        Random random = new Random(date.getTime());
        for(int i = 0; i < modifier; ++i)
            if(random.nextInt(3) > 1) {
                this.damage.setRandomCur();
                enemy.hp.addCur(-(this.damage.getCur()));
                success = true;
                break;
            }
        return success;
    }

    public int getHP(){
        return this.hp.getCur();
    }

    public String getDamage(){
        return "["+this.damage.getMin()+"-"+this.damage.getMax()+"]";
    }

    public int getAttack(){
        return this.attack.getCur();
    }

    public int getProtection(){
        return this.protection.getCur();
    }

    public String toString(){
        return "\nHP: "+this.hp.toString()+"\nDamage: "+getDamage()
                +"\nAttack: "+this.attack+"\nProtection: "+this.protection;
    }
}
