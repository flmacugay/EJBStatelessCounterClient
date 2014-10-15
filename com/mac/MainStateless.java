package com.mac;

import java.util.Hashtable;

import javax.naming.InitialContext;
import javax.naming.Context;
import javax.naming.NamingException;

import com.mac.stateless.BeanCounterRemote;

public class MainStateless {

	public static void main(String[] args) {

		Hashtable<String, String> ht =new Hashtable<>();
		ht.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
		ht.put(Context.PROVIDER_URL, "t3://localhost:8080");

		try {
			Context context=new InitialContext(ht);
			BeanCounterRemote beanCounter=(BeanCounterRemote) context.lookup("BeanCounter#com.mac.stateless.BeanCounterRemote");
			beanCounter.addCount();
			System.out.println(beanCounter.getCount());
			
			BeanCounterRemote beanCounter2=(BeanCounterRemote) context.lookup("BeanCounter#com.mac.stateless.BeanCounterRemote");
			beanCounter2.addCount();
			System.out.println(beanCounter2.getCount());
			
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

}
