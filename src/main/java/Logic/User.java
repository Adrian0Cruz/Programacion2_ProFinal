package Logic;
//@author Jesús Hernández
public class User extends Node {
    private String Name;
    private String PassWord;

    public User (  ) { super(); }

    public String getName (  ) { return Name; }

    public void setName ( String Name ) { this.Name = Name; }

    public String getPassWord (  ) { return PassWord; }

    public void setPassWord ( String PassWord ) { this.PassWord = PassWord; }
    
    public User(String Name, String PassWord ) {
        super();
        this.Name = Name;
        this.PassWord = PassWord;
    }

    @Override
    public String toString (  ) {
        return "User{" + "Name=" + Name + ", PassWord=" + PassWord + '}'; }
}