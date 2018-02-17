package com.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Trainer;

public class ConnectionDao 
{
	private Connection con = null;
	private PreparedStatement pst = null;
	public int addTrainee(Trainer T) 
	{
		int update = 0;
		DbConnection db = new DbConnection();
		con = db.getConnection();
		try{
			pst = con.prepareStatement("insert into tbl_trainer_975152 values(?,?,?,?,?,?,?)");
			pst.setString(1, T.getTrainerId());
			pst.setString(2, T.getTrainerName());
			pst.setString(3, T.getTrainerExp());
			pst.setString(4, T.getTrainerStream());
			pst.setString(5, T.getTrainerNum());
			pst.setString(6, T.getTrainerAdd());
			pst.setString(7, T.getTainerStatus());
			update = pst.executeUpdate();
		}
		catch (SQLException S)
		{
			S.printStackTrace();
		}	
		finally{
			if(con!=null)
			{	
				db.closeConnection();
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return update;
	}
	public ArrayList<Trainer> viewTrainee(String id) {
		DbConnection db = new DbConnection();
		con = db.getConnection();
		ArrayList<Trainer> arrT = new ArrayList<Trainer>();
		try{
			pst=con.prepareStatement("select * from tbl_trainer_975152 where TRAINERID =?");
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next())
			{
				Trainer T = new Trainer();
				T.setTrainerId(rs.getString(1));
				T.setTrainerName(rs.getString(2));
				T.setTrainerExp(rs.getString(3));
				T.setTrainerStream(rs.getString(4));
				T.setTrainerNum(rs.getString(5));
				T.setTrainerAdd(rs.getString(6));
				T.setTainerStatus(rs.getString(7));
				arrT.add(T);
			}
		}catch (SQLException S)
		{
			S.printStackTrace();
		}	
		finally{
			if(con!=null)
			{	
				db.closeConnection();
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return arrT;
	}
}
