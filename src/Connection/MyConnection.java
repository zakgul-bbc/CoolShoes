package Connection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import DAO.Kunde;

public class MyConnection {

	private static Connection conn;

	public MyConnection() {

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			conn = DriverManager.getConnection("jdbc:ucanaccess://C://Users//lucal//Downloads//CoolShoes");
		} catch (ClassNotFoundException err) {
			System.out.println("Treiber kann nicht geladen werden");
		} catch (SQLException err) {
			System.out.println("Verbindung kann nicht aufgebaut werden");
		}
	}

	public ArrayList<String[]> getAllKunde(String tabelle) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT KID as ID, KName as Name, KVorname as Vorname, KAdresse as Adresse, KPLZ as PLZ, KOrt as Ort, KEmailAdresse as Email, KPWD as Passwort FROM Kunde");
			Kunde kunde = new Kunde();
			while (rs.next()) {
				kunde.setId(rs.getInt("ID"));
				kunde.setVorname(rs.getString("Vorname"));
				kunde.setNachname(rs.getString("Name"));
				kunde.setAdreesse(rs.getString("Adresse"));
				kunde.setPlz(rs.getString("PLZ"));
				kunde.setOrt(rs.getString("Ort"));
				kunde.setEmail(rs.getString("Email"));
				kunde.setPasswort(rs.getString("Passwort"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException err) {
			System.out.println("ungültiger SQL-Befehl");
		}
		return null;
	}
	
	public ArrayList<String[]> getAllBestellstatus(String tabelle) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT BID as id, FKKunde as Kunde, FKStatus as Status, FKMitarbeiter as Mitarbeiter FROM Bestellungen");
			Kunde kunde = new Kunde();
			while (rs.next()) {
				kunde.setId(rs.getInt("ID"));
				kunde.setVorname(rs.getString("Vorname"));
				kunde.setNachname(rs.getString("Name"));
				kunde.setAdreesse(rs.getString("Adresse"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException err) {
			System.out.println("ungültiger SQL-Befehl");
		}
		return null;
	}
	
}
