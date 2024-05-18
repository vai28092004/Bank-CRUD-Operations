package bank.dao;

import java.util.List;


import bank.model.Login;
import bank.model.Recharge;
import bank.model.Register;

public interface RegisterDao {
	
	int createRecord(List<Register> lst);
	//boolean validateUser()
	//List<Register> RetriveRecord(int regNo);
	int RetriveRecord(int regNo);
	int deleteRecord(int regNo);
	int updateRecord(Register reg);
	int saveRecharge(Recharge r);
	int LoginRecord(List<Login> lst);
	List<Register> list();
	List<Register> Retrive(int regNo);

}
