package com.koou.file.common;

import com.koou.common.exception.OSExecuteException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yunqiangdi on 3/6/2017.
 */
public class OSExecute {

    public static void command(String command) {
        boolean err = false;
        try {
            Process process = new ProcessBuilder(command.split(" ")).start();
            BufferedReader results = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            String s;
            while ((s = results.readLine()) != null)
                System.out.println(s);
            BufferedReader errors = new BufferedReader(
                    new InputStreamReader(process.getErrorStream()));
            while ((s = errors.readLine()) != null){
                System.err.println(s);
                err = true;
            }
        } catch (IOException e) {
            if (!command.startsWith("CMD /C"))
                command("CMD /C" + command);
            else
                throw new RuntimeException(e);
        }

        if (err) {
            throw new OSExecuteException(command);
        }
    }
}
