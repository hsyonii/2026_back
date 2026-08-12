package day0812;

public class Exam3 {

}
class Car{
    Tire tire;
    void run(){
        this.tire.roll();
    }

}
interface Tire{
    void roll();
}

//구현체
class HnakookTire implements Tire{
    
}
