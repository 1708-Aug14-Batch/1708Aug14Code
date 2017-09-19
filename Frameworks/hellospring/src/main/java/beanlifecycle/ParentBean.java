package beanlifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class ParentBean implements BeanNameAware,
BeanFactoryAware, InitializingBean,DisposableBean{

	private String secret;
	private String beanName;
	private static int i = 0;

	public String getSecret() {
		return secret;
	}

	public ParentBean() {
		super();
		System.out.println(++i + " Instantiate: ParentBean"); //1st call
	}
	
	public void setSecret(String secret) {
		this.secret = secret;
		System.out.println(++i + " Populating property: 'secret'"); //2nd call
	}

	public void setBeanName(String beanName) {
		System.out.println(++i + " Bean's name is: " +beanName); //3rd call
		this.beanName = beanName;
	}

	public void setBeanFactory(BeanFactory womb) 
			throws BeansException {
		System.out.println(++i + " Bean made by Factory: " + womb); //4th call
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println(++i + " After " + beanName + "'s properties set."); //5th call
	}
	
	public void myCustomInitializationMethod(){
		System.out.println(++i +  " Calling my custom init for " + beanName); //6th call
	}

	public void destroy() throws Exception {
		System.out.println(++i + " Disposing bean: " + beanName); //7th call
	}
	
	public void customDestroyMethod(){
		System.out.println(++i + " Actually destroying bean: " +beanName); //8th call
	}
	

}
