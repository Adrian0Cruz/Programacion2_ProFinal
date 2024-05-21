package Logic;
//@author Jesús Hernández
public class List_User {
    private User Cab;
    
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
        while ( A != null ) {
            System.out.println( A.getPassWord() + "  " + A.getName());
            System.out.println(User + "   " + PassWord);
            if ( PassWord.equals(A.getPassWord()) && User.equals( A.getName()) ) {
                return true;
            }
            A = ( User ) A.Sig;
        }
        return false;
    }
}