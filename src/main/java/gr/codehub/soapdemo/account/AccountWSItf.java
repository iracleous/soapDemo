/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.soapdemo.account;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

/**
 *
 * @author iracl
 */
@Stateless
 
@WebService
public interface AccountWSItf {
	@WebMethod
	public void newAccount( String name);

	@WebMethod
	public void withdraw(String name, long amount) throws RuntimeException;

	@WebMethod
	public void deposit(String name, long amount);

	@WebMethod
	public Account findAccountByName(String name);
}
 