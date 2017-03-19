package com.certification.ejb.ejbApp;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "ALBUM")
public class Album implements Serializable
{
   private static final long serialVersionUID = 7443162800563724744L;
   private long   id;
   private String title;
   private int    year;
   private String studio;
   private Band   band;

   @Id
   @GeneratedValue (strategy = GenerationType.IDENTITY)
   @Column (name = "ALBUM_ID", nullable = false)
   public long getId ()
   {
      return id;
   }

   public void setId (long id)
   {
      this.id = id;
   }

   @Column (name = "TITLE", length = 30)
   public String getTitle ()
   {
      return title;
   }

   public void setTitle (String title)
   {
      this.title = title;
   }

   @Column (name = "YEAR_CREATED")
   public int getYear ()
   {
      return year;
   }

   public void setYear (int year)
   {
      this.year = year;
   }

   @Column (name = "STUDIO", length = 25)
   public String getStudio ()
   {
      return studio;
   }

   public void setStudio (String studio)
   {
      this.studio = studio;
   }

   @ManyToOne
   @JoinColumn (name = "BAND_ID", nullable = false)
   public Band getBand ()
   {
      return band;
   }

   public void setBand (Band band)
   {
      this.band = band;
   }

   @Override
   public int hashCode ()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((band == null) ? 0 : band.hashCode());
      result = prime * result + (int) (id ^ (id >>> 32));
      result = prime * result + ((studio == null) ? 0 : studio.hashCode());
      result = prime * result + ((title == null) ? 0 : title.hashCode());
      result = prime * result + year;
      return result;
   }

   @Override
   public boolean equals (Object obj)
   {
      if (this == obj)
      {
         return true;
      }
      if (obj == null)
      {
         return false;
      }
      if (getClass() != obj.getClass())
      {
         return false;
      }
      Album other = (Album) obj;
      if (band == null)
      {
         if (other.band != null)
         {
            return false;
         }
      }
      else if (! band.equals(other.band))
      {
         return false;
      }
      if (id != other.id)
      {
         return false;
      }
      if (studio == null)
      {
         if (other.studio != null)
         {
            return false;
         }
      }
      else if (! studio.equals(other.studio))
      {
         return false;
      }
      if (title == null)
      {
         if (other.title != null)
         {
            return false;
         }
      }
      else if (! title.equals(other.title))
      {
         return false;
      }
      if (year != other.year)
      {
         return false;
      }
      return true;
   }

}
