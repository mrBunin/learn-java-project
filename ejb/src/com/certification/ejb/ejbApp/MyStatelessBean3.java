package com.certification.ejb.ejbApp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class MyStatelessBean3 implements IBean3
{
   @EJB
   ILogger logger;

   @PersistenceContext(unitName = "Music")
   private EntityManager entityManager;

   //   @Override
   //   public String getData()
   //   {
   //
   //      StringBuilder output = new StringBuilder();
   //      getAllBandNames(output);
   //
   //      addBand("band5", "city3", 1989);
   //
   //      modifyBandName("band5", "band55");
   //
//               AuditReader auditReader = AuditReaderFactory.get(entityManager);
   //      Band firstRevisionBand = auditReader.find(Band.class, band.getId(), 1);
   //      Band secondRevisionBand = auditReader.find(Band.class, band.getId(), 2);
   //
   //      output.append("\n\n");
   //      output.append("First band name: " + firstRevisionBand.getName() + "\n");
   //      output.append("Second band name: " + secondRevisionBand.getName() + "\n");
   //
   //      return output.toString();
   //   }

   @Override
   public void addBand(String name, String city, int year)
   {
      logger.logIt("This is method addBand()");

      Band band = new Band();

      band.setName(name);
      band.setCity(city);
      band.setYear(year);

      entityManager.persist(band);
   }

   @SuppressWarnings("unchecked")
   @Override
   public String getAllBandNames()
   {
      logger.logIt("This is method getAllBandNames()");

      Cache cache = entityManager.getEntityManagerFactory().getCache();
      if (cache.contains(Band.class, 1))
      {
         System.out.println("First band is in cache...");
      }

      Query query = entityManager.createNamedQuery("Band.getAllBandsNames");
      List<Band> bandList = query.getResultList();
      StringBuilder output = new StringBuilder();

      for (Band band : bandList)
      {
         output.append("Band name: ").append(band.getName()).append(", year: ")
            .append(band.getYear()).append("\n");
      }

      return output.toString();
   }

   @SuppressWarnings("unchecked")
   @Override
   public void modifyBandName(String origin, String newName)
   {
      logger.logIt("This is method modifyBandName(String origin, String newName)");

      Query query = entityManager.createNamedQuery("Band.getBandByName");
      query.setParameter("name", origin);
      List<Band> bandList = query.getResultList();

      Band band = bandList.get(0);
      band.setName(newName);
      entityManager.merge(band);
   }

   @SuppressWarnings("unchecked")
   @Override
   public void readBandAlbumList(String bandName)
   {
//      Session session = (Session) entityManager.getDelegate();

      logger.logIt("This is method readBandAlbumList(String bandName)");

      Query query = entityManager.createNamedQuery("Band.getBandByName");
      query.setParameter("name", bandName);
      List<Band> bandList = query.getResultList();

      Band band = bandList.get(0);

      List<Album> albumList = (List<Album>) band.getAlbumList();
      System.out.println("Band " + bandName + ": \n");

      for (Album album : albumList)
      {
         System.out.println("Album: " + album.getTitle() + ", year: " + album.getYear() + "\n");
      }
   }

   @Override
   public String getBand(String bandName)
   {
      logger.logIt("This is method getBand(String bandName)");

      Query query = entityManager.createNamedQuery("Band.getBandByName");
      query.setParameter("name", bandName);
      List bandList = query.getResultList();

      return ((Band) bandList.get(0)).toString();
   }

   @Override
   public String getBand(long id)
   {
      logger.logIt("This is method getBand(long id)");

      Band band = entityManager.find(Band.class, id);
      return band.toString();
   }

   @Override
   public String getCommentsForBand(long id)
   {
      logger.logIt("This is method getCommentsForBand(long id)");

      Remark remark = entityManager.find(Remark.class, id);
      return remark.toString();
   }

   @Override
   public String getCommentsForBandByAbout(String about)
   {
      logger.logIt("This is method getCommentsForBandByAbout(String about)");

      Query query = entityManager.createNamedQuery("Remark.getRemarkByAbout");
      query.setParameter("about", about);
      Remark remark = (Remark) query.getSingleResult();
      return remark.toString();
   }

   //   @Override
   //   public String getCityByBandName(String name)
   //   {
   //      Session session = entityManager.unwrap(Session.class);
   //      
   //      Band band = session.
   //   }
}
