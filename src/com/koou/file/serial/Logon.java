package com.koou.file.serial;

import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by yunqiangdi on 3/8/2017.
 */
public class Logon implements Serializable {
    private Date date = new Date();
    private String username;
    private transient String password;

    public Logon(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Logon{" +
                "date=" + date +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static void main(String[] args) throws Exception {
        Logon a = new Logon("Hulk", "myLittlePony");
        System.out.println("logon a = " + a);
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Logon.out"));
        o.writeObject(a);
        o.close();
        TimeUnit.SECONDS.sleep(1);
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Logon.out"));
        System.out.println("Recovering object at " + new Date());
        a = (Logon)in.readObject();
        System.out.println("logon a = " + a);
    }
}
