package com.itis;
import java.util.LinkedList;
import java.util.List;

public class UserBean {
    List<User> list=new LinkedList<>();
    public UserBean(){
        list.add(new User("���������", "��������", 23));
        list.add(new User("���������","��������", 19));
        list.add(new User("������","������", 19));
        list.add(new User("����","���������", 19));
        list.add(new User("������","�������", 20));
    }
    public static class User {
        String firstname;
        String lastname;
        int age;

       public User(){
       }
        private User(String firstname, String lastname, int age){
            this.firstname=firstname;
            this.lastname=lastname;
            this.age=age;

        }
        public String getFirstname() {
            return firstname;
        }
        public String getLastname() {
            return lastname;
        }

        public int getAge() {
            return age;
        }
    }
    public List<User> getUserList() {
        return list;
    }

    public void setUserList(List<User> list) {
        this.list = list;
    }



}
