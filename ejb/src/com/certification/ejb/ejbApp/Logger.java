package com.certification.ejb.ejbApp;

import javax.ejb.Stateless;

/**
 * Created by: Oleg Shabunin
 * Date: 5/22/13
 * Time: 12:11 PM
 */
@Stateless
public class Logger implements ILogger
{
   @Override
   public void logIt (Object obj)
   {
      System.out.println("Logging: " + obj.toString());
   }
}
