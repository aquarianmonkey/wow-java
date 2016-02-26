package com.berns;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class AbstractDao {

	protected static final File file = new File("D:\\workspaces\\restful-app\\src\\main\\resources\\Users.dat");

	public AbstractDao() {
		super();
	}

	protected void saveUserList(List<User> userList, File source) {
		try {
			//File file = new File("D:\\workspaces\\jersey-ws-app\\src\\main\\resources\\Users.dat");
			FileOutputStream fos;
	
			fos = new FileOutputStream(source);
	
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(userList);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected List<User> retrieveSourceList() {
		try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis)) {
			if (!file.exists()) {
				throw new IllegalStateException("NO File datasource!");
			} else {
				return (List<User>) ois.readObject();
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new IllegalStateException("Ooops, sorry!!!", e);
		}
	}

}