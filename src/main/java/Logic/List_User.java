package Logic;
//@author Jesús Hernández
public class List_User {
    private User Cab;
    
    public List_User (  ) { Cab = null; }
    
    private boolean Empty() { return Cab == null; }
    
    private int GetLength() {
        if ( Empty() )  return 0; 
        else {
            User A = Cab;
            int Cont = 0;
            while ( A  != null ) {
                Cont++;
                A = ( User ) A.Sig;
            }
            return Cont;
        }
    }
    
    public void add ( String Name, String PassWord ) {
        User nuevoElemento = new User ( Name, PassWord );
        if ( Cab == null ) Cab = nuevoElemento;
        else{
            User ultimoElemento = Cab;
            while ( ultimoElemento.Sig != null )
                ultimoElemento = ( User ) ultimoElemento.Sig; 
            
            ultimoElemento.Sig = nuevoElemento;
            nuevoElemento.Ant = ultimoElemento;
        }
        
    }
    
    public boolean Cheak ( String User, String PassWord ) {
        User A = Cab;
        System.out.println(A);
        while ( A != null ) {
            System.out.println(A);
            System.out.println( A.getPassWord() + "  " + A.getName());
            System.out.println(User + "   " + PassWord);
            if ( PassWord.equals(A.getPassWord()) && User.equals( A.getName()) ) {
                return true;
            }
            A = ( User ) A.Sig;
        }
        System.out.println(A+"123");
        return false;
    }
}