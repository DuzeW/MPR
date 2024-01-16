//package com.example.demo;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentCaptor;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//public class RestServiceTest {
//    private MyRestService service;
//    private AutoCloseable openMocks;
//    @Mock
//    private CarRepository repository;
//    private CarRepository carRepository;
//
//    @BeforeEach
//    public void init() {
//        openMocks = MockitoAnnotations.openMocks(this);
//        service = new MyRestService(repository);
//    }
//
//    @AfterEach
//    public void tearDown() throws Exception {
//        openMocks.close();
//    }
//
//    @Test
//    public void findFinds() {
//        String name = "Mercedes";
//        String model = "GLC";
//        CarDTO car = new CarDTO(name,model);
//        when(repository.findByName(name)).thenReturn(car);
//
//        CarDTO result = service.getCarByName(name);
//        assertEquals(car, result);
//
//    }
//
//    @Test
//    public void saveSaves() {
//        String name = "Mercedes";
//        String model = "GLC";
//        CarDTO carDTO = new CarDTO(name,model);
//        ArgumentCaptor<CarDTO> captor = ArgumentCaptor.forClass(CarDTO.class);
//        when(repository.save(captor.capture())).thenReturn(carDTO);
//
//        service.add(carDTO);
//        Mockito.verify(repository, Mockito.times(1)).save(Mockito.any());
//        CarDTO carDTOSaveCall = captor.getValue();
//        assertEquals(carDTO, carDTOSaveCall);
//    }
//
//    @Test
//    public void getByNameReturns200WhenCarIsPresent() throws Exception
//    {
//        CarDTO bemwe = new CarDTO("bemwe","E46");
//        when(service.getCarByName(3L)).thenReturn(Optional.of(bemwe));
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/CarRepository/get/3"))
//                .addEcpect(jsonPath("$.name").value("bemwe"))
//                .addExpect(status().isOk());
//    }
//}
