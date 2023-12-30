import java.util.*;
public class TicketBook {
    static int aLB = 1;    //Available lower Berth
    static int aMB = 1;     //Available Middle Berth
    static int aUB  = 1;     //Available Upper Berth
    static int aRAC = 1;   //AvailabLe Rac 
    static int aWL = 1;    //Available Waiting List

    static List<Integer> lBP = new ArrayList<Integer>(Arrays.asList(1));
    static List<Integer> mBP = new ArrayList<Integer>(Arrays.asList(1));
    static List<Integer> uBP = new ArrayList<Integer>(Arrays.asList(1));
    static List<Integer> racBP = new ArrayList<Integer>(Arrays.asList(1));
    static List<Integer> wlBP = new ArrayList<Integer>(Arrays.asList(1));

    static Queue<Integer> wlList = new LinkedList<Integer>();
    static Queue<Integer> racList =  new LinkedList<Integer>();
    static List<Integer> bookedTicketList = new ArrayList<Integer>();// passenger Id
    static Map<Integer,Passenger> passenger_stored_data = new HashMap<Integer,Passenger>();

    public void bookTicket(Passenger p, int snumber,String allotedBerth){
        p.number = snumber;
        p.alloted = allotedBerth;
        passenger_stored_data.put(p.passengerId,p);
        bookedTicketList.add(p.passengerId);    //Not work => ,p
        System.out.println("Passenger ID : " + p.passengerId);
        System.out.println("Passenger Name : " + p.name);
        System.out.println("Passenger Age : " + p.age);
        System.out.println("Passenger Gender : " + p.gender);
        System.out.println("Passenger Berth : " + snumber + allotedBerth);
        System.out.println("--------------------------Booked Successfully");
    }

    public void racTicket(Passenger p , int snumber , String RacBerth){
        p.number = snumber;
        p.alloted = RacBerth;
        passenger_stored_data.put(p.passengerId,p);
        racList.add(p.passengerId);
        System.out.println("Passenger ID : " + p.passengerId);
        System.out.println("Passenger Name : " + p.name );
        System.out.println("Passenger Age : " + p.age);
        System.out.println("Passenger Gender : " + p.gender);
        System.out.println("Passenger Berth : " + snumber + RacBerth);
        System.out.println("---------------------------RAC Berth Given");
    }

    public void waitingTicket(Passenger p , int snumber , String wtBerth){
        p.number = snumber;
        p.alloted = wtBerth;
        passenger_stored_data.put(p.passengerId,p);
        wlList.add(p.passengerId);
        System.out.println("Passenger ID : " + p.passengerId);
        System.out.println("Passenger Name : " + p.name );
        System.out.println("Passenger Age : " + p.age);
        System.out.println("Passenger Gender : " + p.gender);
        System.out.println("Passenger Berth : " + snumber + wtBerth);
        System.out.println("---------------------------You're in Waiting List");
    }

    public void cancelTicket(int passengerId) {
        Passenger p = passenger_stored_data.get(passengerId);
        passenger_stored_data.remove(passengerId);
        bookedTicketList.remove(passengerId);
        int psnumber = p.number;
        System.out.println("------------Cancel Successfully");

        if(p.alloted.equals("L")){
            lBP.add(psnumber);
            aLB++;
        }else if(p.alloted.equals("M")){
            mBP.add(psnumber);
            aMB++;
        }else if(p.alloted.equals("U")){
            uBP.add(psnumber);
            aUB++;
        }

        if(racList.size() > 0){
            Passenger passengerfromRAC = passenger_stored_data.get(racList.poll());
            int pracsnumber = passengerfromRAC.number;
            racBP.add(pracsnumber);
            racList.remove(passengerfromRAC.passengerId);
            aRAC++;

        if(wlList.size() > 0){
            Passenger pfwl = passenger_stored_data.get(wlList.poll());
            int pwlnumber = pfwl.number;
            wlBP.add(pwlnumber);
            wlList.remove(pfwl.passengerId);
           
            pfwl.number = racBP.get(0);
            pfwl.alloted = "RAC";
            racBP.remove(0);
            racList.add(pfwl.passengerId);
            aWL++;
            aRAC--;
        }

        Main.bookTicket(passengerfromRAC);

        }
    
    }

public void availableTickets(){
    System.out.println("The Lower Berth Tickets is : " + lBP );
    System.out.println("The Middle Berth Tickets is : " + mBP );
    System.out.println("The Upper Berth Tickets is : " + uBP );
    System.out.println("The RAC Tickets is : " + aRAC );
    System.out.println("The Waiting List Tickets is : " + aWL );
}

public void passengerDetails(){
        if(passenger_stored_data.size() == 0 ){
            System.out.println("No Passenger Details Available");
            return ;
        }
        else
        {
            for(Passenger p : passenger_stored_data.values())   //.values()
            {
                System.out.println("Passenger ID : " + p.passengerId);
                System.out.println("Passenger Name : " + p.name);
                System.out.println("Passenger Age : " + p.age);
                System.out.println("Passenger Gender : " + p.gender);
                System.out.println("Passenger Child Name : " + p.cname);
                System.out.println("Passenger Child Age : " + p.cage);
                System.out.println("Alloted Berth : " + p.number + p.alloted);
                System.out.println("___________________________________");
            }
        }
    }
}
