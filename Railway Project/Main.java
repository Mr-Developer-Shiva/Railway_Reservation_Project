import java.util.*;
public class Main{
    public static void bookTicket(Passenger p){
        TicketBook tb = new TicketBook();
        //------------------------------Waiting List-------------------------------------------------------------
        if(TicketBook.aWL == 0 ){
            System.out.println(".............No Tickets Available............");
            return;
        }
        else if(p.age > 60 && TicketBook.aLB > 0){
            System.out.println("You're a Senior Citizen, so we arranged a Lower Berth");
            tb.bookTicket(p, (TicketBook.lBP.get(0)), "L");
            TicketBook.lBP.remove(0);
            TicketBook.aLB--;
        }
        else if(p.cname != ("null") && TicketBook.aLB > 0){
            System.out.println("You Have a Chid, So we arranged the Lower Berth");
            tb.bookTicket(p, (TicketBook.lBP.get(0)), "L");
            TicketBook.lBP.remove(0);
            TicketBook.aLB--;
        }
        //---------------------------------Berth-----------------------------------------------------------------
        else if((p.bp.equals("L") && TicketBook.aLB > 0) || (p.bp.equals("M") && TicketBook.aMB > 0 ) || (p.bp.equals("U") && TicketBook.aUB > 0) ){
            if(p.bp.equals("L")){
                System.out.println("Lower Berth Given");
                tb.bookTicket(p, (TicketBook.lBP.get(0)), "L");
                TicketBook.lBP.remove(0);
                TicketBook.aLB--;
            }
            else if(p.bp.equals("M")){
                System.out.println("Middle Berth Given");
                tb.bookTicket(p,(TicketBook.mBP.get(0)), "M");
                TicketBook.mBP.remove(0);
                TicketBook.aMB--;
            }
            else if(p.bp.equals("U")){
                System.out.println("Upper Berth Given");
                tb.bookTicket(p, (TicketBook.uBP.get(0)), "U");
                TicketBook.uBP.remove(0);
                TicketBook.aUB--;
            }
        }
        //---------------------Available Auto Ticket Given----------------------------
            else if(TicketBook.aLB > 0){
                System.out.println("Lower Berth Given");
                tb.bookTicket(p, (TicketBook.lBP.get(0)), "L");
                TicketBook.lBP.remove(0);
                TicketBook.aLB--;
            }
            else if(TicketBook.aMB > 0){
                System.out.println("Middle Berth Given");
                tb.bookTicket(p,(TicketBook.mBP.get(0)), "M");
                TicketBook.mBP.remove(0);
                TicketBook.aMB--;
            }
            else if(TicketBook.aUB > 0){    // USE TOP OF THE CODE CONDITION FIRST EXECUTED 
                System.out.println("Upper Berth Given");
                tb.bookTicket(p, (TicketBook.uBP.get(0)), "U");
                TicketBook.uBP.remove(0);
                TicketBook.aUB--;     
            }
            else if(TicketBook.aRAC > 0){
                System.out.println("RAc  Given");
                tb.racTicket(p, (TicketBook.racBP.get(0)), "RAC");
                TicketBook.racBP.remove(0);
                TicketBook.aRAC--;
            }
            else if(TicketBook.aWL > 0){
                System.out.println("Waiting List Given");
                tb.waitingTicket(p,(TicketBook.wlBP.get(0)),"WL");
                TicketBook.wlBP.remove(0);
                TicketBook.aWL--;
            }
    }

    public static void cancelTicket(int id){
        TicketBook tb = new TicketBook();
        if(!tb.passenger_stored_data.containsKey(id)){
            System.out.println("Passenget ID is not Found");
        }
        else{
            tb.cancelTicket(id);
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean loop = true; //Initialization
        while(loop){
            System.out.println("1.Book \n2.Cancel \n3.Available Ticket \n4.Booked Tickets \n5.Exit") ;
            int choice = scan.nextInt();
            switch(choice){
            case 1:
            {   
                System.out.println("Enter a Passenger Name : " );
                String name = scan.next();
                System.out.println("Enter a Passenger Age : ");
                int age = scan.nextInt(); 
                System.out.println("Enter a Passenger Gender : [M , F]");
                String gender = scan.next();
                if(gender.equals("F"))
                {
                    System.out.println("1. If you have a Child,Press 1 \n2. If you haven't a child,Press 2 ");
                    int gchoice = scan.nextInt();
                    if(gchoice == 1)
                    {
                        System.out.println("Enter Your Child Name : " );
                        String cname = scan.next();
                        System.out.println("Enter Your Child Age : ");
                        int cage = scan.nextInt();
                        System.out.println("Enter the Passenger Berth Preferance [L, M, U]") ;
                        String bp = scan.next();
                        Passenger p = new Passenger(name, age, gender,cname,cage, bp);
                        bookTicket(p);
                    }
                    else if(gchoice == 2){
                        System.out.println("Enter the Passenger Berth Preferance : [L, M, U]");
                        String bp = scan.next();
                        String cname = "null";
                        int cage = 0;
                        Passenger p = new Passenger(name ,age , gender, cname,cage, bp);
                        bookTicket(p);
                    }
                }
                if(gender.equals("M")){
                System.out.println("Enter a Passanger Berth Perferance : [L, M, U]");
                String bp = scan.next();
                String cname = "null";
                int cage = 0 ;
                Passenger p = new Passenger(name,age,gender, cname ,cage ,bp); 
                bookTicket(p);
                }
                break;
            }
            case 2:
            {
                System.out.println("Enter the PassengerID : ");
                int id= scan.nextInt();
                cancelTicket(id);
                break;
            }
            case 3:
            {
                TicketBook tb = new TicketBook();
                tb.availableTickets();
                break;
            }
            case 4:
            {
                TicketBook tbpassengerDetails = new TicketBook();
                tbpassengerDetails.passengerDetails();
                break;
            }
            case 5:
            {
            loop = false;
            break;
            }
            }
        }
    }
}