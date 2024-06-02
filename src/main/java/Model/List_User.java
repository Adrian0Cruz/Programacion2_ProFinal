package Model;
//@author Jesús Hernández

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.scene.control.Alert;

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

    public boolean add(String Name, String PassWord) {
        if (SearchCod(Name) != null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "El usuario '" + Name + "' ya existe. No se agregará.");
            alert.showAndWait();
            return false; // Devuelve false si el usuario ya existe
        }
        User nuevoElemento = new User(Name, PassWord);
        if (Cab == null) {
            Cab = nuevoElemento;
        } else {
            User ultimoElemento = Cab;
            while (ultimoElemento.Sig != null) {
                ultimoElemento = (User) ultimoElemento.Sig;
            }
            ultimoElemento.Sig = nuevoElemento;
            nuevoElemento.Ant = ultimoElemento;
        }
        UserTxt();
        return true; // Devuelve true si el usuario fue agregado con éxito
    }

    public boolean Cheak ( String User, String PassWord ) {
        User A = Cab;
        while ( A != null ) {
            if ( PassWord.equals(A.getPassWord()) && User.equals( A.getName()) ) {
                return true;
            }
            A = ( User ) A.Sig;
        }
        return false;
    }
    
    public boolean SearchUser ( String Input ) {
        User B = Cab;
        while ( B != null ) {
            if ( Input.equals( B.getName (  ) ) || Input.equals ( B.getPassWord() ) ) {
                System.out.println("User: " + B.getName());
                System.out.println("PassWord: " + B.getPassWord());
            }
            B = ( User ) B.Sig;
        }
        return false;
    }
    
    private User SearchCod ( String Name ) {
        if ( Empty() )  return null; 
        else {
            User D = Cab;
            while ( D != null ) {
                if ( Name.equals ( D.getName (  ) ) ) return D;
                else D = ( User ) D.Sig;
            }
            return null;
        }
    }
    
    public void UserTxt (  ) {
        String fileName = "Users.txt";
        String encoding = "UTF-8";
        User C = Cab;
        try {
            PrintWriter writer = new PrintWriter ( fileName , encoding );
            if ( Empty()) {
                writer.println("No Hay Nada En La Lista");
            }
            while ( C != null) {
                writer.println ( C.toString (  ) );
                C = ( User ) C.Sig;
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Ocurrió un error.");
            e.printStackTrace();
        }
    }
    
    public void ImportUsers (  ) throws FileNotFoundException, IOException {
        File file = new File ( "Users.txt" );
        if ( file.exists (  ) ) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ( ( line = br.readLine ( ) ) != null ) {
                    String[] split = line.split("\\=");
                    String Name = split[0];
                    String PassWord = split[1];
                    // Verifica si el ID ya ha sido procesado
                    if ( SearchCod( Name ) == null ) {
                        User nuevoElemento = new User( Name, PassWord );
                        if ( nuevoElemento != null ) {
                            if ( Empty ( ) ) {
                                Cab = nuevoElemento;
                                nuevoElemento.Ant = Cab;
                            } else {
                                User U = Cab;
                                while ( U.Sig != null ) 
                                    U = ( User ) U.Sig;
                                U.Sig = nuevoElemento;
                                nuevoElemento.Ant = U;
                            }
                        }
                    }else {
                        System.out.println ( "Name = " + Name + "\nPor = " + PassWord);
                    }
                }
            }
        }
    }
}