package com.certification.ejb.ejbApp;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by: Oleg Shabunin
 * Date: 5/17/13
 * Time: 10:15 AM
 */
@Entity

@NamedQueries (value = {
      @NamedQuery (name = "Remark.getRemarkByAbout",
            query = "SELECT o FROM Remark o WHERE o.about = :about",
            hints = {@QueryHint (name = "org.hibernate.cacheable", value = "true")})})

@Cache (usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE,
      region = "com.certification.ejb.ejbApp.Remark")

@Table (name = "REMARK")
public class Remark implements Serializable
{
   private static final long serialVersionUID = 2083179867698995802L;
   private long   id;
   private String about;
   private String remark;

   @Id
   @GeneratedValue (strategy = GenerationType.IDENTITY)
   @Column (name = "REMARK_ID", nullable = false)
   public long getId ()
   {
      return id;
   }

   public void setId (long id)
   {
      this.id = id;
   }

   @Column (name = "ABOUT", length = 24)
   public String getAbout ()
   {
      return about;
   }

   public void setAbout (String about)
   {
      this.about = about;
   }

   @Column (name = "REMARK", length = 64)
   public String getRemark ()
   {
      return remark;
   }

   public void setRemark (String remark)
   {
      this.remark = remark;
   }

   @Override
   public boolean equals (Object o)
   {
      if (this == o)
      {
         return true;
      }
      if (! (o instanceof Remark))
      {
         return false;
      }

      Remark remark1 = (Remark) o;

      if (id != remark1.id)
      {
         return false;
      }
      if (! about.equals(remark1.about))
      {
         return false;
      }
      if (remark.equals(remark1.remark))
      {
         return true;
      }

      return false;

   }

   @Override
   public int hashCode ()
   {
      int result = (int) (id ^ (id >>> 32));
      result = 31 * result + about.hashCode();
      result = 31 * result + remark.hashCode();
      return result;
   }

   @Override
   public String toString ()
   {
      return "Remark{" +
            "id=" + id +
            ", about='" + about + '\'' +
            ", remark='" + remark + '\'' +
            '}';
   }
}
