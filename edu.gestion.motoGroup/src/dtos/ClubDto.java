package dtos;

public class ClubDto {
	
	//Atributos
	
	long idClub;
	
	String nombreClub="aaaaa";
	int miembrosClub=999999;
	String sede="aaaaa";
	
	//Getters Y Setters
	
	public long getIdClub() {
		return idClub;
	}
	public void setIdClub(long idClub) {
		this.idClub = idClub;
	}
	public String getNombreClub() {
		return nombreClub;
	}
	public void setNombreClub(String nombreClub) {
		this.nombreClub = nombreClub;
	}
	public int getMiembrosClub() {
		return miembrosClub;
	}
	public void setMiembrosClub(int miembrosClub) {
		this.miembrosClub = miembrosClub;
	}
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	
	
		
	
	
	@Override
	public String toString() {
		return "ClubDto [idClub=" + idClub + ", nombreClub=" + nombreClub + ", miembrosClub=" + miembrosClub + ", sede="
				+ sede + "]";
	}
	
	

}
