package com.certification.ejb.webApp;

import java.io.IOException;
import java.io.Writer;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.certification.ejb.ejbApp.IBean3;

@SuppressWarnings("serial")
public class MyServlet extends HttpServlet
{
   /*
    * This is stateless bean test
    */
   @EJB
   IBean3 myStatelessBean;

   //   /*
   //    * This is stateless bean test
   //    */
   //   @EJB
   //   IBean2 myStatelessBean2;

   @Override
   public void init()
   {
      log("In init");
   }

   @Override
   public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
         IOException
   {
      Writer writer = resp.getWriter();
      writer.write("************************************\n");
      writer.write(myStatelessBean.getCommentsForBand(1L) + "\n");
      writer.write("************************************\n\n");

      writer.write("************************************\n");
      writer.write(myStatelessBean.getCommentsForBandByAbout("Band1") + "\n");
      writer.write("************************************\n\n");

      writer.write("************************************\n");
      writer.write(myStatelessBean.getBand(1L) + "\n");
      writer.write("************************************\n\n");

      writer.write("************************************\n");
      writer.write(myStatelessBean.getBand("band1") + "\n");
      writer.write("************************************\n\n");

//      myStatelessBean.readBandAlbumList("band1");
//
//      Writer writer = resp.getWriter();
//      writer.write("************************************\n");
//      writer.write(myStatelessBean.getAllBandNames() + "\n");
//      writer.write("************************************\n");
      
//      myStatelessBean.addBand("band7", "city1", 1990);
//      myStatelessBean.modifyBandName("band7", "band77");
//
//      writer.write("************************************\n");
//      writer.write("Read again: \n");
//      writer.write(myStatelessBean.getAllBandNames() + "\n");
//      writer.write("************************************\n");
      //      /*
      //       * This is stateless bean test
      //       */
      //      if (myStatelessBean2.start())
      //      {
      //         writer.write("************************************\n");
      //         writer.write("Completed...\n");
      //         writer.write("************************************\n");
      //      }

      //      /**
      //       * This is stateless bean test
      //       */
      //      if (myStatelessBean2.start())
      //      {
      //         writer.write("************************************\n");
      //         writer.write("Test!!!\n");
      //         writer.write(myStatelessBean.getData() + "\n");
      //         writer.write("************************************\n");
      //      }
      //      else
      //      {
      //         writer.write("************************************\n");
      //         writer.write("Bean 'myStatelessBean2 has failed to create queue...\n");
      //         writer.write("************************************\n");
      //      }
   }

}
