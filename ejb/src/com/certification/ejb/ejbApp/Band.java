package com.certification.ejb.ejbApp;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Collection;

@Entity
@NamedQueries ({
      @NamedQuery (name = "Band.getAllBandsNames", query = "SELECT o FROM Band o",
            hints = {@QueryHint (name = "org.hibernate.fetchSize", value = "1")}),

      @NamedQuery (name = "Band.getBandByName",
            query = "SELECT o FROM Band o WHERE o.name = :name",
            hints = {@QueryHint (name = "org.hibernate.cacheable", value = "true")})})

//@SequenceGenerator(name = "BAND_SEQ", sequenceName = "bandSequence")
@Cache (usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE,
      region = "com.certification.ejb.ejbApp.Band")

@Table (name = "BAND")
public class Band implements Serializable
{
   private static final long serialVersionUID = - 3317564682437695577L;
   private long              id;
   private String            name;
   private String            city;
   private int               year;
   private Collection<Album> albumList;

   @Id
   //   @GeneratedValue(generator = "BAND_SEQ", strategy = GenerationType.SEQUENCE)   
   //   @GeneratedValue(generator = "increment")
   //   @GenericGenerator(name = "increment", strategy = "increment")
   @GeneratedValue (strategy = GenerationType.IDENTITY)
   @Column (name = "BAND_ID", nullable = false)
   public long getId ()
   {
      return id;
   }

   public void setId (long id)
   {
      this.id = id;
   }

   @Column (name = "NAME", length = 24)
   public String getName ()
   {
      return name;
   }

   public void setName (String name)
   {
      this.name = name;
   }

   @Column (name = "CITY", length = 20)
   public String getCity ()
   {
      return city;
   }

   public void setCity (String city)
   {
      this.city = city;
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

   @OneToMany (fetch = FetchType.LAZY, mappedBy = "band")
   @Cascade (CascadeType.ALL)
   @Fetch (FetchMode.SELECT)
   public Collection<Album> getAlbumList ()
   {
      return albumList;
   }

   public void setAlbumList (Collection<Album> albumList)
   {
      this.albumList = albumList;
   }

   @Override
   public int hashCode ()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((albumList == null) ? 0 : albumList.hashCode());
      result = prime * result + ((city == null) ? 0 : city.hashCode());
      result = prime * result + (int) (id ^ (id >>> 32));
      result = prime * result + ((name == null) ? 0 : name.hashCode());
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
      Band other = (Band) obj;
      if (albumList == null)
      {
         if (other.albumList != null)
         {
            return false;
         }
      }
      else if (! albumList.equals(other.albumList))
      {
         return false;
      }
      if (city == null)
      {
         if (other.city != null)
         {
            return false;
         }
      }
      else if (! city.equals(other.city))
      {
         return false;
      }
      if (id != other.id)
      {
         return false;
      }
      if (name == null)
      {
         if (other.name != null)
         {
            return false;
         }
      }
      else if (! name.equals(other.name))
      {
         return false;
      }
      if (year != other.year)
      {
         return false;
      }
      return true;
   }

   @Override
   public String toString ()
   {
      return "Band{" +
            "name='" + name + '\'' +
            ", city='" + city + '\'' +
            ", year=" + year +
            ", albumList=" + albumList +
            '}';
   }
}
