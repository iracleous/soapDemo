/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.soapdemo.account;


import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

/**
 *
 * @author iracl
 */
@Stateless
public class AccountManager {
	@PersistenceContext 
	private EntityManager em;	


	public Account findAccount(String name)  
	{
		Query query = em.createQuery("FROM Account a WHERE name= :name");
		query.setParameter("name", name);
		Account account = (Account)query.getSingleResult();
		System.out.println("Found Account "+account);
		return account;	}

@Transactional
	public void createAccount(String name) {
		Account account = new Account();
		account.setName(name);
		account.setAmount(0l);
		em.persist(account);
	 
	}
@Transactional
	public void deposit( 
			String name,

			long amount)  
	{
		Account account = findAccount(name);
		long currentAmount = account.getAmount();
		account.setAmount(currentAmount + amount);
		System.out.println("Updated Account "+account);
		em.persist(account);
	}
        @Transactional
	public void withdraw(String name, long amount) {
		Account account = findAccount(name);	
		long currentAmount = account.getAmount();
		long newAmount = currentAmount - amount;
		if (newAmount < 0) {
			throw new RuntimeException("Unsufficient funds for account "+ account.getName());

		}
		account.setAmount(newAmount);
		em.persist(account);

	}
} 