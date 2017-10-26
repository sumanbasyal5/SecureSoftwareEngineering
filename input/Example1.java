package example;

import java.util.Arrays;

public class Example1 {
	
	public static void main (String args[]) throws IOException {
		Console c = System.console();
		
		if (c == null) {
			System.err.println("No console.");
			System.exit(1);
		}
		
		String username = c.readLine("Enter your user name: ");
		char[] password = c.readPassword("Enter your password: ");
		
		if (!verify(username, password)) {
			throw new SecurityException("Invalid Credentials");
		}
		
		Arrays.fill(password, ' ');
	}
}

