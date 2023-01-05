package gr.codehub.soapdemo.account;


 
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author iracl
 */
@Stateless
 
@WebService
@SOAPBinding(style= SOAPBinding.Style.RPC)
public class AccountWS implements AccountWSItf{
	@Inject
	AccountManager ejb;

 
        @Override
	public void newAccount(@WebParam(name = "name") String name) {
		ejb.createAccount(name);
	}

 
        @Override
	public void withdraw(@WebParam(name = "name") String name,
			@WebParam(name = "amount") long amount) throws RuntimeException {
		ejb.withdraw(name, amount);
	}

 
        @Override
	public void deposit(@WebParam(name = "name") String name,
			@WebParam(name = "amount") long amount) {
		ejb.deposit(name, amount);
	}

	@WebResult(name = "BankAccount")
        @Override
	public Account findAccountByName(String name) {
		return ejb.findAccount(name);
	}
} 