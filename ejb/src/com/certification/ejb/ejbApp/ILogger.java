package com.certification.ejb.ejbApp;

import javax.ejb.Local;

/**
 * Created by: Oleg Shabunin
 * Date: 5/22/13
 * Time: 12:09 PM
 */
@Local
public interface ILogger
{
   void logIt (Object obj);
}
