package com.tecsup.gestion.model;

public class Vacation {

	String username;
	int daysOfVacations;
	
	
	public Vacation(String username, int daysOfVacations) {
		super();
		this.username = username;
		this.daysOfVacations = daysOfVacations;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getDaysOfVacations() {
		return daysOfVacations;
	}
	public void setDaysOfVacations(int daysOfVacations) {
		this.daysOfVacations = daysOfVacations;
	}

	@Override
	public String toString() {
		return "Vacation [username=" + username + ", daysOfVacations=" + daysOfVacations + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + daysOfVacations;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vacation other = (Vacation) obj;
		if (daysOfVacations != other.daysOfVacations)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
	
}
