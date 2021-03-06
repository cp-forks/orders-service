package io.fabric8.quickstarts.orderservice.rest.dto;

import java.io.Serializable;

import io.fabric8.quickstarts.orderservice.model.SectionAllocation;

import javax.persistence.EntityManager;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SectionAllocationDTO implements Serializable
{

   private int occupiedCount;
   private NestedPerformanceIdDTO performance;
   private NestedSectionDTO section;
   private Long id;

   public SectionAllocationDTO()
   {
   }

   public SectionAllocationDTO(final SectionAllocation entity)
   {
      if (entity != null)
      {
         this.occupiedCount = entity.getOccupiedCount();
         this.performance = new NestedPerformanceIdDTO(entity.getPerformanceId());
         this.section = new NestedSectionDTO(entity.getSection());
         this.id = entity.getId();
      }
   }

   public SectionAllocation fromDTO(SectionAllocation entity, EntityManager em)
   {
      if (entity == null)
      {
         entity = new SectionAllocation();
      }
      entity = em.merge(entity);
      return entity;
   }

   public int getOccupiedCount()
   {
      return this.occupiedCount;
   }

   public void setOccupiedCount(final int occupiedCount)
   {
      this.occupiedCount = occupiedCount;
   }

   public NestedPerformanceIdDTO getPerformance()
   {
      return this.performance;
   }

   public void setPerformance(final NestedPerformanceIdDTO performance)
   {
      this.performance = performance;
   }

   public NestedSectionDTO getSection()
   {
      return this.section;
   }

   public void setSection(final NestedSectionDTO section)
   {
      this.section = section;
   }

   public Long getId()
   {
      return this.id;
   }

   public void setId(final Long id)
   {
      this.id = id;
   }
}