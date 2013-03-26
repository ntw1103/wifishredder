package com.kalhoun.wifishredder;

public class WifiConfig {
	private String firstName;
	private String lastName;

	public WifiConfig(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "WifiConfig [firstName=" + firstName + ", lastName=" + lastName
				+ "]";
	}

	public void setMarried(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
