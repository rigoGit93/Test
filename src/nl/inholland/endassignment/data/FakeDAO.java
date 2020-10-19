package nl.inholland.endassignment.data;

import nl.inholland.endassignment.model.Role;
import nl.inholland.endassignment.model.User;

import java.time.LocalDate;

public class FakeDAO extends UserDao {

    @Override
    public void addOrUpdate(User object) {

    }

    @Override
    public void remove(User object) {

    }

    @Override
    public boolean save() {
        return false;
    }

    @Override
    public boolean load() {
        objects.add(new User("Admin", "Pass", "Salman", "tester", LocalDate.now(), Role.ADMIN));
        objects.add(new User("Sales", "Pass", "Vince", "tester", LocalDate.now(), Role.SALES));
        return true;
    }
}
