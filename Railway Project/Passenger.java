
public class Passenger {
    static int id = 1;

    String name ;   //Declaration
    int age;
    String gender;  //use char
    String cname;
     int cage;
    String bp ; //use char

    int passengerId = id++;
    String alloted;  //l,m,u
    int number;     //1|2|3

     

    public Passenger(String name , int age , String gender ,String cname , int cage, String bp){ //user inputs save 
        this.name = name;       
        this.age = age;
        this.gender = gender;
        this.cname = cname ;
        this.cage = cage;
        this.bp = bp;
        alloted =" "; //dummy value
        number = -1;
    }

}
