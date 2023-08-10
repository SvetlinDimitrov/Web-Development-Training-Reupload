package com.example.mobilelegraderebuild.service.Offer;

import com.example.mobilelegraderebuild.domain.constants.Engine;
import com.example.mobilelegraderebuild.domain.constants.Transmission;
import com.example.mobilelegraderebuild.domain.entity.Brand;
import com.example.mobilelegraderebuild.domain.entity.Model;
import com.example.mobilelegraderebuild.domain.entity.Offer;
import com.example.mobilelegraderebuild.domain.entity.UserEntity;
import com.example.mobilelegraderebuild.domain.viewDtos.ViewOfferDto;
import com.example.mobilelegraderebuild.repo.OfferRepository;
import com.example.mobilelegraderebuild.service.Model.ModelService;
import com.example.mobilelegraderebuild.service.User.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OfferServiceImplTest {

    @Mock
    private OfferRepository offerRepository;
    @Mock
    private ModelService modelService;
    @Mock
    private UserService userService;
    @InjectMocks
    private OfferServiceImpl offerService;

    private final static List<ViewOfferDto> listOfferViewDto = new ArrayList<>();
    private final static List<Offer> listOffer = new ArrayList<>();
    @Captor
    private ArgumentCaptor<Offer> offerCaptor;
    private final static String VALID_ID = "1";
    private final static String NOT_VALID_ID = "2";

    @BeforeEach
    void setUp() {
        listOfferViewDto.addAll(List.of(
                ViewOfferDto.builder()
                        .id("1")
                        .engine(Engine.DIESEL)
                        .imageUrl("imageUrl1")
                        .mileage(20)
                        .description("this is test1")
                        .price(BigDecimal.valueOf(500))
                        .transmission(Transmission.AUTOMATIC)
                        .year(1999)
                        .created(LocalDate.parse("2018-10-23"))
                        .modified(LocalDate.parse("2018-10-23"))
                        .modelId("1")
                        .sellerId("1")
                        .offerYear_BrandName_OfferName("1999 test1Brand test1Model")
                        .build(),
                ViewOfferDto.builder()
                        .id("2")
                        .engine(Engine.DIESEL)
                        .imageUrl("imageUrl2")
                        .mileage(20)
                        .description("this is test2")
                        .price(BigDecimal.valueOf(500))
                        .transmission(Transmission.AUTOMATIC)
                        .year(1999)
                        .created(LocalDate.parse("2018-10-23"))
                        .modified(LocalDate.parse("2018-10-23"))
                        .modelId("2")
                        .sellerId("2")
                        .offerYear_BrandName_OfferName("1999 test2Brand test2Model")
                        .build()
        ));
        Model model1 = new Model();
        model1.setId("1");
        model1.setName("test1Model");
        model1.setBrand(Brand.builder().name("test1Brand").build());
        Model model2 = new Model();
        model2.setName("test2Model");
        model2.setId("2");
        model2.setBrand(Brand.builder().name("test2Brand").build());

        UserEntity userEntity1 = new UserEntity();
        userEntity1.setId("1");
        UserEntity userEntity2 = new UserEntity();
        userEntity2.setId("2");

        listOffer.addAll(List.of(
                Offer.builder()
                        .engine(Engine.DIESEL)
                        .imageUrl("imageUrl1")
                        .mileage(20)
                        .description("this is test1")
                        .price(BigDecimal.valueOf(500))
                        .transmission(Transmission.AUTOMATIC)
                        .year(1999)
                        .created(LocalDate.parse("2018-10-23"))
                        .modified(LocalDate.parse("2018-10-23"))
                        .model(model1)
                        .seller(userEntity1)
                        .build(),
                Offer.builder()
                        .engine(Engine.DIESEL)
                        .imageUrl("imageUrl2")
                        .mileage(20)
                        .description("this is test2")
                        .price(BigDecimal.valueOf(500))
                        .transmission(Transmission.AUTOMATIC)
                        .year(1999)
                        .created(LocalDate.parse("2018-10-23"))
                        .modified(LocalDate.parse("2018-10-23"))
                        .model(model2)
                        .seller(userEntity2)
                        .build()
        ));
        listOffer.get(0).setId("1");
        listOffer.get(1).setId("2");
    }

    @AfterEach
    void clean(){
        listOffer.clear();
        listOfferViewDto.clear();
    }

    @Test
    void getAllOffers_withNonEmptyRepository_CorrectlyMapped() {
        when(offerRepository.findAll()).thenReturn(listOffer);

        List<ViewOfferDto> result = offerService.getAllOffers();

        assertEquals(listOfferViewDto , result);
    }

    @Test
    void addOffer_validArguments_successfullySaved() {
        ViewOfferDto offerDto = listOfferViewDto.get(0);
        Offer expected = listOffer.get(0);
        Model model = expected.getModel();
        UserEntity seller = expected.getSeller();

        when(modelService.findById(offerDto.getModelId())).thenReturn(model);
        when(userService.findById(offerDto.getSellerId())).thenReturn(seller);

        offerService.addOffer(offerDto);

        verify(offerRepository , times(1)).save(offerCaptor.capture());

        Offer result = offerCaptor.getValue();

        assertEquals(expected , result);
    }

    @Test
    void getViewOfferById_ValidId_returnsTheCorrectMappedView() {
        Offer offer = listOffer.get(0);
        when(offerRepository.findById(VALID_ID)).thenReturn(Optional.of(offer));

        ViewOfferDto result = offerService.getViewOfferById(VALID_ID);
        ViewOfferDto expected = listOfferViewDto.get(0);

        assertEquals(expected , result);
    }

    @Test
    void getViewOfferById_InvalidId_throwsNoSuchException() {
        when(offerRepository.findById(NOT_VALID_ID)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class , () -> offerService.getViewOfferById(NOT_VALID_ID));
    }

    @Test
    void updateOffer_validParameters_SuccessfulUpdate() {
        ViewOfferDto offerDto = listOfferViewDto.get(1);
        Offer offerToBeChanges = listOffer.get(0);
        Offer excepted = listOffer.get(1);
        Model exceptedMo = excepted.getModel();
        UserEntity exceptedSeller = excepted.getSeller();

        when(offerRepository.findById(offerDto.getId())).thenReturn(Optional.of(offerToBeChanges));
        when(modelService.findById(offerDto.getModelId())).thenReturn(exceptedMo);
        when(userService.findById(offerDto.getSellerId())).thenReturn(exceptedSeller);

        offerService.updateOffer(offerDto);

        verify(offerRepository , times(1)).save(offerCaptor.capture());

        Offer result = offerCaptor.getValue();

        assertEquals(excepted.getMileage() , result.getMileage());
        assertEquals(excepted.getYear() , result.getYear());
        assertEquals(excepted.getEngine() , result.getEngine());
        assertEquals(excepted.getDescription() , result.getDescription());
        assertEquals(excepted.getModel() , result.getModel());
        assertEquals(excepted.getSeller() , result.getSeller());
        assertEquals(excepted.getImageUrl() , result.getImageUrl());
        assertEquals(excepted.getTransmission() , result.getTransmission());
    }

    @Test
    void updateOffer_invalidOfferDto_ThrowsException() {
        ViewOfferDto offerDto = listOfferViewDto.get(1);

        when(offerRepository.findById(offerDto.getId())).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class,() -> offerService.updateOffer(offerDto));
    }

    @Test
    void deleteOffer_withValidParameters_SuccessfulDelete() {
        Offer offer = new Offer();
        offer.setId("sampleId");

        UserEntity seller = new UserEntity();
        seller.getOffers().add(offer);

        offer.setSeller(seller);

        when(offerRepository.findById("sampleId")).thenReturn(Optional.of(offer));

        offerService.deleteOffer("sampleId");

        verify(offerRepository , times(1)).delete(offer);

        assertFalse(seller.getOffers().contains(offer));
    }

    @Test
    void deleteOffer_withInvalidParameters_ThrowsException() {
        when(offerRepository.findById("sampleId")).thenReturn(Optional.empty());



        assertThrows(NoSuchElementException.class , () -> offerService.deleteOffer("sampleId"));
    }
}