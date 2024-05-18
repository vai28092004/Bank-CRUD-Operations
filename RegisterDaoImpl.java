package bank.dao;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import bank.db.BankDbConnection;
import bank.model.Register;
import bank.model.Login;
import bank.model.Recharge;

public class RegisterDaoImpl implements RegisterDao {
BankDbConnection bankdao=new BankDbConnection();
	
	@Override
	public int createRecord(List<Register> lst) {
		// TODO Auto-generated method stub
		
		Register regobj=lst.get(0);
		int i=0;
		Connection con=null;
		try {
			con=bankdao.getDbConnection();
			PreparedStatement pstate=con.prepareStatement("insert into RegisterBank values(?,?,?,?,?)");
			pstate.setInt(1,regobj.getRegNo());
			pstate.setString(2,regobj.getCustName());
			pstate.setString(3,regobj.getUserName());
			pstate.setString(4,regobj.getPassword());
			pstate.setFloat(5,regobj.getAccbal());
			i = pstate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return i;
	}

	@Override
	public int RetriveRecord(int regNo) {
		Connection con=bankdao.getDbConnection();
		List<Register> lstreg=null;
		int i=0;
		try {
			PreparedStatement pstate=con.prepareStatement("retrive from registerbank where regNo=?");
			pstate.setInt(1,regNo);
			i=pstate.executeUpdate();
			//if(i>0) {
			//	System.out.println("Record deleted");
			//}
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return i;
	}

	@Override
	public int deleteRecord(int regNo) {
		Connection con=bankdao.getDbConnection();
		List<Register> lstreg=null;
		int i=0;
		try {
			PreparedStatement pstate=con.prepareStatement("delete from registerbank where regNo=?");
			pstate.setInt(1,regNo);
			i=pstate.executeUpdate();
			//if(i>0) {
			//	System.out.println("Record deleted");
			//}
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return i;
	}

	@Override
	public int updateRecord(Register reg) {
		Connection con=null;
		List<Register> lstreg=null;
		//Register regobj=lstreg.get(0);
		int i = 0;
		try {
			con=BankDbConnection.getDbConnection();
			PreparedStatement pstate=con.prepareStatement("update RegisterBank set ACCBAL=? where regNo=?");
			pstate.setFloat(1, reg.getAccbal());
			pstate.setInt(2,reg.getRegNo());
		    i=pstate.executeUpdate();
			
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int LoginRecord(List <Login>lst) {
		Login lobj=lst.get(0);
		int i=0;
		Connection con=null;
		try {
			con=bankdao.getDbConnection();
			PreparedStatement pstate=con.prepareStatement("insert into Login values(?,?)");
			pstate.setInt(1,lobj.getRegNo());
			pstate.setString(2,lobj.getPassword());
			
			i = pstate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return i;
	}
	@Override
	public List<Register> list() {
		int i=0;
		Connection conn=null;
		List<Register>lst=new LinkedList<Register>();
		try {
			conn=BankDbConnection.getDbConnection();
			String str = "select * from registerbank";
			
			Statement state=conn.createStatement();
			ResultSet result=state.executeQuery(str);
			
			while(result.next())
			{
				Register reg=new Register(result.getInt(1),result.getString(2), result.getString(3), result.getString(4), result.getFloat(5));
				lst.add(reg);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lst;
	}


	@Override
	public List<Register> Retrive(int regno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int saveRecharge(Recharge r) {
		
		int i=0;
		Connection conn=bankdao.getDbConnection();
		
		try {
			PreparedStatement pstate=conn.prepareStatement("insert into recharge values(?,?,?,?,?");
			pstate.setString(1,r.getUsername());
			pstate.setString(2,r.getPassword());
			pstate.setString(3,r.getMobile());
			pstate.setString(4,r.getOperator());
			pstate.setFloat(5,r.getPlan());
			
			pstate.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		i=debit(r.getUsername(),r.getPassword(),r.getPlan());
		return i;
	}

	private int debit(String username, String password, Float plan) {
		// TODO Auto-generated method stub
		return 0;
	}


	}
	

	
	

