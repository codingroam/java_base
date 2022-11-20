package com.acme.arthas;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class RunCMD1 {

    private String a = "fdhsj\njksdj";
   // private String[] cmdToRunWithArgs = {"C:/Program Files/Java/jdk1.8.0_301/jre/../bin/jconsole.exe"};
    private String[] cmdToRunWithArgs = {"C:\\Program Files\\Java\\jdk1.8.0_333\\bin\\jps.exe"};
    @Test
    public void test() throws IOException {
        runNative();
        //process();

    }

    public void process() throws IOException {
        ProcessBuilder pb = new ProcessBuilder(cmdToRunWithArgs);
        Process process = pb.start();
        InputStream inputStream = process.getInputStream();

        byte[] bytes = new byte[1024];
        int count = 0;
        while((count=(inputStream.read(bytes,0,1024)))!=-1){
            System.out.print(new String(bytes,0,count, Charset.defaultCharset()));
        }



    }
    public  List<String> runNative() {
        Process p = null;
        try {
            p = Runtime.getRuntime().exec(cmdToRunWithArgs);
        } catch (SecurityException e) {
//            AnsiLog.trace("Couldn't run command {}:", Arrays.toString(cmdToRunWithArgs));
//            AnsiLog.trace(e);
            return new ArrayList<String>(0);
        } catch (IOException e) {
//            AnsiLog.trace("Couldn't run command {}:", Arrays.toString(cmdToRunWithArgs));
//            AnsiLog.trace(e);
            e.printStackTrace();
            return new ArrayList<String>(0);
        }

        ArrayList<String> sa = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                sa.add(line);
            }
            p.waitFor();
        } catch (IOException e) {
//            AnsiLog.trace("Problem reading output from {}:", Arrays.toString(cmdToRunWithArgs));
//            AnsiLog.trace(e);
            return new ArrayList<String>(0);
        } catch (InterruptedException ie) {
//            AnsiLog.trace("Problem reading output from {}:", Arrays.toString(cmdToRunWithArgs));
//            AnsiLog.trace(ie);
            Thread.currentThread().interrupt();
        } finally {
           // IOUtils.close(reader);
        }
        return sa;
    }
}
