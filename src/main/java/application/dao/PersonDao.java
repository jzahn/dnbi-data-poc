package application.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import application.domain.Person;

public class PersonDao extends JdbcDao {

	public List<Person> getAllPersons() {
		List<Person> results = new ArrayList<Person>();

		String sql = "SELECT * FROM Persons order by PersonId";

		CachedRowSet rs = query(sql);
		
		try {
			while (rs.next()) {
				results.add(new Person(rs.getInt("PersonId"), rs.getString("FirstName"), rs.getString("LastName")));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return results;
	}

}
