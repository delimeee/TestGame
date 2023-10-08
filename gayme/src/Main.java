import java.util.Scanner;
import java.lang.Thread;

public class Main {
    public static int lvl = 1;
    public static void main(String[] args) throws InterruptedException{
        Scanner scanner = new Scanner(System.in);
        String command = "";
        do {
            Player player = new Player(12, new IntScale(1, 6), 5, 5);
            System.out.println("Добро пожаловть на кроваваую арену смерти. Ты обречен" +
                    " на сражение с мертвецами, до тех пор, пока ты не падёшь под тяжестью собственных грехов.\n");
            Thread. sleep(2000);
            System.out.println("1) Начать смертельную битву");
            System.out.println("2) Покинуть арену");
            command = scanner.nextLine();
            switch (command){
                case "1":
                    System.out.println("Из кучи трупов поднимается ваш первый противник.");
                    do {
                        Thread. sleep(2000);
                        System.out.println("Вы наполняетесь решимостью.");
                        Monster monster = new Monster(lvl);
                        do {
                            System.out.println("1) Нанести удар");
                            System.out.println("2) Исцелить здоровье");
                            System.out.println("3) Мои параметры");
                            System.out.println("4) Параметры врага");
                            command = scanner.nextLine();
                            switch (command) {
                                case "1":
                                    boolean suc = player.hit(monster);
                                    if (suc) System.out.println("Вы нанесли отличный удар!");
                                    else System.out.println("Вы... Промазали...");
                                    if(monster.getHP() != 0) {
                                        Thread.sleep(500);
                                        System.out.println("Зомби нападает!");
                                        Thread.sleep(500);
                                        suc = monster.hit(player);
                                        if (suc) System.out.println("Уфф, по вам попали");
                                        else System.out.println("Пронесло, он промазал");
                                        Thread.sleep(500);
                                    }
                                    break;
                                case "2":
                                    player.heal();
                                    break;
                                case "3":
                                    System.out.println(player);
                                    break;
                                case "4":
                                    System.out.println(monster);
                                    break;
                            }
                        } while (player.getHP() != 0 && monster.getHP() != 0);
                        if(monster.getHP() == 0){
                            lvl++;
                            if(player.getProtection() < 30) player.bustProtection();
                            if(player.getAttack() < 30) player.bustAttack();
                            System.out.println("Вы победили монстра и можете выбрать одно из улчшений: ");
                            System.out.println("1) Увеличить и иcцелить здоровье");
                            System.out.println("2) Увеличить урон");
                            do {
                                command = scanner.nextLine();
                                switch (command) {
                                    case "1":
                                        player.bustHP();
                                        player.fullHP();
                                        break;
                                    case "2":
                                        player.bustDamage();
                                        break;
                                }
                            }while(!(command.equals("1") || command.equals("2")));
                            System.out.println("Некогда расслабляться. Вы видите, как на вас идёт еще один мертвец.");
                            Thread.sleep(3000);
                        }
                    }while(player.getHP() != 0);
                    Thread.sleep(3000);
                    System.out.println("Кажется, этот удар по настоящему сильным.");
                    Thread.sleep(3000);
                    System.out.println("Вы не успеваете уклоиться и мертвый воин пронзает вас насквозь.");
                    Thread.sleep(3000);
                    System.out.println("Вы чувствуете как тяжелеет ваше тело.");
                    Thread.sleep(3000);
                    System.out.println("Кажется, это конец. Арена забрала еше одну душу, пополнив свою армию мертвецов очередным бездыханным телом");
                    Thread.sleep(3000);
                    System.out.println("Вы убили "+ (lvl - 1) +" мертвецов");
                    break;
                case "2":
                    System.out.println("Тысячи кинжалов вырываются из под земли и пронзают ваше тело.");
                    Thread. sleep(3000);
                    System.out.println("Вы испытываете сильную боль по всему телу и чувствуйте, как силы покидают вас.");
                    Thread. sleep(3000);
                    System.out.println("В последние секунды перед потерей сознания вы слышите адский хохот.");
                    Thread. sleep(3000);
                    System.out.println("Арена забрала еше одну душу, пополнив свою армию мертвецов очередным бездыханным телом");
                    break;
            }

        }while(!command.equals("2"));
    }
}