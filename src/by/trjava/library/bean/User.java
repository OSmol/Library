package by.trjava.library.bean;

import java.io.Serializable;

public class User implements Serializable {

    String login;// куда пропали атрибуты доступа?
    String password;

    public  User(String login, String password){
        this.login = login;
        this.password = password;
    }

    public User(){}

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        User other = (User) obj;

        if (login == null) {
            if(other.login!= null)
                return false;
        }else if(!login.equals(other.login))
            return false;

        if (password == null) {
            if(other.password!= null)
                return false;
        }else if(!password.equals(other.password))
            return false;


        return true;
    }

    @Override
    public int hashCode() {
        return (((password==null)?0:password.hashCode())+ ((login==null)?0:login.hashCode()));
    }

    @Override
    public String toString() {
        return getClass().getName() + " login = " + login + " password = " + password;
    }
}
