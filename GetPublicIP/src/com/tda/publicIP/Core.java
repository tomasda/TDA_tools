package com.tda.publicIP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Core {

	public void run() {
		
		readCMDResult();
		
	}
	
	public void readCMDResult() {
		
		ProcessBuilder processBuilder = new ProcessBuilder();
        //processBuilder.command("cmd.exe", "/c", "ping -n 3 google.com");
		//curl ifconfig.me
		//nslookup myip.opendns.com. resolver1.opendns.com
		if (System.getProperty("os.name").toLowerCase().startsWith("windows")) {
			processBuilder.command("cmd.exe", "/c", "nslookup myip.opendns.com. resolver1.opendns.com");
		}else {
			processBuilder.command("sh ", "-c", "curl ifconfig.me");
		}
		
		try {
			Process process = processBuilder.start();
		
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
			BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
		
		
			System.out.print("Here is the standard output of th command: \n");
			String s = null;
			while(null!=(s=stdInput.readLine())){
				System.out.println(s);
			}
			System.out.println("Here is the standard error of the command (if any):\n");
			while(null!=(s=stdError.readLine())) {
				System.out.println(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void ping() {
		ProcessBuilder processBuilder = new ProcessBuilder();
        // Windows
        processBuilder.command("cmd.exe", "/c", "ping -n 3 google.com");

        try {

            Process process = processBuilder.start();

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            System.out.println("\nExited with error code : " + exitCode);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
}
