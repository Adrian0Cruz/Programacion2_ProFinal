package Logic;
//@author Jesús Hernández
public class UserListSingleton {
    private static UserListSingleton instance;
    private List_User userList;

    private UserListSingleton (  ) { userList = new List_User(); }

    public static UserListSingleton getInstance() {
        if ( instance == null ) { instance = new UserListSingleton(); }
        return instance;
    }

    public List_User getUserList (  ) { return userList; }
}