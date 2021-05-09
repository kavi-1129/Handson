package org.example;

public enum Doctor {
	
	john("Ishan John"),
	thara("Pavi Thara"),
	vijay("Joesph Vijay"),
	dulquer("dulquer salman");

	private String doctorName;
	
	public String getDoctorName() {
		return doctorName;
	}
	
	private Doctor(String doctorName) {
		this.doctorName = doctorName;
	}

}
