package com.coffeeMachine;

public class Manager extends User {

	public Manager() {
		this.setCodeUser();
	}
	@Override
	protected void showInterfaceCoffe() {
		// TODO Auto-generated method stub

	}
	private void setCodeUser()
	{
		this.codeUser="Manager";
	}
	public String getCodeUser()
	{
		return this.codeUser;
	}


}
