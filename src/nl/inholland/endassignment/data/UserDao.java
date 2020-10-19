package nl.inholland.endassignment.data;

import nl.inholland.endassignment.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class  UserDao implements DAO<User> {

    protected ArrayList<User> objects;


    public UserDao() {
        objects = new ArrayList<>();



        load();
    }

    @Override
    public List<User> getAll() {
        return Collections.unmodifiableList(objects);
    }



    @Override
    public abstract boolean load();
}
