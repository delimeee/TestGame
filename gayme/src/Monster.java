public final class Monster extends Entity{

    private int lvl;

    public Monster(int lvl){
            super( 10 + lvl * 2, new IntScale(1 + (lvl - 1), 6 + (lvl - 1)), 4, 4);
            this.protection.addCur(lvl);
            this.attack.addCur(lvl);
    }

}
