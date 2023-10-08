import java.util.Random;
import java.util.Date;

public class IntScale {
    private int min;

    private int max;

    private int cur;

    public IntScale(int range){
        if(range > 0){
            this.min  = 0;
            this.max = range - 1;
            this.cur = range - 1;
        }
        else System.out.println("Wrong arguments!");
    }

    public IntScale(int min, int max){
        if(min <= max){
            this.min = min;
            this.max = max;
            this.cur = max;
        }
        else System.out.println("Wrong arguments!");
    }

    public IntScale(int min, int max, int cur){
        if(min <= cur && cur <= max) {
            this.min = min;
            this.max = max;
            this.cur = cur;
        }
        else System.out.println("Wrong arguments!");
    }


    public void setMax(int max){
        if(max >= this.min){
            this.max = max;
            if(this.cur > max) this.cur = max;
        }
        else System.out.println("Wrong arguments!");
    }

    public void setMin(int min){
        if(min <= this.max){
            this.min = min;
            if(this.cur < min) this.cur = min;
        }
        else System.out.println("Wrong arguments!");
    }

    public void putCur(int cur){
        if(this.min > cur) this.cur = this.min;
        else if(this.max < cur) this.cur = this.max;
    }

    public void addCur(int cur){
        this.cur += cur;
        if(this.cur > max) this.cur = max;
        else if(this.cur < min) this.cur = min;
    }

    public void setCur(int cur){
        if(this.min <= cur && cur <= this.max ) this.cur = cur;
        else if(this.min > cur){
            this.cur = cur;
            this.min = cur;
        }
        else{
            this.cur = cur;
            this.max = cur;
        }
    }

    public int getCur(){
        return this.cur;
    }

    public int getMax(){
        return this.max;
    }

    public int getMin(){
        return this.min;
    }

    public int range(){
        return this.max - this.min + 1;
    }

    public void expand(int k){
        if(k > 0) {
            this.max += k;
            this.min += k;
        }
        else System.out.println("O_o");
    }

    public void expandMin(int k){
        if(k > 0) {
            this.min -= k;
        }
        else System.out.println("O_o");
    }

    public void expandMax(int k){
        if(k > 0) {
            this.max += k;
        }
        else System.out.println("O_o");
    }

    public void changeRange(int min, int max){
        if(min < max){
            this.min = min;
            this.max = max;
            if(this.cur < min) this.cur = min;
            else if(this.cur > max) this.cur = max;
        }
        else System.out.println("Wrong arguments!");
    }

    public void setRandomCur(){
        Date date = new Date();
        Random rand = new Random(date.getTime());
        this.cur = rand.nextInt(this.range()) + getMin();
    }

    public String toString(){return "["+ min +"..."+ max + "] Current: "+ cur;}

}
