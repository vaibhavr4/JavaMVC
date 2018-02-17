package com.service;

import java.util.ArrayList;

import com.bean.Trainer;
import com.utility.ConnectionDao;

public class Service 
{
	ConnectionDao con = new ConnectionDao();
	public int addTrainer(Trainer T)
	{
		return con.addTrainee(T);
	}
	public ArrayList<Trainer> viewdetails(String id) {
		// TODO Auto-generated method stub
		return con.viewTrainee(id);
	}
}
