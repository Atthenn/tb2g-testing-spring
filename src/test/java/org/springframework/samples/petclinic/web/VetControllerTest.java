package org.springframework.samples.petclinic.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Vets;
import org.springframework.samples.petclinic.service.ClinicService;

import javax.persistence.MapKeyColumn;

import java.util.Collection;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class VetControllerTest {

     @Mock
     ClinicService clinicService;

     @Mock
     Map<String,Object> model;

     @InjectMocks
     VetController vetController;


    @Test
    void showVetList() {
        Vets vets = new Vets();
        Vet vet1 = new Vet();
        Vet vet2 = new Vet();
        vets.getVetList().add(vet1);
        vets.getVetList().add(vet2);


       given(clinicService.findVets()).willReturn(vets.getVetList());
       assertEquals("vets/vetList",vetController.showVetList(model));
       then(model).should().put(anyString(),any());


    }

    @Test
    void showResourcesVetList() {

        Vets vets = new Vets();
        Vet vet1 = new Vet();
        Vet vet2 = new Vet();
        vets.getVetList().add(vet1);
        vets.getVetList().add(vet2);

        given(clinicService.findVets()).willReturn(vets.getVetList());
       // then(clinicService).should().findVets();
        assertThat(vetController.showResourcesVetList().equals(vets));
        assertThat(vets.getVetList()).hasSize(1);



    }
}