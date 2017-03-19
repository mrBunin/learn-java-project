package com.certification.ejb.ejbApp;

import javax.ejb.Local;

@Local
public interface IBean3
{
   void addBand(String name, String city, int year);

   String getAllBandNames();

   void modifyBandName(String origin, String newName);

   void readBandAlbumList(String bandName);

   String getBand(String bandName);

   String getBand(long id);

   String getCommentsForBand(long id);

   String getCommentsForBandByAbout(String about);
}
