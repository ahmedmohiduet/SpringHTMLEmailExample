package com.mohi.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
    	 
    	HTMLMail mm = (HTMLMail) context.getBean("htmlMail");
        String html="<p>Hi!</p><a href=\"google.com\">Link text</a>";
	mm.sendMail("ahmed.mohi.duet@gmail.com",
			"ahmed.mohi.duet@gmail.com",
			"test html email",
			html);
        
    }
}
