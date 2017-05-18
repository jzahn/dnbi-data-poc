package application.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import application.domain.Person;

public class PersonDao extends JdbcDao {

	public List<Person> getAllPersons() {
		List<Person> results = new ArrayList<Person>();

		String sql = "SELECT * FROM Persons order by PersonId";

		ResultSet rs = query(sql);
		try {
			while (rs.next()) {
				results.add(new Person(rs.getInt("PersonId"), rs.getString("FirstName"), rs.getString("LastName")));
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			cleanup();
		}

		return results;
	}

}
