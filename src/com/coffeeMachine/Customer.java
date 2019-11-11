package com.coffeeMachine;

public class Customer extends User {

	public Customer() {
		this.setCodeUser();
	}
	@Override
	protected void showInterfaceCoffe() {
		// TODO Auto-generated method stub

	}
	private void setCodeUser()
	{
		this.codeUser="Customer";
	}
	public String getCodeUser()
	{
		return this.codeUser;
	}

}
