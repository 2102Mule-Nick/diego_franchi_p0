package com.revature.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.revature.exception.UserNameTaken;
import com.revature.exception.UserNotFound;
import com.revature.pojo.Member;

public class MemberDaoKryo implements MemberDao {
	
	private Kryo kryo = new Kryo();
	
	private Logger log = Logger.getRootLogger();
	
	private static final String FOLDER_NAME = "src\\users\\";
	
	private static final String FILE_EXTENSION = ".dat";
	
	public MemberDaoKryo() {
		super();
		kryo.register(Member.class);
		kryo.register(ArrayList.class);
	}
	
	@Override
	public boolean createMember(Member memb) throws UserNameTaken{
		String fileName = FOLDER_NAME + memb.getUsername() + FILE_EXTENSION;
		File file = new File(fileName);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				log.error("ERROR CREATING: " + fileName);
			}
		}
		try(FileOutputStream outputStream = new FileOutputStream(fileName)) {
			Output output = new Output(outputStream);
			kryo.writeObject(output, memb);
			output.close();
			return true;
		} catch (FileNotFoundException e) {
			log.error("could not open file", e);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Member getMemberByUsername(String username) throws UserNotFound {
		String fileName = FOLDER_NAME + username + FILE_EXTENSION;
		File file = new File(fileName);
		if (!file.exists()) {
			return null;
		}
		try (FileInputStream inputStream = new FileInputStream(FOLDER_NAME + username + FILE_EXTENSION)) {
			Input input = new Input(inputStream);
			Member memb = kryo.readObject(input, Member.class);
			input.close();
			return memb;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Member> getAllMembers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMember(Member memb) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean removeMember(Member memb) {
		return false;
		// TODO Auto-generated method stub

	}

}
