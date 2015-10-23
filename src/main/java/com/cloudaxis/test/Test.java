/***************************************************************************
 *
 * This document contains confidential and proprietary information 
 * subject to non-disclosure agreements with CloudAxis. This 
 * information shall not be distributed or copied without written 
 * permission from the CloudAxis.
 *
 ***************************************************************************/

package com.cloudaxis.test;

/***************************************************************************
 *<PRE>
 * 
 *  Creation Date   : Oct 23, 2015
 * 
 *  Author          : steven
 * 
 *  Purpose         : TODO
 * 
 * 
 *  History         : TODO
 * 
 *</PRE>
 ***************************************************************************/
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.cloudaxis.jaxb.XMLParser;


public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		 new Test().test();
	/*	new Test().unserialize();
		new Test().serializes();
		new Test().unserializes();*/
	}
	
	public void test(){
		String str = "<?xml version='1.0' encoding='UTF-8' standalone='yes'?><Customer><name>zzz</name><age>23</age><id>100</id></Customer>";
		Customer customer = (Customer) XMLParser.unmarshal(str,Customer.class);
		System.out.println(customer.name);
	}
	
	public void serialize(){
		 Customer customer = new Customer();
	      customer.id=100;
	      customer.name="zzz";
	      customer.age = 23;
	      File file = new File("customer.xml");
	     boolean custring = XMLParser.marshal(customer, Customer.class,file);
	     System.out.println(custring);
	      
	}
	public void unserialize() throws FileNotFoundException{
		File file = new File("customer.xml");
		Customer key = (Customer)XMLParser.unmarshal(file, Customer.class);
		 System.out.println(key.name);
	}
	
	public void serializes(){
		 Customer customer = new Customer();
	      customer.id=100;
	      customer.name="zzz";
	      customer.age = 23;
	 	 Customer customer1 = new Customer();
	      customer.id=1001;
	      customer.name="zzz1";
	      customer.age = 231;
	      List<Customer> list  = new ArrayList<Customer>();
	      Customers cs = new Customers();
	      list.add(customer1);
	      list.add(customer);
	      cs.customer = list;
	      File file = new File("customers.xml");
	     boolean key = XMLParser.marshal(cs, Customers.class,file);
	     System.out.println(key);
	      
	}
	public void unserializes() throws FileNotFoundException{
		File file = new File("customers.xml");
		
		Customers key = (Customers)XMLParser.unmarshal(file, Customers.class);
		 System.out.println(key.customer.size());
	}
}
