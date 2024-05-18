package bank.model;

public class Recharge {
	private String username;
	private String password;
	private String mobile;
	private String operator;
	private Float plan;
	public Recharge(String username, String password, String mobile, String operator, Float plan) {
		super();
		this.username = username;
		this.password = password;
		this.mobile = mobile;
		this.operator = operator;
		this.plan = plan;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Float getPlan() {
		return plan;
	}
	public void setPlan(Float plan) {
		this.plan = plan;
	}
	
}
