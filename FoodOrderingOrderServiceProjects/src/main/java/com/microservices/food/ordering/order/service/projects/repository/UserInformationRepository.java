package com.microservices.food.ordering.order.service.projects.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.food.ordering.order.service.projects.entity.UserInformation;

@Repository
public interface UserInformationRepository extends JpaRepository<UserInformation, Long> 
{
	UserInformation findByUserInformationId(Long userInformationId);
	UserInformation findByEmailAddress(String emailAddress);
	UserInformation findByUserCorrespondenceAddressZipCode(String zipCode);
}
